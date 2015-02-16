package project.architecture.javaLogger.modules.config;

import java.util.Map;


/**
 * Classe abstraite du module configuration
 * @author mhgeay, kadary
 * @version 1.0
 */
public abstract class AbstractConfigurator implements Configurator {
	
	private static String path;
	public static Map<String, String> settings = null;

	public abstract void setConfig();

	/**
	 * Return the local path of configuration file
	 * @author mhgeay
	 * @param NONE
	 * @return File path
	 */
	public String getConfigFilePath() {
		return path;
	}

	/**
	 * Set the local file path
	 * @author mhgeay
	 * @param Local file path
	 * @return NONE
	 */
	public void setConfigFilePath(String path) {
		AbstractConfigurator.path = path;
	}
	
	public Map<String, String> getSettings(){
		return settings;
	}

}
