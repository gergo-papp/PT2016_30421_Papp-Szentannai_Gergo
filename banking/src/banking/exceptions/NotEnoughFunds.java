package banking.exceptions;

public class NotEnoughFunds extends WithdrawalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3246992403594592997L;

	public NotEnoughFunds(){
		System.out.println("Not enough funds!");
	}

}
