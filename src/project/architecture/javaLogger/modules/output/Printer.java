/**
 * 
 */
package project.architecture.javaLogger.modules.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import project.architecture.javaLogger.modules.config.Key;
import project.architecture.javaLogger.modules.core.Level;
import project.architecture.javaLogger.modules.core.LogManager;

/**
 * @author kadary
 *
 */
public class Printer {

	private Properties settings = LogManager.config.getSettings();

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

	public boolean isLevelEnabled() {
		return isEnabled(Key.ShowLEVEL.name());
	}

	public boolean isDateEnabled() {
		return isEnabled(Key.ShowDATE.name());
	}

	public boolean isFQCNEnabled() {
		return isEnabled(Key.ShowFQCN.name());
	}

	public void write(Level level, String message, String fqcn, String handler,
			String target) {
		
		Map<String, String> log = new HashMap<String, String>();
		Date date = new Date();
		long now = date.getTime();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

		if(isDateEnabled()) {
			log.put("DATE", formater.format(now));
		}

		if(isFQCNEnabled()) {
			log.put("FQCN", fqcn);
		}

		if (isLevelEnabled()) {
			log.put("LEVEL", level.getName());
		}

		log.put("message", message);
		
		
		if (target.equalsIgnoreCase("CONSOLE")) {
			if(log.get("DATE") != null)
				System.out.printf("%-5s %1s", log.get("DATE"), "|");

			if(log.get("FQCN") != null)
				System.out.printf(" %-52s %5s", log.get("FQCN"), "|");

			if(log.get("LEVEL") != null)
				System.out.printf(" %-5s %1s", log.get("LEVEL"), "|");

			System.out.printf(" %-6s%n", log.get("message"));
		}
		
		else if (target.equalsIgnoreCase("FILE")) {
			FileWriter fw = null;			
			String filename = (String) LogManager.config.getSettings().get(Key.LogFilePath.name());
			
			final File logFile = new File (filename);
			final File parent_directory = logFile.getParentFile();
			
			try {

				if (null != parent_directory) {
				    parent_directory.mkdirs();
				}

				fw = new FileWriter (logFile, true);
				String fileSize = (String) LogManager.config.getSettings().get(Key.LogFileSize.name());
				double limitSize = 0.0;
				try {
					limitSize = Double.parseDouble(fileSize.trim());
					limitSize *= 1000; 
				}
				catch (NumberFormatException e) {
					System.out.print("Your log file size is not readable, please check it => ");
					e.printStackTrace();
				}
				
				if (limitSize ==  0 || logFile.length() <= limitSize) {
					//System.out.println("Log file size: " + logFile.length() + "Limit Size: " + limitSize);
					if(log.get("DATE") != null) {
						fw.write(String.format("%-5s %1s", log.get("DATE"), "|"));
					}
					
					if(log.get("FQCN") != null) {
						fw.write(String.format(" %-52s %5s",log.get("FQCN"), "|"));
					}
					
					if(log.get("LEVEL") != null) {
						fw.write(String.format(" %-5s %1s", log.get("LEVEL"), "|"));
					}
					
					fw.write(String.format(" %-6s%n", log.get("message")));
					
					fw.close();
					
					//System.out.println("Log file size: " + logFile.length() + "Limit Size: " + limitSize);
				}
				
				else
					//TODO Adeline verifie ICI la taille fileSize() puis fais une rotation
					System.out.println("Adeline verifie la taille fileSize() puisfais une rotation");
			}
			catch (IOException exception) {
				System.out.print("Unable to write in file => ");
				exception.printStackTrace();
			}
			
			finally {
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println ("Unable to close File => ");
					e.printStackTrace();
				}
			}
		}
	}
}
