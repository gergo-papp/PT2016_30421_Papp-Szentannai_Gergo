package banking.gui.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import banking.Bank;
import banking.gui.Panel;

public class DepositDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1704018998377714408L;
	private final JPanel contentPanel = new JPanel();

	private JTextField personIdField;
	private JTextField accountIdField;
	private JTextField sumField;

	private JTextArea personIdFieldLabel;
	private JTextArea accountIdFieldLabel;
	private JTextArea sumFieldLabel;

	/**
	 * Create the dialog.
	 * 
	 * @param bank
	 */
	public DepositDialog(Bank bank) {

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		personIdField = new JTextField();
		accountIdField = new JTextField();
		sumField = new JTextField();

		personIdFieldLabel = new JTextArea("Person ID:");
		accountIdFieldLabel = new JTextArea("Account ID:");
		sumFieldLabel = new JTextArea("Sum:");

		Dimension textFieldDimension = personIdFieldLabel.getPreferredSize();

		personIdField.setPreferredSize(textFieldDimension);
		accountIdField.setPreferredSize(textFieldDimension);
		sumField.setPreferredSize(textFieldDimension);

		contentPanel.add(personIdFieldLabel);
		contentPanel.add(personIdField);
		contentPanel.add(accountIdFieldLabel);
		contentPanel.add(accountIdField);
		contentPanel.add(sumFieldLabel);
		contentPanel.add(sumField);

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Deposit");
				okButton.setActionCommand("Deposit");
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						int personId, accountId;
						double sum;

						try {
							personId = Integer.valueOf(personIdField.getText());
							accountId = Integer.valueOf(accountIdField.getText());
							sum = Double.valueOf(sumField.getText());

							bank.depositMoney(personId, accountId, sum);
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
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setVisible(true);
	}

}
