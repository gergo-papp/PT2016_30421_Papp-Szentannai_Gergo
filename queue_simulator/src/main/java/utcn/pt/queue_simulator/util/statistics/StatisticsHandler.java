package utcn.pt.queue_simulator.util.statistics;

import utcn.pt.queue_simulator.gui.MainFrame;

public class StatisticsHandler {

	private static double avgWaitingTime;
	private static int nrOfClients;

	private static double maxWaitingTime;
	private static int peakTime;

	public StatisticsHandler(int nrOfQueues) {

		maxWaitingTime = 0.0;
		avgWaitingTime = 0.0;
		nrOfClients = 0;
	}

	public static void displayStatistics() {

		System.out.println("Average waiting time: " + avgWaitingTime);
		System.out.println(
				"Peak waiting time: " + maxWaitingTime + ", Occured at " + peakTime / 60 + ":" + peakTime % 60);
	}

	/**
	 * Updates the average waiting time for the specified queue.
	 * 
	 * @param queueIndex
	 */
	public static void addClientWaitingTime(int waitingTime, int currentTime) {
		avgWaitingTime = ((avgWaitingTime * (double) nrOfClients) + (double) waitingTime)
				/ (double) ((double) nrOfClients + 1);
		nrOfClients++;
		System.out.println("Average waiting time: " + avgWaitingTime);
		MainFrame.printLogMessage("Average waiting time: " + avgWaitingTime + "\n");
		System.out.println("Number of clients: " + nrOfClients);

		if (avgWaitingTime > maxWaitingTime) {
			maxWaitingTime = avgWaitingTime;
			peakTime = currentTime;
		}
	}

}
