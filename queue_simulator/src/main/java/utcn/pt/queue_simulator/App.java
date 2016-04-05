package utcn.pt.queue_simulator;

import utcn.pt.queue_simulator.client.ClientGenerator;
import utcn.pt.queue_simulator.util.io.Environment;

/**
 * Entry point of the application
 *
 */
public class App {

	private static Environment environment;

	public static void main(String[] args) {

		System.out.println("App started");
		
		setEnvironment(new Environment());
		
		ClientGenerator cg = new ClientGenerator(environment);
		System.out.println(cg.generateClient().toString());
		System.out.println(cg.generateClient().toString());

	}

	public Environment getEnvironment() {
		return environment;
	}

	public static void setEnvironment(Environment environment) {
		App.environment = environment;
	}
}
