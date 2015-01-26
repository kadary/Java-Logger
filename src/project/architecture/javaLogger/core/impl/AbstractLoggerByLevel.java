package project.architecture.javaLogger.core.impl;

import project.architecture.javaLogger.core.interfaces.Level;
import project.architecture.javaLogger.core.interfaces.Tagger;


public abstract class AbstractLoggerByLevel extends AbstractLogger {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String FQCN = AbstractLogger.class.getName();
	
	public void entry() {
		entry(FQCN);
	}

	public void entry(Object... params) {
		entry(FQCN, params);
	}

	public void exit() {
		exit(FQCN);
	}
	
	public void info(String message) {
		logIfEnabled(FQCN, Level.INFO, message);
	}

	public void info(String message, Throwable t) {
		logIfEnabled(FQCN, Level.INFO, message, t);
	}

	public void info(Tagger tagger, String message) {
		logIfEnabled(FQCN, Level.INFO, tagger, message);
	}

	public void info(Tagger tagger, String message, Throwable t) {
		logIfEnabled(FQCN, Level.INFO, tagger, message, t);	
	}
	
	public void trace(String message) {
		logIfEnabled(FQCN, Level.TRACE, message);
	}

	public void trace(String message, Throwable t) {
		logIfEnabled(FQCN, Level.TRACE, message, t);
	}

	public void trace(Tagger tagger, String message) {
		logIfEnabled(FQCN, Level.TRACE, tagger, message);
	}

	public void trace(Tagger tagger, String message, Throwable t) {
		logIfEnabled(FQCN, getLevel(), tagger, message, t);	
	}
	
	public void warn(String message) {
		logIfEnabled(FQCN, Level.WARN, message);
	}

	public void warn(String message, Throwable t) {
		logIfEnabled(FQCN, Level.WARN, message, t);
	}

	public void warn(Tagger tagger, String message) {
		logIfEnabled(FQCN, Level.WARN, tagger, message);
	}

	public void warn(Tagger tagger, String message, Throwable t) {
		logIfEnabled(FQCN, Level.WARN, tagger, message, t);
	}
	
	public void debug(String message) {
		logIfEnabled(FQCN, Level.DEBUG, message);	
	}

	public void debug(String message, Throwable t) {
		logIfEnabled(FQCN, Level.DEBUG, message, t);
	}

	public void debug(Tagger tagger, String message) {
		logIfEnabled(FQCN, Level.DEBUG, tagger, message);
	}

	public void debug(Tagger tagger, String message, Throwable t) {
		logIfEnabled(FQCN, Level.DEBUG, tagger, message, t);
	}
	
	public void error(String message) {
		logIfEnabled(FQCN, Level.ERROR, message);
	}

	public void error(String message, Throwable t) {
		logIfEnabled(FQCN, Level.ERROR, message, t);
	}

	public void error(Tagger tagger, String message) {
		logIfEnabled(FQCN, Level.ERROR, tagger, message);
	}

	public void error(Tagger tagger, String message, Throwable t) {
		logIfEnabled(FQCN, Level.ERROR, tagger, message, t);
	}
	
	public void fatal(String message) {
		logIfEnabled(FQCN, Level.FATAL, message);
	}

	public void fatal(String message, Throwable t) {
		logIfEnabled(FQCN, Level.FATAL, message, t);
	}

	public void fatal(Tagger tagger, String message) {
		logIfEnabled(FQCN, Level.FATAL, tagger, message);
	}

	public void fatal(Tagger tagger, String message, Throwable t) {
		logIfEnabled(FQCN, Level.FATAL, tagger, message, t);
	}
	
	public void log(Level level, String message) {
		logIfEnabled(FQCN, Level.ALL, message);		
	}

	public void log(Level level, String message, Throwable t) {
		logIfEnabled(FQCN, Level.ALL, message, t);
	}

	public void log(Level level, Tagger tagger, String message) {
		logIfEnabled(FQCN, Level.ALL, tagger, message);
	}

	public void log(Level level, Tagger tagger, String message, Throwable t) {
		logIfEnabled(FQCN, Level.ALL, tagger, message, t);
	}

}
