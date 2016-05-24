package gui.internalpanels;

import java.util.Set;
import java.util.Vector;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.table.DictionaryTableModel;
import model.Synonyms;
import model.Word;

/**
 * Contains the dictionary in the form of a JTable.
 * 
 * @author gergo_000
 *
 */
public class CenterPanel extends InternalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5796812012896421862L;

	private JScrollPane dictionaryScrollPane;
	private static DictionaryTableModel dictionaryTableModel;
	private JTable dictionaryTable;

	/**
	 * Create the panel.
	 */
	public CenterPanel() {

		initialize();

	}

	private void initialize() {

		createComponents();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		addComponents();

	}

	public static void displayRows(Set<Entry<Word, Synonyms>> set) {
		
		int rowCount = dictionaryTableModel.getRowCount();
		
		// Remove all rows:
		for (int i = 0; i < rowCount; i++)
			dictionaryTableModel.removeRow(0);
		
		if (set == null)
			return;
		
		if (!set.isEmpty()){
			Iterator<Entry<Word, Synonyms>> i = set.iterator();
			
			while(i.hasNext()){
				Entry<Word, Synonyms> entry = i.next();
				
				Vector<String> rowData = new Vector<String>();
				
				rowData.addElement(entry.getKey().toString());
				rowData.addElement(entry.getValue().toString());
				
				dictionaryTableModel.addRow(rowData);
			}
		}
		else{
			SouthPanel.displayMessage("The search returned no results.");
		}
		
	}

	private void createComponents() {

		dictionaryTableModel = new DictionaryTableModel();

		dictionaryTable = new JTable(dictionaryTableModel);
		dictionaryTable.setName("Dictionary table");
		dictionaryTable.getColumnModel().getColumn(0).setMaxWidth(150);

		dictionaryScrollPane = new JScrollPane(dictionaryTable);

	}

	private void addComponents() {

		add(Box.createVerticalStrut(7));
		this.add(dictionaryScrollPane);
		add(Box.createVerticalStrut(10));

	}

}
