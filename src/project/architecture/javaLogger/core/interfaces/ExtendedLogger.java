package project.architecture.javaLogger.core.interfaces;

public interface ExtendedLogger extends LevelLogger {
	
	boolean isEnabled(Level level);
	boolean isEnabled(Level level, String message);
	boolean isEnabled(Level level, String message, Throwable t);
	boolean isEnabled(Level level, Tagger tagger, String message);
	boolean isEnabled(Level level, Tagger tagger, String message, Throwable t);
	
	void log(Level level, String message);
	void log(Level level, String message, Throwable t);
	void log(Level level, Tagger tagger, String message);
	void log(Level level, Tagger tagger, String message, Throwable t);
	
	void logIfEnabled(String fqcn, Level level, String message);
	void logIfEnabled(String fqcn, Level level, String message, Throwable t);
	void logIfEnabled(String fqcn, Level level, Tagger tagger, String message);
	void logIfEnabled(String fqcn, Level level, Tagger tagger, String message, Throwable t);

}
