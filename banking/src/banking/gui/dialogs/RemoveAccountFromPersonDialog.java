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

public class RemoveAccountFromPersonDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3059353441272508548L;
	private final JPanel contentPanel = new JPanel();

	private JTextField personIdField;
	private JTextArea personIdFieldLabel;

	private JTextField accountIdField;
	private JTextArea accountIdFieldLabel;

	/**
	 * Create the dialog.
	 * 
	 * @param bank
	 */
	public RemoveAccountFromPersonDialog(Bank bank) {

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		personIdField = new JTextField();
		accountIdField = new JTextField();

		personIdFieldLabel = new JTextArea("Person ID:");
		accountIdFieldLabel = new JTextArea("Account ID:");

		Dimension textFieldDimension = personIdFieldLabel.getPreferredSize();

		personIdField.setPreferredSize(textFieldDimension);
		accountIdField.setPreferredSize(textFieldDimension);

		contentPanel.add(personIdFieldLabel);
		contentPanel.add(personIdField);
		contentPanel.add(accountIdFieldLabel);
		contentPanel.add(accountIdField);

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
						// TODO Auto-generated method stub
						int personId, accountId;

						try {
							personId = Integer.valueOf(personIdField.getText());
							accountId = Integer.valueOf(accountIdField.getText());

							bank.removeAccount(personId, accountId);
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
						setVisible(false);

					}
				});
				buttonPane.add(cancelButton);
			}
		}
		this.setVisible(true);
	}

}
