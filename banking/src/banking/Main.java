package banking;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankProc bank = new Bank();
		
		Person person = new Person();

		Account account = new SpendingAccount(6161);

		bank.addAccountForPerson(person, account);
		
		
	}

}
