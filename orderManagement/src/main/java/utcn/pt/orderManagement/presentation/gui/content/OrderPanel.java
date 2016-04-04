package utcn.pt.orderManagement.presentation.gui.content;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import utcn.pt.orderManagement.presentation.gui.MainPanel;
import utcn.pt.orderManagement.presentation.gui.tables.OrderTableModel;

public class OrderPanel extends InternalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel headerPanel;
	private JScrollPane contentPanel;

	private JButton addOrderButton;
	private JButton lsitOrdersButton;

	private JButton applyButton;

	private OrderTableModel orderTableModel;
	private JTable table;

	private static int selectedRow = -1;
	private String updateMode = new String();

	public OrderPanel() {

		// Set layout:

		this.setLayout(new BorderLayout(10, 10));

		// Instantiate buttons:

		initButtons();

		// Add content panel:

		initContentPanel();

	}

	private void initButtons() {
		addOrderButton = new JButton("Add order");
		lsitOrdersButton = new JButton("List all orders");

		applyButton = new JButton("Apply");
		applyButton.setEnabled(false);

		// Add ActionListeners:

		addOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] initColumns = { "<Order ID>", "<Product ID>" };
				orderTableModel.insertRow(0, initColumns);
				selectedRow = 0;
				applyButton.setEnabled(true);
				setUpdateMode("add_order");
				MainPanel.setMessage("Enter order details then press Apply!");
			}
		});

		lsitOrdersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fetch all customer rows - all rows will be written into the
				// argument customerTableModel:
				TableManager.fetchOrderRows(orderTableModel);
				applyButton.setEnabled(false);
				MainPanel.setMessage("Listing all orders...");
			
			}
		});

		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedRow != -1) { // Check if a row is selected

					// Get details of the row:
					String[] columns = { (String) table.getValueAt(selectedRow, 0),
							(String) table.getValueAt(selectedRow, 1) };

					// Send the String details of the row to the Table Manager:
					TableManager.addEntity(getUpdateMode(), columns);

					// Reset the apply button:
					applyButton.setEnabled(false);

					// Display the current operation to the user:
					if (getUpdateMode().equals("add_order")) {
						MainPanel.setMessage("Adding order...");
					}
				}

				else {
					MainPanel.setMessage("Please select a row and make the necessary changes.");
					applyButton.setEnabled(false);
				}
			}
		});

		// Add buttons to headerPanel:

		headerPanel = new JPanel();

		headerPanel.add(addOrderButton);
		headerPanel.add(lsitOrdersButton);
		headerPanel.add(applyButton);

		add(headerPanel, BorderLayout.NORTH);
	}

	protected void initContentPanel() {

		initTable();
		contentPanel = new JScrollPane(table);
		add(contentPanel, BorderLayout.CENTER);

	}

	private void initTable() {

		orderTableModel = new OrderTableModel();
		table = new JTable(orderTableModel);
		table.setEnabled(true);

	}

	public static int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		OrderPanel.selectedRow = selectedRow;
	}

	public String getUpdateMode() {
		return updateMode;
	}

	public void setUpdateMode(String updateMode) {
		this.updateMode = updateMode;
	}

}
