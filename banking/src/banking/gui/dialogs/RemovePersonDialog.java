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

public class RemovePersonDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3642741655848709646L;
	private final JPanel contentPanel = new JPanel();
	
	private JTextArea personIdFieldLabel;
	private JTextField personIdField;
	



	/**
	 * Create the dialog.
	 * @param bank 
	 */
	public RemovePersonDialog(Bank bank) {
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		personIdField = new JTextField();
		personIdFieldLabel = new JTextArea("Person ID:");
		
		Dimension textFieldDimension = personIdFieldLabel.getPreferredSize();
		
		personIdField.setPreferredSize(textFieldDimension);
		
		contentPanel.add(personIdFieldLabel);
		contentPanel.add(personIdField);
		
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
						
						int personId;
						
						try{
							personId = Integer.valueOf(personIdField.getText());
							// TODO Check if values are correct!				
							bank.removePeson(personId);
							Panel.refreshTable();
							setVisible(false);
							
						} catch(NumberFormatException ne){
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
