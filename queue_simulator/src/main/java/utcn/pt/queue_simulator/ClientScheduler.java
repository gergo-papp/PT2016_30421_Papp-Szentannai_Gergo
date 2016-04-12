package utcn.pt.queue_simulator;

import java.util.ArrayList;

import utcn.pt.queue_simulator.client.Client;
import utcn.pt.queue_simulator.gui.MainFrame;
import utcn.pt.queue_simulator.util.statistics.StatisticsHandler;

public class ClientScheduler {

	/**
	 * The number of queues (specified in Environment)
	 */
	private int nrOfQueues;
	public StatisticsHandler statisticsHandler;
	/**
	 * Stores each queue. Each queue has to be instantiated and then run in a
	 * thread.
	 */
	private ArrayList<Queue> queues;
	private Thread[] queueThreads;

	public ClientScheduler(int nrOfQueues) {

		this.setNrOfQueues(nrOfQueues);
		

		queues = new ArrayList<Queue>();
		statisticsHandler = new StatisticsHandler(nrOfQueues);
		queueThreads = new Thread[nrOfQueues];

		// Instantiate queues and start them in separate threads:
		for (int i = 0; i < getNrOfQueues(); i++) {
			queues.add(new Queue(i));
			queueThreads[i] = new Thread(queues.get(i));
			queueThreads[i].setDaemon(true);
			queueThreads[i].start();
			//new Thread(queues.get(i)).start();
			
			System.out.println(queues.get(i).toString());
		}
		System.out.println(this);

	}
	
	protected void stopQueueThreads(){
		MainFrame.printLogMessage("Stopping queues...\n");
		for (int i = 0; i < getNrOfQueues(); i++) {
			queueThreads[i].interrupt();
		}
	}

	/**
	 * Dispatch the client to the shortest waiting time queue
	 * 
	 * @param client
	 */
	public void dispatchClientToQueue(Client client, int currentTime) {

		int shortestQueueIndex = getShortestQueueIndex();
		StatisticsHandler.addClientWaitingTime(queues.get(shortestQueueIndex).getWaitingTime(), currentTime);

		queues.get(shortestQueueIndex).addClient(client);

	}

	/**
	 * Return the index of the shortest queue
	 * 
	 * @return shortestQueueIndex
	 */
	private int getShortestQueueIndex() {
		int shortestQueueIndex = 0;
		int shortestQueue = Integer.MAX_VALUE;
		for (int i = 0; i < getNrOfQueues(); i++) {
			if (shortestQueue > queues.get(i).getWaitingTime()) {
				shortestQueue = queues.get(i).getWaitingTime();
				shortestQueueIndex = i;
			}
		}
		return shortestQueueIndex;
	}

	private int getNrOfQueues() {
		return nrOfQueues;
	}

	private void setNrOfQueues(int nrOfQueues) {
		this.nrOfQueues = nrOfQueues;
	}

	@Override
	public String toString() {
		return "ClientScheduler [nrOfQueues=" + nrOfQueues + ", queues=" + queues + "]";
	}

	public boolean areQueuesEmpty() {
		boolean isActive = false;
		int i = 0;
		while (!isActive && i < getNrOfQueues()) {
			if (queues.get(i).isNotEmpty()) {
				isActive = true;
			}
		}
		return isActive;
	}

	protected void stopQueues() {
		for (int i = 0; i < getNrOfQueues(); i++) {
			queues.get(i).setActive(false);
		}
	}
}
