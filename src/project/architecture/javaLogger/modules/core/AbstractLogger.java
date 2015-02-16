package project.architecture.javaLogger.modules.core;

import java.util.Properties;

import project.architecture.javaLogger.modules.config.Key;
import project.architecture.javaLogger.modules.output.ConsoleHandler;
import project.architecture.javaLogger.modules.output.DataBaseHandler;
import project.architecture.javaLogger.modules.output.FileHandler;
import project.architecture.javaLogger.modules.output.Handler;
import project.architecture.javaLogger.modules.output.Target;


/**
 * @author kadary
 * @version 1.0
 */
public class AbstractLogger implements Logger {
	
	private String fqcn;
	private Handler console = new ConsoleHandler();
	private Handler file = new FileHandler();
	private Handler db = new DataBaseHandler();
	private Properties settings = LogManager.config.getSettings();
    
    public AbstractLogger(String name) {
        this.setFQCN(name);
    }

	public String getFQCN() {
		return fqcn;
	}

	public void setFQCN(String fqcn) {
		this.fqcn = fqcn;
	}

	public boolean isEnabled(String level) {	
		String value;
		boolean result = false;
		try {
			if (settings.get(level) != null) {
				value = (String) settings.get(level);
				result = value.equalsIgnoreCase("true") ? true : false;
			}
		}
		catch (NullPointerException e) {
			System.out.print("Settings not set! please check your config: ");
			e.printStackTrace();
		}
		return result;
	}

	public boolean isInfoEnabled() {
		return isEnabled(Key.LevelINFO.name());
	}

	public void info(String message) {
		if (isEnabled(Key.ConsoleHandler.name())) {
			console.log(Level.INFO, message, this.getFQCN(), Target.CONSOLE);
		}
		
		if (isEnabled(Key.FileHandler.name())) {
			file.log(Level.INFO, message, this.getFQCN(), Target.FILE);
		}
		
		if (isEnabled(Key.DataBaseHandler.name())) {
			db.log(Level.INFO, message, this.getFQCN(), Target.DB);
		}
	}

	public boolean isWarnEnabled() {
		return isEnabled(Key.LevelWARN.name());
	}

	public void warn(String message) {
		if (isEnabled(Key.ConsoleHandler.name())) {
			console.log(Level.WARN, message, this.getFQCN(), Target.CONSOLE);
		}
		
		if (isEnabled(Key.FileHandler.name())) {
			file.log(Level.WARN, message, this.getFQCN(), Target.FILE);
		}
		
		if (isEnabled(Key.DataBaseHandler.name())) {
			db.log(Level.WARN, message, this.getFQCN(), Target.DB);
		}
	}

	public boolean isErrorEnabled() {
		return isEnabled(Key.LevelERROR.name());
	}

	public void error(String message) {
		if (isEnabled(Key.ConsoleHandler.name())) {
			console.log(Level.ERROR, message, this.getFQCN(), Target.CONSOLE);
		}
		
		if (isEnabled(Key.FileHandler.name())) {
			file.log(Level.ERROR, message, this.getFQCN(), Target.FILE);
		}
		
		if (isEnabled(Key.DataBaseHandler.name())) {
			db.log(Level.ERROR, message, this.getFQCN(), Target.DB);
		}
	}

	public boolean isDebugEnabled() {
		return isEnabled(Key.LevelDEBUG.name());
	}

	public void debug(String message) {
		if (isEnabled(Key.ConsoleHandler.name())) {
			console.log(Level.DEBUG, message, this.getFQCN(), Target.CONSOLE);
		}
		
		if (isEnabled(Key.FileHandler.name())) {
			file.log(Level.DEBUG, message, this.getFQCN(), Target.FILE);
		}
		
		if (isEnabled(Key.DataBaseHandler.name())) {
			db.log(Level.DEBUG, message, this.getFQCN(), Target.DB);
		}
	}

	@Override
	public boolean isTraceEnabled() {
		return isEnabled(Key.LevelTrace.name());
	}

	@Override
	public void trace(String message) {
		if (isEnabled(Key.ConsoleHandler.name())) {
			console.log(Level.TRACE, message, this.getFQCN(), Target.CONSOLE);
		}
		
		if (isEnabled(Key.FileHandler.name())) {
			file.log(Level.TRACE, message, this.getFQCN(), Target.FILE);
		}
		
		if (isEnabled(Key.DataBaseHandler.name())) {
			db.log(Level.TRACE, message, this.getFQCN(), Target.DB);
		}
		
	}
}
