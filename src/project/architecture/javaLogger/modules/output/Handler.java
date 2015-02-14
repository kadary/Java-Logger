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

	void log(Level info, String message);

}
