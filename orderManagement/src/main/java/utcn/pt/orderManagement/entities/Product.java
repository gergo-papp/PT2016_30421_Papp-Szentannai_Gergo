package utcn.pt.orderManagement.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product implements Serializable, Comparable<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6109307712760808214L;

	@Id
	private int idProduct;
	private String productName;
	private int quantity;
	private String description;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "OrderProcessing", joinColumns = { @JoinColumn(name = "idProduct") }, inverseJoinColumns = {
			@JoinColumn(name = "idOrder") })
	private Set<Order> orders = new HashSet<Order>();


	

	public Product() {
		setQuantity(0);
	}

	public Product(int idProduct, String productName) {
		setQuantity(0);
		setIdProduct(idProduct);
		setProductName(productName);
	}

	public Product(int idProduct, String productName, int quantity, String description) {
		setDescription(description);
		setQuantity(quantity);
		setIdProduct(idProduct);
		setProductName(productName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProduct;
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
		Product other = (Product) obj;
		if (idProduct != other.idProduct)
			return false;
		return true;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int compareTo(Product product) {
		return getIdProduct() - product.getIdProduct();
	}

	public int getQuantity() {
		return quantity;
	}

	public boolean setQuantity(int quantity) {
		if (quantity < 0)
			return false;
		else {
			this.quantity = quantity;
			return true;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public String getProductDescription() { return productDescription; }
	 * 
	 * 
	 * public void setProductDescription(String productDescription) {
	 * this.productDescription = productDescription; }
	 * 
	 */

}
