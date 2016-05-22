package banking;

import banking.accounts.Account;

public interface BankProc {

	/**
	 * The fields of all the parameters should be initialized. Search for an
	 * already existing Person and adds the account to it. Otherwise stores the
	 * new Person.
	 * 
	 * @pre isWellFormed(); person.personId != null; account != null && should
	 *      not already exist
	 * @post isWellFormed(); number of persons same or greater with one then
	 *       before; number of accounts greater than before
	 * 
	 * @param person
	 *            the Person to be added
	 * @param account
	 *            the Account to be added
	 */
	void addAccountForPerson(Person person, Account account);

	/**
	 * @pre isWellFormed()
	 * @post isWellFormed()
	 * 
	 * @param accountId
	 *            destination account ID
	 * @param sum
	 *            sum to be added to account
	 */
	void depositMoney(int personId, int accountId, double sum);

	/**
	 * 
	 * @pre isWellFormed()
	 * @post isWellFormed()
	 * 
	 * @param accountId
	 *            the ID of the account from which to remove money
	 * @param sum
	 *            the sum to be removed from the account
	 */
	void withdrawMoney(int personId, int accountId, double sum);

	/**
	 * Warning! If this is the last account of a person, the bank will remain in
	 * a inconsistent state. Please also remove the person in this case or add a
	 * new account.
	 * 
	 * @pre isWellFormed();
	 * @post isWellFormed(); if !isWellFormed() then remove the person that lost
	 *       its account or throw exception;
	 * 
	 * @param accountId
	 *            the ID of the account to be removed
	 */
	void removeAccount(int personId, int accountId);

	/**
	 * 
	 * Check if each there are null elements and if each person has at least one
	 * account.
	 * 
	 * @return true if the Bank is in a good state and false if the data in the
	 *         bank is corrupted or damaged
	 */
	boolean isWellFormed();

}
