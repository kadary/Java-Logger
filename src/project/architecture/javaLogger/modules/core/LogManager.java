package project.architecture.javaLogger.modules.core;

import java.util.HashMap;
import java.util.Map;

import project.architecture.javaLogger.modules.config.ConfigFromProperties;
import project.architecture.javaLogger.modules.config.Configurator;


/**
 * @author kadary
 *
 */
public class LogManager {
	
	public static final Map<String,String> settings;
	private Map<String, Logger> loggers = new HashMap<String, Logger>();
	private String fqcn;
	private static final Configurator configuration = new ConfigFromProperties();
	
	static {
		configuration.setConfig();
		settings = configuration.getSettings();
	}
	
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
