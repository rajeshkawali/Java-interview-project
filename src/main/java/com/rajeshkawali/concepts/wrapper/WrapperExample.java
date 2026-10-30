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

=>"boxing": refers to the process of converting a primitive data type (such as int, float, double, etc.) 
to its corresponding wrapper class (such as Integer, Float, Double, etc.).
 
=>"Unboxing": is the opposite process, converting a wrapper class object 
to its corresponding primitive data type. 

Java 5 introduced autoboxing and auto-unboxing feature to make it easier to use primitive and wrapper classes together.

=>Autoboxing: Automatic conversion of primitive types to their corresponding wrapper class object.
=>Auto-unboxing: Automatic conversion of wrapper class object to their corresponding primitive types.	
*/




/*
 * ==========================================================
 * WRAPPER CLASSES IN JAVA
 * ==========================================================
 *
 * Wrapper classes convert primitive values into objects.
 *
 * Java has 8 primitive types and their wrapper classes:
 *
 * Primitive       Wrapper Class
 * ---------       -------------
 * byte            Byte
 * short           Short
 * int             Integer
 * long            Long
 * float           Float
 * double          Double
 * char            Character
 * boolean         Boolean
 *
 * IMPORTANT POINTS:
 *
 * 1. Wrapper classes allow primitive values to be used
 *    where objects are required, such as collections
 *    and generic types.
 *
 * 2. Wrapper classes are final and immutable.
 *    Their values cannot be changed after creation,
 *    and these classes cannot be extended.
 *
 * 3. Wrapper classes provide useful methods/constants:
 *
 *    Integer.parseInt("100")     -> primitive int
 *    Integer.valueOf("100")      -> Integer object
 *    Integer.toString(100)       -> String
 *    Integer.MAX_VALUE          -> Maximum int value
 *    Integer.MIN_VALUE          -> Minimum int value
 *    Double.parseDouble("10.5") -> primitive double
 *
 * 4. AUTOBOXING (Java 5+):
 *    Automatic conversion from primitive to wrapper.
 *
 *    int a = 10;
 *    Integer b = a;
 *
 * 5. UNBOXING (Java 5+):
 *    Automatic conversion from wrapper to primitive.
 *
 *    Integer a = 10;
 *    int b = a;
 *
 * 6. Wrapper classes can store null, unlike primitives.
 *
 *    Integer a = null;  // Valid
 *    int b = null;      // Compilation error
 *
 * 7. Unboxing a null wrapper throws
 *    NullPointerException.
 *
 *    Integer a = null;
 *    int b = a;         // NullPointerException
 *
 * 8. == VS equals():
 *
 *    == compares object references for two wrappers.
 *    equals() compares their values and wrapper types.
 *
 *    Integer a = 200;
 *    Integer b = 200;
 *
 *    a == b       -> Usually false
 *    a.equals(b)  -> true
 *
 * 9. INTEGER CACHE:
 *    Integer.valueOf() caches values from -128 to 127
 *    at minimum, so reference equality may be true
 *    for cached values.
 *
 *    Integer a = 100;
 *    Integer b = 100;
 *    a == b       -> true
 *
 *    Avoid == for comparing wrapper values.
 *
 * 10. PERFORMANCE:
 *     Primitives generally use less memory and avoid
 *     boxing/unboxing overhead.
 *
 *     Prefer primitives when null and object behavior
 *     are not required.
 *
 * 11. COMMON USE CASES:
 *     - Collections: List<Integer>, Set<Double>
 *     - Generics: Optional<Integer>
 *     - Nullable values: Integer age = null
 *     - Parsing strings into numeric values
 *     - APIs requiring objects instead of primitives
 *
 * ==========================================================
 * INTERVIEW SUMMARY
 * ==========================================================
 *
 * Primitive -> Wrapper  = Autoboxing
 * Wrapper   -> Primitive = Unboxing
 *
 * parseInt() -> Returns primitive int
 * valueOf()  -> Returns wrapper Integer
 *
 * Wrapper classes are immutable and final.
 *
 * Use equals() for wrapper value comparison.
 *
 * Unboxing null throws NullPointerException.
 *
 * ==========================================================
 */
