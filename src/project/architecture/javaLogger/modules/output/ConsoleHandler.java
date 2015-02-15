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
	public void log(Level level, String message, String fqcn, Target target){
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
				log.put("fqcn", fqcn);
			}


			log.put("message", message);

			System.out.printf("%-5s %1s %-52s %5s %-5s %1s %-6s%n", log.get("date"), "|", log.get("fqcn"), "|", log.get("level"), "|", log.get("message"));
		}

	}

}
