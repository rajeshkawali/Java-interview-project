package com.rajeshkawali.designpattern.strategypattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class StrategyMain {

	/*
	In this example, the Strategy interface defines the algorithm that is used for performing an operation. 
	OperationAdd, OperationSubtract, and OperationMultiply are concrete implementations of the strategy. 
	The Context class uses a strategy object to perform the operation.
	
	The Strategy pattern allows for a decoupling of the logic that performs an operation from the object 
	that uses that logic, so that the same object can perform different operations, 
	depending on the strategy that it is using.
	*/
	public static void main(String[] args) {
		StrategyContext context = new StrategyContext(new OperationAdd());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		context = new StrategyContext(new OperationSubtract());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		context = new StrategyContext(new OperationMultiply());
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}
}
/*
The Strategy pattern is a behavioral design pattern that defines a family of algorithms, 
encapsulates each one as an object, and makes them interchangeable. 
This allows for an object's behavior to be changed at runtime by switching out the strategy object.

The pattern consists of three main components:-->

1.The Context class, which is the object that uses the strategy.
2.The Strategy interface, which defines the algorithm that is used for performing a specific task.
3.The concrete Strategy implementations, which are the objects that implement the algorithm.


The Context class has a reference to the Strategy interface. The concrete strategy objects are 
created and passed to the context object. The context object then uses the strategy object to perform the task.

One of the main benefits of the strategy pattern is that it allows for the separation of the 
logic that performs a task from the object that uses that logic. This allows for the same context 
object to perform different tasks, depending on the strategy it is using.

Another benefit of the pattern is that it allows for the easy addition of new strategies and the 
ability to change strategies at runtime. This makes the system more flexible and adaptable to changing requirements.

The pattern is commonly used in situations where a class has multiple behaviors, but they are 
implemented as separate classes and the client should be able to switch between them at runtime. 
It is also used when the algorithm that is used to perform a task needs to be chosen at runtime 
based on the input data or other dynamic factors.
*/