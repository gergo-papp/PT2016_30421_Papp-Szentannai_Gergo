package banking;

public interface BankProc {

	/**
	 * 
	 * @param person
	 */
	void addAccountForPerson(Person person, Account account);
	
	void depositMoney(int accId, double sum);

	/**
	 * Returns true if the Bank is in a good state. If the data in the bank is
	 * corrupted or damaged, false is returned.
	 * 
	 * @return
	 */
	boolean isWellFormed();

}
