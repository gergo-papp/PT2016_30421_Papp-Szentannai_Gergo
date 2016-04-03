package utcn.pt.orderManagement.presentation.gui.content;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import utcn.pt.orderManagement.presentation.gui.tables.ProductTableModel;

public class ProductPanel extends InternalPanel {

	private static final long serialVersionUID = 7993245199050175652L;
	private JPanel headerPanel;
	private JScrollPane contentPanel;

	private JButton addProductButton;
	private JButton lsitProductsButton;

	private JButton applyButton;

	private ProductTableModel productTableModel;
	private JTable table;

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
		lsitProductsButton = new JButton("List all products");

		applyButton = new JButton("Apply");
		applyButton.setEnabled(false);

		// Add ActionListeners:

		addProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		lsitProductsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		// Add buttons to headerPanel:

		headerPanel = new JPanel();

		headerPanel.add(addProductButton);
		headerPanel.add(lsitProductsButton);
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

		// TEST:
		String[] obj = { "12_5894", "Apples" };
		productTableModel.addRow(obj);
		//
	}
}
