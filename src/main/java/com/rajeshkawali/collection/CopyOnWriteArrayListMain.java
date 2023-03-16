package com.rajeshkawali.collection;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Rajesh_Kawali
 *
 */
public class CopyOnWriteArrayListMain {

	//1. CopyOnWriteArrayList is synchronized(means at a time only one thread can access the object).
	//2. CopyOnWriteArrayList uses fail-safe iterator.
	//3. CopyOnWriteArrayList can not throw ConcurrentModificationException.
	//4. CopyOnWriteArrayList class was added in java version 1.5
	//5. CopyOnWriteArrayList class is present in java.util.concurrent package.
	//6. CopyOnWriteArrayList allows null.
	//7. clone method return the shallow copy of the original object.
	//8. CopyOnWriteArrayList is a thread-safe.(Performance is Slow).
	//9. add, remove operator is not supported by CopyOnWriteArrayList iterator
	//10. 

	public static void main(String[] args) {

		List<Object> list = new CopyOnWriteArrayList<>();
		list.add("raj1");
		list.add('B');
		list.add('c');
		list.add(null);
		list.add(11.55f);
		list.add(11.55);
		list.add(null);
		list.add('B');
		list.add(24);
		list.add("raj1");
		System.out.println(list); // [raj1, B, c, null, 11.55, 11.55, null, B, 24, raj1]
		int i= 0;
		// add, remove operator is not supported by CopyOnWriteArrayList iterator
		Iterator<Object> failSafeIterator = list.iterator();
		while (failSafeIterator.hasNext()) {
			list.add("Add = "+ (i++)); // not adding in CopyOnWriteArrayList in Java.
			System.out.println("Read = "+ failSafeIterator.next());
			//failSafeIterator.remove(); //not supported in CopyOnWriteArrayList in Java.(UnsupportedOperationException)
			//System.out.println(list);
		}
		System.out.println("---------------------------------------------------------------------------------");
		// Modify the list
		System.out.println("add = "+list.add("D")); // add = true
		System.out.println("remove = "+list.remove("B")); //remove = false
		
		System.out.println(list); //[raj1, B, c, null, 11.55, 11.55, null, B, 24, raj1, Add = 0, Add = 1, Add = 2, Add = 3, Add = 4, Add = 5, Add = 6, Add = 7, Add = 8, Add = 9, D]
        // Iterate over the modified list
        for (Object element : list) {
            System.out.println(element);
        }
	}
}
/*
 CopyOnWriteArrayList is a thread-safe implementation of the List interface in
 Java. It is designed for use in multi-threaded environments where threads may
 concurrently read and write to the list.
 
 CopyOnWriteArrayList is implemented using a copy-on-write strategy, which
 means that the list is stored as an array, and that a new array is created
 and written to whenever the list is modified. This ensures that the list is
 never modified in place, which makes it thread-safe.
 */

/*
CopyOnWriteArrayList is a thread-safe variant of the ArrayList class in Java. 
It guarantees that all operations on the list are thread-safe and do not require any external synchronization. 
The class is designed to be used in situations where there are frequent reads and infrequent writes to the list.

The internal working of CopyOnWriteArrayList can be summarized in the following steps:-->

When a CopyOnWriteArrayList instance is created, it is initialized with an internal array that is empty.

Whenever an element is added, modified or removed from the list, a new copy of the internal array is created, 
and the operation is performed on the new array. This ensures that the original array remains unchanged, 
and any existing iterators continue to function as expected.

Once the operation is complete, the new array replaces the old one, and all subsequent operations are 
performed on the new array. This process is known as "copy-on-write."

Since each write operation creates a new copy of the array, there can be multiple versions of the 
array in memory at any given time. However, only one version is actively used by the list, 
and the old versions are eventually garbage collected.

Since the internal array is not modified after it is initially created, all read 
operations can be performed without synchronization.

If a read operation is performed while a write operation is in progress, 
the read operation will see the old version of the array. This is because the write operation 
creates a new copy of the array, and the read operation does not wait for the write operation to complete.

In summary, CopyOnWriteArrayList provides a thread-safe way to perform operations on a list by 
creating a new copy of the internal array for each write operation. This approach ensures 
that all read operations are performed without synchronization, but it can result in 
increased memory usage and slower write operations. 

*/



/*
 1.CopyOnWriteArrayList is a thread-safe implementation of the List interface in Java. 
 
 2.It is implemented using a copy-on-write strategy, which means that
 a new array is created and written to whenever the list is modified. This
 ensures that the list is never modified in place, which makes it thread-safe.
 
 3.CopyOnWriteArrayList is generally faster for read operations than other
 thread-safe list implementations, but may not provide the same level of
 performance as other list implementations in some scenarios.
  
 4.It is useful in situations where you need to perform frequent reads on a list and infrequent writes. 
 
 5.CopyOnWriteArrayList is not suitable for all situations,
 and you should consider your specific needs and performance requirements when
 choosing which list implementation to use.
 
 */
