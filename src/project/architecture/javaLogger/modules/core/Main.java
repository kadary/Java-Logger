package project.architecture.javaLogger.modules.core;


public class Main {
	public static void main(String[] args) {

		LogManager logManager = new LogManager();
		Logger logger = logManager.getLogger();
		
		 System.out.println(logger.getName());
	}

}
