package utcn.pt.queue_simulator;

import utcn.pt.queue_simulator.util.io.Environment;
import utcn.pt.queue_simulator.Simulator;

/**
 * Entry point of the application. Sets the environment and instantiates a
 * Simulator.
 *
 */
public class App {

	@SuppressWarnings("unused")
	private static Environment environment;

	private static Simulator simulator;

	private static Thread simulationThread;

	public static void main(String[] args) {

		// Set the environment variables:
		environment = new Environment();

		// Create a simulator (controller of the application):
		simulator = new Simulator();

		// Start the controller in a new thread:
		startSimulation();

	}

	private static void startSimulation() {
		
		simulationThread = new Thread(simulator);
		simulationThread.setPriority(Thread.MAX_PRIORITY);
		simulationThread.setName("Simulator Thread");
		simulationThread.start();

	}

}
