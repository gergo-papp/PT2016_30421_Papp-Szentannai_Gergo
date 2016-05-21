package banking.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import banking.Bank;
import banking.Person;
import banking.accounts.Account;
import banking.gui.dialogs.AddAccountForPersonDialog;
import banking.gui.dialogs.AddPersonDialog;
import banking.gui.dialogs.DepositDialog;
import banking.gui.dialogs.RemoveAccountFromPersonDialog;
import banking.gui.dialogs.RemovePersonDialog;
import banking.gui.dialogs.WithdrawDialog;

public class Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2897463159211883771L;
	
	private JButton addPersonButton;
	private JButton removePersonButton;
	private JButton addAccountForPersonButton;
	private JButton removeAccountFromPersonButton;

	private JButton depositButton;
	private JButton withdrawButton;

	private static JTable table;
	private static TableModel tableModel;
	
	private JPanel buttonPanel;
	private JScrollPane scrollTablePane;
	
	private static Bank bank;

	/**
	 * Create the panel.
	 * @param bank 
	 */
	public Panel(Bank bank) {
		
		Panel.bank = bank;
			
		initPanelComponents(bank);
		
	}

	private void initPanelComponents(Bank bank) {
		
		setLayout(new BorderLayout());
		
		buttonPanel = new JPanel();

		initButtons(bank);
		addButtons();
		
		this.add(buttonPanel, BorderLayout.NORTH);

		initAndAddTable();

		this.setVisible(true);

	}

	private void initAndAddTable() {
		table = new JTable();
		
		tableModel = new TableModel();
		

		table.setModel(tableModel);
		
		scrollTablePane = new JScrollPane(table);

		this.add(scrollTablePane, BorderLayout.CENTER);
		
		refreshTable();

	}
	
	public static void refreshTable(){
		
		int rowCount = tableModel.getRowCount();
		
		// Remove all rows
		
		for (int i = 0; i< rowCount; i++){
			tableModel.removeRow(0);
		}
		
		
		
		Map<Account, Person> persAccPairs = bank.getAllAccounts();
		
		for (Map.Entry<Account, Person> entry : persAccPairs.entrySet())
		{
			String coll1, coll2, coll3;
			
			coll1 = new String(String.valueOf(entry.getValue().getPersonId()));
			coll2 = entry.getValue().getName();
			coll3 = entry.getKey().toString();
			
			Object rowData[] = {coll1, coll2, coll3};
			tableModel.addRow(rowData);
			
		}
		
		table.repaint();
		table.revalidate();
		
		
	}

	private void initButtons(Bank bank) {
		addPersonButton = new JButton("Add person");
		addPersonButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							@SuppressWarnings("unused")
							JDialog dialog = new AddPersonDialog(bank);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}

		});
		removePersonButton = new JButton("Remove person");
		removePersonButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							@SuppressWarnings("unused")
							JDialog dialog = new RemovePersonDialog(bank);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}

		});
		addAccountForPersonButton = new JButton("Add account for person");
		addAccountForPersonButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							@SuppressWarnings("unused")
							JDialog dialog = new AddAccountForPersonDialog(bank);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}

		});
		removeAccountFromPersonButton = new JButton("Remove account from person");
		removeAccountFromPersonButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							@SuppressWarnings("unused")
							JDialog dialog = new RemoveAccountFromPersonDialog(bank);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}

		});

		depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							@SuppressWarnings("unused")
							JDialog dialog = new DepositDialog(bank);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}

		});
		withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							@SuppressWarnings("unused")
							JDialog dialog = new WithdrawDialog(bank);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}

		});

	}

	private void addButtons() {
		buttonPanel.add(addPersonButton);
		buttonPanel.add(removePersonButton);
		buttonPanel.add(addAccountForPersonButton);
		buttonPanel.add(removeAccountFromPersonButton);

		buttonPanel.add(depositButton);
		buttonPanel.add(withdrawButton);

	}

}
