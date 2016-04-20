package banking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Bank implements BankProc {

	private Map<Person, HashSet<Account>> accountMap;

	public Bank() {

		accountMap = new HashMap<Person, HashSet<Account>>();
	}

	@Override
	public void addAccountForPerson(Person person, Account account) {
		
		if (accountMap.containsKey(person)) {
			accountMap.get(person).add(account);
			return;
		}
		HashSet<Account> tampHashSet = new HashSet<Account>();
		tampHashSet.add(account);
		accountMap.put(person, tampHashSet);
		System.out.println("Added new account to new person");
		System.out.println(account + " " + person);

		account.addObserver(person);

	}

	@Override
	public boolean isWellFormed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void depositMoney(int accId, double sum) {
		// Search for account
		accountMap.get(new SpendingAccount(accId));

		// Put money

	}

}
