package com.rajeshkawali.concepts.immutable;
import java.util.HashMap;
import java.util.Map;

/*
How to Create an immutable class in Java?

1.Declare the class as final so it can't be extended.
2.Make all fields private so that direct access is not allowed.
3.Don't provide setter methods for variables.
4.Make all mutable fields final so that its value can be assigned only once.
5.Initialize all the fields via a constructor performing deep copy.
6.Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
---------------------------------------------------------
1.The class must be declared as final (So that child classes can�t be created)
2.Data members in the class must be declared as private (So that direct access is not allowed)
3.Data members in the class must be declared as final (So that we can�t change the value of it after object creation)
4.A parameterized constructor should initialize all the fields performing a deep copy (So that data members can�t be modified with object reference)
5.Deep Copy of objects should be performed in the getter methods (To return a copy rather than returning the actual object reference)
6.No setters (To not have the option to change the value of the instance variable)

 */

/**
 * @author Rajesh_Kawali
 *
 */
 final class ImmutableClass2 {
	private final String name;
	private final int regNo;
	private final Map<String, String> metadata;

	public ImmutableClass2(String name, int regNo,
				Map<String, String> metadata)
	{
		this.name = name;
		this.regNo = regNo;
		Map<String, String> tempMap = new HashMap<>();
		for (Map.Entry<String, String> entry :
			metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.metadata = tempMap;
	}

	public String getName() { return name; }

	public int getRegNo() { return regNo; }

	public Map<String, String> getMetadata()
	{
		Map<String, String> tempMap = new HashMap<>();
		for (Map.Entry<String, String> entry : this.metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}
}

// Test class
 class Test {
	public static void main(String[] args)
	{
		Map<String, String> map = new HashMap<>();
		map.put("1", "first");
		map.put("2", "second");
		ImmutableClass2 s = new ImmutableClass2("ABC", 101, map);
		System.out.println(s.getName());
		System.out.println(s.getRegNo());
		System.out.println(s.getMetadata());

		// Uncommenting below line causes error
		// s.regNo = 102;

		map.put("3", "third");
		System.out.println(s.getMetadata()); // Remains unchanged due to deep copy in constructor

		s.getMetadata().put("4", "fourth");
		System.out.println(s.getMetadata()); // Remains unchanged due to deep copy in getter
	}
}
/*
Key points to remember while creating an immutable class in Java:-->

1.Declare the class as final: 
This ensures that the class cannot be subclassed, 
and its state cannot be changed.

2.Make all instance variables private and final: 
This ensures that the state of the class cannot be changed after it is created.

3.Provide only getter methods for accessing the instance variables: 
Since the instance variables are final, you cannot provide setter methods. 
Instead, you can provide getter methods that return the current state of the instance variables.

4.Don't provide any methods that can modify the state of the class: 
This includes methods that modify the state of any mutable objects referenced by the class.

5.Implement the clone() method to throw CloneNotSupportedException: 
This ensures that the object cannot be cloned, since it is immutable.

6.Use a constructor to initialize all the instance variables: 
The constructor should take all the necessary values as parameters and 
initialize the instance variables accordingly.

7.Make sure the class is thread-safe: 
Immutable classes are often used in concurrent applications, 
so it's important to make sure that the class is thread-safe. 
You can achieve this by using primitive types, final variables, and thread-safe collections.

8.Avoid exposing mutable objects: 
If the class holds a reference to a mutable object, 
make sure that the reference is not exposed to the outside world. 
Instead, return a copy of the object or a new instance that is not connected to the original.
*/