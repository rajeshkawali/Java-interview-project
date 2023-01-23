package com.rajeshkawali.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Rajesh_Kawali
 */
public class StreamExample {

	/*
	Stream interface is a part of the java.util.stream package 
	which is a sequence of elements supporting sequential and parallel 
	aggregate operations. The Stream interface provides a set of methods 
	for performing filter/map/reduce-like operations on data.
	*/
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(6, 1, 2, 3, 5, 4, 2);

		List<Integer> ResultList = list.stream().filter(x -> x%2==0).collect(Collectors.toList());
				
		System.out.println(ResultList);

	}
}
/*
Stream interface contains the following methods:-->

filter(Predicate<? super T> predicate): Returns a stream consisting of the elements of this stream that match the given predicate.

map(Function<? super T, ? extends R> mapper): Returns a stream consisting of the results of applying the given function to the elements of this stream.

flatMap(Function<? super T, ? extends Stream<? extends R>> mapper): Returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.

peek(Consumer<? super T> action): Returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are consumed from the resulting stream.

forEach(Consumer<? super T> action): Performs an action for each element of this stream.

collect(Collector<? super T, A, R> collector): Performs a reduction on the elements of this stream using a Collector.

toArray(): Returns an array containing the elements of this stream.

min(Comparator<? super T> comparator): Returns the minimum element of this stream according to the provided Comparator.

max(Comparator<? super T> comparator): Returns the maximum element of this stream according to the provided Comparator.

count(): Returns the count of elements in this stream.

findFirst(): Returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty.

findAny(): Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.

allMatch(Predicate<? super T> predicate): Returns whether all elements of this stream match the provided predicate.

anyMatch(Predicate<? super T> predicate): Returns whether any elements of this stream match the provided predicate.

noneMatch(Predicate<? super T> predicate): Returns whether no elements of this stream match the provided predicate.

sorted(): Returns a stream consisting of the elements of this stream, sorted according to natural order.

sorted(Comparator<? super T> comparator): Returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.

distinct(): Returns a stream consisting of the distinct elements of this stream.

limit(long maxSize): Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.

skip(long n): Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream.

reduce(T identity, BinaryOperator<T> accumulator): Performs a reduction on the elements of this stream, using the provided identity value and an associative accumulation function, and returns the reduced value.

reduce(BinaryOperator<T> accumulator): Performs a reduction on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced value, if any.

iterator(): Returns an iterator for the elements of this stream.

spliterator(): Creates a Spliterator over the elements of this stream.

isParallel(): Returns whether this stream is parallel.

sequential(): Returns a sequential stream consisting of the same elements as this stream.

parallel(): Returns a parallel stream consisting of the same elements as this stream.

unordered(): Returns an unordered stream consisting of the same elements as this stream.

onClose(Runnable closeHandler): Registers a close handler to be executed when the stream is closed (either by the terminal stream operation or by calling the close() method explicitly).

close(): Closes this stream, causing all close handlers for this stream pipeline to be called.


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