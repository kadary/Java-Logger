package org.thesoftwarecraftsman.logging.javaLogger.core;

import java.util.HashMap;
import java.util.Map;

import org.thesoftwarecraftsman.logging.javaLogger.modules.config.Configurator;
import org.thesoftwarecraftsman.logging.javaLogger.modules.config.DefaultConfigurator;

/**
 * Principal class of Logger. it's must be imported in project by customer
 * @author kadary
 * @version 1.0
 */
public class LogManager {
	
	public static final Map<String, Logger> loggers = new HashMap<String, Logger>();
	private String fqcn;
	public static final Configurator config = new DefaultConfigurator();
	
	/**
	 * Return string log
	 * @param targetClass the class from witch the logger will get its identifier
	 * @return logger  A new logger or stored one
	 */
	public <T> Logger getLogger(Class<T> targetClass) {
		if (targetClass != null) {
			this.fqcn = targetClass.getName();
		}
		if (loggers.containsKey(fqcn)) {
			return loggers.get(fqcn);
		}
		else 
			loggers.put(fqcn, new DefaultLogger(fqcn));
			return loggers.get(fqcn);
	}
	
	public Logger getLogger(String targetClass) {
		if (targetClass != null & targetClass != "") {
				this.fqcn = targetClass;
		}
		if (loggers.containsKey(fqcn)) {
			return loggers.get(fqcn);
		}
		else 
			loggers.put(fqcn, new DefaultLogger(fqcn));
			return loggers.get(fqcn);
	}
	
	public Logger getLogger() {
		return this.getLogger(Thread. currentThread().getStackTrace()[2].getClassName());
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
