package utcn.pt.polynomials.polynomial.operators;

import utcn.pt.polynomials.polynomial.Polynom;

public class Derivate implements UnaryOperator {

	public Polynom compute(Polynom A) {

		int nrOfMonoms = A.getNrOfMonoms();
		int[][] coeff = new int[nrOfMonoms][2];

		for (int i = 0; i < nrOfMonoms; i++) {

			coeff[i][1] = A.getMonom(i)[0] - 1;
			coeff[i][0] = A.getMonom(i)[1] * A.getMonom(i)[0];
			System.out.println("term " + i + "; " + A.getMonom(i)[1] + "x^" + A.getMonom(i)[1] + ", derivated term: "
					+ coeff[1][1] + "x^" + coeff[i][0]);
		}

		Polynom P = new Polynom(coeff);
		return P;
	}

}
