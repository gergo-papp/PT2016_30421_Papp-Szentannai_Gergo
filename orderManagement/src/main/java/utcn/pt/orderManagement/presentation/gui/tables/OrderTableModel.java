package utcn.pt.orderManagement.presentation.gui.tables;

import javax.swing.table.DefaultTableModel;

import utcn.pt.orderManagement.presentation.gui.content.OrderPanel;

public class OrderTableModel extends DefaultTableModel {

	private static String[] columnNames = { "Order ID", "Product" };

	/**
	 * 
	 */
	private static final long serialVersionUID = -3225319702897819799L;

	public OrderTableModel() {
		super(getColumnNames(), 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		if (OrderPanel.getSelectedRow() == -1) {
			return false;
		} else if (OrderPanel.getSelectedRow() == row) { //
			return true;
		} else
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

}
