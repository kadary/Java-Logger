package project.architecture.javaLogger.test;

import project.architecture.javaLogger.modules.output.formater.AbstractFormater;

public class TestFormater extends AbstractFormater {
	
	public TestFormater() {
		this.isDateEnabled = true;
		this.isFQCNEnabled = true;
		this.isLevelEnabled = true;
		this.isMessageEnabled = true;
		
		this.separator = "###";
	}

}
