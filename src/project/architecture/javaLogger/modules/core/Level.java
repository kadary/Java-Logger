package project.architecture.javaLogger.modules.core;

/**
 * Herited class with our 6 log levels : TRACE > DEBUG > INFO > WARM > ERROR > OFF
 * off - Logger disabled
 * error - Other runtime errors or unexpected conditions. Expect these to be immediately visible on a status console.
 * warn - Use of deprecated APIs, poor use of API, 'almost' errors, other runtime situations that are undesirable or unexpected, but not necessarily "wrong". Expect these to be immediately visible on a status console.
 * info - Interesting runtime events (startup/shutdown). Expect these to be immediately visible on a console, so be conservative and keep to a minimum.
 * debug - detailed information on the flow through the system. Expect these to be written to logs only.
 * trace - more detailed information. Expect these to be written to logs only.
 * 
 * @author kadary
 * @version 1.1
 */
public class Level extends AbstractLevel {
	
	public Level(String name, int value) {
		this.setName(name);
		this.setValue(value);
	}
	
	public static final Level TRACE = new Level("TRACE", Integer.MAX_VALUE);
	
	public static final Level DEBUG = new Level("DEBUG", 400);
	
	public static final Level INFO = new Level("INFO", 300);
	
	public static final Level WARN = new Level("WARN", 200);
	
	public static final Level ERROR = new Level("ERROR", 100);
	
	public static final Level OFF = new Level("OFF", Integer.MIN_VALUE);
}
