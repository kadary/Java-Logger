package project.architecture.javaLogger.modules.core;

import java.util.HashMap;
import java.util.Map;


/**
 * @author kadary
 *
 */
public class LogManager {
	private Map<String, Logger> loggers = new HashMap<String, Logger>();
	private String loggerName;
	
	
	public LogManager() {
		loggerName = Thread. currentThread().getStackTrace()[2].getClassName();
	}
	
	public Logger getLogger(String name) {
		if (name != null && name != "") {
			this.loggerName = name;
		}
		if (loggers.containsKey(loggerName)) {
			return loggers.get(loggerName);
		}
		else 
			loggers.put(loggerName, new ExtendedLogger(loggerName));
			return loggers.get(loggerName);
	}
	
	public Logger getLogger() {
		return this.getLogger(loggerName);
	}
	
	public void closeLogger(String name) {
		if (name != null && name != "") {
			if(loggers.containsKey(name)) {
				loggers.remove(loggerName);
			}
		}
	}
	
	public void closeLogger() {
		this.closeLogger(loggerName);
	}

}
