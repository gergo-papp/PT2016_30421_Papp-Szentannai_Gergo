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



	/**
	 * 
	 */
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
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					// TODO
					// No row selected
					// Message: select a row to edit
				} else {
					// TODO
					// set current row editable
					// enable apply button
					// check for errors
					// send to business layer
				}
			}
		});
		listCustomersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = customerTableModel.getRowCount();
				for (int i = 0; i < rowCount; i++)
					customerTableModel.removeRow(0);
				TableManager.fetchCustomerRows(customerTableModel);
			}
		});
		addCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				// create new row
				// set editable
				// enable apply button
				// check input values
				// send to business layer
			}
		});
		removeCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				// get current row
				// get ID
				// send command to business layer
			}
		});

		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				// nothing if not active
				// edit or remove the current row's data (send command to
				// business layer)
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

	private void initContentPanel() {

		
		initTable();
		contentPanel = new JScrollPane(table);
		add(contentPanel, BorderLayout.CENTER);
	}

	private void initTable() {

		customerTableModel = new CustomerTableModel();
		table = new JTable(customerTableModel);
		table.setEnabled(true);
		
		// TEST:
		String[] obj = {"119917","First Last"};
		customerTableModel.addRow(obj);
		//
	}
}
