package utcn.pt.orderManagement.presentation.gui.tables;

import javax.swing.table.DefaultTableModel;

public class CustomerTableModel extends DefaultTableModel {

	private static final long serialVersionUID = -503979692677095346L;

	private static String[] columnNames = { "Customer ID", "Customer Name" };

	public CustomerTableModel() {
		super(getColumnNames(), 0); // sets the column names of the table
	}

	public static String[] getColumnNames() {
		return columnNames;
	}

	public static void setColumnNames(String[] columnNames) {
		CustomerTableModel.columnNames = columnNames;
	}

}
