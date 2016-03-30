package utcn.pt.orderManagement.entities;

import java.io.Serializable;
import java.util.HashSet;

import utcn.pt.orderManagement.dataAccessLayer.Database;

public class Model implements Serializable {

	private static final long serialVersionUID = -2570625099474932221L;

	public static Database database;

	private HashSet<Customer> customers;
	private HashSet<Order> orders;
	private HashSet<Product> products;
	private HashSet<Warehouse> warehouses;

	private OrderProcessingDepartment orderProcessingDepartment;
	private ProductDistribution productDistribution;

	public Model() {

		initModels();
		initDatabase();
		System.out.println("Model created");
	}

	/**
	 * Initializes the database and automatically attempts to connect.
	 */
	private void initDatabase() {
		database = new Database();
	}

	/**
	 * Instantiates the models as HashSets
	 */
	private void initModels() {
		setCustomers(new HashSet<Customer>());
		setOrders(new HashSet<Order>());
		setProducts(new HashSet<Product>());
		setWarehouses(new HashSet<Warehouse>());
	}

	// TODO:
	/*
	 * READ: get info from database - store acquired data in model - send model
	 * parameters to TableManager
	 * - read is done on the entire database (all elements have to be extracted)
	 * 
	 * WRITE: respond to a call from TableManager - check syntax then add new
	 * Model - send model to database for add/update
	 * - first update models, then add new model (auto check for duplicate);
	 * sent models
	 */

	public HashSet<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(HashSet<Customer> customers) {
		this.customers = customers;
	}

	public HashSet<Order> getOrders() {
		return orders;
	}

	public void setOrders(HashSet<Order> orders) {
		this.orders = orders;
	}

	public HashSet<Product> getProducts() {
		return products;
	}

	public void setProducts(HashSet<Product> products) {
		this.products = products;
	}

	public HashSet<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(HashSet<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public OrderProcessingDepartment getOrderProcessingDepartment() {
		return orderProcessingDepartment;
	}

	public void setOrderProcessingDepartment(OrderProcessingDepartment orderProcessingDepartment) {
		this.orderProcessingDepartment = orderProcessingDepartment;
	}

	public ProductDistribution getProductDistribution() {
		return productDistribution;
	}

	public void setProductDistribution(ProductDistribution productDistribution) {
		this.productDistribution = productDistribution;
	}

}
