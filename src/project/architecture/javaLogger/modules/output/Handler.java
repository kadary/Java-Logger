/**
 * 
 */
package project.architecture.javaLogger.modules.output;

import project.architecture.javaLogger.modules.core.Level;

/**
 * @author kadary
 *
 */
public interface Handler {
	
	void log(Level level, String message, String fqcn, Target target);
	
	boolean isLevelEnabled();
	boolean isDateEnabled();
	boolean isClassNameEnabled();

}
