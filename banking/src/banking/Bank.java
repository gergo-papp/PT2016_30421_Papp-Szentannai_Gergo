package banking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import banking.accounts.Account;
import banking.accounts.SpendingAccount;

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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void depositMoney(Account account, double sum) {
		
		// Search for account
		account.deposit(sum);

		// Put money
		
		//

	}

}
