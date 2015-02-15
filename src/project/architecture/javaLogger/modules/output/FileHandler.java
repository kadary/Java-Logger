package project.architecture.javaLogger.modules.output;

import project.architecture.javaLogger.modules.core.Level;

/**
 * @author kadary
 *
 */
public class FileHandler extends AbstractHandler {

	@Override
	public void log(Level level, String message, String fqcn, Target target) {
		if(target.equals(Target.FILE)) {
			
		}
		
	}

}
