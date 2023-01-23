package com.rajeshkawali.designpattern.commandpattern;
/**
 * 
 * @author Rajesh_Kawali
 *
 */
class Light {

	private boolean isOn = false;

	public void switchOn() {
		isOn = true;
		System.out.println("The light is on");
	}

	public void switchOff() {
		isOn = false;
		System.out.println("The light is off");
	}
}
