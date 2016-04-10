package utcn.pt.queue_simulator.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

import utcn.pt.queue_simulator.client.Client;
import utcn.pt.queue_simulator.util.io.Environment;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	// Size of application frame:
	private final int frameWidth = 950;
	private final int frameHeight = 600;

	// Size of screen (resolution):
	private int screenWidth = 1920;
	private int screenHeight = 1080;

	// Center of the screen:
	private Point centeredFrameLocation = new Point((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);

	private static JPanel panel;
	private JTextField timeField;
	private static JPanel contentPanel;

	private static JScrollPane[] scrollPane;
	private static JList<Client>[] customerList;
	private Dimension textDimension = new Dimension(10, 100);

	private JScrollBar speedScroller;

	private static JScrollPane logPane;
	private static JTextArea logText;

	public MainFrame(String title) {
		super(title);

		initFrame();
		initPanel();

	}

	private void initFrame() {

		this.setSize(frameWidth, frameHeight);
		this.setLocation(centeredFrameLocation);

		this.setVisible(true);
		// this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		System.out.println("Frame initialized");

	}

	private void initPanel() {

		panel = new JPanel();
		panel.setLayout(new BorderLayout());

		initNorth();
		initWest();
		initCenter();
		initSouth();

		System.out.println("Main Panel added");

	}

	private void initNorth() {
		timeField = new JTextField();
		timeField.setEditable(false);
		timeField.setBackground(Color.cyan);

		Font timeFont = new Font("SansSerif", Font.BOLD, 20);
		timeField.setFont(timeFont);
		timeField.setSelectedTextColor(Color.black);
		timeField.setSelectionColor(Color.cyan);

		panel.add(timeField, BorderLayout.NORTH);
	}

	@SuppressWarnings("unchecked")
	private void initCenter() {
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));

		int nrOfQueues = Environment.getNrOfQueues();
		scrollPane = new JScrollPane[nrOfQueues];
		customerList = new JList[nrOfQueues];

		contentPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		for (int i = 0; i < nrOfQueues; i++) {
			customerList[i] = new JList<Client>();
			customerList[i].setMinimumSize(textDimension);
			customerList[i].setMaximumSize(textDimension);
			customerList[i].setSize(textDimension);
			scrollPane[i] = new JScrollPane(customerList[i]);
			scrollPane[i].setSize(textDimension);

			JViewport jv1 = new JViewport();
			jv1.setView(new JLabel("waitingTime:"));
			scrollPane[i].setColumnHeader(jv1);

			contentPanel.add(scrollPane[i]);
			contentPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		}
		panel.add(contentPanel, BorderLayout.CENTER);
		add(panel);
	}

	private void initWest() {

		speedScroller = new JScrollBar();
		speedScroller.getModel().setMinimum(1);
		speedScroller.getModel().setMaximum(200);
		speedScroller.getModel().setValue(100);
		speedScroller.addAdjustmentListener(new AdjustmentListener() {

			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				Environment.setSimulationSpeed(speedScroller.getValue());
			}

		});

		JPanel westPanel = new JPanel();
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.X_AXIS));
		westPanel.add(Box.createRigidArea(new Dimension(20, 10)));
		westPanel.add(speedScroller);
		westPanel.add(Box.createRigidArea(new Dimension(10, 10)));

		panel.add(westPanel, BorderLayout.WEST);
	}

	private void initSouth() {
		logText = new JTextArea();

		logText.setAutoscrolls(true);
		logText.setRows(10);
		logText.append("Logging\n");

		logPane = new JScrollPane(logText);
		logPane.setAutoscrolls(true);

		panel.add(logPane, BorderLayout.SOUTH);

	}

	public void displayCurrentTime(int currentTime) {
		// TODO Auto-generated method stub
		String h = new String(Integer.toString(currentTime / 60));
		String m = new String(Integer.toString(currentTime % 60));
		timeField.setText(h + ":" + m);
	}

	public static void displayData(Client[] client, int queueId, int waitingTime) {

		// setup
		scrollPane[queueId].revalidate();

		// update header (waiting time)
		JViewport jv1 = new JViewport();
		jv1.setView(new JLabel("wait " + waitingTime));
		scrollPane[queueId].setColumnHeader(jv1);

		// update list
		customerList[queueId].setListData(client);

		// clean up
		scrollPane[queueId].repaint();
		scrollPane[queueId].validate();

	}

	public static void printLogMessage(String message) {
		logText.append(message);
		logPane.getVerticalScrollBar().setValue(logPane.getVerticalScrollBar().getMaximum());
		;
	}

	public JPanel getPanel() {
		return panel;
	}

	@Override
	public String toString() {
		return "Frame [frameWidth=" + frameWidth + ", frameHeight=" + frameHeight + ", screenWidth=" + screenWidth
				+ ", screenHeight=" + screenHeight + "]";
	}

}
