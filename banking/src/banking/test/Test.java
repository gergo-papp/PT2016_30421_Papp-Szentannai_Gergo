package banking.test;

import banking.Bank;
import banking.BankProc;
import banking.Person;
import banking.accounts.Account;
import banking.accounts.SavingAccount;
import banking.accounts.SpendingAccount;
import banking.exceptions.WithdrawalException;

public class Test {

	public Test(int testId) {
		switch (testId) {
		case 1: {

			System.out.println("\nTEST 1\n");
			test1();
			System.out.println("\nFINISHED TEST 1\n");
			break;

		}
		case 2: {

			System.out.println("\nTEST 2\n");
			test2();
			System.out.println("\nFINISHED TEST 2\n");
			break;

		}
		default: {

			System.out.println("Invalid test case!");

		}
		}
	}

	private void test1() {
		
		// Bank
		BankProc bank = new Bank();

		// Person 1
		Person person1 = new Person("Marcello", 1);

		Account account11 = new SpendingAccount(11);

		bank.addAccountForPerson(person1, account11);
		
		bank.depositMoney(account11, 500);

		try {
			account11.withdraw(150);
		} catch (WithdrawalException e) {
			System.out.println("Transaction failed!");
		}
		try {
			account11.withdraw(400);
		} catch (WithdrawalException e1) {
			System.out.println("Transaction failed!");
		}
		
		bank.depositMoney(account11, 1512.12);

	}

	private void test2() {
		
		// Bank
		BankProc bank = new Bank();

		// Person 2
		Person person2 = new Person("Marcello", 1);

		Account account2 = new SavingAccount(11);

		bank.addAccountForPerson(person2, account2);
		
		bank.depositMoney(account2, 50000);

		try {
			account2.withdraw(60000);
		} catch (WithdrawalException e) {
			System.out.println("Transaction failed!");
		}
		try {
			account2.withdraw(300);
		} catch (WithdrawalException e1) {
			System.out.println("Transaction failed!");
		}
		try {
			account2.withdraw(300);
		} catch (WithdrawalException e1) {
			System.out.println("Transaction failed!");
		}
		try {
			account2.withdraw(300);
		} catch (WithdrawalException e1) {
			System.out.println("Transaction failed!");
		}
		try {
			account2.withdraw(300);
		} catch (WithdrawalException e1) {
			System.out.println("Transaction failed!");
		}

		
		bank.depositMoney(account2, 1512.12);
		
	}

}
