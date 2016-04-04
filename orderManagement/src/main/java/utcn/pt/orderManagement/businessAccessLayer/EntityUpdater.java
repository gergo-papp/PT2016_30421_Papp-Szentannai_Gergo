package utcn.pt.orderManagement.businessAccessLayer;

import utcn.pt.orderManagement.App;
import utcn.pt.orderManagement.entities.Customer;
import utcn.pt.orderManagement.entities.Order;
import utcn.pt.orderManagement.entities.Product;

public class EntityUpdater implements EntityHandler{

	/**
	 * Creates a new Customer from the Strings. Nothing is done if the customer
	 * ID is already present.
	 * 
	 * @param columns
	 */
	public static void addCustomer(String[] columns) {

		// Get Integer ID:
		int id = Integer.parseInt(columns[0]);

		// Create new customer:
		Customer newCustomer = new Customer(id, columns[1], columns[2], columns[3]);

		// Add new customer:
		App.getModels().addCustomer(newCustomer);
	}

	/**
	 * Updates (or creates if missing) the Customer specifies by column[0] and
	 * sets the fields based on the other column values.
	 * 
	 * @param columns
	 */
	public static void editCustomer(String[] columns) {

		// Get Integer ID:
		int id = Integer.parseInt(columns[0]);
		Customer newCustomer = new Customer(id, columns[1], columns[2], columns[3]);

		// Removes the existing customer:
		App.getModels().getCustomers().remove(new Customer(id));

		// Adding the customer with the same ID but updated values:
		App.getModels().addCustomer(newCustomer);
	}

	public static void addProduct(String[] columns) {

		// Get Integer ID:
		int id = Integer.parseInt(columns[0]);
		int quantity = Integer.parseInt(columns[2]);

		// Create new product:
		Product newProduct = new Product(id, columns[1], quantity, columns[3]);

		// Add new product:
		App.getModels().addProduct(newProduct);
	}

	public static void addOrder(String[] columns) {
		// TODO generate order
	}

}
