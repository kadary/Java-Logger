/**
 * 
 */
package project.architecture.javaLogger.modules.output.handler;

import project.architecture.javaLogger.core.Level;
import project.architecture.javaLogger.modules.output.formater.Formater;

/**
 * Choose of information stored
 * @author kadary
 * @verion 1.0
 */
public interface Handler {
	
	void log(Level level, String message, String fqcn, String handler, Formater formater);
	void log(Level level, String message, String fqcn, String handler, Formater formater, Level levelFixed);
	void log(Level level, String message, String fqcn, String name, Formater formater, boolean forceLogging);

}
