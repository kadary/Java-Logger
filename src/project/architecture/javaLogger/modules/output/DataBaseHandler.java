package project.architecture.javaLogger.modules.output;

import project.architecture.javaLogger.modules.core.Level;

/**
 * Storage on database
 * @author kadary, mhgeay
 * @version 1.0
 */
public class DataBaseHandler extends AbstractHandler {

	@Override
	public void log(Level level, String message, String fqcn, String handler) {
		if(this.getClass().getName().equals(handler)) {
			
			// mhgeay : je peux tenter l'insert sur une base MySQl ou SQLite
		}
		
	}

	@Override
	public void log(Level level, String message, String fqcn, String handler,
			Level levelFixed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level level, String message, String fqcn, String handler,
			boolean forceLogging) {
		// TODO Auto-generated method stub
		
	}

}
