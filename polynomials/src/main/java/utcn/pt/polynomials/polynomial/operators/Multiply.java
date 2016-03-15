package utcn.pt.polynomials.polynomial.operators;

import java.util.ArrayList;

import utcn.pt.polynomials.polynomial.Polynom;

public class Multiply implements BinaryOperator {

	public Polynom compute(Polynom A, Polynom B) {

		A.sort();
		B.sort();

		int nrOfMonomsA = A.getGrade() + 1;
		int nrOfMonomsB = B.getGrade() + 1;

		ArrayList<int[]> newCoefficients = new ArrayList<int[]>();
		int monomToBeAdded[] = new int[2];

		for (int i = 0; i < nrOfMonomsA; i++) {
			for (int j = 0; j < nrOfMonomsB; j++) {

				System.out.println("i=" + i + ", j=" + j);

				// Calculate new value (multiply elements one by one):

				monomToBeAdded[1] = A.getCoeff(i) * B.getCoeff(j); // coefficient
				System.out.println("coeff: " + A.getCoeff(i) + " * " + B.getCoeff(j));

				monomToBeAdded[0] = i + j; // power
				System.out.println("power: " + i + " + " + j);

				// Adding element (if not zero):

				System.out.println("monom to be added: " + monomToBeAdded[1] + "x^" + monomToBeAdded[0]
						+ " at location " + newCoefficients.size());

				int[] temp;
				temp = new int[2];
				temp[1] = monomToBeAdded[0];
				temp[0] = monomToBeAdded[1];

				if (temp[0] != 0)///////////////////////////////////
					newCoefficients.add(temp);
			}
		}

		int[][] tempArray = new int[newCoefficients.size()][2];

		for (int i = 0; i < newCoefficients.size(); i++) {
			System.out.print(newCoefficients.get(i)[1] + "x^");
			System.out.print(newCoefficients.get(i)[0] + " ");

		}

		Polynom P = new Polynom(newCoefficients.toArray(tempArray));
		//return P.combineMonomsWithSamePower();
		return P;
	}

}
