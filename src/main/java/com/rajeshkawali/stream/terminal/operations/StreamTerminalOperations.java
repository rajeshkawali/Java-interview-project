package com.rajeshkawali.stream.terminal.operations;
// https://youtu.be/eA307vFsENA
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Rajesh_Kawali
 *
 */
public class StreamTerminalOperations {
	//Terminal operations of Stream API  --> toArray(),collect(),count(),reduce(),forEach(),forEachOrdered(),
	//min(),max(),anyMatch(),allMatch(),noneMatch(),findAny(),findFirst() 
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(6, 1, 2, 3, 5, 4, 2);
		
		//toArray() --> Convert List to Array
		Object[] array = list.stream().toArray();
		System.out.println(array[0]);// print first element of array
		System.out.println("--------------------------------------------------------------------1");
		//collect(Collector<? super T, A, R> collector) --> Collects all the elements in the list/set
		Set<Integer> set = list.stream().collect(Collectors.toSet());// Convert List to Set
		System.out.println(set);;// Print only unique values
		System.out.println("--------------------------------------------------------------------2");
		// count() --> count the no of elements present in the list
		System.out.println(list.stream().count());
		System.out.println("--------------------------------------------------------------------3");
		// reduce(T identity, BinaryOperator<T> accumulator) --> reduce used to reduce the elements to single unit
		System.out.println(list.stream().reduce(0,(x,y)->(x+y))); // Sum of digits
		System.out.println("--------------------------------------------------------------------4");
		//forEach(Consumer<? super T> action) --> print all elements in the list
		list.stream().forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------5");
		//forEachOrdered(Consumer<? super T> action) --> print all elements in the list with ordered
		list.stream().forEachOrdered(System.out::println);
		System.out.println("--------------------------------------------------------------------6");
		//min(Comparator<? super T> comparator) --> return minimum value in the list
		System.out.println(list.stream().min((x,y)->x-y).get());
		System.out.println("--------------------------------------------------------------------7");
		//max(Comparator<? super T> comparator) --> return max value in the list
		System.out.println(list.stream().max((x,y)->x-y).get());
		System.out.println("--------------------------------------------------------------------8");
		//anyMatch(Predicate<? super T> predicate) --> return true if any one element will match the condition
		System.out.println(list.stream().anyMatch(x->x==6));
		System.out.println("--------------------------------------------------------------------9");
		//allMatch(Predicate<? super T> predicate) --> return true if all the element will match the condition
		System.out.println(list.stream().allMatch(x->x/1==x));
		System.out.println("--------------------------------------------------------------------10");
		//noneMatch(Predicate<? super T> predicate) --> return true if none of the elements matches with the condition
		System.out.println(list.stream().noneMatch(x->x==7)); 
		System.out.println("--------------------------------------------------------------------11");
		//findAny() --> find any element in the list
		System.out.println(list.stream().findAny()); 
		System.out.println("--------------------------------------------------------------------12");
		//findFirst() --> Find first elementof the list
		System.out.println(list.stream().findFirst().get()); 
		System.out.println("--------------------------------------------------------------------13");
	}
}
/*
List of some terminal operations in the Stream interface:-->

forEach(Consumer<? super T> action): Performs an action for each element of this stream.

forEachOrdered(Consumer<? super T> action): Performs an action for each element of this stream, in the encounter order of the stream if the stream has a defined encounter order.

toArray(): Returns an array containing the elements of this stream.

toArray(IntFunction<A[]> generator): Returns an array containing the elements of this stream, using the provided generator function to allocate the returned array, as well as any additional arrays that might be required for a partitioned execution or for resizing.

collect(Collector<? super T, A, R> collector): Performs a reduction on the elements of this stream using a Collector.

min(Comparator<? super T> comparator): Returns the minimum element of this stream according to the provided Comparator.

max(Comparator<? super T> comparator): Returns the maximum element of this stream according to the provided Comparator.

count(): Returns the count of elements in this stream.

findFirst(): Returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty.

findAny(): Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.

allMatch(Predicate<? super T> predicate): Returns whether all elements of this stream match the provided predicate.

anyMatch(Predicate<? super T> predicate): Returns whether any elements of this stream match the provided predicate.

noneMatch(Predicate<? super T> predicate): Returns whether no elements of this stream match the provided predicate.
*/

