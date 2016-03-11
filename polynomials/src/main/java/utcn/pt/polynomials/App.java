package utcn.pt.polynomials;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import utcn.pt.polynomials.gui.MainFrame;

/**
 * Entry point of the program. Start the MainFrame.
 *
 */
public class App {
	
	public static JFrame myFrame;
	
	public static void main(String[] args) {
		System.out.println("App started");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				myFrame = new MainFrame("Polynomial Calculator");
			}
		});
	}
}
