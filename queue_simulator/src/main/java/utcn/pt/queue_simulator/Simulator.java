package utcn.pt.queue_simulator;

import java.util.Random;

import javax.swing.SwingUtilities;

import utcn.pt.queue_simulator.client.Client;
import utcn.pt.queue_simulator.client.ClientGenerator;
import utcn.pt.queue_simulator.gui.MainFrame;
import utcn.pt.queue_simulator.util.io.Environment;
import utcn.pt.queue_simulator.util.statistics.StatisticsHandler;

/**
 * Starts the ClientScheduler and initializes the Frame. Also asks the
 * ClientScheduler to randomly generate Clients based on the current time.
 * 
 * @author gergo_000
 *
 */
public class Simulator implements Runnable {

	private ClientScheduler clientScheduler;
	private ClientGenerator clientGenerator;
	private int currentTime;
	private int clientSpawnRate;
	private Random random = new Random();
	private MainFrame frame;

	public Simulator() {

		// Set start time of the simulation:
		setCurrentTime(Environment.getSimulationStartTime());

		// Initialize ClientGenerator:
		setClientGenerator(new ClientGenerator());

		// Initialize ClientScheduler:
		setClientScheduler(new ClientScheduler(Environment.getNrOfQueues()));

		// Initialize GUI:
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				frame = new MainFrame("Client queues");
			}

		});

		// Wait for the initialization of all GUI components:
		try {

			Thread.sleep(500);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		MainFrame.printLogMessage("\nSimulation started:\n\n\n");
		MainFrame.printLogMessage(this.toString() + "\n\n");
		System.out.println(this);
	}

	/**
	 * Advances time and generates new clients with a specified frequency.
	 */
	public void run() {

		System.out.println("Simulation thread started");

		int simulationEndTime = Environment.getSimulationEndTime();

		// Simulate time:

		// The simulation stops when the final time is reached and all queues
		// are empty. The simulator waits for unfinished tasks to complete.

		while (currentTime < simulationEndTime || queuesNotEmpty()) {

			// Update GUI components:
			frame.displayCurrentTime(currentTime);
			MainFrame.printLogMessage("Time: " + currentTime / 60 + ":" + currentTime % 60 + "    ");

			setClientSpawnRate();

			// Create new client with the specified frequency of
			// clientSpawnRate:
			if (clientSpawnRate != 0) {
				if (currentTime % clientSpawnRate == 0) {

					// Generate new client:
					Client client = clientGenerator.generateClient();
					MainFrame.printLogMessage("Client generated  --  Client: " + client + "\n");

					// Dispatch client to a queue:
					clientScheduler.dispatchClientToQueue(client, currentTime);

				} else {
					MainFrame.printLogMessage("\n");
				}
			} else {
				MainFrame.printLogMessage("\n");
			}

			try {
				// Sleep to simulate the real time:
				Thread.sleep(Environment.getSimulationSpeed());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Increase current time (specified in minutes):
			currentTime++;

		}


		

		MainFrame.printLogMessage("\n\n -- Final statistics --\n");

		// Display the statistics:
		System.out.println("Final statistics:");
		StatisticsHandler.displayStatistics();

		
		clientScheduler.stopQueues();
		clientScheduler.stopQueueThreads();
		
		
	}

	/**
	 * Set the spawn rate of the clients. The new value will depend on the
	 * current time and some random values for simulating real-life scenarios.
	 */
	private void setClientSpawnRate() {

		if (currentTime < Environment.getSimulationStartTime() + 90)
			// first 90 minutes : 5 minutes +- 5
			clientSpawnRate = 5 + random.nextInt(10) - 5;

		else if (currentTime < Environment.getSimulationStartTime() + 180)
			// 90-180 minutes : 2 minutes +- 1
			clientSpawnRate = 2 + random.nextInt(2) - 1;

		else if (currentTime < Environment.getSimulationStartTime() + 300)
			// 180-300 minutes : 3 minutes +- 1
			clientSpawnRate = 3 + random.nextInt(2) - 1;

		else if (currentTime < Environment.getSimulationStartTime() + 480)
			// 300-480 minutes : 10 minutes +- 5
			clientSpawnRate = 10 + random.nextInt(10) - 5;

		else if (currentTime < Environment.getSimulationStartTime() + 600)
			// 480-600 minutes : 8 minutes +- 4
			clientSpawnRate = 8 + random.nextInt(8) - 4;

		else if (currentTime > Environment.getSimulationEndTime())
			clientSpawnRate = 0;

		else
			clientSpawnRate = 2;

	}

	private boolean queuesNotEmpty() {
		return clientScheduler.areQueuesEmpty();

	}

	@Override
	public String toString() {
		return "Simulator [clientScheduler=" + clientScheduler + ", clientGenerator=" + clientGenerator
				+ ", currentTime=" + currentTime + "]";
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
