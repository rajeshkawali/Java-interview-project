package com.rajeshkawali.concepts.generics;

/**
 * @author Rajesh_Kawali
 *
 */
//Generics provide strong compile-time type checking and 
//reduces risk of ClassCastException and explicit casting of objects.
public class GenericsType<T> {

	private T t;

	public T get() {
		return this.t;
	}

	public void set(T t1) {
		this.t = t1;
	}
}
/*

This defines a generic class called GenericsType that takes a type parameter T. 
The class has a single private field called t of type T.

The class has two methods: get() and set(). The get() method returns the current value of t, 
and the set() method sets the value of t to a new value passed as an argument.

By making the class generic with type parameter T, you can use the same implementation 
of GenericsType for different types of data. For example, if you create an instance of 
GenericsType with type parameter String, you can set and get String values. 
If you create an instance of GenericsType with type parameter Integer, 
you can set and get Integer values.
*/