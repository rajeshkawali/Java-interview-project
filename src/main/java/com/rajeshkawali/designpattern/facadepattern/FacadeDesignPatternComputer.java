package com.rajeshkawali.designpattern.facadepattern;

// Complex subsystem
class CPU {
	public void freeze() {
		System.out.println("CPU frozen");
	}

	public void jump(long position) {
		System.out.println("CPU jumped to " + position);
	}

	public void execute() {
		System.out.println("CPU executing commands");
	}
}

class Memory {
	public void load(long position, byte[] data) {
		System.out.println("Loaded data at position " + position);
	}
}

class HardDrive {
	public byte[] read(long lba, int size) {
		System.out.println("Reading " + size + " bytes from LBA " + lba);
		return new byte[] {};
	}
}

// Facade class
class Computer {
	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;

	public Computer() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.hardDrive = new HardDrive();
	}

	public void startComputer() {
		cpu.freeze();
		memory.load(0, hardDrive.read(0, 1024));
		cpu.jump(0);
		cpu.execute();
	}
}

// Client code
public class FacadeDesignPatternComputer {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.startComputer();
	}
}
/*
In this example, we have a complex subsystem consisting of three classes: CPU, Memory, and HardDrive. 
Each of these classes has its own functionality. The CPU class has methods to freeze, jump, 
and execute instructions. The Memory class has a method to load data into memory. 
The HardDrive class has a method to read data from a hard drive.

The Computer class is the Facade class that encapsulates the complexity of the subsystem. 
It has references to each of the subsystem classes and defines a simple method startComputer() 
that initializes the CPU, loads data into memory, jumps to the start position, and executes instructions.

The client code creates an instance of the Computer class and invokes its startComputer() method. 
The client does not need to know anything about the individual subsystem classes or their methods; 
it only needs to know how to start the computer.

By using the Facade pattern, we have simplified the interface to a complex subsystem and made it easier to use.

          +-------------------------+                     
          |    Computer    			|                     
          +-------------------------+                     
          | - cpu: CPU     			|                     
          | - memory: Memory 		|                     
          | - hardDrive: HardDrive 	|                     
          +-------------------------+                     
          | +startComputer() 		|                     
          +-------------------------+                     
                   |                              
         +---------+---------------------------+                   
         |                    |                |   
+---------------+    +-------------------+  +------------------------+    
|     CPU       |    |     Memory    	 |  |   HardDrive            |    
+---------------+    +-------------------+  +------------------------+    
|+freeze()      |    |+load(long, byte[])|  |+read(long, int): byte[]|    
|+jump(long)    |    +-------------------+  |                 		 |    
|+execute()     |                         	|                 		 |    
+---------------+                         	+------------------------+

*/

/*
The Facade pattern is a structural design pattern that provides a simple and unified 
interface to a complex system or set of subsystems. It hides the complexities of the system 
by providing a simplified interface to the client.

The Facade pattern is useful when a complex system is composed of multiple subsystems, 
each with its own set of classes and interfaces. It is difficult and time-consuming for 
clients to understand and use the system directly, as they would need to deal with all 
the individual subsystems and their interfaces. The Facade pattern simplifies this by 
providing a single entry point to the system, abstracting away the details of the subsystems.

By using the Facade pattern, clients can interact with the system using a simple and consistent interface. 
They don't need to know about the complexities of the system or the details of the subsystems. 
This makes it easier for them to use the system and reduces the amount of code they need to write.

Some examples of when to use the Facade pattern are:-->

When a complex system is composed of multiple subsystems with their own set of interfaces, and you want to provide a simple and unified interface to the clients.
When you want to decouple the clients from the system's implementation details and reduce dependencies between them.
When you want to provide a layer of abstraction over the system to make it easier to maintain, modify, or extend in the future. 
*/
