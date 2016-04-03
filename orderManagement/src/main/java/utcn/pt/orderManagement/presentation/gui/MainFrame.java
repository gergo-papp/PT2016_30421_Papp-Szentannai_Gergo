package utcn.pt.orderManagement.presentation.gui;

import java.awt.Point;
import javax.swing.JFrame;


public class MainFrame extends JFrame {

	/**
	 * Automatically generated serialVersionUID.
	 */
	private static final long serialVersionUID = -1858043989753519493L;

	// Size of application frame:
	private final int frameWidth = 800;
	private final int frameHeight = 600;

	// Size of screen (resolution):
	private int screenWidth = 1920;
	private int screenHeight = 1080;

	// Center of the screen:
	private Point centeredFrameLocation = new Point((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);

	private MainPanel mainPanel;

	/**
	 * This is the Main frame. All components and Panels are displayed within
	 * this frame.
	 */
	public MainFrame() {
		super("Order Management Application");
		initFrame();
		initPanel();
	}

	/*
	 * Initializes the frame of the whole application. This method sets the size
	 * and location of the application frame.
	 */
	private void initFrame() {

		this.setSize(frameWidth, frameHeight);
		this.setLocation(centeredFrameLocation);

		this.setVisible(true);
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		System.out.println("Main Frame initialized");

	}

	/**
	 * Initializes the panel of the MainFrame. Sets the layout.
	 */
	private void initPanel() {

		mainPanel = new MainPanel();
		add(mainPanel);
		System.out.println("Main Panel added");

	}
}
