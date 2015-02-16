package project.architecture.javaLogger.modules.core;



/**
 * Implementation of Log msg types and FQCN path
 * @author kadary, mhgeay
 * @version 1.1
 */
public interface Logger {
		
	// TRACE
	boolean isTraceEnabled();
	void trace(String message);
	
	// DEBUG
	boolean isDebugEnabled();
	void debug(String message);
	
	// INFO
	boolean isInfoEnabled();
	void info(String message);
	
	// WARNING
	boolean isWarnEnabled();
	void warn(String message);
	
	// ERROR
	boolean isErrorEnabled();
	void error(String message);

	// Custom path (FQCN)
	String getFQCN();
	void setFQCN(String fqcn);
}
