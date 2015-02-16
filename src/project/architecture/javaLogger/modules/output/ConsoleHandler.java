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
			
			if(log.get("DATE") != null)
				System.out.printf("%-5s %1s", log.get("DATE"), "|");
			
			if(log.get("FQCN") != null)
				System.out.printf(" %-52s %5s", log.get("FQCN"), "|");
			
			if(log.get("LEVEL") != null)
				System.out.printf(" %-5s %1s", log.get("LEVEL"), "|");
			
			System.out.printf(" %-6s%n", log.get("message"));
		}

	}

}
