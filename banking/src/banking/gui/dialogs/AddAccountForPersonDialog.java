package banking.gui.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import banking.Bank;
import banking.Person;
import banking.accounts.Account;
import banking.accounts.SavingAccount;
import banking.accounts.SpendingAccount;
import banking.gui.Panel;

public class AddAccountForPersonDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2612359555279918535L;
	private final JPanel contentPanel = new JPanel();
	
	private JTextField personIdField;
	private JTextField accountIdField;

	private JCheckBox isSavingAccount;

	private JTextArea personIdFieldLabel;
	private JTextArea accountIdFieldLabel;



	/**
	 * Create the dialog.
	 * @param bank 
	 */
	public AddAccountForPersonDialog(Bank bank) {

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		personIdField = new JTextField();
		accountIdField = new JTextField();
		isSavingAccount = new JCheckBox();

		personIdFieldLabel = new JTextArea("Person ID:");
		accountIdFieldLabel = new JTextArea("Account ID:");

		Dimension textFieldDimension = personIdFieldLabel.getPreferredSize();

		personIdField.setPreferredSize(textFieldDimension);
		accountIdField.setPreferredSize(textFieldDimension);
		isSavingAccount.setText("is saving account?");

		contentPanel.add(personIdFieldLabel);
		contentPanel.add(personIdField);
		contentPanel.add(accountIdFieldLabel);
		contentPanel.add(accountIdField);
		contentPanel.add(isSavingAccount);
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						// TODO Check if values are correct!

						// Create Person and Account objects
						Person person;
						Account account;
						
						try {
							
							person = new Person("", Integer.valueOf(personIdField.getText()));

							
							if (isSavingAccount.isSelected()) {
								// Saving account
								account = new SavingAccount(Integer.valueOf(accountIdField.getText()));
							} else {
								// Spending account
								account = new SpendingAccount(Integer.valueOf(accountIdField.getText()));
							}
							// Send objects
							bank.addAccountForPerson(person, account);
							Panel.refreshTable();
							
							setVisible(false);
						} catch (NumberFormatException ne) {
							System.out.println("Please specify correct values!");
						}					

					}

				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						// TODO Close the window without doing anything
						setVisible(false);

					}

				});
				buttonPane.add(cancelButton);
			}
		}
		this.setVisible(true);
	}

}
