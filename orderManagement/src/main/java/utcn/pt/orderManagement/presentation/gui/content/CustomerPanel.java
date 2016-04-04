package utcn.pt.orderManagement.presentation.gui.content;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import utcn.pt.orderManagement.presentation.gui.MainPanel;
import utcn.pt.orderManagement.presentation.gui.tables.CustomerTableModel;

public class CustomerPanel extends InternalPanel {

	private static final long serialVersionUID = 8533365157363819506L;

	private JPanel headerPanel;
	private JScrollPane contentPanel;

	private JButton listCustomersButton;
	private JButton addCustomerButton;
	private JButton editCustomerButton;
	private JButton removeCustomerButton;

	private JButton orders;
	private JButton applyButton;

	private CustomerTableModel customerTableModel;
	private JTable table;

	private static int selectedRow = -1;
	private String updateMode = new String();

	public CustomerPanel() {

		// Set layout:

		this.setLayout(new BorderLayout(10, 10));

		// Instantiate buttons:

		initButtons();

		// Add content panel:

		initContentPanel();

	}

	private void initButtons() {
		listCustomersButton = new JButton("List all customers");
		addCustomerButton = new JButton("Add customer");
		editCustomerButton = new JButton("Edit customer");
		removeCustomerButton = new JButton("Remove customer");

		orders = new JButton("Orders");

		applyButton = new JButton("Apply");
		applyButton.setEnabled(false);

		// Add ActionListeners:

		orders.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO open orders Panel
				if (table.getSelectedRowCount() > 1) {
					MainPanel.setMessage("Plese select only one customer!");
					applyButton.setEnabled(false);
					selectedRow = -1;
				} else if (table.getSelectedRowCount() < 1) {
					MainPanel.setMessage("Plese select a customer!");
					applyButton.setEnabled(false);
				} else {
					selectedRow = table.getSelectedRow();
					String id = new String((String) table.getValueAt(selectedRow, 0));
					MainPanel.openOrderPanel(id);
				}

			}

		});

		editCustomerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRowCount() > 1) {
					MainPanel.setMessage("Plese select only one row!");
					applyButton.setEnabled(false);
					selectedRow = -1;
				} else if (table.getSelectedRowCount() < 1) {
					MainPanel.setMessage("Plese select a row!");
					applyButton.setEnabled(false);
				} else {
					selectedRow = table.getSelectedRow();
					setUpdateMode("edit_customer");
					applyButton.setEnabled(true);
				}
			}

		});

		listCustomersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fetch all customer rows - all rows will be written into the
				// argument customerTableModel:
				TableManager.fetchCustomerRows(customerTableModel);
				applyButton.setEnabled(false);
				MainPanel.setMessage("Listing all customers...");
			}
		});

		addCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] initColumns = { "<ID>", "<firs>","<last>","<e-mail>",""};
				customerTableModel.insertRow(0, initColumns);
				selectedRow = 0;
				applyButton.setEnabled(true);
				setUpdateMode("add_customer");
				MainPanel.setMessage("Enter customer details then press Apply!");
			}
		});

		removeCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedRow = -1;
				applyButton.setEnabled(false);
				if (table.getSelectedRowCount() > 1) {
					MainPanel.setMessage("Plese select only one row!");
				} else if (table.getSelectedRowCount() < 1) {
					MainPanel.setMessage("Plese select a row!");
				} else {
					selectedRow = table.getSelectedRow();
				}

				if (selectedRow != -1) { // Check if a row is selected
					TableManager.removeEntity("customer", (String) table.getValueAt(selectedRow, 0));
					MainPanel.setMessage("Removing curomer...");
				} else {
					MainPanel.setMessage("Please select a row to be deleted.");
				}
			}
		});

		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (selectedRow != -1) { // Check if a row is selected

					// Get details of the row:
					String[] columns = { (String) table.getValueAt(selectedRow, 0),
							(String) table.getValueAt(selectedRow, 1),(String) table.getValueAt(selectedRow, 2),(String) table.getValueAt(selectedRow, 3) };

					// Send the String details of the row to the Table Manager:
					TableManager.addEntity(getUpdateMode(), columns);

					// Reset the apply button:
					applyButton.setEnabled(false);

					// Display the current operation to the user:
					if (getUpdateMode().equals("edit_customer")) {
						MainPanel.setMessage("Editing customer...");
					} else if (getUpdateMode().equals("add_customer")) {
						MainPanel.setMessage("Adding customer...");
					}
				}

				else {
					MainPanel.setMessage("Please select a row and make the necessary changes.");
					applyButton.setEnabled(false);
				}
				selectedRow = -1;
			}
		});

		// Add buttons to headerPanel:

		headerPanel = new JPanel();

		headerPanel.add(orders);
		headerPanel.add(listCustomersButton);
		headerPanel.add(editCustomerButton);
		headerPanel.add(addCustomerButton);
		headerPanel.add(removeCustomerButton);
		headerPanel.add(applyButton);

		add(headerPanel, BorderLayout.NORTH);
	}

	protected void initContentPanel() {

		initTable();
		contentPanel = new JScrollPane(table);
		add(contentPanel, BorderLayout.CENTER);
	}

	private void initTable() {

		customerTableModel = new CustomerTableModel();
		table = new JTable(customerTableModel);
		table.setEnabled(true);

	}

	public static int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		CustomerPanel.selectedRow = selectedRow;
	}

	public String getUpdateMode() {
		return updateMode;
	}

	public void setUpdateMode(String updateMode) {
		this.updateMode = updateMode;
	}
}
