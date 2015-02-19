package project.architecture.javaLogger.modules.core;

import project.architecture.javaLogger.modules.output.Formater;
import project.architecture.javaLogger.modules.output.Handler;



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
	
	void addHandler(Handler handler);
	
	void setLevel(Level level);
	
	void setFormater(Formater formater);
}
