package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import gui.internalpanels.*;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8438576029794021570L;

	private InternalPanel northPanel;
	private InternalPanel centerPanel;
	private InternalPanel westPanel;
	private InternalPanel southPanel;

	/**
	 * Create the panel.
	 */
	public MainPanel() {

		initialize();

	}

	/**
	 * Initialize the contents of the panel.
	 */
	private void initialize() {

		// Set layout:

		this.setLayout(new BorderLayout());

		// Create internal panels:

		createInternalPanels();

		// Add internal panels:

		addInternalPanels();

	}

	private void createInternalPanels() {

		northPanel = new NorthPanel();
		centerPanel = new CenterPanel();
		westPanel = new WestPanel();
		southPanel = new SouthPanel();

	}

	private void addInternalPanels() {

		this.add(northPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(westPanel, BorderLayout.WEST);
		this.add(southPanel, BorderLayout.SOUTH);

	}

}
