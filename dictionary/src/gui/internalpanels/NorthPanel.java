package gui.internalpanels;

import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import gui.dialogs.*;

/**
 * Contains the buttons for the basic operations.
 * 
 * @author gergo_000
 *
 */
public class NorthPanel extends InternalPanel {

	private static final long serialVersionUID = -6565756869395978507L;

	private JButton addWordButton, removeWordButton, addSynonymsButton, removeSynonymsButton, removeAllButton;

	private Dialog addWordDialog, removeWordDialog, addSynonymDialog, removeSynonymDialog, removeAllDialog;

	/**
	 * Create the panel.
	 */
	public NorthPanel() {

		initialize();

	}

	private void initialize() {

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		createComponents();

		addComponents();

	}

	private void createComponents() {

		addWordButton = new JButton("Add word");
		removeWordButton = new JButton("Remove word");

		addSynonymsButton = new JButton("Add synonym");
		removeSynonymsButton = new JButton("Remove synonym");

		removeAllButton = new JButton("Remove all!");
		String removeAllButtonTooltipText = "Warning! This will erase all words and synonims!";
		removeAllButton.setToolTipText(removeAllButtonTooltipText);

		addActionListeners();

	}

	private void addActionListeners() {

		addWordButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Add word
				EventQueue.invokeLater(new Runnable() {

					public void run() {
						try {

							addWordDialog = new AddWordDialog();
							addWordDialog.setVisible(true);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});
		removeWordButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Remove word
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							removeWordDialog = new RemoveWordDialog();
							removeWordDialog.setVisible(true);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		addSynonymsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Add synonym
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							addSynonymDialog = new AddSynonymDialog();
							addSynonymDialog.setVisible(true);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		removeSynonymsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Remove synonym
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							removeSynonymDialog = new RemoveSynonymDialog();
							removeSynonymDialog.setVisible(true);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		removeAllButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							removeAllDialog = new RemoveAllDialog();
							removeAllDialog.setVisible(true);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

	}

	private void addComponents() {

		add(Box.createVerticalStrut(2));
		this.add(addWordButton);
		add(Box.createVerticalStrut(5));
		this.add(removeWordButton);
		add(Box.createVerticalStrut(5));
		this.add(addSynonymsButton);
		add(Box.createVerticalStrut(5));
		this.add(removeSynonymsButton);
		add(Box.createVerticalStrut(5));
		this.add(removeAllButton);
		add(Box.createVerticalStrut(2));

	}

}
