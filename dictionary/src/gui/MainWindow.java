package gui;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.internalpanels.SouthPanel;
import model.Dictionary;

public class MainWindow {

	private JFrame mainFrame;
	private JPanel mainPanel;
	
	public static Dictionary dictionary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		
		initialize();
		
		initDictionary();
		
	}

	private void initDictionary() {

		// Open dictionary from hard disk (or create a new file if not found):
		
		readFromSer();
		
	}
	
	private void readFromSer() {
		try {
			FileInputStream fileIn = new FileInputStream("dictionary.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			dictionary = (Dictionary) in.readObject();
			in.close();
			fileIn.close();
			SouthPanel.displayMessage("Welcome! The dictionary was successfuly loaded.");
		} catch (IOException i) {
			dictionary = new Dictionary();
			SouthPanel.displayWarningMessage("Unable to open dictionary.ser! A new dictionary was created.");
		} catch (ClassNotFoundException c) {
			SouthPanel.displayWarningMessage("Dictionary could not be opened!");
			c.printStackTrace();
			return;
		}

	}

	public static void writeToSer() {
		try {
			FileOutputStream fileOut = new FileOutputStream("dictionary.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(dictionary);
			out.close();
			fileOut.close();
			SouthPanel.displayMessage("The dictionary was successfuly saved.");
		} catch (IOException ioE) {
			ioE.printStackTrace();
			SouthPanel.displayWarningMessage("The dictionary was not saved!");

		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Create frame:
		
		mainFrame = new JFrame();
		mainFrame.setBounds(610, 290, 700, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		
		// Create panel:
		
		mainPanel = new MainPanel();
		
		// Add panel:
		
		mainFrame.add(mainPanel);
		
	}

}
