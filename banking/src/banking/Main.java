package banking;

import java.awt.EventQueue;

import banking.gui.MainWindow;
import banking.test.Test;

public class Main {

	/**
	 * The entry point of the application. Starts the Frame.
	 * 
	 */
	public static void main(String[] args) {

		// runTests();

		// Start the Window:

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					MainWindow window = new MainWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Runs various test
	 */
	@SuppressWarnings("unused")
	private static void runTests() {
		System.out.println("Starting tests\n\n");

		new Test(1);
		new Test(2);
		new Test(3);
		new Test(4);
		new Test(5); // + write contents
		new Test(6); // read from serialization

		System.out.println("\n\nAll tests have finished");

	}

}
