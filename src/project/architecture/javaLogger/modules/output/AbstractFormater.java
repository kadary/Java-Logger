package project.architecture.javaLogger.modules.output;

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
	
	

	@Override
	public String getSeparator() {
		return separator;
	}
	@Override
	public List<String> getOthers() {
		return other;
	}
	@Override
	public boolean isLevelEnabled() {
		return isLevelEnabled;
	}
	@Override
	public boolean isMessageEnabled() {
		return isMessageEnabled;
	}
	@Override
	public boolean isDateEnabled() {
		return isDateEnabled;
	}
	@Override
	public boolean isFQCNEnabled() {
		return isFQCNEnabled;
	}
	
}
