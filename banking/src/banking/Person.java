package banking;

import java.util.Observable;
import java.util.Observer;

import banking.accounts.Account;

public class Person implements Observer {
	private int personId;
	private String name;

	public Person(String string, int i) {
		setName(string);
		setPersonId(i);
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + personId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (personId != other.personId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + "]";
	}

	@Override
	public void update(Observable observable, Object arg) {
		// TODO Auto-generated method stub
		Account account = (Account) observable;

		System.out.println("NOTIFICATION: " + this + " " + account);
	}

}
