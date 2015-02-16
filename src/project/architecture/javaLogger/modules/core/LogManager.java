package project.architecture.javaLogger.modules.core;

import java.util.HashMap;
import java.util.Map;

import project.architecture.javaLogger.modules.config.ConfigFromProperties;
import project.architecture.javaLogger.modules.config.Configurator;

/**
 * Principal class of Logger. it's must be imported in project by customer
 * @author kadary
 * @version 1.0
 */
public class LogManager {
	
	private Map<String, Logger> loggers = new HashMap<String, Logger>();
	private String fqcn;
	public static final Configurator config = new ConfigFromProperties();

	public LogManager() {
		fqcn = Thread. currentThread().getStackTrace()[2].getClassName();
	}
	
	/**
	 * Return string log
	 * @param name [Fully-Qualified Class Name]
	 * @return Full log : Date+Time FQCN Level Log message
	 */
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
