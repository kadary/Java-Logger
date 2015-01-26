package project.architecture.javaLogger.config;

import java.util.Map;

public abstract class AbstractConfigurator {
	
	private static String path;

	public abstract Map<String,String> getConfig();

	public static String getConfigFilePath() {
		return path;
	}

	public static void setConfigFilePath(String path) {
		AbstractConfigurator.path = path;
	}

}
