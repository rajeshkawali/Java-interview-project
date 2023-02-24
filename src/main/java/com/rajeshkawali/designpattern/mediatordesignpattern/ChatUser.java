package com.rajeshkawali.designpattern.mediatordesignpattern;

// Concrete colleague implementation
public class ChatUser implements User {
	private String name;
	private ChatMediator mediator;

	public ChatUser(String name, ChatMediator mediator) {
		this.name = name;
		this.mediator = mediator;
	}

	@Override
	public void sendMessage(String message) {
		System.out.println(name + " sending message: " + message);
		mediator.sendMessage(message, this);
	}

	@Override
	public void receiveMessage(String message) {
		System.out.println(name + " received message: " + message);
	}
}