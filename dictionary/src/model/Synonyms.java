package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Synonyms implements Serializable {

	private static final long serialVersionUID = -4317025931793057514L;

	private Set<Word> synonyms;

	public Synonyms() {
		synonyms = new HashSet<Word>();
	}

	public Set<Word> getSynonims() {
		return synonyms;
	}

	public void setSynonims(HashSet<Word> synonims) {
		this.synonyms = synonims;
	}

	public boolean contains(Word synonym) {
		return synonyms.contains(synonym);
	}

	public void addSynonym(Word synonym) {
		synonyms.add(synonym);
	}

	public void removeSynonym(Word synonym) {
		synonyms.remove(synonym);
	}

	@Override
	public String toString() {
		if (synonyms.isEmpty()) {
			return "";
		} else {
			String synonymsString = new String("");

			Iterator<Word> i = synonyms.iterator();

			while (i.hasNext()) {

				String nextSyn = i.next().getName();
				nextSyn = nextSyn.concat(", ");
				synonymsString = synonymsString.concat(nextSyn);
			}
			synonymsString = synonymsString.substring(0, max(synonymsString.length() - 2, 0));

			return synonymsString;
		}

	}

	private int max(int i, int j) {
		if (i > j)
			return i;
		return j;
	}

}
