package utcn.pt.polynomials.polynomial;

import java.util.Comparator;

public class Monom /* implements Comparable<Monom> */ {
	private int power;
	private int value;

	/**
	 * Specifies a monom as the power and value.
	 * 
	 * @param newPower
	 * @param newvalue
	 */
	public Monom(int newPower, int newvalue) {
		this.power = newPower;
		this.value = newvalue;

	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	/*
	 * public int compareTo(Monom compareMonom) { return getPower() -
	 * compareMonom.getPower(); }
	 */
	/**
	 * Compares the power of two monoms.
	 */
	public static Comparator<Monom> monomPowerComparator = new Comparator<Monom>() {
		public int compare(Monom monom1, Monom monom2) {
			return monom1.getPower() - monom2.getPower();
		}
	};

}
