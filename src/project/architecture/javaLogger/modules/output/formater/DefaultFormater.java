/**
 * 
 */
package project.architecture.javaLogger.modules.output.formater;

import java.util.Properties;

import project.architecture.javaLogger.core.LogManager;
import project.architecture.javaLogger.modules.config.Key;

/**
 * @author kadary
 *
 */
public class DefaultFormater extends AbstractFormater {
	
	private Properties settings = LogManager.config.getSettings();
	
	public DefaultFormater() {
		this.isDateEnabled = this.dateEnabled();
		this.isFQCNEnabled = this.FQCNEnabled();
		this.isLevelEnabled = this.levelEnabled();
		this.isMessageEnabled = true;
		if(settings.get((Key.Separator.name())) != null) {
			try {
				this.separator = (String) settings.get(Key.Separator.name());
			}
			catch (ClassCastException e) {
				System.out.println("Please check your default separator, it must be a char: ");
				e.printStackTrace();
				this.separator = "|";
			}
		}
		else 
			this.separator = "|";
	}
	
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

	private boolean levelEnabled() {
		return isEnabled(Key.ShowLEVEL.name());
	}

	private boolean dateEnabled() {
		return isEnabled(Key.ShowDATE.name());
	}

	private boolean FQCNEnabled() {
		return isEnabled(Key.ShowFQCN.name());
	}

}
