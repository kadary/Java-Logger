package project.architecture.javaLogger.modules.config;

import java.util.Map;

/**
 * Interface of Config module
 * @author kadary
 * @version 1.0
 */
public interface Configurator {
	
	public abstract void setConfig();
	
	public String getConfigFilePath();
	
	public void setConfigFilePath(String path);
	
	public Map<String, String> getSettings();

}
