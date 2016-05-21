package banking.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;

import banking.Bank;
import banking.accounts.Account;
import banking.Person;

public class MainWindow {

	private Bank bank;

	private JFrame frame;
	private JPanel panel;

	/**
	 * Create the application.
	 */
	public MainWindow() {

		readFromSer();

		reLinkObservers();

		initialize();

		// Add event when closing the Frame. The bank has to be serialized.
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent wE) {

				writeToSer();

				wE.getWindow().dispose();
			}
		});

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new Panel(bank);
		this.frame.setVisible(true);
		frame.add(panel);
	}

	private void reLinkObservers() {
		Iterator<Entry<Account, Person>> i = bank.getAllAccounts().entrySet().iterator();

		while (i.hasNext()) {

			Entry<Account, Person> accPersEntry = i.next();
			accPersEntry.getKey().addObserver(accPersEntry.getValue());

		}

	}

	private void readFromSer() {
		try {
			FileInputStream fileIn = new FileInputStream("bank.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			bank = (Bank) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			bank = new Bank();
		} catch (ClassNotFoundException c) {
			System.out.println("Bank class not found");
			c.printStackTrace();
			return;
		}

	}

	protected void writeToSer() {
		try {
			FileOutputStream fileOut = new FileOutputStream("bank.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(bank);
			out.close();
			fileOut.close();
		} catch (IOException ioE) {
			ioE.printStackTrace();
			System.out.println("The bank was not saved!");

		}

	}

}
