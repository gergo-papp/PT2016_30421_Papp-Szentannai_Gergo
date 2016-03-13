package utcn.pt.polynomials.polynomial;

import java.util.ArrayList;
import java.util.Collections;

public class Polynom {

	private ArrayList<Monom> monoms;

	/**
	 * Creates an empty/uninitialized Polynomial without coefficients.
	 */
	public Polynom() {
		monoms = new ArrayList<Monom>();
		System.out.println("Polynomial declared (no coefficients).\n");
		// No elements are created.
	}

	/**
	 * Specifies the Polynomial as an array of integers. The index of an element
	 * corresponds to the power of the Polynomial.
	 * 
	 * @param coeff
	 */
	public Polynom(int[] coeff) {

		monoms = new ArrayList<Monom>();

		System.out.print("Input coefficients: ");
		for (int i = 0; i < coeff.length; i++) {
			System.out.print(coeff[i] + " ");
		}
		System.out.println();

		if (coeff.length == 0) {
			System.out.println("No coefficients!");
		} else {
			for (int i = 0; i < coeff.length; i++) {
				if (coeff[i] != 0) { // We can ignore 0 elements.
					Monom tempMonom = new Monom(i, coeff[i]);
					monoms.add(tempMonom);
				}

			}
		}
		System.out.println("Polynomial created.\n");
	}

	/**
	 * Specifies the Polynomial as an integer vector with 2 rows and n>0
	 * columns. The values in the first row represent the scalar value and the
	 * second row the corresponding power.
	 * 
	 * @param coeff
	 */
	public Polynom(int[][] coeff) {

		System.out.print("Input monoms: ");
		for (int i = 0; i < coeff.length; i++) {
			System.out.print(coeff[i][0] + "x^");
			System.out.print(coeff[i][1] + " ");
		}
		System.out.println();

		monoms = new ArrayList<Monom>();

		if (coeff.length == 0) {
			System.out.println("No coefficients!");
		} else if (coeff[0].length != 2) {
			System.out.println("Wrong size of array!");
		} else {
			for (int i = 0; i < coeff.length; i++) {
				if (coeff[i][0] != 0)
					monoms.add(new Monom(coeff[i][1], coeff[i][0]));
			}
			System.out.println("Polynomial created.\n");
		}

	}

	/**
	 * Organizes the Monoms based on the power, in ascending order. Mostly used
	 * for printing to the user in an easier-to-read form.
	 */
	public void sort() {
		Collections.sort(monoms, Monom.monomPowerComparator);
	}

	/**
	 * Returns the highest power of the polynomial with non-zero coefficient.
	 * 
	 * @return
	 */
	public int getGrade() {
		this.sort();
		int index = monoms.size() - 1;
		return monoms.get(index).getPower();
	}

	/**
	 * Returns the index'th monom.
	 * 
	 * @param index
	 * @return
	 */
	public int[] getMonom(int index) {
		int[] tempMonom = new int[2];
		tempMonom[0] = monoms.get(index).getPower();
		tempMonom[1] = monoms.get(index).getValue();
		return tempMonom;
	}

	/**
	 * Returns the coefficient at the specified power. Returns 0 if no such
	 * power found.
	 * 
	 * @param power
	 * @return
	 */
	public int getCoeff(int power) {
		int coeff = 0;

		for (int i = 0; i < getNrOfMonoms(); i++) {
			if (getMonom(i)[0] == power) {
				coeff = getMonom(i)[1];
			}
		}
		return coeff;
	}

	/**
	 * Returns number of monoms in the polynomial.
	 * 
	 * @return
	 */
	public int getNrOfMonoms() {
		return monoms.size();
	}

	/**
	 * Removes monoms having 0 as coefficient.
	 */
	public void removeZeroMonoms() {
		for (int i = 0; i < monoms.size(); i++) {
			if (monoms.get(i).getValue() == 0) {
				monoms.remove(i);
				i--;
			}
		}
	}
}
