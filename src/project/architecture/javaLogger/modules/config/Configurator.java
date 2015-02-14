package project.architecture.javaLogger.modules.config;

import java.util.Map;

public interface Configurator {
	
	public abstract void setConfig();
	
	public String getConfigFilePath();
	
	public void setConfigFilePath(String path);
	
	public Map<String, String> getSettings();

}
