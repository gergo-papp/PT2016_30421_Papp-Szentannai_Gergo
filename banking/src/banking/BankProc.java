package banking;

import banking.accounts.Account;

public interface BankProc {

	/**
	 * 
	 * @pre
	 * @post
	 * 
	 * @param person
	 *            a new or already existing person
	 * @param account
	 *            the account to be mapped to the person
	 */
	void addAccountForPerson(Person person, Account account);

	/**
	 * Removes all accounts of a person then deletes it.
	 * 
	 * @pre
	 * @post
	 * 
	 * @param personId
	 */
	void removePerson(int personId);

	/**
	 * Removes the account
	 * 
	 * @param accountId
	 */
	void removeAccount(int accountId);

	void depositMoney(int personId, int accountId, double sum);

	void withdrawMoney(int accountId, double sum);

	/**
	 * Returns true if the Bank is in a good state. If the data in the bank is
	 * corrupted or damaged, false is returned.
	 * 
	 * @return
	 */
	boolean isWellFormed();

}
