package project.architecture.javaLogger.modules.output;

import project.architecture.javaLogger.modules.core.Level;

/**
 * Storage on file
 * @author kadary, adepolas
 * @version 1.0
 */
public class FileHandler extends AbstractHandler {

	@Override
	public void log(Level level, String message, String fqcn, Target target) {
		if(target.equals(Target.FILE)) {
			//TODO Adeline ton code doit se trouver ici
		}
		
	}

}
