package utcn.pt.orderManagement.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable, Comparable<Customer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8820919719111455030L;

	@Id
	private int idCustomer;
	private String customerFirstName;
	//private String customerLastName;
	//private String customerEmail;
	
	public Customer(){
		
	}
	
	public Customer(int idCustomer) {
		setIdCustomer(idCustomer);
		setCustomerFirstName(null);
	}
	
	public Customer(int idCustomer, String customerFirstName) {
		setIdCustomer(idCustomer);
		setCustomerFirstName(customerFirstName);
	}
/*
	public Customer(int idCustomer, String customerFirstName, String customerLastName) {
		setIdCustomer(idCustomer);
		setCustomerFirstName(customerFirstName);
		setCustomerLastName(customerLastName);
	}
	public Customer(int idCustomer, String customerFirstName, String customerLastName, String customerEmail) {
		setIdCustomer(idCustomer);
		setCustomerFirstName(customerFirstName);
		setCustomerLastName(customerLastName);
		setCustomerEmail(customerEmail);
	}
*/
	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public int compareTo(Customer customer) {
		return getIdCustomer() - customer.getIdCustomer();
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
/*
	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
*/

	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", customerFirstName=" + customerFirstName + "]";
	}
	

}
