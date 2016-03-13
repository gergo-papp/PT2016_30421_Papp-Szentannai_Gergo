package utcn.pt.polynomials.io;

import utcn.pt.polynomials.App;
import utcn.pt.polynomials.polynomial.Polynom;

public class UIReader {

	/**
	 * Reads a Polynomial from the specified source. The possible sources are
	 * the following:
	 * 
	 * 0: (user input A); 1: (user input B);
	 * 
	 * @param source
	 * @return
	 */
	public Polynom readPolynom(int source) {

		String inputString = new String();

		// Reading from the specified location (and storing the input as a
		// String):
		switch (source) {
		case 0:
			inputString = App.myFrame.getA();
			break;
		case 1:
			inputString = App.myFrame.getB();
			break;
		default:
			System.out.println("Incorrect source specified!");
			break;
		}

		System.out.println("Input string: " + inputString);

		// returning the Polynomial:
		return toPolynom(inputString);
	}

	/**
	 * Extracts the Polynomial from a string. The format is:
	 * [sign1][coefficient1]x^[power1] [sign2][coefficient2]x^[power2] ...
	 * 
	 * @param inputString
	 * @return
	 */
	private Polynom toPolynom(String inputString) {
		Polynom P;
		String[] tempStrings;
		tempStrings = inputString.split(" ");
		int[][] tempMonoms = new int[tempStrings.length][2];
		int x;
		try {
		for (int i = 0; i < tempStrings.length; i++) {
			System.out.println(tempStrings[i]); // for testing
			tempStrings[i].trim();
			x = tempStrings[i].indexOf("x^");
			tempMonoms[i][0] = Integer.parseInt(tempStrings[i].substring(0, x));
			tempMonoms[i][1] = Integer.parseInt(tempStrings[i].substring(x + 2, tempStrings[i].length()));
		}}
		catch (Exception e){
			System.out.println("Incorrect input format!");
			App.printer.printStatus("Incorrect input format!");
		}
		
		P = new Polynom(tempMonoms);
		return P;
	}

}
