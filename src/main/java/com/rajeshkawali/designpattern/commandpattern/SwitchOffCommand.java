package com.rajeshkawali.designpattern.commandpattern;
/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class SwitchOffCommand implements Command {
	private Light light;

	public SwitchOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.switchOff();
	}
}
