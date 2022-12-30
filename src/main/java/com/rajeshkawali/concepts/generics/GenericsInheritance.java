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