package project.architecture.javaLogger.modules.output;

import project.architecture.javaLogger.modules.config.Key;
import project.architecture.javaLogger.modules.core.Level;
import project.architecture.javaLogger.modules.core.LogManager;

/**
 * @author kadary
 *
 */

public class FileHandler extends AbstractHandler {
	
	private static String logFilePath;
	
	public FileHandler() {
		this.setLogFilePath((String) LogManager.config.getSettings().get(Key.LogFilePath.name()));
	}
	
	public FileHandler(String logFilePath) {
		this.setLogFilePath(logFilePath);
	}
	
	private Printer printer = new Printer();

	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater) {

		if(handler.equals(FileHandler.class.getName())) {
			
			printer.write(level, message, fqcn, FileHandler.class.getName(), formater, this.getLogFilePath());
		}

	}

	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater,
			Level levelFixed) {
		String logFileName = this.getLogFilePath();
		if (level == levelFixed) {
			if(handler.equals(FileHandler.class.getName())) {
				printer.write(levelFixed, message, fqcn, FileHandler.class.getName(), formater, logFileName);
			}
		}
	}
	
	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater,
			boolean forceLogging) {
		if (forceLogging) {
			if(this.getClass().getName().equals(handler)) {
				printer.write(level, message, fqcn, FileHandler.class.getName(), formater, this.getLogFilePath());
			}
		}	
	}

	public String getLogFilePath() {
		return logFilePath;
	}

	public void setLogFilePath(String logFilePath) {
		FileHandler.logFilePath = logFilePath;
	}
}
