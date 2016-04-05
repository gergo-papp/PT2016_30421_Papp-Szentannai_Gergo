package utcn.pt.queue_simulator.client;

public final class ClientIdGenerator {
	
	private int uniqueId;
	
	protected ClientIdGenerator(){
		uniqueId = 0;
	}
	
	protected int generateUniqueId(){
		uniqueId++;
		return uniqueId;
	}

}
