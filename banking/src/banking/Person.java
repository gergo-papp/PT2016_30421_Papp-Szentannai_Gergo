package banking;

import java.util.Observable;
import java.util.Observer;

public class Person implements Observer {
	int personId;
	String name;

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
	public void update(Observable observable, Object person) {
		// TODO Auto-generated method stub
		Account account = (Account)observable;
		
		System.out.println("Account updated: " + (Person)person + account);
	}

}
