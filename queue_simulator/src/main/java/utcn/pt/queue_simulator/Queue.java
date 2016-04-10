package utcn.pt.queue_simulator;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import utcn.pt.queue_simulator.client.Client;
import utcn.pt.queue_simulator.gui.MainFrame;
import utcn.pt.queue_simulator.util.io.Environment;

/**
 * This is a runnable class and should be handled as a thread. After starting
 * the thread, you can can asynchronously add new tasks (clients). The class
 * will automatically update the waiting time for this queue and will
 * automatically send its contents to a JList which has to be already
 * instantiated.
 * 
 * The JList will be updated when a new task (client) is added or removed (after
 * processing the client, i.e. sleeping for the client's service time).
 * 
 * @author gergo_000
 *
 */
public class Queue implements Runnable {

	private boolean active;
	private int queueId;

	private BlockingQueue<Client> clientQueue;
	private AtomicInteger waitingTime;

	/**
	 * Initializes the Queue and sets active = false
	 * 
	 * @param queueId
	 */
	public Queue(int queueId) {
		
		System.out.println("Queue created");
		setQueueId(queueId);
		
		waitingTime = new AtomicInteger();
		clientQueue = new LinkedBlockingQueue<Client>();
		waitingTime.set(0);
		
		setActive(true);
		
	}

	/**
	 * Adds a new task (client) to the end of the queue. Also updates the JList
	 * and the waiting time.
	 * 
	 * @param client
	 */
	public void addClient(Client client) {
		
		clientQueue.add(client);
		waitingTime.addAndGet(client.getServiceTime());

		updateJList(getQueueId());
		
	}

	public void run() {

		// For this implementation, isActive() always returns true.
		while (isActive()) {

			try {

				// Get next element:
				// The task will automatically be suspended until the queue
				// becomes non-empty
				Client client = clientQueue.take();

				// Sleep for elements processing time
				Thread.sleep(client.getServiceTime() * Environment.getSimulationSpeed());

				// Decrease waiting time
				waitingTime.addAndGet(-client.getServiceTime());

				// Update the JList:
				updateJList(getQueueId());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Exiting thread");

		// end run()
	}

	private void updateJList(int queueId) {

		// create temporary queue:
		BlockingQueue<Client> tempClientQueue = new LinkedBlockingQueue<Client>();

		tempClientQueue.addAll(clientQueue);

		// transform the queue to an array:
		Client[] clientArray = tempClientQueue.toArray(new Client[0]);

		// send client list (as an array) to the JList:
		MainFrame.displayData(clientArray, queueId, getWaitingTime());

	}

	@Override
	public String toString() {
		return "Queue [queueId=" + queueId + "]";
	}


	public boolean isActive() {
		return active;
	}

	protected void setActive(boolean active) {
		this.active = active;
	}

	public int getWaitingTime() {
		return waitingTime.intValue();
	}

	public int getQueueId() {
		return queueId;
	}

	private void setQueueId(int queueId) {
		this.queueId = queueId;
	}

	protected boolean isNotEmpty() {
		return !clientQueue.isEmpty();
	}

}
