package org.thesoftwarecraftsman.logging.javaLogger.modules.output.handler;

import org.thesoftwarecraftsman.logging.javaLogger.core.Level;
import org.thesoftwarecraftsman.logging.javaLogger.modules.output.formater.Formater;

/**
 * Storage on database
 * @author kadary, mhgeay
 * @version 1.0
 */
public class DataBaseHandler extends AbstractHandler {

	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater) {
		if(this.getClass().getName().equals(handler)) {
			
			// mhgeay : je peux tenter l'insert sur une base MySQl ou SQLite
		}
		
	}

	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater,
			Level levelFixed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater,
			boolean forceLogging) {
		// TODO Auto-generated method stub
		
	}

}
