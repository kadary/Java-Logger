package org.thesoftwarecraftsman.logging.javaLogger.modules.output.formater;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kadary
 *
 */

public abstract class AbstractFormater implements Formater {
	
	protected String separator;
	protected boolean isDateEnabled;
	protected boolean isMessageEnabled;
	protected boolean isLevelEnabled;
	protected boolean isFQCNEnabled;
	protected List<String> other = new ArrayList<String>();
	
	

	public String getSeparator() {
		return separator;
	}
	public List<String> getOthers() {
		return other;
	}
	public boolean isLevelEnabled() {
		return isLevelEnabled;
	}
	public boolean isMessageEnabled() {
		return isMessageEnabled;
	}
	public boolean isDateEnabled() {
		return isDateEnabled;
	}
	public boolean isFQCNEnabled() {
		return isFQCNEnabled;
	}
	
}
