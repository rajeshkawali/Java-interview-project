package com.rajeshkawali.designpattern.mediatordesignpattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Colleague interface
public interface User {
	public void sendMessage(String message);

	public void receiveMessage(String message);
}