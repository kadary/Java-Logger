package project.architecture.javaLogger.modules.output;

import project.architecture.javaLogger.modules.core.Level;

/**
 * @author kadary
 *
 */

public class FileHandler extends AbstractHandler {
	
	private Printer printer = new Printer();

	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater) {

		if(handler.equals(FileHandler.class.getName())) {
			
			printer.write(level, message, fqcn, FileHandler.class.getName(), formater);
		}

	}

	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater,
			Level levelFixed) {
		if (level == levelFixed) {
			if(handler.equals(FileHandler.class.getName())) {
				printer.write(levelFixed, message, fqcn, FileHandler.class.getName(), formater);
			}
		}
	}
	
	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater,
			boolean forceLogging) {
		if (forceLogging) {
			if(this.getClass().getName().equals(handler)) {
				printer.write(level, message, fqcn, FileHandler.class.getName(), formater);
			}
		}	
	}
}
