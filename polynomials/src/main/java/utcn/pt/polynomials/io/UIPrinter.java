package utcn.pt.polynomials.io;

import utcn.pt.polynomials.App;
import utcn.pt.polynomials.polynomial.Polynom;

public class UIPrinter implements Printer {

	public void printPolynom(Polynom P) {
		String outputString = new String();
		
		P.sort();
		for (int i=0;i<P.getNrOfMonoms();i++){
			if (P.getMonom(i)[1]>=0)
				outputString+="+";
			outputString+=P.getMonom(i)[1];
			outputString+="x^";
			outputString+=P.getMonom(i)[0];
			outputString+=" ";
		}
		
		App.myFrame.setResult(outputString);
	}

	public void printStatus(String s) {
		App.myFrame.setStatus(s);
		
	}

}
