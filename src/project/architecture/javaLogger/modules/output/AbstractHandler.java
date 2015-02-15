package project.architecture.javaLogger.modules.output;

import project.architecture.javaLogger.modules.core.Level;
import project.architecture.javaLogger.modules.core.LogManager;

/**
 * @author kadary
 * @version 1.0
 */
public abstract class AbstractHandler implements Handler {

	public abstract void log(Level level, String message, String fqcn, Target target);


	public boolean isEnabled(String token) {	
		String value;
		boolean result = false;
		try {
			if (LogManager.settings.get(token) != null) {
				value = LogManager.settings.get(token);
				result = value.equalsIgnoreCase("true") ? true : false;
			}
		}
		catch (NullPointerException e) {
			System.out.print("Settings not set! please check your config: ");
			e.printStackTrace();		
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
