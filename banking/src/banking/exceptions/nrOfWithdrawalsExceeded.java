package banking.exceptions;

public class nrOfWithdrawalsExceeded extends WithdrawalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6348697948447565568L;

	public nrOfWithdrawalsExceeded(){
		System.out.println("The number of permitted withdrawals was reached!");
	}
}
