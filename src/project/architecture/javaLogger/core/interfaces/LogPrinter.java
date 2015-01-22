package project.architecture.javaLogger.core.interfaces;

public interface LogPrinter {
	
	void logMessage(String fqcn, Level level, String message);
	
	void logMessage(String fqcn, Level level, String message,
			Throwable t);
	
	void logMessage(String fqcn, Level level, Tagger tagger,
			String message);
	
	void logMessage(String fqcn2, Level level, Tagger tagger,
			String message, Throwable t);
}
