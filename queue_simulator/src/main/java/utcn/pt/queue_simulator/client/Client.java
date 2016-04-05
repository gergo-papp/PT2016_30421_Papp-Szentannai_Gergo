package utcn.pt.queue_simulator.client;

import utcn.pt.queue_simulator.util.exceptions.IllegalServiceTimeException;

/**
 * 
 * @author gergo_000
 *
 */
public class Client {

	/**
	 * The unique ID of the client
	 */
	private int clientId;

	/**
	 * Service time in seconds
	 */
	private int serviceTime;

	/**
	 * Creates a new client with the specified parameters.
	 * 
	 * @param clientId
	 * @param serviceTime
	 * @throws IllegalServiceTimeException
	 *             if serviceTime < 0
	 */
	protected Client(int clientId, int serviceTime) throws IllegalServiceTimeException {
		this.setClientId(clientId);
		this.setServiceTime(serviceTime);
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", serviceTime=" + serviceTime + "]";
	}

	public int getClientId() {
		return clientId;
	}

	protected void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	/**
	 * Sets the service time specified in seconds
	 * 
	 * @param serviceTime
	 * @throws IllegalServiceTimeException
	 *             if serviceTime < 0
	 */
	protected void setServiceTime(int serviceTime) throws IllegalServiceTimeException {
		if (serviceTime < 0) {
			throw new IllegalServiceTimeException();
		} else {
			this.serviceTime = serviceTime;
		}

	}

}
