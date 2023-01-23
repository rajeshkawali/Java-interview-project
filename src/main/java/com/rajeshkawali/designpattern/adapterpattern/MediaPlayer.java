package com.rajeshkawali.designpattern.adapterpattern;
/**
 * 
 * @author Rajesh_Kawali
 *
 */
interface MediaPlayer {
	void play(String audioType, String fileName);
}
/*
Here are some key points to remember about the Adapter design pattern:-->

The Adapter design pattern is a structural pattern that allows you to adapt an interface of an existing class to a different interface.
The Adapter pattern is useful when you want to reuse an existing class in a new context and the existing class does not conform to the interface expected by the new context.
The Adapter pattern involves two key components: the Target interface and the Adapter class.
The Target interface defines the interface expected by the new context.
The Adapter class holds a reference to the existing class and conforms to the Target interface by implementing its methods and forwarding the request to the existing class.
The Adapter class acts as a bridge between the Target interface and the existing class, allowing them to work together.
The Adapter pattern promotes the separation of concerns between the client and the existing class by encapsulating the request into a separate object.
The Adapter pattern allows for flexibility in the way requests are handled, as different Adapter classes can be used to handle the same request in different ways.
The Adapter pattern is often used to make legacy code work with new code, and to allow different systems to communicate with each other.
*/