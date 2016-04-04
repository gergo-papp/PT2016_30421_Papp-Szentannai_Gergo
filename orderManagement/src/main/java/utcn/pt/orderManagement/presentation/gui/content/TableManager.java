package utcn.pt.orderManagement.presentation.gui.content;

import utcn.pt.orderManagement.businessAccessLayer.EntityFetcher;
import utcn.pt.orderManagement.businessAccessLayer.EntityRemover;
import utcn.pt.orderManagement.businessAccessLayer.EntityUpdater;
import utcn.pt.orderManagement.presentation.gui.tables.CustomerTableModel;
import utcn.pt.orderManagement.presentation.gui.tables.OrderTableModel;
import utcn.pt.orderManagement.presentation.gui.tables.ProductTableModel;

/**
 * Wrapper class between GUI and Business level.
 * 
 * @author gergo_000
 *
 */
public class TableManager {

	// Getting rows:

	protected static void fetchCustomerRows(CustomerTableModel customerTableModel) {

		// Remove all rows:
		int rowCount = customerTableModel.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			customerTableModel.removeRow(0);
		}

		// Get rowData as a 2D vector of Strings:
		String[][] rowData = EntityFetcher.listCustomers();
		if (rowData != null) {
			int i;
			int length = rowData.length;

			// Insert all rows into the table
			for (i = 0; i < length; i++) {
				customerTableModel.addRow((String[]) rowData[i]);
			}
		}
	}

	protected static void fetchOrderRows(OrderTableModel orderTableModel) {

		// Remove all rows:
		int rowCount = orderTableModel.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			orderTableModel.removeRow(0);
		}

		// Get rowData as a 2D vector of Strings:
		String[][] rowData = EntityFetcher.listOrders();
		int i;
		int length = rowData.length;

		// Insert all rows into the table
		for (i = 0; i < length; i++) {
			orderTableModel.addRow((String[]) rowData[i]);
		}
	}

	protected static void fetchProductRows(ProductTableModel productTableModel) {

		// Remove all rows:
		int rowCount = productTableModel.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			productTableModel.removeRow(0);
		}

		// Get rowData as a 2D vector of Strings:
		String[][] rowData = EntityFetcher.listProducts();
		int i;
		int length = rowData.length;

		// Insert all rows into the table
		for (i = 0; i < length; i++) {
			productTableModel.addRow((String[]) rowData[i]);
		}
	}

	// Updating data (sending to business level):

	protected static void addEntity(String entity, String[] columns) {

		// send the columns to BusinessAccessLayer:

		if (entity.equals("edit_customer")) {

			EntityUpdater.editCustomer(columns);

		} else if (entity.equals("add_customer")) {
			EntityUpdater.addCustomer(columns);

		} else if (entity.equals("add_product")) {
			EntityUpdater.addProduct(columns);

		} else if (entity.equals("add_order")) {
			EntityUpdater.addOrder(columns);

		}

	}

	protected static void removeEntity(String entity, String id) {
		int idEntity = Integer.parseInt(id);
		if (entity.equals("customer")) {
			EntityRemover.removeCustomer(idEntity);
		}

	}

}
