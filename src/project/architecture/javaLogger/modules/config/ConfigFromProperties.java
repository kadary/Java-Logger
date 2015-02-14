package project.architecture.javaLogger.modules.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Config module : Read configuration from Properties local file
 * @author mhgeay
 * @version 1.0
 */
public class ConfigFromProperties extends AbstractConfigurator {
	
	private Properties configProp = new Properties();
	Map<String,String> config = new HashMap<String,String>();;

	/**
	 * Return the content of Properties file within a Map collection
	 * @param NONE
	 * @return MAP config
	 */
	@Override
	public void setConfig() {
		
		setConfigFilePath("JavaLogger.properties");
		
		FileInputStream configFileStream;
		try {
			configFileStream = new FileInputStream(getConfigFilePath());
			try {
				  configProp.load(configFileStream);
				  if(!configProp.isEmpty()) {
					  for(String key : configProp.stringPropertyNames()) {
						  String value = configProp.getProperty(key);
						  //System.out.println(key + " => " + value);
						  config.put(key, value);
						}
				  }
				  configFileStream.close();
				} 
			catch (IOException e) {
					e.printStackTrace();
				}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		settings = config;
	}
}
