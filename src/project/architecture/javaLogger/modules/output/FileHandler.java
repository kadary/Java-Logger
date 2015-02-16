package project.architecture.javaLogger.modules.output;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import project.architecture.javaLogger.modules.config.Key;
import project.architecture.javaLogger.modules.core.Level;
import project.architecture.javaLogger.modules.core.LogManager;

/**
 * @author kadary
 *
 */

public class FileHandler extends AbstractHandler {

	@Override
	public void log(Level level, String message, String fqcn, Target target) {

		if(target.equals(Target.FILE)) {

			Map<String, String> log = new HashMap<String, String>();
			FileWriter fw = null;			
			String filename = (String) LogManager.config.getSettings().get(Key.LogFilePath.name());
			
			final File logFile = new File (filename);
			final File parent_directory = logFile.getParentFile();

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
