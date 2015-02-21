package project.architecture.javaLogger.modules.output.handler;

import project.architecture.javaLogger.core.Level;
import project.architecture.javaLogger.core.LogManager;
import project.architecture.javaLogger.modules.config.Key;
import project.architecture.javaLogger.modules.output.formater.Formater;

/**
 * @author kadary
 *
 */

public class FileHandler extends AbstractHandler {
	
	private static String logFilePath;
	private static Integer logFileLimitSize;
	
	public FileHandler() {
		this.setLogFilePath((String) LogManager.config.getSettings().get(Key.LogFilePath.name()));
		FileHandler.setLogFileLimitSize(this.initLogFileLimitSize());	
	}
	
	public FileHandler(String logFilePath, Integer logFileLimitSize) {
		this.setLogFilePath(logFilePath);
		if(logFileLimitSize != null) {
			FileHandler.logFileLimitSize = logFileLimitSize.intValue();
		}
		else
			FileHandler.setLogFileLimitSize(this.initLogFileLimitSize());
	}
	
	private Printer printer = new Printer();

	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater) {

		if(handler.equals(FileHandler.class.getName())) {
			
			printer.write(level, message, fqcn, FileHandler.class.getName(), formater, this.getLogFilePath(), this.getLogFileLimitSize());
		}

	}

	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater,
			Level levelFixed) {
		if (level == levelFixed) {
			if(handler.equals(FileHandler.class.getName())) {
				printer.write(levelFixed, message, fqcn, FileHandler.class.getName(), formater, this.getLogFilePath(), this.getLogFileLimitSize());
			}
		}
	}
	
	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater,
			boolean forceLogging) {
		if (forceLogging) {
			if(this.getClass().getName().equals(handler)) {
				printer.write(level, message, fqcn, FileHandler.class.getName(), formater, this.getLogFilePath(), this.getLogFileLimitSize());
			}
		}	
	}

	public String getLogFilePath() {
		return logFilePath;
	}

	public void setLogFilePath(String logFilePath) {
		FileHandler.logFilePath = logFilePath;
	}

	public int getLogFileLimitSize() {
		return logFileLimitSize;
	}

	public static void setLogFileLimitSize(Integer logFileLimitSize) {
		FileHandler.logFileLimitSize = logFileLimitSize;
	}
	
	private Integer initLogFileLimitSize() {
		String fileSize = (String) LogManager.config.getSettings().get(Key.LogFileSize.name());
		Integer limitSize = 0;
		try {
			limitSize = Integer.parseInt(fileSize.trim());
			limitSize *= 1000; 
		}
		catch (NumberFormatException e) {
			System.out.print("Your log file size is not readable, please check it => ");
			e.printStackTrace();
		}
		return limitSize;
	}
	
}
