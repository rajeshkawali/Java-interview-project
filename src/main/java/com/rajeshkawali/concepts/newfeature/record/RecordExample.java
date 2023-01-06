package com.rajeshkawali.concepts.newfeature.record;


/**
 * @author Rajesh_Kawali
 *
 */
record Point(int x, int y) {

	/*
	Record classes are a new feature introduced in Java Development Kit (JDK) 14. 
	They are a concise way of creating simple, immutable data classes that represent records, 
	such as a point on a coordinate system or an account in a bank. Record classes have a 
	public accessor method for each component and also have a toString(), hashCode(), and equals() 
	method that is generated automatically based on the components of the record.
	*/
	public int xMethod() {
		return x;
	}

	public int yMethod() {
		return y;
	}

	public int multiply() {
		return x * x;
	}

	public int addition() {
		return x + y;
	}
}

public class RecordExample {
	public static void main(String[] args) {
		Point p1 = new Point(5, 2);
		Point p2 = new Point(3, 4);
		Point p3 = new Point(5, 2);

		System.out.println(p1.xMethod()); // prints "5"
		System.out.println(p1.yMethod()); // prints "2"
		System.out.println(p1.addition()); // prints "7
		System.out.println(p1.multiply()); // prints "25"

		System.out.println(p1.equals(p2)); // prints "false"
		System.out.println(p1.equals(p3)); // prints "true"
		System.out.println(p1.toString()); // prints "Point[x=5, y=2]"
	}
}
/*
Some key points to consider when implementing a record class in Java:-->

1.A record class must have a name and a list of components, and it must be defined using the record keyword.

2.The components of a record class are public, final, and non-null by default, and they are defined as instance variables.

3.A record class has a public accessor method for each component, which is named after the component and has a return type that matches the type of the component.

4.A record class has a toString(), hashCode(), and equals() method that is generated automatically based on the components of the record.

5.A record class cannot have any instance methods or instance variables other than the components.

6.A record class cannot have a superclass or an explicit constructor, and it cannot be abstract or final.

7.A record class is implicitly final, and it cannot be subclassed or extended.

8.A record class can have interfaces, in which case the record class must implement all of the methods of the interfaces.
*/


/*
Some key differences between POJO and record classes in Java:-->

1.POJOs are mutable, while record classes are immutable.

2.POJOs have getter and setter methods for their data, while record classes have public accessor methods for their components.

3.POJOs do not have a toString(), hashCode(), or equals() method by default, while record classes have these methods generated automatically based on the components of the record.

4.POJOs can have instance variables, instance methods, and constructors, while record classes can only have components and cannot have a superclass or an explicit constructor.

5.POJOs can be abstract or final, while record classes are always final and cannot be subclassed or extended.
*/