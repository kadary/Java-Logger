package project.architecture.javaLogger.modules.output;

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
