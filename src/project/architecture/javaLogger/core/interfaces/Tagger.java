package project.architecture.javaLogger.core.interfaces;

import java.io.Serializable;

public interface Tagger extends Serializable{
	
	String getName();
	
	Tagger[] getParents();
	
	Boolean hasParents();
	
	void isInstanceOf(Tagger t);
	
	void isInstanceOf(String s);
	
	Tagger addParents(Tagger... t);
	
	Tagger setParents(Tagger... t);
	
	Boolean removeTagger(Tagger t);

}
