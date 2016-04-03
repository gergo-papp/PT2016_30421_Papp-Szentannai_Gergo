package utcn.pt.orderManagement.presentation.gui.content;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import utcn.pt.orderManagement.presentation.gui.tables.CustomerTableModel;

public class CustomerPanel extends InternalPanel {

	private static final long serialVersionUID = 8533365157363819506L;

	private JPanel headerPanel;
	private JScrollPane contentPanel;

	private JButton listCustomersButton;
	private JButton addCustomerButton;
	private JButton editCustomerButton;
	private JButton removeCustomerButton;

	private JButton applyButton;

	private CustomerTableModel customerTableModel;
	private JTable table;

	private int selectedRow = -1;


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

		applyButton = new JButton("Apply");
		applyButton.setEnabled(false);

		// Add ActionListeners:

		editCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		});
		listCustomersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		addCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		removeCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		// Add buttons to headerPanel:

		headerPanel = new JPanel();

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

		// TEST:
		String[] obj = { "119917", "First Last" };
		customerTableModel.addRow(obj);
		//
	}

	public int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}
}
