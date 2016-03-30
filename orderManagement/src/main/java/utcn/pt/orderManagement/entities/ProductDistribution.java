package utcn.pt.orderManagement.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductDistribution implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7359906523938069198L;
	
	@Id
	private int idWarehouse;
	@Id
	private int idProduct;
	private int quantity;
	
	public int getIdWarehouse() {
		return idWarehouse;
	}
	public void setIdWarehouse(int idWarehouse) {
		this.idWarehouse = idWarehouse;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int compareTo(ProductDistribution productDistribution){
		return (getIdProduct() - productDistribution.getIdProduct()) * (getIdWarehouse() - productDistribution.getIdWarehouse());
	}

}
