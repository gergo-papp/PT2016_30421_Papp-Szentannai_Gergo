package utcn.pt.queue_simulator;

import utcn.pt.queue_simulator.client.Client;
import utcn.pt.queue_simulator.client.ClientGenerator;
import utcn.pt.queue_simulator.util.io.Environment;

public class Simulator implements Runnable{
	
	private ClientScheduler clientScheduler;
	private ClientGenerator clientGenerator;
	private int currentTime;
	//private Frame frame;
	
	public Simulator(){
		System.out.println("Simulator initialized");
		setClientGenerator(new ClientGenerator());
		setCurrentTime(Environment.getSimulationStartTime());
		setClientScheduler(new ClientScheduler(Environment.getNrOfQueues()));
	}

	public void run() {
		
		System.out.println("Simulation thread started");
		int simulationEndTime = Environment.getSimulationEndTime();
		
		while(currentTime < simulationEndTime){
			
			Client client = clientGenerator.generateClient();
			clientScheduler.dispatchClientToQueue(client);
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			currentTime++;
			
		}
	}

	
	
	public ClientScheduler getClientScheduler() {
		return clientScheduler;
	}

	private void setClientScheduler(ClientScheduler clientScheduler) {
		this.clientScheduler = clientScheduler;
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
		System.out.println("Current time: " + currentTime);
	}

	public ClientGenerator getClientGenerator() {
		return clientGenerator;
	}

	public void setClientGenerator(ClientGenerator clientGenerator) {
		this.clientGenerator = clientGenerator;
	}

}
