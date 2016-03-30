package utcn.pt.orderManagement.presentation.gui.tables;

import javax.swing.table.DefaultTableModel;



public class OrderTableModel extends DefaultTableModel {
	



	private static String[] columnNames = {"Order ID","Column"};

	private static boolean isEdited = false;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3225319702897819799L;
	

	
	public OrderTableModel() {
		super( getColumnNames(),0);
		// TODO Auto-generated constructor stub
		String[] obj = {"0","testProduct"};
		addRow(obj);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		if (isEdited)
			return true;
		return false;
	}
	
	public static String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		OrderTableModel.columnNames = columnNames;
	}


	public int getColumnCount() {
		return 2;
	}


	public static boolean isEdited() {
		return isEdited;
	}


	public static void setEdited(boolean isEdited) {
		OrderTableModel.isEdited = isEdited;
	}

	
}
