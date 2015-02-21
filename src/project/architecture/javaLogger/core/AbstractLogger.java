package project.architecture.javaLogger.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import project.architecture.javaLogger.modules.config.Key;
import project.architecture.javaLogger.modules.output.formater.DefaultFormater;
import project.architecture.javaLogger.modules.output.formater.Formater;
import project.architecture.javaLogger.modules.output.handler.ConsoleHandler;
import project.architecture.javaLogger.modules.output.handler.DataBaseHandler;
import project.architecture.javaLogger.modules.output.handler.FileHandler;
import project.architecture.javaLogger.modules.output.handler.Handler;


/**
 * @author kadary
 * @version 1.0
 * @param <V>
 */
public abstract class AbstractLogger implements Logger {

	private String fqcn;
	private Handler CONSOLE = new ConsoleHandler();
	private Handler FILE = new FileHandler();
	private Handler DB = new DataBaseHandler();
	protected Map<String, Handler> handlers = new HashMap<String, Handler>();
	protected Level levelFixed;
	protected Formater formater;
	protected Properties settings = LogManager.config.getSettings();

	public AbstractLogger(String name) {
		String configClass = name + ".Name";
		String configLevel = name + ".Level";
		String configHandlers = name + ".Handlers";
		String configFormater = name + ".Formater";
		
		if(settings.containsKey(configClass)) {
			this.setFQCN((String) settings.get(configClass));
			//System.out.println(this.fqcn);
		}
		else
			this.setFQCN(name);
		
		if(settings.containsKey(configLevel)) {
			this.setLevel(Level.getLevel((String) settings.get(configLevel)));
			//System.out.println(this.levelFixed.name);
		}			
		
		if(settings.containsKey(configHandlers)) {
			String[] handlers = settings.getProperty(configHandlers).split(",");
			for(int i = 0; i < handlers.length; i++) {
				Class<?> configHandler;
				try {
					configHandler = Class.forName(handlers[i].trim());
					this.addHandlerClass(configHandler);
					//System.out.println(configHandler.getCanonicalName());
				} catch (ClassNotFoundException e) {
					System.out.print("The class you have specified as handler doe's not exist: ");
					e.printStackTrace();
				}
			}
		}
		
		if(settings.containsKey(configFormater)) {
			String formater = settings.getProperty(configFormater);
			Class<?> formaterClass;
				try {
					formaterClass = Class.forName(formater.trim());
					this.setFormaterClass(formaterClass);
				} catch (ClassNotFoundException e) {
					setFormater(new DefaultFormater());
					System.out.print("The class you have specified as framater doe's not exist: ");
					e.printStackTrace();
				}
			}
		else 
			setFormater(new DefaultFormater());
		
	}
	
	public abstract void trace(String message);
	public abstract void debug(String message);
	public abstract void info(String message);
	public abstract void warn(String message);
	public abstract void error(String message);


	private String getFQCN() {
		return fqcn;
	}

	private void setFQCN(String fqcn) {
		this.fqcn = fqcn;
	}

	public boolean isEnabled(String levelFixed) {	
		String value;
		boolean result = false;
		try {
			if (settings.get(levelFixed) != null) {
				value = (String) settings.get(levelFixed);
				result = value.equalsIgnoreCase("true") ? true : false;
			}
		}
		catch (NullPointerException e) {
			System.out.print("Settings not set! please check your config: ");
			e.printStackTrace();
		}
		return result;
	}

	public boolean isInfoEnabled() {
		return isEnabled(Key.LevelINFO.name());
	}

	public boolean isWarnEnabled() {
		return isEnabled(Key.LevelWARN.name());
	}

	public boolean isErrorEnabled() {
		return isEnabled(Key.LevelERROR.name());
	}

	public boolean isDebugEnabled() {
		return isEnabled(Key.LevelDEBUG.name());
	}

	@Override
	public boolean isTraceEnabled() {
		return isEnabled(Key.LevelTrace.name());
	}

	@Override
	public void addHandler(Handler handler) {
		handlers.put(handler.getClass().getName(), handler);
	}
	private void addHandlerClass(Class<?> configHandler) {
		try {
			Handler handler = (Handler) configHandler.newInstance();
			this.addHandler(handler);
			//System.out.println(this.handlers.toString());
		} catch (InstantiationException e) {
			System.out.print("Unable to instantiate your provided handler: ");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.print("Can't access to your provided handler: ");
			e.printStackTrace();
		}
	}

	@Override
	public void setLevel(Level levelFixed) {
		this.levelFixed = levelFixed;
	}

	@Override
	public void setFormater(Formater formater) {
		this.formater = formater;
	}
	private void setFormaterClass(Class<?> formaterClass) {
			try {
				Formater formater = (Formater) formaterClass.newInstance();
				this.setFormater(formater);
				//System.out.println(this.formater.getClass().getCanonicalName());
			} catch (InstantiationException e) {
				System.out.print("Unable to instantiate your provided formater: ");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.print("Can't access to your provided formater: ");
				e.printStackTrace();
			}
	}

	protected void logByLoggerConfig(String message, Level level) {
		if (!handlers.isEmpty()) {
			Set<String> keys = handlers.keySet();
			Iterator<String> iterator = keys.iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				Handler handler = handlers.get(key);
				if(!isNull(levelFixed)) {
					if(levelFixed.getValue() > level.getValue()) {
						handler.log(level, message, this.getFQCN(), handler.getClass().getName(), formater, true);
					}
					else
						handler.log(level, message, this.getFQCN(), handler.getClass().getName(), formater, levelFixed);
				}
				else
					handler.log(level, message, this.getFQCN(), handler.getClass().getName(), formater);
			}
		}
		else if(!isNull(levelFixed)) {
			if (isEnabled(Key.ConsoleHandler.name())) {
				if(levelFixed.getValue() > level.getValue()) {
					CONSOLE.log(level, message, this.getFQCN(), ConsoleHandler.class.getName(), formater, true);
				}
				else
					CONSOLE.log(level, message, this.getFQCN(), ConsoleHandler.class.getName(), formater, levelFixed);
			}

			if (isEnabled(Key.FileHandler.name())) {
				if(levelFixed.getValue() > level.getValue()) {
					FILE.log(level, message, this.getFQCN(), FileHandler.class.getName(), formater, true);
				}
				else
					FILE.log(level, message, this.getFQCN(), FileHandler.class.getName(), formater, levelFixed);
			}

			if (isEnabled(Key.DataBaseHandler.name())) {
				if(levelFixed.getValue() > level.getValue()) {
					DB.log(level, message, this.getFQCN(), DataBaseHandler.class.getName(), formater, true);
				}
				else
					DB.log(level, message, this.getFQCN(), DataBaseHandler.class.getName(), formater, levelFixed);
			}
		}
	}

	protected void logByPropConfig(String message, Level level) {
		if (handlers.isEmpty() & isNull(levelFixed)) {
			if (isEnabled(Key.ConsoleHandler.name())) {
				CONSOLE.log(level, message, this.getFQCN(), ConsoleHandler.class.getName(), formater);
			}

			if (isEnabled(Key.FileHandler.name())) {
				FILE.log(level, message, this.getFQCN(), FileHandler.class.getName(), formater);
			}

			if (isEnabled(Key.DataBaseHandler.name())) {
				DB.log(level, message, this.getFQCN(), DataBaseHandler.class.getName(), formater);
			}
		}
	}

	protected boolean isNull(Level levelFixed) {
		return this.levelFixed == null || this.levelFixed.getName() == " " ? true : false;
	}
}
