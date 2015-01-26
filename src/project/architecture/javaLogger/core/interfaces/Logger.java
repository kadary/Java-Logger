package project.architecture.javaLogger.core.interfaces;


public interface Logger {
		
	Level getLevel();
	String getName();
	
	void entry();
	void entry(Object... params);
	void exit();
	<T> T exit(T result);
	
}
