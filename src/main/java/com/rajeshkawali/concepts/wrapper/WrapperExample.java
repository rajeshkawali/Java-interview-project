package com.rajeshkawali.concepts.wrapper;


/**
 * @author Rajesh_Kawali
 *
 */
public class WrapperExample {
	/*
	 wrapper classes are used to convert primitive data types (such as int, float,
	 double, etc.) to objects. The wrapper classes in Java are:
	 
	 Boolean, Byte, Short, Integer, Long, Float, Double, Character.
	 
	 Each of these wrapper classes corresponds to a primitive data type in Java.
	 For example, the Integer wrapper class corresponds to the int primitive data type. 
	 The primary benefit of using wrapper classes is that they allow
	 primitive data types to be used as objects, which is necessary for certain
	 situations, such as when an object is required but a primitive value is more appropriate.
	 
	 A common use of wrapper classes is in situations where an object is required, 
	 but a primitive value would be more appropriate. For example, the ArrayList 
	 class can only hold objects, so if you want to create an ArrayList of integers, 
	 you would use the Integer wrapper class instead of the int primitive data type.
	 */
	@SuppressWarnings({ "removal", "unused" })
	public static void main(String[] args) {

		int primitiveInt = 100;
		Integer intWrapper = new Integer(primitiveInt); // Create an Integer object from a primitive int
		int backToPrimitive = intWrapper.intValue(); // Convert the Integer object back to a primitive int

		double primitiveDouble = 3.14;
		Double doubleWrapper = new Double(primitiveDouble); // Create a Double object from a primitive double
		double backToPrimitiveDouble = doubleWrapper.doubleValue(); // Convert the Double object back to a primitive double

		boolean primitiveBool = true;
		Boolean boolWrapper = new Boolean(primitiveBool); // Create a Boolean object from a primitive boolean
		boolean backToPrimitiveBool = boolWrapper.booleanValue(); // Convert the Boolean object back to a primitive boolean

		char primitiveChar = 'a';
		Character charWrapper = new Character(primitiveChar); // Create a Character object from a primitive char
		char backToPrimitiveChar = charWrapper.charValue(); // Convert the Character object back to a primitive char

		System.out.println("Integer wrapper: " + intWrapper);
		System.out.println("Back to primitive int: " + backToPrimitive);

		System.out.println("Double wrapper: " + doubleWrapper);
		System.out.println("Back to primitive double: " + backToPrimitiveDouble);

		System.out.println("Boolean wrapper: " + boolWrapper);
		System.out.println("Back to primitive boolean: " + backToPrimitiveBool);

		System.out.println("Character wrapper: " + charWrapper);
		System.out.println("Back to primitive char: " + backToPrimitiveChar);
		System.out.println("--------------------------------------------------------------------");
		Boolean bool = new Boolean(true); // Create a Boolean object with the value true
		boolean primitive = bool.booleanValue(); // Convert the Boolean object back to a boolean primitive
		System.out.println("Primitive value: " + primitive);
		System.out.println("--------------------------------------------------------------------");
		Byte b = new Byte((byte) 100); // Create a Byte object with the value 100
		byte primitiveB = b.byteValue(); // Convert the Byte object back to a byte primitive
		System.out.println("Primitive value: " + primitiveB);
		System.out.println("--------------------------------------------------------------------");
		Short s = new Short((short) 5000); // Create a Short object with the value 5000
		short primitiveS = s.shortValue(); // Convert the Short object back to a short primitive
		System.out.println("Primitive value: " + primitiveS);
		System.out.println("--------------------------------------------------------------------");
		Integer i = new Integer(10000); // Create an Integer object with the value 10000
		int primitiveI = i.intValue(); // Convert the Integer object back to an int primitive
		System.out.println("Primitive value: " + primitiveI);
		System.out.println("--------------------------------------------------------------------");
		Long l = new Long(1000000L); // Create a Long object with the value 1000000
		long primitiveL = l.longValue(); // Convert the Long object back to a long primitive
		System.out.println("Primitive value: " + primitiveL);
		System.out.println("--------------------------------------------------------------------");
		Float f = new Float(3.14f); // Create a Float object with the value 3.14
		float primitiveF = f.floatValue(); // Convert the Float object back to a float primitive
		System.out.println("Primitive value: " + primitiveF);
		System.out.println("--------------------------------------------------------------------");
		Double d = new Double(3.14); // Create a Double object with the value 3.14
		double primitiveD = d.doubleValue(); // Convert the Double object back to a double primitive
		System.out.println("Primitive value: " + primitiveD);
		System.out.println("--------------------------------------------------------------------");
		Character c = new Character('a'); // Create a Character object with the value 'a'
		char primitiveC = c.charValue(); // Convert the Character object back to a char primitive
		System.out.println("Primitive value: " + primitiveC);
		System.out.println("--------------------------------------------------------------------");
		/*
		Autoboxing: Automatic conversion of primitive types to their corresponding wrapper class object.
		 */
		int x = 10;
		Integer y = x;   //Autoboxing, int to Integer 
		System.out.println("--------------------------------------------------------------------");
		/*
		Auto-unboxing: Automatic conversion of wrapper class object to their corresponding primitive types.
		 */
		Integer x1 = new Integer(10);
		int y1 = x1;   //Auto-unboxing, Integer to int
		System.out.println("--------------------------------------------------------------------");
	}
}
/*

"boxing": refers to the process of converting a primitive data type (such as int, float, double, etc.) to its corresponding wrapper class (such as Integer, Float, Double, etc.). 
"Unboxing": is the opposite process, converting a wrapper class object to its corresponding primitive data type. 

Java 5 introduced autoboxing and auto-unboxing feature to make it easier to use primitive and wrapper classes together.

Autoboxing: Automatic conversion of primitive types to their corresponding wrapper class object.
Auto-unboxing: Automatic conversion of wrapper class object to their corresponding primitive types.	
*/


/*
Some key points to remember about wrapper classes in Java:-->

Wrapper classes are used to convert primitive data types to objects.

There is a wrapper class for each primitive data type in Java: Boolean, Byte, Short, Integer, Long, Float, Double, and Character.

Wrapper classes provide many methods like max_value, min_value, parse_XXX, toXXXString which make the code more readable and user-friendly.

The primary benefit of using wrapper classes is that they allow primitive data types to be used as objects, which is necessary for certain situations, such as when an object is required but a primitive value is more appropriate.

Common use cases include using a wrapper class to store a primitive value in a collection, as a method argument when an object is required, or as a return type for a method that should return an object.

From Java 5, it has features called autoboxing and unboxing, which makes the process of converting between primitive and wrapper types more convenient and less verbose.

In addition to conversion functionality, some wrapper classes also have other useful methods such as parsing and formatting.

Wrapper classes are immutable and final so the value of the object once created can't be changed and the object can't be overridden.
*/