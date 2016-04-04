package utcn.pt.orderManagement.presentation.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import utcn.pt.orderManagement.presentation.gui.content.*;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 420414993398556961L;

	private static int hgap = 10;
	private static int vgap = 10;
	
	private Dimension frameSize = new Dimension(2,2);

	static JTextField messageField;
	private JScrollPane statusScrollPane;
	
	private static JTabbedPane tabbedPane;
	private InternalPanel customerPanel;


	private static InternalPanel orderPanel;

	private InternalPanel productPanel;

	public static void openOrderPanel(String id){
		orderPanel = new OrderPanel(id);
		String tabName = new String();
		tabName = "Orders of customer " + id;
		tabbedPane.insertTab(tabName, null, orderPanel, null, 0);
	}
	public static void closeOrderPanel(OrderPanel OrderPanel){
		tabbedPane.remove(OrderPanel);
	}
	
	
	public MainPanel() {

		setLayout(new BorderLayout(hgap, vgap));

		initPanels();
		initMessagePanel();

		System.out.println("Main Panel initialized");
	}

	private void initPanels() {
		customerPanel = new CustomerPanel();
		//orderPanel = new OrderPanel();
		productPanel = new ProductPanel();
		// homePanel = new HomePanel();
		// logInPanel = new LogInPanel();

		tabbedPane = new JTabbedPane();

		tabbedPane.addTab("Customers", customerPanel);
		//tabbedPane.addTab("Orders", orderPanel);
		tabbedPane.addTab("Products", productPanel);
		add(tabbedPane, BorderLayout.CENTER);
		
		add(Box.createRigidArea(frameSize) , BorderLayout.EAST);
		add(Box.createRigidArea(frameSize) , BorderLayout.WEST);
		add(Box.createRigidArea(frameSize) , BorderLayout.NORTH);
	}

	private void initMessagePanel() {
		messageField = new JTextField();
		statusScrollPane = new JScrollPane(messageField);
		add(statusScrollPane, BorderLayout.SOUTH);
		messageField.setPreferredSize(new Dimension(0,50));
		messageField.setEditable(false);
		setMessage("Test message");
	}

	public static void setMessage(String message) {
		messageField.setText(message);
	}
}
