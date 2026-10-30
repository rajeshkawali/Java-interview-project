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
Difference Between Comparable and Comparator in Java

1. Comparable:
- Comparable is an interface in java.lang package.
- Used to define the natural/default sorting order.
- It contains compareTo(T obj) method.
- The class itself implements Comparable.
- Sorting logic is written inside the model class.
- Generally defines one natural sorting order.
- Modifies the class to implement the interface.
- Used by Collections.sort() and Arrays.sort().

Example:
class Employee implements Comparable<Employee> {

    int id;

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }
}

2. Comparator:

- Comparator is an interface in java.util package.
- Used to define custom/multiple sorting orders.
- Its main abstract method is compare(T o1, T o2).
- Sorting logic can be written outside the model class.
- Does not require modifying the Employee class.
- Multiple Comparators can be created for one class.
- Can sort by ID, name, salary, age, etc.
- Supports lambda expressions and method references.
- Used by Collections.sort(list, comparator), List.sort(comparator), and Arrays.sort(array, comparator).

Example:
Comparator<Employee> byName = (e1, e2) -> e1.name.compareTo(e2.name);

3. Important Return Values:
compareTo() and compare() return:
Negative value -> First object comes before second.
Zero           -> Both objects are equal in sorting order.
Positive value -> First object comes after second.

Note: Zero means equal according to the comparator,
not necessarily equal according to equals().

4. Interview Key Differences:
Comparable -> Natural sorting, compareTo(), java.lang.
Comparator -> Custom sorting, compare(), java.util.
Comparable -> Sorting logic inside the class.
Comparator -> Sorting logic can be outside the class.
Comparable -> One natural ordering per class.
Comparator -> Multiple custom orderings.
*/
