package banking;

import java.util.Observable;

public abstract class Account extends Observable {
	int accountId;
	double balane;
	
	public Account(){
		
	}
	public Account(int accId){
		accountId=accId;
	}

	abstract void addMoney(double sum);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
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
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balane=" + balane + "]";
	}

}
