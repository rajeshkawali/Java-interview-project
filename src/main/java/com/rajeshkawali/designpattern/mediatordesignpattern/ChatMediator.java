package com.rajeshkawali.designpattern.mediatordesignpattern;

// Mediator interface defining the communication protocol
public interface ChatMediator {
	public void sendMessage(String message, User user);

	public void addUser(User user);
}
/*

*/