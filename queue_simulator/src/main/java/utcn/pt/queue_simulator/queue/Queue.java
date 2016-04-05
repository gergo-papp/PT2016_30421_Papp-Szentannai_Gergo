package utcn.pt.queue_simulator.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import utcn.pt.queue_simulator.client.Client;

public class Queue implements Runnable {
	
	private boolean active;



	private BlockingQueue<Client> clientQueue;
	private AtomicInteger waitingTime;
	
	/**
	 * Initializes the Queue and sets active = false
	 * @param queueId
	 */
	public Queue(){
		setClientQueue(new LinkedBlockingQueue<Client>());
		waitingTime.set(0);
		setActive(true);
	}
	
	public void addClient(Client client){
		clientQueue.add(client);
		waitingTime.addAndGet(client.getServiceTime());
	}
	
	public void run() {
		// TODO Auto-generated method stub
		// while true
		while (isActive()){
			
			try {
				
				// get element
				Client client = clientQueue.take();
				// sleep for elements processing time
				Thread.sleep(client.getServiceTime());
				// update waitingtime
				waitingTime.addAndGet(-client.getServiceTime());
				
				
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
			// sleep for elements processing time
			
	}



	public BlockingQueue<Client> getClientQueue() {
		return clientQueue;
	}

	public void setClientQueue(BlockingQueue<Client> clientQueue) {
		this.clientQueue = clientQueue;
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public AtomicInteger getWaitingTime() {
		return waitingTime;
	}

}
