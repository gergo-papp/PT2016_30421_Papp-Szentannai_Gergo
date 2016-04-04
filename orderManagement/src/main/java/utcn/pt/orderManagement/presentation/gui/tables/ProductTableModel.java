package utcn.pt.orderManagement.presentation.gui.tables;

import javax.swing.table.DefaultTableModel;

import utcn.pt.orderManagement.presentation.gui.content.ProductPanel;

public class ProductTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 921057178723731637L;

	private static String[] columnNames = {"Product ID","Product Name"};
	
	public ProductTableModel() {
		super( getColumnNames(),0);
		// TODO Auto-generated constructor stub

	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		if (ProductPanel.getSelectedRow() == -1) {
			return false;
		} else if (ProductPanel.getSelectedRow() == row) { //
			return true;
		} else
			return false;
	}

	public static String[] getColumnNames() {
		return columnNames;
	}

	public static void setColumnNames(String[] columnNames) {
		ProductTableModel.columnNames = columnNames;
	}
	
}
