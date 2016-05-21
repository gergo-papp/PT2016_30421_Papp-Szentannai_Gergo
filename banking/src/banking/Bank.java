package banking;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import banking.accounts.Account;
import banking.accounts.GenericAccount;
import banking.exceptions.WithdrawalException;

public class Bank implements BankProc, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1434344283847903748L;

	private Map<Person, HashSet<Account>> accountMap;

	public Bank() {

		accountMap = new HashMap<Person, HashSet<Account>>();

	}

	/**
	 * Returns each pair of person-account as a Map. A person can appear
	 * multiple times, while an account only once.
	 * 
	 * @return Map<Person, Account>
	 */
	public Map<Account, Person> getAllAccounts() {

		Map<Account, Person> persAccPairs = new HashMap<Account, Person>();
		
		for (Map.Entry<Person, HashSet<Account>> entry : accountMap.entrySet())
		{
		    Iterator<Account> i = entry.getValue().iterator();
		    
		    while(i.hasNext()){
		    	persAccPairs.put(i.next(), entry.getKey());
		    	//System.out.println("[TABLE]: " + entry.getKey() + persAccPairs.get(entry.getKey()));
		    	
		    }
		}

		return persAccPairs;

	}

	@Override
	public void addAccountForPerson(Person person, Account account) {

		if (accountMap.containsKey(person)) {
			accountMap.get(person).add(account);
			System.out.println("Added new account to existing person");
			System.out.println(account + " " + person);
			return;
		}
		HashSet<Account> tempHashSet = new HashSet<Account>();
		tempHashSet.add(account);
		accountMap.put(person, tempHashSet);
		System.out.println("Added new account to new person");
		System.out.println(account + " " + person);

		account.addObserver(person);

	}

	@Override
	public void depositMoney(int personId, int accountId, double sum) {

		assert sum > 0 : "Sum has to be greater than 0!";

		// Create person and account object:
		Person tempPerson = new Person("", personId);
		Account tempAccount = new GenericAccount(accountId);

		// Find the accounts of the created person:
		HashSet<Account> tempAccountSet = accountMap.get(tempPerson);

		if (accountMap.containsKey(tempPerson)) {

			// Search for the given account:
			for (Account currAccount : tempAccountSet) {
				// if (currAccount.equals(tempAccount)) {
				if (currAccount.equals(tempAccount)) {
					// The account was found:
					currAccount.deposit(sum);

					return;
				}
			}

			System.out.println("The specified person-account pair was not found!");
		} else {
			System.out.println("The specified person was not found!");
		}
	}

	@Override
	public void withdrawMoney(int personId, int accountId, double sum) {

		assert sum > 0 : "Sum has to be greater than 0!";

		// Create person and account object:
		Person tempPerson = new Person("", personId);
		Account tempAccount = new GenericAccount(accountId);

		// Find the accounts of the created person:
		HashSet<Account> tempAccountSet = accountMap.get(tempPerson);

		// Search for the given account:
		for (Account currAccount : tempAccountSet) {
			if (currAccount.equals(tempAccount)) {

				// The account was found:
				try {
					// Try to withdraw money:
					currAccount.withdraw(sum);
				} catch (WithdrawalException e) {
					System.out.println("Transaction failed!");
				}

				return;

			}
		}
		System.out.println("The specified person-account pair was not found!");

	}

	@Override
	public void removeAccount(int personId, int accountId) {

		// Create person and account object:
		Person tempPerson = new Person("", personId);
		Account tempAccount = new GenericAccount(accountId);

		if (accountMap.containsKey(tempPerson)) {
			// Find the accounts of the created person:
			HashSet<Account> tempAccountSet = accountMap.get(tempPerson);

			// Search for the given account:
			for (Account currAccount : tempAccountSet) {
				if (currAccount.equals(tempAccount)) {

					// The account was found - delete it:
					tempAccountSet.remove(currAccount);

					return;

				}
			}
			System.out.println("Account not found!");
			return;
		} else {
			System.out.println("Person not found!");
		}

	}

	@Override
	public boolean isWellFormed() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		return "Bank [accountMap=" + accountMap + "]";
	}

	public void removePeson(int personId) {
		// TODO Remove all accounts

		// TODO Remove person

	}

}
