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