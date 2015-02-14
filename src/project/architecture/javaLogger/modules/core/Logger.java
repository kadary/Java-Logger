package project.architecture.javaLogger.modules.core;



/**
 * @author kadary
 *
 */
public interface Logger {
		
	boolean isInfoEnabled();
	void info(String message);
	
	boolean isWarnfoEnabled();
	void warn(String message);
	
	boolean isErrorEnabled();
	void error(String message);
	
	boolean isDebugEnabled();
	void debug(String message);

	String getName();
	void setName(String name);
}
