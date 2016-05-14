package banking.exceptions;

public class WithdrawalLimitExceeded extends WithdrawalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6616133926521754632L;

	public WithdrawalLimitExceeded(){
		System.out.println("You have reached your daily withdrawal limit!");
	}
}
