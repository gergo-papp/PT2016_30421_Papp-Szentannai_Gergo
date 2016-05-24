package gui.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import gui.MainWindow;

public class RemoveAllDialog extends JDialog {


	private static final long serialVersionUID = -8694739829375801520L;
	private final JPanel contentPanel = new JPanel();

	private JTextArea warningText;

	/**
	 * Create the dialog.
	 */
	public RemoveAllDialog() {
		setBounds(810, 465, 300, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			warningText = new JTextArea("Are you sure?\nThis will delete all entries in the dictionary?");
			warningText.setEditable(false);
			contentPanel.add(warningText);
		}
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Remove all!");
				okButton.setActionCommand("Remove all!");
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						MainWindow.dictionary.removeAll();
						dispose();
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
						dispose();

					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

}
