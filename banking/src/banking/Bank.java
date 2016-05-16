package banking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import banking.accounts.Account;
import banking.accounts.GenericAccount;
import banking.accounts.SpendingAccount;
import banking.exceptions.WithdrawalException;

public class Bank implements BankProc {

	private Map<Person, HashSet<Account>> accountMap;

	public Bank() {

		accountMap = new HashMap<Person, HashSet<Account>>();
	}

	@Override
	public void addAccountForPerson(Person person, Account account) {

		if (accountMap.containsKey(person)) {
			accountMap.get(person).add(account);
			//System.out.println("Added new account to existing person");
			//System.out.println(account + " " + person);
			return;
		}
		HashSet<Account> tempHashSet = new HashSet<Account>();
		tempHashSet.add(account);
		accountMap.put(person, tempHashSet);
		//System.out.println("Added new account to new person");
		//System.out.println(account + " " + person);

		account.addObserver(person);

	}

	@Override
	public boolean isWellFormed() {
		return true;
	}

	@Override
	public void depositMoney(int personId, int accountId, double sum) {
		
		
		
		// Search for the account
		Iterator i = accountMap.get(new Person("", personId)).iterator();
		


	}

	@Override
	public void withdrawMoney(int accountId, double sum) {/*
		try {
			//account.withdraw(sum);
		} catch (WithdrawalException e) {
			System.out.println("Transaction failed!");
		}
		*/
	}

	@Override
	public void removePerson(int personId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAccount(int accountId) {
		// TODO Auto-generated method stub
		
	}

}
