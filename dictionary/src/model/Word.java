package model;

import java.io.Serializable;

public class Word implements Serializable{

	private static final long serialVersionUID = 9018383050622954183L;
	
	private String name;
	
	
	public Word(String name) {
		this.name = name;
	}


	public String getName(){
		return name;
	}


	@Override
	public String toString() {
		return name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public boolean matches(String searchName) {
		
		StringBuffer strBuff = new StringBuffer();
		strBuff.append(""); // initialize
		
		for(int i = 0; i<searchName.length(); i++){
			if (searchName.charAt(i) == '*')
				strBuff.append("[a-z]*");
			else if (searchName.charAt(i) == '?')
				strBuff.append("[a-z]?");
			else
				strBuff.append("[" + searchName.charAt(i) + "]");
		}
		
		strBuff.append("$");
		
		return name.matches(strBuff.toString()); // call the String.matches() method
	}
	
	

}
