package utcn.pt.orderManagement.presentation.gui.content;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import utcn.pt.orderManagement.presentation.gui.MainPanel;
import utcn.pt.orderManagement.presentation.gui.tables.ProductTableModel;

public class ProductPanel extends InternalPanel {

	private static final long serialVersionUID = 7993245199050175652L;
	private JPanel headerPanel;
	private JScrollPane contentPanel;

	private JButton addProductButton;
	private JButton listProductsButton;

	private JButton applyButton;

	private ProductTableModel productTableModel;
	private JTable table;

	private static int selectedRow = -1;
	private String updateMode = new String();

	public ProductPanel() {
		// Set layout:
		this.setLayout(new BorderLayout(10, 10));

		// Instantiate buttons:
		initButtons();

		// Add content panel:
		initContentPanel();
	}

	private void initButtons() {
		addProductButton = new JButton("Add product");
		listProductsButton = new JButton("List all products");

		applyButton = new JButton("Apply");
		applyButton.setEnabled(false);

		// Add ActionListeners:

		addProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] initColumns = { "<p ID>", "<p name>", "<quantity>", "<descr>" };
				productTableModel.insertRow(0, initColumns);
				selectedRow = 0;
				applyButton.setEnabled(true);
				setUpdateMode("add_product");
				MainPanel.setMessage("Enter product details then press Apply!");
			}
		});
		listProductsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fetch all customer rows - all rows will be written into the
				// argument customerTableModel:
				TableManager.fetchProductRows(productTableModel);
				applyButton.setEnabled(false);
				MainPanel.setMessage("Listing all products...");
			}
		});
		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedRow != -1) { // Check if a row is selected

					// Get details of the row:
					String[] columns = { (String) table.getValueAt(selectedRow, 0),
							(String) table.getValueAt(selectedRow, 1), (String) table.getValueAt(selectedRow, 2),
							(String) table.getValueAt(selectedRow, 3) };

					// Send the String details of the row to the Table Manager:
					TableManager.addEntity(getUpdateMode(), columns);

					// Reset the apply button:
					applyButton.setEnabled(false);

					// Display the current operation to the user:
					if (getUpdateMode().equals("add_product")) {
						MainPanel.setMessage("Adding product...");
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

		headerPanel.add(addProductButton);
		headerPanel.add(listProductsButton);
		headerPanel.add(applyButton);

		add(headerPanel, BorderLayout.NORTH);
	}

	protected void initContentPanel() {

		initTable();
		contentPanel = new JScrollPane(table);
		add(contentPanel, BorderLayout.CENTER);

	}

	private void initTable() {

		productTableModel = new ProductTableModel();
		table = new JTable(productTableModel);
		table.setEnabled(true);

	}

	public static int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		ProductPanel.selectedRow = selectedRow;
	}

	public String getUpdateMode() {
		return updateMode;
	}

	public void setUpdateMode(String updateMode) {
		this.updateMode = updateMode;
	}
}
