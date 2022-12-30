package com.rajeshkawali.concepts.generics;

/**
 * @author Rajesh_Kawali
 *
 */
//Generics was added in Java 5 to provide compile-time type checking and removing risk of 
//ClassCastException that was common while working with collection classes. 
public class GenericsClassExample {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String args[]) {
		GenericsType<String> type1 = new GenericsType<>();
		type1.set("Rajesh"); // allowed
		//type1.set(10); //compile time error
		
		GenericsType type2 = new GenericsType(); // Raw type
		type2.set("Rajesh"); //String allowed
		type2.set(10); //Integer allowed
	}
}
/*
When we don’t provide the type to GenericsType class, the type becomes 
Object and hence it’s allowing both String and Integer objects. But, 
we should always try to avoid this because we will have to use type 
casting while working on raw type that can produce runtime errors.

Java Generic Type Naming convention:-->
E - Element (used extensively by the Java Collections Framework, for example ArrayList, Set etc.)
K - Key (Used in Map)
N - Number
T - Type
V - Value (Used in Map)
S,U,V etc. - 2nd, 3rd, 4th types

Reference : https://www.digitalocean.com/community/tutorials/java-generics-example-method-class-interface
*/