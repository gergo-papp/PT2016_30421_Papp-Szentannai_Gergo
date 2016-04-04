package utcn.pt.orderManagement.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity (name="Order_table")
public class Order implements Serializable, Comparable<Order> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5176837645059295869L;
	
	@Id
	private int idOrder;
	
	@ManyToMany(mappedBy="orders")
    private Set<Product> employees = new HashSet<Product>();
	
    @ManyToOne
    @JoinColumn(name="idCustomer")
    private Customer customer;
	
	public String toString(){
		String data = new String(Integer.toString(idOrder));
		data += " ";
		data += customer.getIdCustomer();
		
		return data;
		
	}

	public Order(){
		
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int compareTo(Order order) {
		return getIdOrder() - order.getIdOrder();
	}

}
