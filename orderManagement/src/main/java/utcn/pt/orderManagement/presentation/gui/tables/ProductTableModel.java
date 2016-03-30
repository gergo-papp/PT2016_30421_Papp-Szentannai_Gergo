package utcn.pt.orderManagement.presentation.gui.tables;

import javax.swing.table.DefaultTableModel;

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

	public static String[] getColumnNames() {
		return columnNames;
	}

	public static void setColumnNames(String[] columnNames) {
		ProductTableModel.columnNames = columnNames;
	}
	
}
