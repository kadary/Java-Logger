package project.architecture.javaLogger.modules.core;

import project.architecture.javaLogger.modules.config.ConfigFromProperties;
import project.architecture.javaLogger.modules.config.Configurator;
import project.architecture.javaLogger.modules.output.ConsoleHandler;
import project.architecture.javaLogger.modules.output.DataBaseHandler;
import project.architecture.javaLogger.modules.output.FileHandler;
import project.architecture.javaLogger.modules.output.Handler;
import project.architecture.javaLogger.modules.output.Target;


/**
 * @author kadary
 *
 */
public class AbstractLogger implements Logger {
	
	private String name;
	private Handler console = new ConsoleHandler();
	private Handler file = new FileHandler();
	private Handler db = new DataBaseHandler();
	
	public static final Configurator configuration = new ConfigFromProperties();
 
    
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
		if (isEnabled(Target.CONSOLE.name())) {
			console.log(Level.INFO, message, this.getName(), Target.CONSOLE);
		}
		
		if (isEnabled(Target.FILE.name())) {
			file.log(Level.INFO, message, this.getName(), Target.FILE);
		}
		
		if (isEnabled(Target.DB.name())) {
			db.log(Level.INFO, message, this.getName(), Target.DB);
		}
	}

	public boolean isWarnfoEnabled() {
		return isEnabled(Level.WARN.getName());
	}

	public void warn(String message) {
		if (isEnabled(Target.CONSOLE.name())) {
			console.log(Level.WARN, message, this.getName(), Target.CONSOLE);
		}
		
		if (isEnabled(Target.FILE.name())) {
			file.log(Level.WARN, message, this.getName(), Target.FILE);
		}
		
		if (isEnabled(Target.DB.name())) {
			db.log(Level.WARN, message, this.getName(), Target.DB);
		}
	}

	public boolean isErrorEnabled() {
		return isEnabled(Level.ERROR.getName());
	}

	public void error(String message) {
		if (isEnabled(Target.CONSOLE.name())) {
			console.log(Level.ERROR, message, this.getName(), Target.CONSOLE);
		}
		
		if (isEnabled(Target.FILE.name())) {
			file.log(Level.ERROR, message, this.getName(), Target.FILE);
		}
		
		if (isEnabled(Target.DB.name())) {
			db.log(Level.ERROR, message, this.getName(), Target.DB);
		}
	}

	public boolean isDebugEnabled() {
		return isEnabled(Level.DEBUG.getName());
	}

	public void debug(String message) {
		if (isEnabled(Target.CONSOLE.name())) {
			console.log(Level.DEBUG, message, this.getName(), Target.CONSOLE);
		}
		
		if (isEnabled(Target.FILE.name())) {
			file.log(Level.DEBUG, message, this.getName(), Target.FILE);
		}
		
		if (isEnabled(Target.DB.name())) {
			db.log(Level.DEBUG, message, this.getName(), Target.DB);
		}
	}
}
