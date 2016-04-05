package utcn.pt.orderManagement;

import javax.swing.SwingUtilities;

import utcn.pt.orderManagement.entities.Model;
import utcn.pt.orderManagement.presentation.gui.MainFrame;

/**
 * Entry point of the program. Initializes classes for handling Models and the GUI.
 *
 */
public class App {

	private static Model models;
	


	public static void main(String[] args) {
		
		System.out.println("Program started");

		initGui();
		setModels(new Model());

	}
	
	
	

	private static void initGui() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				MainFrame myFrame = new MainFrame();
			}
		});
	}

	public static Model getModels() {
		return models;
	}

	public static void setModels(Model models) {
		App.models = models;
	}

}