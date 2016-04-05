package utcn.pt.queue_simulator.client;

import java.util.Random;

import utcn.pt.queue_simulator.util.exceptions.IllegalServiceTimeException;

public final class ClientServiceTimeGenerator {
	/**
	 * Minimum waiting time for each client
	 */
	private int minWaitingTime;
	/**
	 * Maximum waiting time for each client
	 */
	private int maxWaitingTime;

	// Used to generate random waiting time
	private Random random;

	/**
	 * 
	 * @param minWaitingTime
	 * @param maxWaitingTime
	 * @throws IllegalServiceTimeException
	 *             if minWaitingTime > maxWaitingTime
	 */
	ClientServiceTimeGenerator(int minWaitingTime, int maxWaitingTime) {
		random = new Random();
		this.setMinWaitingTime(minWaitingTime);
		this.setMaxWaitingTime(maxWaitingTime);
		if (getMinWaitingTime() > getMaxWaitingTime()) {
			throw new IllegalServiceTimeException();
		}
	}

	/**
	 * Generates a random service time between minWaitingTime and maxWaitingTime
	 * 
	 * @return
	 */
	protected int generateServiceTime() {

		return random.nextInt((getMaxWaitingTime() - getMinWaitingTime()) + 1) + getMinWaitingTime();
	}

	private int getMinWaitingTime() {
		return minWaitingTime;
	}

	private void setMinWaitingTime(int minWaitingTime) {
		this.minWaitingTime = minWaitingTime;
	}

	private int getMaxWaitingTime() {
		return maxWaitingTime;
	}

	private void setMaxWaitingTime(int maxWaitingTime) {
		this.maxWaitingTime = maxWaitingTime;
	}

}
