package com.rajeshkawali.concepts.generics;

public class GenericsInheritance {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String str = "abc";
		Object obj = new Object();
		obj = str; // works because String is-a Object, inheritance in java

		GenericsType<String> strType = new GenericsType<String>();
		GenericsType<Object> objType = new GenericsType<Object>();
		//objType=strType; // compilation error since GenericsType<String> is not a GenericsType<Object>
		obj = strType; // GenericsType<T> parent is Object
	}
}
/*
We are not allowed to assign GenericsType<String> variable 
to GenericsType<Object> variable because they are not related, 
in fact GenericsType<T> parent is Object.
*/

/*
Generics and Inheritance

1. Normal inheritance works.
   String is-a Object.

   Object obj = new String();   // Valid

2. Generic inheritance does NOT work.
   GenericsType<String> is NOT a GenericsType<Object>.

   GenericsType<Object> obj = new GenericsType<String>(); // Invalid

3. Every generic class still extends Object.

   Object obj = new GenericsType<String>(); // Valid

Reason:
Java generics are invariant to maintain type safety.
*/

