package banking.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import banking.Bank;
import banking.BankProc;
import banking.Person;
import banking.accounts.Account;
import banking.accounts.SavingAccount;
import banking.accounts.SpendingAccount;

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
		case 3: {

			System.out.println("\nTEST 3\n");
			test3();
			System.out.println("\nFINISHED TEST 3\n");
			break;

		}
		case 4: {

			System.out.println("\nTEST 4\n");
			test4();
			System.out.println("\nFINISHED TEST 4\n");
			break;

		}
		case 5: {

			System.out.println("\nTEST 5\n");
			test5();
			System.out.println("\nFINISHED TEST 5\n");
			break;

		}
		case 6: {

			System.out.println("\nTEST 6\n");
			test6();
			System.out.println("\nFINISHED TEST 6\n");
			break;

		}
		case 7: {

			System.out.println("\nTEST 7\n");
			test7();
			System.out.println("\nFINISHED TEST 7\n");
			break;

		}
		case 8: {

			System.out.println("\nTEST 8\n");
			test8();
			System.out.println("\nFINISHED TEST 8\n");
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

		bank.depositMoney(1, 11, 500);

		bank.withdrawMoney(1, 11, 150);

		bank.withdrawMoney(1, 11, 400);

		bank.depositMoney(1, 11, 1512.12);

	}

	private void test2() {

		// Bank
		BankProc bank = new Bank();

		// Person 2
		Person person2 = new Person("Marcello", 1);

		Account account2 = new SavingAccount(11);

		bank.addAccountForPerson(person2, account2);

		bank.depositMoney(1, 11, 50000);

		bank.withdrawMoney(1, 11, 60000);

		bank.withdrawMoney(1, 11, 300);

		bank.withdrawMoney(1, 11, 300);

		bank.withdrawMoney(1, 11, 300);

		bank.withdrawMoney(1, 11, 300);

		bank.depositMoney(1, 11, 1512.12);

	}

	private void test3() {

		// Bank
		BankProc bank = new Bank();

		// Person 2
		Person person2 = new Person("Marcello", 1);

		Account account2 = new SavingAccount(11);

		bank.addAccountForPerson(person2, account2);

		bank.depositMoney(1, 11, 50000);

		bank.depositMoney(1, 12, 50000);
		bank.depositMoney(2, 11, 50000);
		bank.depositMoney(2, 12, 50000);

	}

	private void test4() {

		// Bank
		BankProc bank = new Bank();

		// Person 1
		Person person1 = new Person("Gergo", 1);

		Account account11 = new SpendingAccount(1);
		Account account12 = new SpendingAccount(2);
		Account account21 = new SpendingAccount(3);
		Account account22 = new SpendingAccount(4);

		bank.addAccountForPerson(person1, account11);
		bank.addAccountForPerson(person1, account12);
		bank.addAccountForPerson(person1, account21);
		bank.addAccountForPerson(person1, account22);

		bank.depositMoney(1, 1, 500);
		bank.withdrawMoney(1, 1, 150);
		bank.withdrawMoney(1, 1, 400);
		bank.depositMoney(1, 1, 1512.12);

		bank.depositMoney(1, 2, 100);
		bank.withdrawMoney(1, 2, 500);
		bank.withdrawMoney(1, 2, 100);
		bank.depositMoney(1, 2, 1512.12);

		bank.depositMoney(1, 3, 10000);
		bank.withdrawMoney(1, 3, 5000);
		bank.withdrawMoney(1, 3, 400);
		bank.depositMoney(1, 3, 151.42);

		bank.depositMoney(1, 4, 500);
		bank.withdrawMoney(1, 4, 150);
		bank.withdrawMoney(1, 4, 400);
		bank.depositMoney(1, 4, 1512.12);

		bank.depositMoney(1, 1, 100);
		bank.withdrawMoney(1, 2, 200);
		bank.withdrawMoney(1, 3, 200);
		bank.depositMoney(1, 4, 300);

		bank.depositMoney(1, 1, 50);
		bank.withdrawMoney(1, 2, 400);
		bank.withdrawMoney(1, 3, 120);
		bank.depositMoney(1, 4, 40.12);

	}

	private void test5() {

		// Bank
		BankProc bank = new Bank();

		// Person 1
		Person person1 = new Person("Gergo", 1);

		// Person 2
		Person person2 = new Person("Balazs", 2);

		Account account11 = new SpendingAccount(1);
		Account account12 = new SpendingAccount(2);
		Account account21 = new SavingAccount(3);
		Account account22 = new SavingAccount(4);

		Account account31 = new SpendingAccount(5);
		Account account32 = new SavingAccount(6);

		bank.addAccountForPerson(person1, account11);
		bank.addAccountForPerson(person1, account12);
		bank.addAccountForPerson(person1, account21);
		bank.addAccountForPerson(person1, account22);

		bank.addAccountForPerson(person2, account31);
		bank.addAccountForPerson(person2, account32);

		bank.depositMoney(1, 1, 500);
		bank.withdrawMoney(1, 1, 150);
		bank.withdrawMoney(1, 1, 400);
		bank.depositMoney(1, 1, 1512.12);

		bank.depositMoney(1, 2, 100);
		bank.withdrawMoney(1, 2, 500);
		bank.withdrawMoney(1, 2, 100);
		bank.depositMoney(1, 2, 1512.12);

		bank.depositMoney(2, 5, 500);
		bank.withdrawMoney(2, 6, 150);
		bank.withdrawMoney(2, 5, 400);
		bank.depositMoney(2, 6, 1512.12);

		bank.depositMoney(2, 5, 100);
		bank.withdrawMoney(2, 6, 500);
		bank.withdrawMoney(2, 5, 100);
		bank.depositMoney(2, 6, 1512.12);

		bank.depositMoney(1, 3, 10000);
		bank.withdrawMoney(1, 3, 5000);
		bank.withdrawMoney(1, 3, 400);
		bank.depositMoney(1, 3, 151.42);

		bank.depositMoney(1, 4, 500);
		bank.withdrawMoney(1, 4, 150);
		bank.withdrawMoney(1, 4, 400);
		bank.depositMoney(1, 4, 1512.12);

		bank.depositMoney(1, 1, 100);
		bank.withdrawMoney(1, 2, 200);
		bank.withdrawMoney(1, 3, 200);
		bank.depositMoney(1, 4, 300);

		bank.depositMoney(1, 1, 50);
		bank.withdrawMoney(1, 2, 400);
		bank.withdrawMoney(1, 3, 120);
		bank.depositMoney(1, 4, 40.12);

		bank.withdrawMoney(2, 1, 400);
		bank.depositMoney(2, 3, 1512.12);
		bank.depositMoney(1, 5, 100);
		bank.withdrawMoney(1, 6, 500);

		try {
			FileOutputStream fileOut = new FileOutputStream("bank.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(bank);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("The bank was not saved!");
		}

	}

	private void test6() {
		Bank bank = null;
		try {
			FileInputStream fileIn = new FileInputStream("bank.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			bank = (Bank) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Bank class not found");
			c.printStackTrace();
			return;
		}
		bank.depositMoney(1, 1, 500);
		bank.withdrawMoney(1, 1, 150);
		bank.withdrawMoney(1, 1, 400);
		bank.depositMoney(1, 1, 1512.12);

		bank.depositMoney(1, 2, 100);
		bank.withdrawMoney(1, 2, 500);
		bank.withdrawMoney(1, 2, 100);
		bank.depositMoney(1, 2, 1512.12);

		bank.depositMoney(2, 5, 500);
		bank.withdrawMoney(2, 6, 150);
		bank.withdrawMoney(2, 5, 400);
		bank.depositMoney(2, 6, 1512.12);

		bank.depositMoney(2, 5, 100);
		bank.withdrawMoney(2, 6, 500);
		bank.withdrawMoney(2, 5, 100);
		bank.depositMoney(2, 6, 1512.12);

	}

	private void test7() {

		// Bank
		@SuppressWarnings("unused")
		BankProc bank = new Bank();

	}

	private void test8() {

		@SuppressWarnings("unused")
		Bank bank = null;
		try {
			FileInputStream fileIn = new FileInputStream("bank.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			bank = (Bank) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Bank class not found");
			c.printStackTrace();
			return;
		}

	}

}
