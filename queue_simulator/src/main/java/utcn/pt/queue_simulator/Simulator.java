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
		setClientGenerator(new ClientGenerator());
		setCurrentTime(Environment.getSimulationStartTime());
		setClientScheduler(new ClientScheduler(Environment.getNrOfQueues()));
	}

	public void run() {
		
		// TODO Auto-generated method stub
		int simulationEndTime = Environment.getSimulationEndTime();
		
		while(currentTime < simulationEndTime){
			Client client = clientGenerator.generateClient();
			clientScheduler.dispatchClientToQueue(client);
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
	}

	public ClientGenerator getClientGenerator() {
		return clientGenerator;
	}

	public void setClientGenerator(ClientGenerator clientGenerator) {
		this.clientGenerator = clientGenerator;
	}

}
