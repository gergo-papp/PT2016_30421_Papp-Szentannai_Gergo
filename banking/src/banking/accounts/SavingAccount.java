package banking.accounts;

import banking.exceptions.NotEnoughFunds;
import banking.exceptions.WithdrawalException;
import banking.exceptions.WithdrawalLimitExceeded;
import banking.exceptions.nrOfWithdrawalsExceeded;

public class SavingAccount extends Account {

	private int availableWithdrawals;
	private double withdrawalLimit;
	private double dailyWithdrawal;

	public SavingAccount(int accId) {
		super(accId);
		setAvailableWithdrawals(2);
		setWithdrawalLimit(1000);
		setDailyWithdrawal(0);
	}

	@Override
	public void deposit(double sum) {

		setBalance(getBalance() + sum);

		setChanged();
		notifyObservers();

	}

	@Override
	public void withdraw(double sum) throws WithdrawalException {
		if (getAvailableWithdrawals()+1 > 0) {
			if (getDailyWithdrawal() + sum <= getWithdrawalLimit()) {
				if (getBalance() >= sum) {

					setBalance(getBalance() - sum);

					setDailyWithdrawal(getDailyWithdrawal() + sum);
					decreaseAvailableWithdrawals();

					setChanged();
					notifyObservers();

				} else {
					throw (new NotEnoughFunds());
				}

			} else {
				throw (new WithdrawalLimitExceeded());
			}

		} else {
			throw (new nrOfWithdrawalsExceeded());
		}

	}

	@Override
	public String toString() {
		return "SavingAccount [accountId=" + getAccountId() + ", balane=" + getBalance() + "]";
	}

	public int getAvailableWithdrawals() {
		return availableWithdrawals;
	}

	public void setAvailableWithdrawals(int availableWithdrawals) {
		this.availableWithdrawals = availableWithdrawals;
	}

	public void decreaseAvailableWithdrawals() {
		this.availableWithdrawals = getAvailableWithdrawals() - 1;
	}

	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}

	public void setWithdrawalLimit(double withdrawalLimit) {
		this.withdrawalLimit = withdrawalLimit;
	}

	public double getDailyWithdrawal() {
		return dailyWithdrawal;
	}

	public void setDailyWithdrawal(double d) {
		this.dailyWithdrawal = d;
	}

}
