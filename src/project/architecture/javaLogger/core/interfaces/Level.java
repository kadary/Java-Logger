package project.architecture.javaLogger.core.interfaces;

public enum Level {
	
	/**
     * No events will be logged.
     */
    OFF,
    
    /**
     * A fine-grained debug message, typically capturing the flow through the application.
     */
    TRACE,
    
    /**
     * An event for informational purposes.
     */
    INFO,
    
    /**
     * An event that might possible lead to an error.
     */
    WARN,
    
    /**
     * A general debugging event.
     */
    DEBUG,
    
    /**
     * An error in the application, possibly recoverable.
     */
    ERROR,

    /**
     * A severe error that will prevent the application from continuing.
     */
    FATAL,    

    /**
     * All events should be logged.
     */
    ALL;
}
