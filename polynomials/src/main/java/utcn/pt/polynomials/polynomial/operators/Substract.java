package utcn.pt.polynomials.polynomial.operators;

import utcn.pt.polynomials.polynomial.Polynom;

public class Substract implements BinaryOperator {

	public Polynom compute(Polynom A, Polynom B) {
		int i;
		int max = max(A.getGrade(), B.getGrade())+1;
		int coeff[] = new int[max];

		for (i = 0; i < max; i++) {
			coeff[i] = A.getCoeff(i) - B.getCoeff(i);
		}
		Polynom P = new Polynom(coeff);
		P.removeZeroMonoms();
		return P;
	}

	/**
	 * Returns the maximal value between to integers.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private int max(int a, int b) {
		return (a < b ? b : a);
	}

}
