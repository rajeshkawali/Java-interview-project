package com.rajeshkawali.concepts.general;
public class StringClass {

	public static void main(String[] args) {

		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		StringBuilder s4 = new StringBuilder("java");
		StringBuffer s5 = new StringBuffer("java");
		
		System.out.println("------------------------------------------1");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println("------------------------------------------2");
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		System.out.println("------------------------------------------3");
		//System.out.println(s3==s4); //Incompatible operand types String and StringBuilder
		System.out.println(s1.equals(s4));
		System.out.println(s3.equals(s4));
		System.out.println("------------------------------------------4");
		//System.out.println(s4==s5); //Incompatible operand types StringBuilder and StringBuffer
		System.out.println(s1.equals(s4));
		System.out.println(s3.equals(s4));
		System.out.println(s4.equals(s5));
		System.out.println(s1.equals(s5));
		System.out.println(s3.equals(s5));
		System.out.println("------------------------------------------5");
		String s6 = "javajava";
		String s7 = s1+s2;
		String s8 = s1+"java";
		System.out.println(s6==s7);
		System.out.println(s6.equals(s7));
		System.out.println(s6==s8);
		System.out.println(s6.equals(s8));
		System.out.println("------------------------------------------6");
		s1.concat("java");
		s4.append("java");
		s5.append("java");
		System.out.println(s1);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println("------------------------------------------7");
		
		
		System.out.println("------------------------------------------");
		
		
		System.out.println("------------------------------------------");
	}

}


/*
String Constant Pool (SCP)
--------------------------
1. SCP is a special memory area inside the Heap.
2. String literals are stored in the String Constant Pool.
3. If the same literal already exists, Java reuses the existing object.
4. This saves memory and improves performance.

Example:
String s1 = "java";
String s2 = "java";

s1 == s2          // true (same object)
s1.equals(s2)     // true

------------------------------------------------------------

Non-Constant Pool
-----------------
1. Objects created using 'new' are stored outside the String Constant Pool.
2. Every 'new String()' creates a new object, even if the content is the same.

Example:
String s1 = "java";
String s2 = new String("java");

s1 == s2          // false (different objects)
s1.equals(s2)     // true (same content)

------------------------------------------------------------

== vs equals()
---------------
==        -> Compares object references (memory addresses).
equals() -> Compares object contents.

------------------------------------------------------------

StringBuilder and StringBuffer
------------------------------
1. They do not use the String Constant Pool.
2. equals() is not overridden, so it behaves like Object.equals().
3. It compares object references, not contents.

Example:
StringBuilder sb1 = new StringBuilder("java");
StringBuilder sb2 = new StringBuilder("java");

sb1 == sb2         // false
sb1.equals(sb2)    // false

------------------------------------------------------------

String Immutability
-------------------
String objects are immutable (cannot be changed).

String s = "java";
s.concat("8");

System.out.println(s);   // java

To change it:
s = s.concat("8");

------------------------------------------------------------

StringBuilder/StringBuffer Mutability
-------------------------------------
They are mutable (contents can be changed).

StringBuilder sb = new StringBuilder("java");
sb.append("8");

Output:
java8

------------------------------------------------------------

Important Interview Points
--------------------------
1. String literals -> String Constant Pool.
2. new String() -> New object outside the pool.
3. == compares references.
4. equals() compares contents (only for String).
5. StringBuilder/StringBuffer compare references because they don't override equals().
6. String is immutable; StringBuilder and StringBuffer are mutable.
*/


/*
intern() Method

1. Used to get the String Constant Pool (SCP) reference.
2. If the string is already in the SCP, it returns the existing pooled object.
3. If not, it adds the string to the SCP and returns the pooled reference.
4. The original heap object is NOT moved to the SCP; it remains in the heap.

Example:
String s1 = new String("java"); // Heap
String s2 = s1.intern();        // SCP

s1 == s2      // false
s1.equals(s2) // true
*/