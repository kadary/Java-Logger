package project.architecture.javaLogger.modules.core;

import project.architecture.javaLogger.modules.output.DefaultFormater;


/**
 * ???
 * @author kadary
 * version 1.0
 */
public class DefaultLogger extends AbstractLogger {

	public DefaultLogger(String name) {
		super(name);
		setFormater(new DefaultFormater());
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
	public void debug(String message) {
		if (!handlers.isEmpty() || !isNull(levelFixed)) {
			this.logByLoggerConfig(message, Level.DEBUG);
		}

		else {
			this.logByPropConfig(message, Level.DEBUG);
		}
	}
	
	@Override
	public void error(String message) {
		if (!handlers.isEmpty() || !isNull(levelFixed)) {
			this.logByLoggerConfig(message, Level.ERROR);
		}
		else {
			this.logByPropConfig(message, Level.ERROR);
		}
	}
	
	@Override
	public void warn(String message) {
		if (!handlers.isEmpty() || !isNull(levelFixed)) {
			this.logByLoggerConfig(message, Level.WARN);
		}
		else {
			this.logByPropConfig(message, Level.WARN);
		}
	}
	
	@Override
	public void info(String message) {
		if (!handlers.isEmpty() || !isNull(levelFixed)) {
			this.logByLoggerConfig(message, Level.INFO);
		}

		else {
			this.logByPropConfig(message, Level.INFO);
		}
	}
}