/*
Short-circuiting operations are stream operations that, when encountered, 
may terminate the stream pipeline early, without processing the entire stream. 
These operations can be used to optimize stream pipelines by allowing them to 
stop processing as soon as they have found an element that meets a specified condition.

Some short-circuiting operations in the Stream interface:-->

findFirst(): Returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty.

findAny(): Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.

allMatch(Predicate<? super T> predicate): Returns whether all elements of this stream match the provided predicate.

anyMatch(Predicate<? super T> predicate): Returns whether any elements of this stream match the provided predicate.

noneMatch(Predicate<? super T> predicate): Returns whether no elements of this stream match the provided predicate.

limit(long maxSize): Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.

skip(long n): Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream.
*/


/*
Terminal operations of Stream API:-->

The Stream API in Java provides several terminal operations, 
which are operations that consume the stream and return a 
result or a side-effect. Terminal operations are the end of the Stream pipeline.

forEach: Performs an action for each element of the stream.
toArray: Returns an array containing the elements of the stream.
reduce: Combines all elements of the stream into a single value using a specified accumulator function.
collect: Collects the elements of the stream into a container, such as a List or Set.
min and max: Returns the minimum or maximum element of the stream according to the natural ordering or a provided comparator.
count: Returns the number of elements in the stream.
anyMatch, allMatch, noneMatch: These operations return a boolean value indicating if any, all, or none of the elements in the stream match a given predicate.
findFirst and findAny: Returns an Optional describing the first or any element of the stream that matches a given predicate.
------------------------------------------------------------------------------------------------------------
Intermediate operations of Stream API:-->

The Stream API in Java also provides several intermediate operations, 
which are operations that transform a stream into another stream. 
These operations are called intermediate because they do not consume 
the stream and they allow further operations to be performed on the resulting stream. 

filter: Returns a stream containing only the elements that match a given predicate.
map: Returns a stream consisting of the results of applying a given function to the elements of the stream.
flatMap: Returns a stream consisting of the elements of the stream obtained by replacing each element with the contents of a mapped stream produced by applying a given function.
distinct: Returns a stream consisting of the distinct elements of the stream.
sorted: Returns a stream consisting of the elements of the stream in sorted order.
peek: Returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are consumed from the resulting stream.
limit: Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
skip: Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream.
------------------------------------------------------------------------------------------------------------
Short circuiting operations of Stream API:-->

The Stream API in Java also provides several short-circuiting operations, 
which are intermediate operations that allow the evaluation of a stream to be 
stopped as soon as the desired result is found. These operations are called 
short-circuiting because they don't evaluate the entire stream, 
they stop when they find the first match. 

anyMatch: Returns a boolean value indicating if any elements of the stream match a given predicate.
allMatch: Returns a boolean value indicating if all elements of the stream match a given predicate.
noneMatch: Returns a boolean value indicating if no elements of the stream match a given predicate.
findFirst: Returns an Optional describing the first element of the stream.
findAny: Returns an Optional describing any element of the stream.
limit: Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
skip: Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream.

*/


/*
6
--------------------------------------------------------------------1
[1, 2, 3, 4, 5, 6]
--------------------------------------------------------------------2
7
--------------------------------------------------------------------3
23
--------------------------------------------------------------------4
6
1
2
3
5
4
2
--------------------------------------------------------------------5
6
1
2
3
5
4
2
--------------------------------------------------------------------6
1
--------------------------------------------------------------------7
6
--------------------------------------------------------------------8
true
--------------------------------------------------------------------9
true
--------------------------------------------------------------------10
true
--------------------------------------------------------------------11
Optional[6]
--------------------------------------------------------------------12
6
--------------------------------------------------------------------13

 */
