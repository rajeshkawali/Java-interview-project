package com.rajeshkawali.designpattern.commandpattern;
/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class CommandDesignPatternMain {
	/*
	The Command design pattern is a behavioral design pattern that turns a request 
	into a stand-alone object that contains all information about the request. 
	This transformation lets you pass requests as a method arguments, 
	delay or queue a request’s execution, and support undo-redo.
	*/
	public static void main(String[] args) {
		Light light = new Light();
		Command switchOn = new SwitchOnCommand(light);
		Command switchOff = new SwitchOffCommand(light);

		RemoteControl remoteControl = new RemoteControl();

		remoteControl.setCommand(switchOn);
		remoteControl.pressButton(); // prints "The light is on"

		remoteControl.setCommand(switchOff);
		remoteControl.pressButton(); // prints "The light is off"
	}
}
/*
In this example, the Light class represents a light that can be switched on and off. 
The SwitchOnCommand and SwitchOffCommand classes implement the Command interface 
and hold a reference to the Light object. The execute() method of the SwitchOnCommand 
class calls the switchOn() method of the Light class, while the execute() method of the 
SwitchOffCommand class calls the switchOff() method of the Light class.

The RemoteControl class has a Command field, which can be set to either a 
SwitchOnCommand or a SwitchOffCommand object. The pressButton() method of the RemoteControl 
class then calls the execute() method of the current command, which in turn switches the light on or off.

In this example, the Remote Control is the client and the Command is the abstraction, 
the SwitchOnCommand and SwitchOffCommand are the implementation of the Command Interface, and the Light is the Receiver.
*/


/*
Here are the steps to implement the Command design pattern in Java:-->

Identify the command interface: Define an interface for the command with an execute() method that will be implemented by the concrete commands.
Create concrete command classes: Implement the command interface with concrete command classes that will perform specific operations.
Create the invoker class: The invoker class is responsible for executing the command by calling the execute() method on the command object.
Create the receiver class: The receiver class is the object that performs the operation specified by the command.
Create the client code: The client code creates the invoker and the receiver objects, creates a concrete command object and sets it on the invoker object.
*/


