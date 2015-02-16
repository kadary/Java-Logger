package project.architecture.javaLogger.modules.output;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import project.architecture.javaLogger.modules.core.Level;
import project.architecture.javaLogger.modules.core.LogManager;

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

			if(isDateEnabled()) {
				log.put("date", formater.format(now));
				indent = indent + formater.format(now) + "	|	";
			}

			if(isClassNameEnabled()) {
				log.put("class", loggerName);
				indent = indent + loggerName + "	|	";
			}
			
			if (isLevelEnabled()) {
				log.put("level", level.getName());
				indent = indent + level.getName() + "	|	";
			}
			
			log.put("message", message);
			indent = indent + message;
			
			//recuperation dans properties du chemin pour le fichier ou ecrire
			String filename = LogManager.settings.get("FilePath");
			
			//Partie parsing manquante
			
			File logFile = new File (filename);
			//File f = new File (filename);
			
			try
			{
			    FileWriter fw = new FileWriter (logFile,true);
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
