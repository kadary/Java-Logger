package project.architecture.javaLogger.modules.output;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import project.architecture.javaLogger.modules.core.Level;

/**
 * @author kadary
 *
 */
public class ConsoleHandler extends AbstractHandler {
	@Override
	public void log(Level level, String message, String loggerName, Target target){
		Map<String, String> log = new HashMap<String, String>();
		
		if(target.equals(Target.CONSOLE)) {
			Date date = new Date();
			long now = date.getTime();
			SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

			if (isLevelEnabled()) {
				log.put("level", level.getName());
			}
			if(isDateEnabled()) {
				log.put("date", formater.format(now));
			}

			if(isClassNameEnabled()) {
				log.put("class", loggerName);
			}

			log.put("message", message);
			
			//Correction de l'affichage null en cas de parametre date/level/class desactives dans properties
			if(log.get("date") != null)
				System.out.printf("%-5s %1s", log.get("date"), "|");
			if(log.get("class") != null)
				System.out.printf(" %-52s %5s",log.get("class"), "|");
			
			if(log.get("level") != null)
				System.out.printf(" %-5s %1s", log.get("level"), "|");
			
			System.out.printf(" %-6s%n", log.get("message"), "|");
			
			//System.out.printf("%-5s %1s %-52s %5s %-5s %1s %-6s%n", log.get("date"), "|", log.get("class"), "|", log.get("level"), "|", log.get("message"));
			//System.out.printf(finalMessage);
		}

	}

}
