package project.architecture.javaLogger.modules.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import project.architecture.javaLogger.modules.config.Key;
import project.architecture.javaLogger.modules.output.ConsoleHandler;
import project.architecture.javaLogger.modules.output.DataBaseHandler;
import project.architecture.javaLogger.modules.output.FileHandler;
import project.architecture.javaLogger.modules.output.Handler;


/**
 * @author kadary
 * @version 1.0
 * @param <V>
 */
public class AbstractLogger implements Logger {

	private String fqcn;
	private Handler CONSOLE = new ConsoleHandler();
	private Handler FILE = new FileHandler();
	private Handler DB = new DataBaseHandler();
	protected Map<String, Handler> handlers = new HashMap<String, Handler>();
	protected Level levelFixed ;
	private Properties settings = LogManager.config.getSettings();

	public AbstractLogger(String name) {
		this.setFQCN(name);
	}

	private String getFQCN() {
		return fqcn;
	}

	private void setFQCN(String fqcn) {
		this.fqcn = fqcn;
	}

	public boolean isEnabled(String levelFixed) {	
		String value;
		boolean result = false;
		try {
			if (settings.get(levelFixed) != null) {
				value = (String) settings.get(levelFixed);
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
		if (!handlers.isEmpty() || !isNull(levelFixed)) {
			this.logByLoggerConfig(message, Level.INFO);
		}

		else {
			this.logByPropConfig(message, Level.INFO);
		}
	}

	public boolean isWarnEnabled() {
		return isEnabled(Key.LevelWARN.name());
	}

	public void warn(String message) {
		if (!handlers.isEmpty() || !isNull(levelFixed)) {
			this.logByLoggerConfig(message, Level.WARN);
		}
		else {
			this.logByPropConfig(message, Level.WARN);
		}
	}

	public boolean isErrorEnabled() {
		return isEnabled(Key.LevelERROR.name());
	}

	public void error(String message) {
		if (!handlers.isEmpty() || !isNull(levelFixed)) {
			this.logByLoggerConfig(message, Level.ERROR);
		}
		else {
			this.logByPropConfig(message, Level.ERROR);
		}
	}

	public boolean isDebugEnabled() {
		return isEnabled(Key.LevelDEBUG.name());
	}

	public void debug(String message) {
		if (!handlers.isEmpty() || !isNull(levelFixed)) {
			this.logByLoggerConfig(message, Level.DEBUG);
		}

		else {
			this.logByPropConfig(message, Level.DEBUG);
		}
	}

	@Override
	public boolean isTraceEnabled() {
		return isEnabled(Key.LevelTrace.name());
	}

	@Override
	public void trace(String message) {
		if (!handlers.isEmpty() || !isNull(levelFixed)) {
			this.logByLoggerConfig(message, Level.TRACE);
		}

		else {
			this.logByPropConfig(message, Level.TRACE);
		}		
	}

	@Override
	public void setHandlers(Handler handler) {
		handlers.put(handler.getClass().getName(), handler);
	}

	@Override
	public void setLevel(Level levelFixed) {
		this.levelFixed = levelFixed;
	}

	@Override
	public void setLayout() {
		// TODO Auto-generated method stub

	}

	private void logByLoggerConfig(String message, Level level) {
		if (!handlers.isEmpty()) {
			Set<String> keys = handlers.keySet();
			Iterator<String> iterator = keys.iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				Handler handler = handlers.get(key);
				if(!isNull(levelFixed)) {
					if(levelFixed.getValue() > level.getValue()) {
						handler.log(level, message, this.getFQCN(), handler.getClass().getName(), true);
					}
					else
						handler.log(level, message, this.getFQCN(), handler.getClass().getName(), levelFixed);
				}
				else
					handler.log(level, message, this.getFQCN(), handler.getClass().getName());
			}
		}
		else if(!isNull(levelFixed)) {
			if (isEnabled(Key.ConsoleHandler.name())) {
				if(levelFixed.getValue() > level.getValue()) {
					CONSOLE.log(level, message, this.getFQCN(), ConsoleHandler.class.getName(), true);
				}
				else
					CONSOLE.log(level, message, this.getFQCN(), ConsoleHandler.class.getName(), levelFixed);
			}

			if (isEnabled(Key.FileHandler.name())) {
				if(levelFixed.getValue() > level.getValue()) {
					FILE.log(level, message, this.getFQCN(), FileHandler.class.getName(), true);
				}
				else
					FILE.log(level, message, this.getFQCN(), FileHandler.class.getName(), levelFixed);
			}

			if (isEnabled(Key.DataBaseHandler.name())) {
				if(levelFixed.getValue() > level.getValue()) {
					DB.log(level, message, this.getFQCN(), DataBaseHandler.class.getName(), true);
				}
				else
					DB.log(level, message, this.getFQCN(), DataBaseHandler.class.getName(), levelFixed);
			}
		}
	}

	private void logByPropConfig(String message, Level level) {
		if (handlers.isEmpty() & isNull(levelFixed)) {
			if (isEnabled(Key.ConsoleHandler.name())) {
				CONSOLE.log(level, message, this.getFQCN(), ConsoleHandler.class.getName());
			}

			if (isEnabled(Key.FileHandler.name())) {
				FILE.log(level, message, this.getFQCN(), FileHandler.class.getName());
			}

			if (isEnabled(Key.DataBaseHandler.name())) {
				DB.log(level, message, this.getFQCN(), DataBaseHandler.class.getName());
			}
		}
	}

	private boolean isNull(Level levelFixed) {
		return this.levelFixed == null || this.levelFixed.getName() == " " ? true : false;
	}
}
