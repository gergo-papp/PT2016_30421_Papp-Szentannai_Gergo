package banking.accounts;

import banking.exceptions.WithdrawalException;

/**
 * Instantiate this object if you need a temporary Account object, which holds
 * the accountId field.
 * 
 * @author gergo_000
 *
 */
public class GenericAccount extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9132895422449514658L;

	public GenericAccount(int accId) {
		super(accId);
	}

	@Override
	public void deposit(double sum) {
		System.out.println("Operation not allowed on temporary account");

	}

	@Override
	public void withdraw(double sum) throws WithdrawalException {
		System.out.println("Operation not allowed on temporary account");

	}

}
