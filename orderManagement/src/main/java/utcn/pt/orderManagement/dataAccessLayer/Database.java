package utcn.pt.orderManagement.dataAccessLayer;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Database {
	
	//Session session; //session = sessionFactory.openSession();
	private SessionFactory sessionFactory;
	//session.beginTransaction();
	//session.getTransaction().commit();
	
	public Database() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	
}
