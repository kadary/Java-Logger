package project.architecture.javaLogger.modules.output;

public class LogWriterTest {
	
	public static void main(String[] args) {
		LogPrinter l = new LogPrinter ();
		String messageLong = "Ceci est un message très très long car on veut tester l'indentation du LoggerWriter pour pouvoir réajuster le texte dans la console/le fichier texte. Et blablabla... Et blablabla ! Baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin baratin. ";
		l.write("Welcome to Logger");
		l.write(messageLong);
	}
}
