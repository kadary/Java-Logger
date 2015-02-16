package project.architecture.javaLogger.test;

import project.architecture.javaLogger.modules.core.LogManager;
import project.architecture.javaLogger.modules.core.Logger;

/**
 * TEST class main : Class for developers. They can try their latest codes
 * @author kadary
 * @version 1.0
 */
public class Main {
	public static void main(String[] args) {

		LogManager logManager = new LogManager();
		Logger logger = logManager.getLogger();
		Logger loggerClassCustom = logManager.getLogger("test of custom FQCN");
		Logger loggerClassA = logManager.getLogger("com.esiea.classA");
		
		if (logger.isInfoEnabled()) {
			logger.info("Ceci est un message tres tres long car on veut tester l'indentation du LoggerWriter pour pouvoir reajuster le texte dans la console/le fichier texte. Et blablabla... Et blablabla ! Baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin. ");
		}
		if (loggerClassCustom.isDebugEnabled()) {
			loggerClassCustom.debug("Salut");
		}
		
		if (logger.isWarnEnabled()) {
			logger.warn("Test de la librairie");
		}
		
		if (loggerClassCustom.isErrorEnabled()) {
			loggerClassCustom.error("Whaouuuuuuuuuuuuuuuuuuuu");
		}
		
		if (loggerClassA.isWarnEnabled()) {
			loggerClassA.warn("ClassA is not defined");
		}
	}

}
