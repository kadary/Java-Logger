package project.architecture.javaLogger.modules.output;

import project.architecture.javaLogger.modules.config.ConfigFromProperties;
import project.architecture.javaLogger.modules.config.Configurator;
import project.architecture.javaLogger.modules.core.Level;

/**
 * @author kadary
 *
 */
public abstract class AbstractHandler implements Handler {
	
	public static final Configurator configuration = new ConfigFromProperties();
	
	public AbstractHandler() {
		configuration.setConfig();
	}
	
	public abstract void log(Level level, String message, String fqcn, Target target);
	
	
	public boolean isEnabled(String token) {	
		String value;
		boolean result = false;
		if (configuration.getSettings().get(token) != null) {
			value = configuration.getSettings().get(token);
			result = value.equalsIgnoreCase("true") ? true : false;
		}
		return result;
	}

	public boolean isLevelEnabled() {
		return isEnabled("LEVEL");
	}

	public boolean isDateEnabled() {
		return isEnabled("DATE");
	}

	public boolean isClassNameEnabled() {
		return isEnabled("FQCN");
	}
	
}
