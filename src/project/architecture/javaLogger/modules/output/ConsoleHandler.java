package project.architecture.javaLogger.modules.output;
import project.architecture.javaLogger.modules.core.Level;

/**
 * @author kadary
 *
 */
public class ConsoleHandler extends AbstractHandler {

	private Printer printer = new Printer();
	@Override
	public void log(Level level, String message, String fqcn, String handler){		
		if(this.getClass().getName().equals(handler)) {
			printer.write(level, message, fqcn, handler, "CONSOLE");
		}

	}

	@Override
	public void log(Level level, String message, String fqcn, String handler,
			Level levelFixed) {
		if (level.equals(levelFixed)) {
			if(this.getClass().getName().equals(handler)) {
				printer.write(levelFixed, message, fqcn, handler, "CONSOLE");
			}
		}

	}

}
