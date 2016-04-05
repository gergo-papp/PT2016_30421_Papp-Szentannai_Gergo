package utcn.pt.queue_simulator.client;

import utcn.pt.queue_simulator.util.io.Environment;

public final class ClientGenerator {

	/**
	 * Minimum waiting time for each client
	 */
	private int minWaitingTime;
	/**
	 * Maximum waiting time for each client
	 */
	private int maxWaitingTime;

	/**
	 * Maximum number of active queues. The actual number of active queues
	 * varies between 0 and nrOfQueues
	 */
	private int nrOfQueues;



	private ClientIdGenerator clientIdGenerator;
	private ClientServiceTimeGenerator clientServiceTimeGenerator;

	public ClientGenerator() {
		System.out.println("Client generator initialized");
		
		setMinWaitingTime(Environment.getMinWaitingTime());
		setMaxWaitingTime(Environment.getMaxWaitingTime());
		setNrOfQueues(Environment.getNrOfQueues());
		
		clientIdGenerator = new ClientIdGenerator();
		clientServiceTimeGenerator = new ClientServiceTimeGenerator(getMinWaitingTime(), getMaxWaitingTime());
		
	}
	


	public Client generateClient(){
		int clientId = clientIdGenerator.generateUniqueId();
		int serviceTime = clientServiceTimeGenerator.generateServiceTime();
		
		Client client = new Client(clientId, serviceTime);
		
		return client;
	}

	public int getMinWaitingTime() {
		return minWaitingTime;
	}

	public void setMinWaitingTime(int minWaitingTime) {
		this.minWaitingTime = minWaitingTime;
	}

	public int getMaxWaitingTime() {
		return maxWaitingTime;
	}

	public void setMaxWaitingTime(int maxWaitingTime) {
		this.maxWaitingTime = maxWaitingTime;
	}

	public int getNrOfQueues() {
		return nrOfQueues;
	}

	public void setNrOfQueues(int nrOfQueues) {
		this.nrOfQueues = nrOfQueues;
	}

}
