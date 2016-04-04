package utcn.pt.orderManagement.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer implements Serializable, Comparable<Customer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8820919719111455030L;

	@Id
	private int idCustomer;
	
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	private int nrOfOrders;
	
    @OneToMany(mappedBy="idOrder")
    private Set<Order> orders;

	
	public Customer(){
		updateNrOfOrders();
	}
	
	public Customer(int idCustomer) {
		//updateNrOfOrders();
		setIdCustomer(idCustomer);
		setCustomerFirstName(null);
	}
	
	public Customer(int idCustomer, String customerFirstName) {
		updateNrOfOrders();
		setIdCustomer(idCustomer);
		setCustomerFirstName(customerFirstName);
	}

	public Customer(int idCustomer, String customerFirstName, String customerLastName) {
		setIdCustomer(idCustomer);
		setCustomerFirstName(customerFirstName);
		setCustomerLastName(customerLastName);
		updateNrOfOrders();
	}
	public Customer(int idCustomer, String customerFirstName, String customerLastName, String customerEmail) {
		setIdCustomer(idCustomer);
		setCustomerFirstName(customerFirstName);
		setCustomerLastName(customerLastName);
		setCustomerEmail(customerEmail);
		updateNrOfOrders();
	}

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


	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", customerFirstName=" + customerFirstName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCustomer;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Customer other = (Customer) obj;
		if (idCustomer != other.idCustomer)
			return false;
		return true;
	}

	public int getNrOfOrders() {
		updateNrOfOrders();
		return nrOfOrders;
	}

	public void updateNrOfOrders() {
		if (orders==null)
			this.nrOfOrders = 0;
		else
			this.nrOfOrders = orders.size();
	}

	

}
