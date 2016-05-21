package banking.gui;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

	private static final long serialVersionUID = -503979692677095346L;

	private static String[] columnNames = { "Person ID", "Name", "Account" };

	public TableModel() {
		super(getColumnNames(), 0); // sets the column names of the table
		
	}

	public static String[] getColumnNames() {
		return columnNames;
	}

	public static void setColumnNames(String[] columnNames) {
		TableModel.columnNames = columnNames;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
