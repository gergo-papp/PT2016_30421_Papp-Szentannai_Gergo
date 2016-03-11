package utcn.pt.polynomials.polynomial;

public class Monom {
	private int power;
	private int value;
	
	public Monom(int newPower , int newvalue){
		setPower(newPower);
		setValue(newvalue);
		
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

}
