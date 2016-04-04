package utcn.pt.orderManagement.dataAccessLayer;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import utcn.pt.orderManagement.entities.Customer;

public class Database {

	private SessionFactory sessionFactory;

	/**
	 * Configures and starts a new connection to the database.
	 */
	public Database() {
		setSessionFactory(new Configuration().configure().buildSessionFactory());

	}

	@SuppressWarnings("rawtypes")
	public List listCustomers() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		List customerList = session.createQuery("FROM Customer").list();
		for (Iterator iterator = customerList.iterator(); iterator.hasNext();) {
			Customer customer = (Customer) iterator.next();
			System.out.println("Name: " + customer.getCustomerFirstName());
			System.out.println("ID: " + customer.getIdCustomer() + "\n");
		}
		session.getTransaction().commit();
		session.close();
		return customerList;
	}

	public void listOrders() {
	}

	public void listProducts() {
	}

	public void saveOrUpdate(Object entity) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		session.close();
	}

	public void remove(Object entity) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
