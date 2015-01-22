package project.architecture.javaLogger.core.impl;

import project.architecture.javaLogger.core.interfaces.Level;
import project.architecture.javaLogger.core.interfaces.LogPrinter;
import project.architecture.javaLogger.core.interfaces.Tagger;


public abstract class AbstractExtendedLogger extends AbstractLoggerByLevel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LogPrinter printer = new Printer();
	
	public void logIfEnabled(String fqcn, Level level, String message) {
		if (isEnabled(level, message)) 
			printer.logMessage(fqcn, level, message);
	}
	
	public void logIfEnabled(String fqcn, Level level, String message,
			Throwable t) {
		if (isEnabled(level, message, t)) 
			printer.logMessage(fqcn, level, message, t);
	}

	public void logIfEnabled(String fqcn, Level level, Tagger tagger,
			String message) {
		if (isEnabled(level, tagger, message))
			printer.logMessage(fqcn, level, tagger, message);	
	}

	public void logIfEnabled(String fqcn, Level level, Tagger tagger,
			String message, Throwable t) {
		if (isEnabled(level, tagger, message, t))
			printer.logMessage(fqcn, level, tagger, message, t);	
	}
	
}
