package project.architecture.logger.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogPrinter {
	
		LogTarget logtarget;
		
		public LogPrinter(LogTarget t)
		{
				this.logtarget = t;
		}

	
		//Si target est la "console" on fait un System print ln
		public void write(String message)//public void write(String message,LogType logtype)
		{		
				String loggerType = "DEBUG";
				// loggerType = logtype.toString();
				Date date = new Date();
				long now = date.getTime();
				SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy hh:mm:ss");
				String msgFormater = message;
				
				for(int i=0; i < message.length(); i++)
				{
					
				}
				
				System.out.println("["+ loggerType +"] =="+"== ["+formater.format(now) +"] " + msgFormater);
				
		}
		
}
