package project.architecture.javaLogger.core.impl;

import java.io.Serializable;

import project.architecture.javaLogger.core.interfaces.ExtendedLogger;
import project.architecture.javaLogger.core.interfaces.Level;

public abstract class AbstractLogger implements ExtendedLogger, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    
    private final String name;
    
    public AbstractLogger() {
        this.name = getClass().getName();
    }
    
    public AbstractLogger(String name) {
        this.name = name;
    }
    
    public String getName() {
		return name;
	}

	public boolean isInfoEnabled() {
		return isEnabled(Level.INFO);
	}

	public boolean isTraceEnabled() {
		return isEnabled(Level.TRACE);
	}

	public boolean isWarnEnabled() {
		return isEnabled(Level.WARN);
	}

	public boolean isDebugEnabled() {
		return isEnabled(Level.DEBUG);
	}

	public boolean isErrorEnabled() {
		return isEnabled(Level.ERROR);
	}

	public boolean isFatalEnabled() {
		return isEnabled(Level.FATAL);
	}

	public <T> T exit(T result) {
		return exit(result);
	}
}
