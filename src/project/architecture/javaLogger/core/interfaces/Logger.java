package project.architecture.javaLogger.core.interfaces;


public interface Logger {
		
	Level getLevel();
	String getName();
	MessageFactory getMessageFactory();
	
	void entry();
	void entry(Object... params);
	void exit();
	<T> T exit(T result);
	
	void printf(Level level, String format, Object... params);
	void printf(Level level, Tagger tagger, String format, Object... params);
	
	<T extends Throwable> T throwing(Level level, T t);
	<T extends Throwable> T throwing(T t);
	
	boolean isEnabled(Level level);
	void log(Level level, String message);
	void log(Level level, String message, Throwable t);
	boolean isEnabled(Level level, Tagger tagger);
	void log(Level level, Tagger tagger, String message);
	void log(Level level, Tagger tagger, String message, Throwable t);
		
}
