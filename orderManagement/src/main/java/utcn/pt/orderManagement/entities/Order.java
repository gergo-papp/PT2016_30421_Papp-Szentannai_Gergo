package utcn.pt.orderManagement.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order implements Serializable, Comparable<Order> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5176837645059295869L;
	
	@Id
	private int idOrder;
	private int idCustomer;
	
	public String toString(){
		String data = new String(Integer.toString(idOrder));
		data += " ";
		data += Integer.toString(idCustomer);
		
		return data;
		
	}

	public Order(int idOrder, int idCustomer) {
		setIdOrder(idOrder);
		setIdCustomer(idCustomer);
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public int compareTo(Order order) {
		return getIdOrder() - order.getIdOrder();
	}

}
