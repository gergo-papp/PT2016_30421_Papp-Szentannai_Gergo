package utcn.pt.queue_simulator.util.io;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import utcn.pt.queue_simulator.util.exceptions.ConfigFileReadException;

public final class Environment {
	/**
	 * Minimum waiting time for each client
	 */
	private static int minWaitingTime;

	/**
	 * Maximum waiting time for each client
	 */
	private static int maxWaitingTime;

	/**
	 * Maximum number of active queues. The actual number of active queues
	 * varies between 0 and nrOfQueues
	 */
	private static int nrOfQueues;

	/**
	 * Specifies the simulation interval (lower bound)
	 */
	private static int simulationStartTime;
	/**
	 * Specifies the simulation interval (upper bound)
	 */
	private static int simulationEndTime;

	private static int simulationSpeed = 100;

	public Environment() {
		try {
			setEnvironment();
		} catch (ConfigFileReadException e) {
			System.out.println("Could not read cnfiguration file");
			e.printStackTrace();
		}
		System.out.println(this);
	}

	private void setEnvironment() throws ConfigFileReadException {
		// TODO Open configuration file and read input variables

		File configFile = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(configFile);

			doc.getDocumentElement().normalize();
			Element e = doc.getDocumentElement();

			setMinWaitingTime(Integer.parseInt(e.getAttribute("minWaitingTime")));
			setMaxWaitingTime(Integer.parseInt(e.getAttribute("maxWaitingTime")));
			setNrOfQueues(Integer.parseInt(e.getAttribute("nrOfQueues")));
			setSimulationStartTime(Integer.parseInt(e.getAttribute("simulationStartTime")));
			setSimulationEndTime(Integer.parseInt(e.getAttribute("simulationEndTime")));

		} catch (ParserConfigurationException e) {
			System.out.println("Failed to initialize document builder");
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("Error when reading from xml file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Error");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception - probably some values could not be retrieved");
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "Environment [minWaitingTime=" + minWaitingTime + ", maxWaitingTime=" + maxWaitingTime + ", nrOfQueues="
				+ nrOfQueues + ", simulationStartTime=" + simulationStartTime + ", simulationEndTime="
				+ simulationEndTime + "]";
	}

	public static int getMinWaitingTime() {
		return minWaitingTime;
	}

	private void setMinWaitingTime(int minWaitingTime) {
		Environment.minWaitingTime = minWaitingTime;
	}

	public static int getMaxWaitingTime() {
		return maxWaitingTime;
	}

	private void setMaxWaitingTime(int maxWaitingTime) {
		Environment.maxWaitingTime = maxWaitingTime;
	}

	public static int getNrOfQueues() {
		return nrOfQueues;
	}

	private void setNrOfQueues(int nrOfQueues) {
		Environment.nrOfQueues = nrOfQueues;
	}

	public static int getSimulationStartTime() {
		return simulationStartTime;
	}

	private void setSimulationStartTime(int simulationStartTime) {
		Environment.simulationStartTime = simulationStartTime;
	}

	public static int getSimulationEndTime() {
		return simulationEndTime;
	}

	private void setSimulationEndTime(int simulationEndTime) {
		Environment.simulationEndTime = simulationEndTime;
	}

	public static int getSimulationSpeed() {
		// TODO Auto-generated method stub
		return simulationSpeed;
	}

	public static void setSimulationSpeed(int simulationSpeed) {
		if (simulationSpeed < 1) {
			Environment.simulationSpeed = 1;
		} else {
			Environment.simulationSpeed = simulationSpeed;
		}
	}

	public static void modifySimulationSpeed(int delta) {
		setSimulationSpeed(getSimulationSpeed() + delta);

	}

}
