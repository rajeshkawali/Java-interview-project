package com.rajeshkawali.collection;
import java.util.Enumeration;
import java.util.Stack;

/**
 * @author Rajesh_Kawali
 *
 */
public class StackMain {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		/*
		Stack is a collection in Java that represents a last-in-first-out (LIFO) ordering of elements. 
		It is a specialized form of a Vector, and it has a similar API. 
		The main difference between a Stack and a Vector is that the Stack class provides a 
		small number of additional methods to push and pop elements from the stack.
		*/
		
		// 1.It allows multiple null elements.
		// 2.Duplicates elements are allowed.
		// 3.Insertion order are preserved.
		// 4.Stack has default initial capacity 10 and Stack will be re-sized when the 11th element is inserted into Stack,it will Double its size(means 20).
		// 5.It allows Heterogeneous Objects. 
		// 6.If we access index value which is not available in Stack then it return ArrayIndexOutOfBoundsException.
		// 7.It extends Vector class.
		// 8.Stack is Synchronized.
		// 9.class represents a last-in-first-out (LIFO) stack of objects.
		// 10.Stack class is thread safe. All methods of Stack class are synchronized so that only one thread can execute them at any given time.
		
		Stack stack = new Stack();
		System.out.println("Size of stack at creation: " + stack.size());
		System.out.println("Capacity Before adding Objects is: "+stack.capacity());
		
		stack.push("Rajesh");
		stack.push(null);
		stack.push(4477);
		stack.push("12345");
		stack.push("Rajesh");
		stack.push(null);
		stack.push("Test");
		stack.push(""); // It will accept as empty value.
		stack.push("Rajesh");
		
		System.out.println(stack);
		Object peekObj = stack.peek();
		System.out.println("Peek Objects is: "+peekObj);
		System.out.println("Pushed Objects is: "+stack.push("Krishna"));
		System.out.println("Peek Objects is: "+stack.peek()); // It return top element of Stack.
		System.out.println("Pushed Objects is: "+stack.push("Mumbai")); // Adding the element into Stack.
		System.out.println("Poped Objects is: "+stack.pop()); //remove the object from top of stack.
		System.out.println("Searched Objects is: "+stack.search("Test"));//It return offset of stack.
		System.out.println("Poped Objects is: "+stack.pop()); //remove the object from top of stack.
		System.out.println("To check Stack is empty or not : "+stack.empty()); // if Stack is not empty then it return false.
		System.out.println("Size of stack after Adding Objects :" + stack.size());
		//System.out.println("index of ArrayList at 22 --: " + stack.get(22)); // ArrayIndexOutOfBoundsException
		System.out.println("Capacity Before adding Objects is: "+stack.capacity());
		
		System.out.println("----------------------------------------------------");
        Enumeration en = stack.elements();
        while (en.hasMoreElements())
        {
            System.out.println(en.nextElement());
        }
	}
}
/*
Here is a list of some of the common methods of the Stack class in Java:-->

push(E e): Pushes an element onto the top of the stack.
pop(): Removes and returns the top element of the stack.
peek(): Returns the top element of the stack without removing it.
empty(): Returns true if the stack is empty, false otherwise.
search(Object o): Returns the 1-based position of the specified element in the stack, with the top element being considered as position 1.
capacity(): Returns the current capacity of the stack.
ensureCapacity(int minCapacity): Increases the capacity of the stack, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.
trimToSize(): Trims the capacity of the stack to be the stack's current size.
*/

/*
In Java, Stack is a class that implements the Stack interface and extends the Vector class. 
It represents a last-in-first-out (LIFO) stack of objects. It's similar to a Vector, 
but it implements a few additional methods that are specific to the stack data structure.

Stack provides the following methods:-->

push(E item): Pushes an item onto the top of this stack.
pop(): Removes the object at the top of this stack and returns that object as the value of this function.
peek(): Looks at the object at the top of this stack without removing it from the stack.
empty(): Tests if this stack is empty.
It's useful when you need a LIFO data structure, and you want to perform operations like push, pop and peek.

In summary, Stack is a class that implements the Stack interface and 
extends the Vector class. It represents a last-in-first-out (LIFO) 
stack of objects and it provides the methods push, pop, peek and empty. 
It's useful when you need a LIFO data structure, and you want to 
perform operations like push, pop and peek.
*/


/*
Stack is a class in Java that implements the Stack interface and extends the Vector class.
It represents a last-in-first-out (LIFO) stack of objects.
It provides the following methods: push(E item), pop(), peek(), and empty().
push(E item): Pushes an item onto the top of the stack.
pop(): Removes the object at the top of this stack and returns that object as the value of this function.
peek(): Looks at the object at the top of this stack without removing it from the stack.
empty(): Tests if this stack is empty.
It's useful when you need a LIFO data structure, and you want to perform operations like push, pop and peek.
Stack is not thread-safe, so if multiple threads are accessing the same Stack object and at least one of them modifies the stack, there is a risk of data corruption.
*/