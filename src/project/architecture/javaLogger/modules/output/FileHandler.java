package project.architecture.javaLogger.modules.output;

import project.architecture.javaLogger.modules.core.Level;

/**
 * @author kadary
 *
 */

public class FileHandler extends AbstractHandler {
	
	private Printer printer = new Printer();

	@Override
	public void log(Level level, String message, String fqcn, String handler) {

		if(handler.equals(FileHandler.class.getName())) {
			
			printer.write(level, message, fqcn, handler, "FILE");
		}

	}

	@Override
	public void log(Level level, String message, String fqcn, String handler,
			Level levelFixed) {
		if (level == levelFixed) {
			if(handler.equals(FileHandler.class.getName())) {
				printer.write(levelFixed, message, fqcn, handler, "FILE");
			}
		}
	}
	
	@Override
	public void log(Level level, String message, String fqcn, String handler,
			boolean forceLogging) {
		if (forceLogging) {
			if(this.getClass().getName().equals(handler)) {
				printer.write(level, message, fqcn, handler, "FILE");
			}
		}	
	}
}
