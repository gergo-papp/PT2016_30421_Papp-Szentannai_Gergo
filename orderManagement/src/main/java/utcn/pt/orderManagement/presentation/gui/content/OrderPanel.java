package utcn.pt.orderManagement.presentation.gui.content;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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

	OrderTableModel orderTableModel;
	private JTable table;

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
			}
		});
		lsitOrdersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = orderTableModel.getRowCount();
				for (int i = 0; i < rowCount; i++)
					orderTableModel.removeRow(0);
				TableManager.fetchOrderRows(orderTableModel);
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

		headerPanel.add(addOrderButton);
		headerPanel.add(lsitOrdersButton);
		headerPanel.add(applyButton);

		add(headerPanel, BorderLayout.NORTH);
	}

	private void initContentPanel() {
		
		initTable();
		contentPanel = new JScrollPane(table);
		add(contentPanel, BorderLayout.CENTER);

	}

	private void initTable() {

		orderTableModel = new OrderTableModel();
		table = new JTable(orderTableModel);
		table.setEnabled(true);
		
	}


}
