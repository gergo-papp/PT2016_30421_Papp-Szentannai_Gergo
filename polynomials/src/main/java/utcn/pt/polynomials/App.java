package utcn.pt.polynomials;

import java.awt.AWTEvent;
import java.io.IOException;

import javax.swing.SwingUtilities;

import utcn.pt.polynomials.gui.MainFrame;
import utcn.pt.polynomials.io.UIPrinter;
import utcn.pt.polynomials.io.UIReader;
import utcn.pt.polynomials.polynomial.Polynom;

/**
 * Entry point of the program. Start the MainFrame.
 *
 */
public class App {

	public static MainFrame myFrame;
	public static UIPrinter printer = new UIPrinter(); // Printer Class -
														// interacts with the
														// GUI.
	public static UIReader reader = new UIReader(); // Reader class - reads user
													// input and converts this
													// to Polynomials

	private static AWTEvent currentEvent;

	public static void main(String[] args) {
		System.out.println("App started");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				myFrame = new MainFrame("Polynomial Calculator");
				currentEvent = java.awt.EventQueue.getCurrentEvent();
			}
		});

		// Wait for the first thread (initialization of the Frame) to finish -
		// not a very elegant solution but works. This is needed for the test()
		// method. If the following statement is missing some parts of the GUI
		// do not initialize before test() and a NullPointerException occurs.
		while (currentEvent == java.awt.EventQueue.getCurrentEvent())
			;

		test();
	}

	private static void test() {

		//

		// Declaring Polynomial (method 1):
		int[] coeff1 = { 1, 0, -2, 3, 2 };
		Polynom P1 = new Polynom(coeff1);
		printer.printPolynom(P1);

		// Declaring Polynomial (method 2):
		int[][] coeff2 = { { 5, 0 }, { 0, 2 }, { 1, 1 }, { 1, 3 }, { -10, 4 }, { 0, 5 } };
		Polynom P2 = new Polynom(coeff2);
		printer.printPolynom(P2);

		// Declaring Polynomial (error 1):
		int[][] coeff3 = { { 0, 0, 1 } };
		Polynom P3 = new Polynom(coeff3);
		printer.printPolynom(P3);

		// Declaring Polynomial (error 2):
		int[] coeff4 = new int[0];
		Polynom P4 = new Polynom(coeff4);
		printer.printPolynom(P4);

		try {
			System.in.read();
		} catch (IOException e) {
		}

		// reading and the n displaying a Polynomial from field A (only after
		// enter is pressed in the console):
		Polynom P5 = reader.readPolynom(0);
		printer.printPolynom(P5);

	}
}
