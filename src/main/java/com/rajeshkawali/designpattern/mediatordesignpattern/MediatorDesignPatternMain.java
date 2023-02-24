package com.rajeshkawali.designpattern.mediatordesignpattern;

public class MediatorDesignPatternMain {

	/*
	The Mediator Pattern is a behavioral design pattern that promotes loose coupling 
	between objects by encapsulating the way objects interact and communicate with each other. 
	In this pattern, a mediator object acts as an intermediary between a set of objects, 
	allowing them to communicate with each other without being aware of each other's existence.
	*/
	public static void main(String[] args) {
		
		ChatMediator chatRoom = new ChatRoom();

		User user1 = new ChatUser("Laksh", chatRoom);
		User user2 = new ChatUser("Keshav", chatRoom);

		chatRoom.addUser(user1);
		chatRoom.addUser(user2);

		user1.sendMessage("Hello, Laksh!");
		user2.sendMessage("Hi, Keshav!");
	}
}
/*
In this example, the ChatMediator interface defines the communication protocol, 
which includes methods for sending messages and adding users. The ChatRoom class 
is a concrete implementation of the mediator interface, which maintains a list of 
users and broadcasts messages to all users except the sender.

The User interface is the colleague interface, which defines methods for sending 
and receiving messages. The ChatUser class is a concrete implementation of the 
user interface, which maintains a reference to the mediator and uses it to send messages to other users.

The example usage code demonstrates how to use the mediator pattern to allow 
two users to communicate with each other through a chat room. The ChatMediator 
and ChatUser objects are created, and the users are added to the chat room using 
the addUser method. The users then send messages to each other using the 
sendMessage method, which is handled by the mediator to broadcast the message to all other users.
*/

/*
Here are the steps to implement the Mediator design pattern in Java:-->

Identify the objects that need to communicate with each other but have dependencies.
Create an interface that defines the communication protocol between these objects. This interface should define the methods that objects can use to communicate with each other.
Create a concrete mediator class that implements the communication interface. This class should encapsulate the communication logic and have references to all the objects that need to communicate with each other.
Modify the objects that need to communicate with each other to have a reference to the mediator object. This can be done either through constructor injection or setter injection.
Modify the implementation of these objects to use the mediator object to communicate with other objects instead of directly referencing them.
*/