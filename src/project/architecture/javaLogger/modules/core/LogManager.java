package project.architecture.javaLogger.modules.core;

import java.util.HashMap;
import java.util.Map;


/**
 * @author kadary
 *
 */
public class LogManager {
	private Map<String, Logger> loggers = new HashMap<String, Logger>(); 
	
	public Logger getLogger(String name) {
		if (loggers.containsKey(name)) {
			return loggers.get(name);
		}
		else 
			loggers.put(name, new ExtendedLogger(name));
			return loggers.get(name);
	}
	
	public Logger getLogger() {
		String name = Thread. currentThread().getStackTrace()[2].getClassName();
		if (loggers.containsKey(name)) {
			return loggers.get(name);
		}
		else 
			loggers.put(name, new ExtendedLogger(name));
			return loggers.get(name);
	}

}
