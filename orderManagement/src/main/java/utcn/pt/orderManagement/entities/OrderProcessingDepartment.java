package utcn.pt.orderManagement.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderProcessingDepartment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4556106701585596258L;
	
	@Id
	private int idProduct;
	@Id
	private int idOrder;
	private int quantity;
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public int compareTo(OrderProcessingDepartment orderProcessingDepartment){
		return (getIdProduct() - orderProcessingDepartment.getIdProduct()) * (getIdOrder() - orderProcessingDepartment.getIdOrder());
	}

}
