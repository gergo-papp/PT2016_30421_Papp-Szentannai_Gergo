package utcn.pt.queue_simulator;

import utcn.pt.queue_simulator.util.io.Environment;
import utcn.pt.queue_simulator.Simulator;

/**
 * Entry point of the application
 *
 */
public class App {

	private static Environment environment;
	private static Simulator simulator;

	public static void main(String[] args) {

		System.out.println("App started");
		
		// Set the environment variables:
		setEnvironment(new Environment());
		setSimulator(new Simulator());
		
		new Thread(getSimulator()).start();

	}

	public Environment getEnvironment() {
		return environment;
	}

	public static void setEnvironment(Environment environment) {
		App.environment = environment;
	}

	public static Simulator getSimulator() {
		return simulator;
	}

	public static void setSimulator(Simulator simulator) {
		App.simulator = simulator;
	}
}
