package gui.internalpanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

import gui.MainWindow;

/**
 * Contains operations for saving and closing the application. It also displays
 * messages.
 * 
 * @author gergo_000
 *
 */
public class SouthPanel extends InternalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2254002020574655740L;

	private static JTextField messageField;
	private JButton saveButton;


	/**
	 * Create the panel.
	 */
	public SouthPanel() {

		initialize();

		// Display welcome message:
		
		displayMessage("Welcome!");

	}
	
	
	public static void displayMessage(String message) {
		messageField.setForeground(Color.black);
		messageField.setText(message);
	}
	
	public static void displayWarningMessage(String message) {
		messageField.setForeground(Color.red);
		messageField.setText(message);
	}
	

	private void initialize() {

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		createComponents();

		addComponents();
		
	}

	private void createComponents() {

		messageField = new JTextField();
		messageField.setEditable(false);
		

		saveButton = new JButton("Save");
		String messageTooltipText = "Saves the changes made by the user to the hard disk.";
		saveButton.setToolTipText(messageTooltipText);
		
		// Add actionListener:
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Save dictionary
				MainWindow.writeToSer();
			}
		});

	}

	private void addComponents() {

		this.add(messageField);
		add(Box.createHorizontalStrut(5));
		this.add(saveButton);

	}
	


}
