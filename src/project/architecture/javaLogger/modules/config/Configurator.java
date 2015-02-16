package project.architecture.javaLogger.modules.config;

import java.util.Enumeration;
import java.util.Properties;

/**
 * Interface of Config module
 * @author kadary
 * @version 1.0
 */
public interface Configurator {
	
	public String getConfigFilePath();
	
	public void setConfigFilePath(String path);
	
	public Properties getSettings();
	
	public Enumeration<?> getKeys();

}
