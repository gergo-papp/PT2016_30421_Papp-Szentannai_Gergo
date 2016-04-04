package utcn.pt.orderManagement.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import utcn.pt.orderManagement.dataAccessLayer.Database;
import utcn.pt.orderManagement.presentation.gui.MainPanel;

/**
 * [READ]: get info from database - store acquired data in model - send model
 * parameters to TableManager - read is done on the entire database (all
 * elements have to be extracted)
 * 
 * [WRITE]: respond to a call from TableManager - check syntax then add new
 * Model - send model to database for add/update - first update models, then add
 * new model (auto check for duplicate); sent models
 */
public class Model implements Serializable {

	private static final long serialVersionUID = -2570625099474932221L;

	public static Database database;

	private Set<Customer> customers;
	private Set<Order> orders;
	private Set<Product> products;
	private Set<Warehouse> warehouses;

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
		long millis = 10;
		try {
			Thread.sleep(millis);
			database = new Database();
		} catch (InterruptedException e) {

			e.printStackTrace();
			MainPanel.setMessage("Failed to connect to database! Please restart the app.");
		}
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

	public boolean removeCustomer(int id) {
		Customer costomerToBeRemoved = new Customer(id);
		System.out.println(costomerToBeRemoved.toString());

		for (Iterator<Customer> it = customers.iterator(); it.hasNext();) {
			Customer tempCust = it.next();
			System.out.println(tempCust.toString());
			if (tempCust.equals(costomerToBeRemoved)) {
				database.remove(tempCust);
				database.remove(tempCust);
				System.out.println("Removing customer:" + tempCust);
				return true;
			}
		}
		return false;
	}

	public boolean addCustomer(Customer newCustomer) {
		if (getCustomers().add(newCustomer)) {
			database.saveOrUpdate(newCustomer);
			return true;
		}
		return false;
	}

	public boolean addProduct(Product newProduct) {

		if (getProducts().add(newProduct)) {
			database.saveOrUpdate(newProduct);
			return true;
		}
		return false;
	}

	public boolean addOrder(Order newOrder) {

		if (getOrders().add(newOrder)) {
			database.saveOrUpdate(newOrder);
			return true;
		}
		return false;
	}

	public HashSet<Customer> getCustomers() {
		return (HashSet<Customer>) customers;
	}

	public void setCustomers(HashSet<Customer> customers) {
		this.customers = customers;
	}

	public HashSet<Order> getOrders() {
		return (HashSet<Order>) orders;
	}

	public void setOrders(HashSet<Order> orders) {
		this.orders = orders;
	}

	public HashSet<Product> getProducts() {
		return (HashSet<Product>) products;
	}

	public void setProducts(HashSet<Product> products) {
		this.products = products;
	}

	public HashSet<Warehouse> getWarehouses() {
		return (HashSet<Warehouse>) warehouses;
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
