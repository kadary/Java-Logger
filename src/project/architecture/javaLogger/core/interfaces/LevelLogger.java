package project.architecture.javaLogger.core.interfaces;

public interface LevelLogger extends Logger {
	
	boolean isInfoEnabled();
	void info(String message);
	void info(String message, Throwable t);
	boolean isInfoEnabled(Tagger tagger);
	void info(Tagger tagger, String message);
	void info(Tagger tagger, String message, Throwable t);
	
	boolean isTraceEnabled();
	void trace(String message);
	void trace(String message, Throwable t);
	boolean isTraceEnabled(Tagger tagger);
	void trace(Tagger tagger, String message);
	void trace(Tagger tagger, String message, Throwable t);
	
	boolean isWarnEnabled();
	void warn(String message);
	void warn(String message, Throwable t);
	boolean isWarnEnabled(Tagger tagger);
	void warn(Tagger tagger, String message);
	void warn(Tagger tagger, String message, Throwable t);
	
	boolean isDebugEnabled();
	void debug(String message);
	void debug(String message, Throwable t);
	boolean isDebugEnabled(Tagger tagger);
	void debug(Tagger tagger, String message);
	void debug(Tagger tagger, String message, Throwable t);
	
	boolean isErrorEnabled();
	void error(String message);
	void error(String message, Throwable t);
	boolean isErrorEnabled(Tagger tagger);
	void error(Tagger tagger, String message);
	void error(Tagger tagger, String message, Throwable t);
	
	boolean isFatalEnabled();
	void fatal(String message);
	void fatal(String message, Throwable t);
	boolean isFatalEnabled(Tagger tagger);
	void fatal(Tagger tagger, String message);
	void fatal(Tagger tagger, String message, Throwable t);

}
