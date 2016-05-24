package gui.internalpanels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import gui.MainWindow;

/**
 * Contains a search field.
 * 
 * @author gergo_000
 *
 */
public class WestPanel extends InternalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6335547544420470797L;

	private JButton searchButton;
	private JTextField searchText;
	private JTextPane helpText;

	/**
	 * Create the panel.
	 */
	public WestPanel() {

		initialize();

	}

	private void initialize() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		createComponents();

		addComponents();

	}

	private void createComponents() {

		searchText = new JTextField();
		searchText.setEditable(true);
		searchText.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
		searchText.setText("*");

		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Search
				CenterPanel.displayRows(MainWindow.dictionary.search(searchText.getText()));
			}
		});

		helpText = new JTextPane();
		helpText.setEditable(false);
		String helpTextContent = "Search for any entry in the dictionary.\n\nHints:\n    ? - one characters\n    * - one or more characters\nExample:\n    c?r\n    po*lation\n    s?ience\n\nDisplay all synonims: *";
		helpText.setText(helpTextContent);
		helpText.setBackground(this.getBackground());

	}

	private void addComponents() {

		add(Box.createVerticalStrut(6));
		this.add(searchText);
		add(Box.createVerticalStrut(10));
		this.add(searchButton);
		add(Box.createVerticalStrut(20));
		this.add(helpText);
		add(Box.createVerticalStrut(130));

	}

}
