package com.rajeshkawali.concepts.generics;

import com.rajeshkawali.model.Employee;

/**
 * @author Rajesh_Kawali
 *
 */
//Interface which accept generic T type (Means this will accept any class).
// Comparable interface is a example of Generic in interfaces(Check source code of Comparable)
public interface GenericInterfaceExample<T> {
	public String get(T t);
}

//Passing GenericsTest class to interface T.
class GenericOneImpl implements GenericInterfaceExample<GenericsTest> {
	@Override
	public String get(GenericsTest t) {
		return t.getCompany();
	}
}

//Passing Employee class to interface T.
class GenericTwoImpl implements GenericInterfaceExample<Employee> {
	@Override
	public String get(Employee t) {
		return t.getFirstName();
	}
}

//Passing Employee class to interface T.
@SuppressWarnings("rawtypes")
class GenericTreeImpl implements GenericInterfaceExample {
	@Override
	public String get(Object obj) {
		return obj.toString();
	}
}