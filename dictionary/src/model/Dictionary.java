package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import gui.internalpanels.SouthPanel;

public class Dictionary extends AbstractDictionary {

	/**
	 * The whole Dictionary class should be Serializable.
	 */
	private static final long serialVersionUID = 1911536096241327225L;

	private HashMap<Word, Synonyms> dictionary;

	public Dictionary() {

		dictionary = new HashMap<Word, Synonyms>();

	}

	/**
	 * Searches for the specified String value. The value can contain * and ?,
	 * which stand for one, or respectively more unknown characters.
	 * 
	 * @param name
	 * @return a Set with all the (Word, Synonyms) Entries that match the search
	 *         criteria
	 */
	public Set<Entry<Word, Synonyms>> search(String name) {

		if (name.equals("*")) {

			// Display everything:
			return dictionary.entrySet();
		}

		Set<Entry<Word, Synonyms>> set = new HashSet<Entry<Word, Synonyms>>();

		Iterator<Entry<Word, Synonyms>> i = dictionary.entrySet().iterator();

		while (i.hasNext()) {
			Entry<Word, Synonyms> entry = i.next();
			if (entry.getKey().matches(name)) {
				set.add(entry);
			}

		}

		return set;

	}

	@Override
	public boolean isDictionaryWellFormed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addWord(String name) {

		Word word = new Word(name);

		if (dictionary.containsKey(word)) {
			SouthPanel.displayWarningMessage("\"" + word + "\" is already in the dictionary!");
		} else {
			Synonyms synonyms = new Synonyms();
			dictionary.put(word, synonyms);
			SouthPanel.displayMessage("\"" + word + "\" was added to the dictionary.");
		}

	}

	@Override
	public void removeWord(String name) {

		Word word = new Word(name);

		if (dictionary.containsKey(word)) {
			dictionary.remove(word);
			SouthPanel.displayMessage("\"" + word + "\" was removed from the dictionary.");
		} else {

			SouthPanel.displayWarningMessage("\"" + word + "\" is not in the dictionary!");
		}

	}

	@Override
	public void addSynonym(String name, String synonymName) {

		Word word = new Word(name);
		Word synonym = new Word(synonymName);

		if (dictionary.containsKey(word)) {
			if (dictionary.get(word).contains(synonym)) {

				SouthPanel.displayWarningMessage("\"" + synonym + "\" is already a synonym for \"" + word + "\".");

			} else {

				dictionary.get(word).addSynonym(synonym);
				SouthPanel.displayMessage("\"" + synonym + "\" was added as a synonym for \"" + word + "\".");

			}
		} else {

			SouthPanel.displayWarningMessage("\"" + word + "\" is not in the dictionary!");

		}

	}

	@Override
	public void removeSynonym(String name, String synonymName) {

		Word word = new Word(name);
		Word synonym = new Word(synonymName);

		if (dictionary.containsKey(word)) {
			if (dictionary.get(word).contains(synonym)) {

				dictionary.get(word).removeSynonym(synonym);
				SouthPanel.displayMessage("\"" + synonym + "\" was removed as a synonym for \"" + word + "\".");

			} else {

				SouthPanel.displayWarningMessage("\"" + synonym + "\" is not a synonym for \"" + word + "\"!");

			}
		} else {

			SouthPanel.displayWarningMessage("\"" + word + "\" is not in the dictionary!");

		}

	}

	@Override
	public void removeAll() {
		dictionary.clear();
	}

}
