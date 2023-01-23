package com.rajeshkawali.designpattern.commandpattern;
/**
 * 
 * @author Rajesh_Kawali
 *
 */
interface Command {
	void execute();
}
/*
Here are some key points to remember about the Command design pattern:-->

The Command design pattern is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request.
The Command pattern is useful when you want to pass requests as method arguments, delay or queue a request's execution, and support undo-redo.
The Command pattern involves four key components: the Command interface, ConcreteCommands, the Client, and the Receiver.
The Command interface defines a single method, execute(), which is called to perform the request.
ConcreteCommands are classes that implement the Command interface and hold a reference to the Receiver, which is the object that the request is being sent to.
The Client is the object that creates and sets the ConcreteCommands and calls the execute() method on them.
The Receiver is the object that receives the request and performs the corresponding action.
The Command pattern promotes the separation of concerns between the Client and the Receiver by encapsulating the request into a separate object.
The Command pattern allows for flexibility in the way requests are handled, as different ConcreteCommands can be used to handle the same request in different ways.
The Command pattern also enables the implementation of undo-redo functionality by storing the history of requests in a stack, and reversing the execution of commands when the undo operation is performed.
*/