package banking.accounts;

import banking.exceptions.NotEnoughFunds;

public class SpendingAccount extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2048064505405594037L;

	public SpendingAccount(int accId) {
		super(accId);
	}

	@Override
	public void deposit(double sum) {

		setBalance(getBalance() + sum);

		setChanged();
		notifyObservers();

	}

	@Override
	public void withdraw(double sum) throws NotEnoughFunds {
		if (getBalance() >= sum) {

			setBalance(getBalance() - sum);

			setChanged();
			notifyObservers();

		} else {
			throw (new NotEnoughFunds());
		}

	}

	@Override
	public String toString() {
		return "SpendingAccount [accountId=" + getAccountId() + ", balane=" + getBalance() + "]";
	}

}
