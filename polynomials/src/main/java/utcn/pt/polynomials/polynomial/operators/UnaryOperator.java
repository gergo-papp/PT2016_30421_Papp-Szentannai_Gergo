package utcn.pt.polynomials.polynomial.operators;

import utcn.pt.polynomials.polynomial.Polynom;

public interface UnaryOperator extends Operator{
	public Polynom compute(Polynom A);
}
