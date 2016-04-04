package utcn.pt.orderManagement.presentation.gui.tables;

import javax.swing.table.DefaultTableModel;

import utcn.pt.orderManagement.presentation.gui.content.CustomerPanel;
import utcn.pt.orderManagement.presentation.gui.content.ProductPanel;

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

	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		if (CustomerPanel.getSelectedRow() == -1) {
			return false;
		} else if (CustomerPanel.getSelectedRow() == row) { //
			return true;
		} else
			return false;
	}
	

}
