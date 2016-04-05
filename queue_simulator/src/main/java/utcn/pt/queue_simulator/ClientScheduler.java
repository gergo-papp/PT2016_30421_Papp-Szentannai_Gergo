package utcn.pt.queue_simulator;

import utcn.pt.queue_simulator.client.Client;
import utcn.pt.queue_simulator.queue.Queue;

public class ClientScheduler {

	private int nrOfQueues;
	private Queue[] queues;

	public ClientScheduler(int nrOfQueues) {

		this.setNrOfQueues(nrOfQueues);

		queues = new Queue[getNrOfQueues()];

		for (int i = 0; i < getNrOfQueues(); i++) {
			queues[i] = new Queue();
		}
	}

	/**
	 * Dispatch the client to the shortest waiting time queue
	 * 
	 * @param client
	 */
	public void dispatchClientToQueue(Client client) {
		int shortestQueueIndex = getShortestQueueIndex();
		queues[shortestQueueIndex].addClient(client);
	}

	private int getShortestQueueIndex() {
		int shortestQueueIndex = Integer.MAX_VALUE;
		for (int i = 0; i < getNrOfQueues(); i++) {
			if (shortestQueueIndex > queues[i].getWaitingTime().intValue()) {
				shortestQueueIndex = queues[i].getWaitingTime().intValue();
			}
		}
		return 0;
	}

	public int getNrOfQueues() {
		return nrOfQueues;
	}

	public void setNrOfQueues(int nrOfQueues) {
		this.nrOfQueues = nrOfQueues;
	}
}
