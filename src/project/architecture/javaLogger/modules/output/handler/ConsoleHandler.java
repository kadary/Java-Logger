package project.architecture.javaLogger.modules.output.handler;
import project.architecture.javaLogger.core.Level;
import project.architecture.javaLogger.modules.output.formater.Formater;

/**
 * @author kadary
 *
 */
public class ConsoleHandler extends AbstractHandler {

	private Printer printer = new Printer();
	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater){		
		if(this.getClass().getName().equals(handler)) {
			printer.write(level, message, fqcn, ConsoleHandler.class.getName(), formater, null);
		}

	}

	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater,
			Level levelFixed) {
		if (level.equals(levelFixed)) {
			if(this.getClass().getName().equals(handler)) {
				printer.write(levelFixed, message, fqcn, ConsoleHandler.class.getName(), formater, null);
			}
		}

	}

	@Override
	public void log(Level level, String message, String fqcn, String handler, Formater formater,
			boolean forceLogging) {
		if (forceLogging) {
			if(this.getClass().getName().equals(handler)) {
				printer.write(level, message, fqcn, ConsoleHandler.class.getName(), formater, null);
			}
		}	
	}

}
