package org.thesoftwarecraftsman.logging.javaLogger.core;

/**
 * The Abstract class on witch all levels class should extended 
 * @author kadary
 * @version 1.0
 */
public class AbstractLevel {

	protected String name;
	protected int value;
	
	/**
	 * @return  name  The name of this level 
	 */	 
	public String getName() {
		return name;
	}
	
	/**
	 * @param  name  The name of the level to set
	 */	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return value The numerical value of the level
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * 
	 * @param value	The numerical value of this level
	 */
	public void setValue(int value) {
		this.value = value;
	}
}
