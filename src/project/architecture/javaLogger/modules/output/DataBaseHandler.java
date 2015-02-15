package project.architecture.javaLogger.modules.output;

import project.architecture.javaLogger.modules.core.Level;

/**
 * Storage on database
 * @author kadary, mhgeay
 * @version 1.0
 */
public class DataBaseHandler extends AbstractHandler {

	@Override
	public void log(Level level, String message, String fqcn, Target target) {
		if(target.equals(Target.DB)) {
			
			// mhgeay : je peux tenter l'insert sur une base MySQl ou SQLite
		}
		
	}

}
