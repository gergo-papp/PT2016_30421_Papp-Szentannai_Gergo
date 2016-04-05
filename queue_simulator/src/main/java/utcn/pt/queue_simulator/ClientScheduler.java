package utcn.pt.queue_simulator;

import java.util.ArrayList;

import utcn.pt.queue_simulator.client.Client;
import utcn.pt.queue_simulator.queue.Queue;

public class ClientScheduler {

	private int nrOfQueues;
	private ArrayList<Queue> queues;

	public ClientScheduler(int nrOfQueues) {
		
		System.out.println("Client Scheduler initialized. Number of queues: " + nrOfQueues);

		this.setNrOfQueues(nrOfQueues);

		queues = new ArrayList<Queue>();

		System.out.println(queues.toString());
		
		for (int i = 0; i < getNrOfQueues(); i++) {
			queues.add(new Queue());
			new Thread(queues.get(i)).start();
			System.out.println(queues.get(i).toString());
		}
	}

	/**
	 * Dispatch the client to the shortest waiting time queue
	 * 
	 * @param client
	 */
	public void dispatchClientToQueue(Client client) {
		int shortestQueueIndex = getShortestQueueIndex();
		System.out.println("Shortest queue time:" + shortestQueueIndex);
		queues.get(shortestQueueIndex).addClient(client);
	}

	private int getShortestQueueIndex() {
		int shortestQueueIndex = Integer.MAX_VALUE;
		for (int i = 0; i < getNrOfQueues(); i++) {
			if (shortestQueueIndex > queues.get(i).getWaitingTime()) {
				shortestQueueIndex = queues.get(i).getWaitingTime();
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
