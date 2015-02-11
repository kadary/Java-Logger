package project.architecture.javaLogger.modules.core;


/**
 * @author kadary
 *
 */
public class Level extends AbstractLevel {
	
	public Level(String name, int value) {
		this.setName(name);
		this.setValue(value);
	}
	
	public static final Level OFF = new Level("OFF", Integer.MIN_VALUE);
	
	
	public static final Level INFO = new Level("INFO", 500);
	
	public static final Level WARN = new Level("WARN", 1000);
	
	public static final Level DEBUG = new Level("DEBUG", 1500);
	
	public static final Level ERROR = new Level("ERROR", 2000);
	
	public static final Level ALL = new Level("ALL", Integer.MAX_VALUE);

}
