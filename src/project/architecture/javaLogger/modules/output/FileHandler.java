package project.architecture.javaLogger.modules.output;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import project.architecture.javaLogger.modules.core.Level;

/**
 * @author kadary
 *
 */
public class FileHandler extends AbstractHandler {

	@Override
	public void log(Level level, String message, String loggerName, Target target) {
		Map<String, String> log = new HashMap<String, String>(); 
		String indent="";
		
		if(target.equals(Target.FILE)) {
			
			Date date = new Date();
			long now = date.getTime();
			SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

			if (isLevelEnabled()) {
				log.put("level", level.getName());
				indent = indent + level.getName() + "	|	";
			}
			if(isDateEnabled()) {
				log.put("date", formater.format(now));
				indent = indent + formater.format(now) + "	|	";
			}

			if(isClassNameEnabled()) {
				log.put("class", loggerName);
				indent = indent + loggerName + "	|	";
			}
			
			log.put("message", message);
			indent = indent + message;
			//System.out.printf("%-5s %1s %-52s %5s %-5s %1s %-6s%n", log.get("date"), "|", log.get("class"), "|", log.get("level"), "|", log.get("message"));
			
			File f = new File ("log.txt");
			 
			try
			{
			    FileWriter fw = new FileWriter (f,true);
			    
			    fw.write(indent+"\n");
			 
			    fw.close();
			}
			catch (IOException exception)
			{
			    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
			}
			
			
		}
		
	}

}
