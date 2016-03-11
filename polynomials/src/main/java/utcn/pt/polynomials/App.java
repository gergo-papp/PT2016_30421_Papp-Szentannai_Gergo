package utcn.pt.polynomials;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import utcn.pt.polynomials.gui.MainFrame;

/**
 * Entry point of the program.
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("App started");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				JFrame myFrame = new MainFrame("Polynomial Calculator");
			}
		});
	}
}
