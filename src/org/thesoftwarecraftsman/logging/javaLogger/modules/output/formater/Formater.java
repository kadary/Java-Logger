package org.thesoftwarecraftsman.logging.javaLogger.modules.output.formater;

import java.util.List;


/**
 * @author kadary
 *
 */
public interface Formater {
	
	String getSeparator();
	List<String> getOthers();
	boolean isLevelEnabled();
    boolean isMessageEnabled();
	boolean isDateEnabled();
	boolean isFQCNEnabled();


}
