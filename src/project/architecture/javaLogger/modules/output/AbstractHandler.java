package project.architecture.javaLogger.modules.output;

import java.util.Properties;

import project.architecture.javaLogger.modules.config.Key;
import project.architecture.javaLogger.modules.core.Level;
import project.architecture.javaLogger.modules.core.LogManager;

/**
 * @author kadary
 * @version 1.0
 */
public abstract class AbstractHandler implements Handler {
	
	private Properties settings = LogManager.config.getSettings();

	public abstract void log(Level level, String message, String fqcn, Target target);


	public boolean isEnabled(String token) {	
		String value;
		boolean result = false;
		try {
			if (settings.get(token) != null) {
				value = (String) settings.get(token);
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
	return isEnabled(Key.ShowLEVEL.name());
}

public boolean isDateEnabled() {
	return isEnabled(Key.ShowDATE.name());
}

public boolean isFQCNEnabled() {
	return isEnabled(Key.ShowFQCN.name());
}

}
