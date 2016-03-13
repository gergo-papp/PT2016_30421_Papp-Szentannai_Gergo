package utcn.pt.polynomials.polynomial.operators;

import utcn.pt.polynomials.polynomial.Polynom;

public interface BinaryOperator extends Operator{
	public Polynom compute(Polynom A, Polynom B);
}
