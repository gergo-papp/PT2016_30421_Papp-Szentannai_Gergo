package model;

import java.io.Serializable;

public abstract class AbstractDictionary implements Serializable {

	private static final long serialVersionUID = 5375117009592242247L;
	
	public abstract boolean isDictionaryWellFormed();
	
	/**
	 * 
	 * @param name the new word that should be added
	 */
	abstract void addWord(String name);
	
	/**
	 * 
	 * @param name
	 */
	abstract void removeWord(String name);
	
	/**
	 * 
	 * @param word
	 * @param synonym
	 */
	abstract void addSynonym(String name, String synonymName);
	
	/**
	 * 
	 * @param word
	 * @param synonym
	 */
	abstract void removeSynonym(String name, String synonymName);
	
	/**
	 * 
	 */
	abstract void removeAll();
	

}
