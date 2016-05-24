package gui.table;


import javax.swing.table.DefaultTableModel;

public class DictionaryTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7443877686037703714L;

	private static String[] columnNames = { "Word", "Synonims" };

	public DictionaryTableModel() {

		super(columnNames, 0);

	}

}
