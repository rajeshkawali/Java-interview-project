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
The Command pattern is a behavioral design pattern that allows you to encapsulate a request 
or an action as an object. This object can be used to parameterize other objects, 
such as a queue, and store requests or actions for later execution. 
The Command pattern promotes loose coupling between the requester of a particular 
action and the object that performs the action, making it easier to modify, extend, or replace 
individual actions without affecting the rest of the system.

In the Command pattern, there are four key components:-->
Command: Defines the interface for executing an operation.
Concrete Command: Implements the Command interface and specifies the receiver of the action.
Receiver: The object that performs the actual action.
Invoker: Asks the command to carry out the request.

When to use the Command pattern:-->
When you need to parameterize objects based on an action or a request, and store these objects for later execution.
When you want to decouple objects that produce requests from objects that execute requests.
When you want to support undo and redo functionality in your application.
When you want to implement a transactional system where a series of commands are 
executed in a single transaction, and the whole transaction can be rolled back if any command fails.
*/