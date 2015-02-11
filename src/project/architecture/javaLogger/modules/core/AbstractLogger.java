package project.architecture.javaLogger.modules.core;


/**
 * @author kadary
 *
 */
public class AbstractLogger implements Logger {
	
	private String name;
	private Level level;
    
    public AbstractLogger() {
        this.setName(getClass().getName());
        this.setLevel(null);
    }
    
    public AbstractLogger(String name, Level level) {
        this.setName(name);
        this.setLevel(level);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public boolean isEnabled(String level) {
		// TODO Checked from config files if the level is enabled of not
		return false;
	}

	public boolean isInfoEnabled() {
		return isEnabled(Level.INFO.getName());
	}

	public void info(String message) {
		// TODO Auto-generated method stub
		
	}

	public boolean isWarnfoEnabled() {
		return isEnabled(Level.WARN.getName());
	}

	public void warn(String message) {
		// TODO Auto-generated method stub
		
	}

	public boolean isErrorEnabled() {
		return isEnabled(Level.ERROR.getName());
	}

	public void error(String message) {
		// TODO Auto-generated method stub
		
	}

	public boolean isDebugEnabled() {
		return isEnabled(Level.DEBUG.getName());
	}

	public void debug(String message) {
		// TODO Auto-generated method stub
		
	}
}
