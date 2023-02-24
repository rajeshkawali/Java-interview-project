package com.rajeshkawali.designpattern.mediatordesignpattern;

// Colleague interface
public interface User {
	public void sendMessage(String message);

	public void receiveMessage(String message);
}