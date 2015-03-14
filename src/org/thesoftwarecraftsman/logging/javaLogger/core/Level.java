package org.thesoftwarecraftsman.logging.javaLogger.core;


/**
 * Herited class with our 6 log levels : TRACE > ERROR > DEBUG > WARM > INFO > OFF
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

	public static Level getLevel(String levelName) {
		Level level;
		int value = 0;
		//Transform string to Int for switch case compatibility (Java 5)
		if (levelName.equalsIgnoreCase("INFO")) {
			value = 1;
		}
		else if (levelName.equalsIgnoreCase("WARN")) {
			value= 2;
		}
		else if (levelName.equalsIgnoreCase("DEBUG")) {
			value = 3;
		}
		
		else if (levelName.equalsIgnoreCase("ERROR")) {
			value = 4;
		}
		else {
			value = 5;
		}
		
		switch (value) {
		case 1:
			level = Level.INFO;
			break;
		case 2:
			level = Level.WARN;
			break;
		case 3:
			level = Level.DEBUG;
			break;
		case 4:
			level = Level.ERROR;
			break;
		default:
			level = Level.TRACE;
			break;	
			}
		return level;
	}

	public static final Level OFF = new Level("OFF", Integer.MIN_VALUE);

	public static final Level INFO = new Level("INFO", 100);

	public static final Level WARN = new Level("WARN", 200);

	public static final Level DEBUG = new Level("DEBUG", 300);

	public static final Level ERROR = new Level("ERROR", 400);

	public static final Level TRACE = new Level("TRACE", Integer.MAX_VALUE);

}
