package project.architecture.javaLogger.modules.core;

import project.architecture.javaLogger.modules.config.ConfigFromProperties;
import project.architecture.javaLogger.modules.config.Configurator;

public class Main {
	public final static Configurator configuration = new ConfigFromProperties(); 
	public static void main(String[] args) {
		//configuration.setConfigFilePath("C:/Users/kadary/Desktop/JavaLogger.properties");
		configuration.setConfig();
		String value;
		boolean result = false;
		if (configuration.getSettings().get("INFO") != null) {
			value = configuration.getSettings().get("INFO");
			result = value.equalsIgnoreCase("true") ? true : false;
		}
		
		 System.out.println(result);

	}

}
