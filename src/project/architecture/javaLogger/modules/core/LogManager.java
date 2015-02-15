package project.architecture.javaLogger.modules.core;

import java.util.HashMap;
import java.util.Map;


/**
 * @author kadary
 *
 */
public class LogManager {
	private Map<String, Logger> loggers = new HashMap<String, Logger>();
	private String fqcn;
	
	
	public LogManager() {
		fqcn = Thread. currentThread().getStackTrace()[2].getClassName();
	}
	
	public Logger getLogger(String name) {
		if (name != null && name != "") {
			this.fqcn = name;
		}
		if (loggers.containsKey(fqcn)) {
			return loggers.get(fqcn);
		}
		else 
			loggers.put(fqcn, new ExtendedLogger(fqcn));
			return loggers.get(fqcn);
	}
	
	public Logger getLogger() {
		return this.getLogger(fqcn);
	}
	
	public void closeLogger(String name) {
		if (name != null && name != "") {
			if(loggers.containsKey(name)) {
				loggers.remove(name);
			}
		}
	}
	
	public void closeLogger() {
		this.closeLogger(fqcn);
	}

}
