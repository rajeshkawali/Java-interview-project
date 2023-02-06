package com.rajeshkawali.concepts.comparetor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rajesh_Kawali
 *
 */
class Employee1 implements Comparable<Employee1>{

	int id;
	String name;
	int marks;

	Employee1() {
	}
	
	public Employee1(int id, String name, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public int compareTo(Employee1 o) {
		Employee1 e = (Employee1)o;
		
		//return this.name.compareTo(e.name);
		//return this.marks - e.marks;
		return this.id - e.id;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
}


public class ComparableTest {

	public static void main(String[] args) {
		
		HashSet<Employee1> ts = new HashSet<Employee1>();
		ts.add(new Employee1(3, "rajesh1", 88));
		ts.add(new Employee1(5, "bajaj", 75));
		ts.add(new Employee1(1, "anil", 66));
		ts.add(new Employee1(4, "rajesh4", 42));
		ts.add(new Employee1(2, "pankaj", 11));
		
		List<Employee1> list = new ArrayList<Employee1>(ts); 
		Collections.sort(list);
		System.out.println(list);
		System.out.println("-----------------------------------------------------");
		Iterator<Employee1> it = ts.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            /*
            		Employee [id=1, name=anil, marks=66]
					Employee [id=2, name=pankaj, marks=11]
					Employee [id=3, name=rajesh1, marks=88]
					Employee [id=5, name=bajaj, marks=75]
					Employee [id=4, name=rajesh4, marks=42]
            */
        }
	}
}
/*
"Comparable" is an interface for defining the natural order of a class' objects
"Comparable" requires implementation of "compareTo" method
"Comparator" is an interface for defining multiple sorting orders for a class
"Comparator" requires implementation of "compare" method
"Comparable" is used by sorting algorithms and data structures for default sorting
"Comparator" provides alternative to "Comparable" for multiple sorting orders.
*/

/*
Difference between comparable and comparator in java :-->
In Java, "Comparable" is an interface that is implemented by a class to allow its 
objects to be compared to each other. The class must provide an implementation of 
the "compareTo" method that defines the order of the objects. This is used by various 
sorting algorithms and data structures, such as the "sort" method in the "Arrays" class.

On the other hand, "Comparator" is an interface used to define multiple sorting 
orders for a class. It provides an alternative to using the "compareTo" method provided 
by the "Comparable" interface. A class can implement the "Comparator" interface and 
provide a custom implementation of the "compare" method to define a sorting order. 
This allows multiple sorting orders to be defined for a single class, and the 
appropriate sorting order can be chosen at runtime.
*/