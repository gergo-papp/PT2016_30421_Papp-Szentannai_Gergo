package banking.accounts;

import banking.exceptions.WithdrawalException;

public class GenericAccount extends Account {

	public GenericAccount(int accId) {
		super(accId);
	}

	@Override
	public void deposit(double sum) {

		System.out.println("Operation not allowed on temporary account!");

	}

	@Override
	public void withdraw(double sum) throws WithdrawalException {

		System.out.println("Operation not allowed on temporary account!");

	}

}
