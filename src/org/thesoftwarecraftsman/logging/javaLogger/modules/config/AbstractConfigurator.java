package org.thesoftwarecraftsman.logging.javaLogger.modules.config;

import java.util.Enumeration;
import java.util.Properties;


/**
 * Classe abstraite du module configuration
 * @author mhgeay, kadary
 * @version 1.0
 */
public abstract class AbstractConfigurator implements Configurator {
	
	private static String path;

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
	
	public abstract Properties getSettings();
	
	public abstract Enumeration<?> getKeys();

}
