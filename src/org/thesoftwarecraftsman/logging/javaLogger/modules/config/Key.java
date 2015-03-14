/**
 * 
 */
package org.thesoftwarecraftsman.logging.javaLogger.modules.config;

/**
 * @author kadary
 *
 */
public enum Key {
	//Level activation config
	LevelINFO,
	LevelDEBUG,
	LevelWARN,
	LevelERROR,
	LevelTrace,

	//OUTPUT Handler Config
	
	//FileHandler Config
	FileHandler,
	LogFilePath,
	LogFileSize,
	
	//Console Handler
	ConsoleHandler,

	//DataBase Handler
	DataBaseHandler,

	//OUTPUT Format Configuration
	ShowLEVEL,
	ShowDATE,
	ShowFQCN,
	Separator,
}
