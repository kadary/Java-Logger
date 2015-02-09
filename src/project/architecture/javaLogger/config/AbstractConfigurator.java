package project.architecture.javaLogger.config;

import java.util.Map;


/**
 * Classe abstraite du module configuration
 * @author mhgeay
 * @version 1.0
 */
public abstract class AbstractConfigurator {
	
	private static String path;

	public abstract Map<String,String> getConfig();

	/**
	 * Return the local path of configuration file
	 * @author mhgeay
	 * @param NONE
	 * @return File path
	 */
	public static String getConfigFilePath() {
		return path;
	}

	/**
	 * Set the local file path
	 * @author mhgeay
	 * @param Local file path
	 * @return NONE
	 */
	public static void setConfigFilePath(String path) {
		AbstractConfigurator.path = path;
	}

}
