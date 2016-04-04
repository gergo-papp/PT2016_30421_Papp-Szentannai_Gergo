package utcn.pt.orderManagement.businessAccessLayer;

import utcn.pt.orderManagement.App;

public class EntityRemover implements EntityHandler{
	public static void removeCustomer(int id) {
		App.getModels().removeCustomer(id);
	}

}
