package utcn.pt.orderManagement.businessAccessLayer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import utcn.pt.orderManagement.App;
import utcn.pt.orderManagement.entities.Customer;
import utcn.pt.orderManagement.entities.Model;
import utcn.pt.orderManagement.entities.Product;

public class EntityFetcher implements EntityHandler {

	@SuppressWarnings("unchecked")
	public static String[][] listCustomers() {

		// Clear model:
		// App.getModels().getCustomers();

		// Create input List:
		List<Customer> customerList;
		customerList = new ArrayList<Customer>(Model.database.listCustomers());

		// Fetch list from Data Access Layer:
		// customerList = Model.database.listCustomers();

		for (@SuppressWarnings("rawtypes")
		Iterator iterator = customerList.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next().toString());
			// System.out.print("ID: ");
			// System.out.print("Name: ");
		}

		// Update the model:
		App.getModels().setCustomers(new HashSet<Customer>(customerList));

		// At this point the model contains the update entities.

		// Get number of entities:
		int size = App.getModels().getCustomers().size();
		System.out.println("Size: " + size);
		if (size < 1) {
			return null;
		} else {
			// Initialize String[][] for storing rows;
			String[][] customerRows = new String[size][4];

			Iterator<Customer> iterator = App.getModels().getCustomers().iterator();
			int i = 0;

			// Insert all rows as strings:
			for (iterator = App.getModels().getCustomers().iterator(); iterator.hasNext(); i++) {
				Customer tempCustomer = (Customer) iterator.next();

				customerRows[i][0] = String.valueOf(tempCustomer.getIdCustomer());
				customerRows[i][1] = tempCustomer.getCustomerFirstName();
				customerRows[i][2] = tempCustomer.getCustomerLastName();
				customerRows[i][3] = tempCustomer.getCustomerEmail();
			}

			// Return the string:
			return customerRows;
		}
	}

	public static String[][] listOrders() {

		// Clear model:
		App.getModels().getOrders().clear();

		return null;
	}

	@SuppressWarnings("unchecked")
	public static String[][] listProducts() {

		// Clear model:
		// App.getModels().getCustomers();

		// Create input List:
		List<Product> productList;
		productList = new ArrayList<Product>(Model.database.listProducts());

		// Fetch list from Data Access Layer:
		// customerList = Model.database.listCustomers();

		for (@SuppressWarnings("rawtypes")
		Iterator iterator = productList.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next().toString());
			// System.out.print("ID: ");
			// System.out.print("Name: ");
		}

		// Update the model:
		App.getModels().setProducts(new HashSet<Product>(productList));

		// At this point the model contains the update entities.

		// Get number of entities:
		int size = App.getModels().getProducts().size();
		System.out.println("Size: " + size);
		if (size < 1) {
			return null;
		} else {
			// Initialize String[][] for storing rows;
			String[][] productRows = new String[size][4];

			Iterator<Product> iterator = App.getModels().getProducts().iterator();
			int i = 0;

			// Insert all rows as strings:
			for (iterator = App.getModels().getProducts().iterator(); iterator.hasNext(); i++) {
				Product tempProduct = (Product) iterator.next();

				productRows[i][0] = String.valueOf(tempProduct.getIdProduct());
				productRows[i][1] = tempProduct.getProductName();
				productRows[i][2] = String.valueOf(tempProduct.getQuantity());
				productRows[i][3] = tempProduct.getDescription();
			}

			// Return the string:
			return productRows;
		}
	}

}
