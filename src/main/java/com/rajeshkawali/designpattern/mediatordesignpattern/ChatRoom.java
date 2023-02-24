package com.rajeshkawali.designpattern.mediatordesignpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
//Concrete mediator implementation
public class ChatRoom implements ChatMediator {
	private List<User> users;

	public ChatRoom() {
		this.users = new ArrayList<>();
	}

	@Override
	public void sendMessage(String message, User user) {
		for (User u : users) {
			if (u != user) {
				u.receiveMessage(message);
			}
		}
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
	}
}