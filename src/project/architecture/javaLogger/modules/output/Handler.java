/**
 * 
 */
package project.architecture.javaLogger.modules.output;

import project.architecture.javaLogger.modules.core.Level;

/**
 * Choose of information stored
 * @author kadary
 * @verion 1.0
 */
public interface Handler {
	
	void log(Level level, String message, String fqcn, String handler);
	void log(Level level, String message, String fqcn, String handler, Level levelFixed);

}
