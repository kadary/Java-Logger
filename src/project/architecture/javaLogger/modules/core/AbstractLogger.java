package project.architecture.javaLogger.modules.core;

import project.architecture.javaLogger.modules.config.ConfigFromProperties;
import project.architecture.javaLogger.modules.config.Configurator;
import project.architecture.javaLogger.modules.output.Handler;


/**
 * @author kadary
 *
 */
public class AbstractLogger implements Logger {
	
	private String name;
	private Handler handler;
	
	public static final Configurator configuration= new ConfigFromProperties();
     
    public AbstractLogger(String name) {
        this.setName(name);
        configuration.setConfig();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled(String level) {	
		String value;
		boolean result = false;
		if (configuration.getSettings().get(level) != null) {
			value = configuration.getSettings().get(level);
			result = value.equalsIgnoreCase("true") ? true : false;
		}
		return result;
	}

	public boolean isInfoEnabled() {
		return isEnabled(Level.INFO.getName());
	}

	public void info(String message) {
		handler.log(Level.INFO, message);
		
	}

	public boolean isWarnfoEnabled() {
		return isEnabled(Level.WARN.getName());
	}

	public void warn(String message) {
		handler.log(Level.WARN, message);
	}

	public boolean isErrorEnabled() {
		return isEnabled(Level.ERROR.getName());
	}

	public void error(String message) {
		handler.log(Level.ERROR, message);
	}

	public boolean isDebugEnabled() {
		return isEnabled(Level.DEBUG.getName());
	}

	public void debug(String message) {
		handler.log(Level.DEBUG, message);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
