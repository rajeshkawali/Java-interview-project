package com.rajeshkawali.stream.intermediate.operations;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Rajesh_Kawali
 *
 */
/**
 * Demonstrates Intermediate operations of Java Stream API.
 * Intermediate operations transform a stream into another stream.
 *
 * Operations included:
 * filter(), map(), flatMap(), distinct(), sorted(), peek(), limit(), skip()
 */
public class StreamIntermediateOperations {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(6, 1, 2, 3, 5, 4, 2);
        System.out.println("--------------------------------------------------");
        // 1. filter() - Select even numbers
        // Keeps only elements that match the given condition (predicate)
        System.out.println("1. filter() - Even numbers: " +
                list.stream()
                    .filter(x -> x % 2 == 0)
                    .collect(Collectors.toList()));
        System.out.println("--------------------------------------------------");
        // 2. map() - Transform elements
        // Here: Filter values <= 3, then add 2 to each
        System.out.println("2. map() - Elements <= 3, then add 2:");
        list.stream()
            .filter(x -> x <= 3)
            .map(x -> x + 2)
            .forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        // 3. flatMap() - Flatten nested structures (strings to characters)
        List<String> listOfStrings = Arrays.asList("fff", "bbb", "ccc", "aaa", "eee", "dddd");
        // a. Extract 2nd character from each string and sort
        System.out.println("3.a flatMap() - 2nd characters sorted:");
        System.out.println(
            listOfStrings.stream()
                .flatMap(str -> Stream.of(str.charAt(1)))
                .sorted()
                .collect(Collectors.toList())
        );
        // b. Extract 3rd character and filter only 'e'
        System.out.println("3.b flatMap() - Filter only 'e' as 3rd char:");
        listOfStrings.stream()
            .map(str -> str.length() > 2 ? str.charAt(2) : null)
            .filter(Objects::nonNull)
            .filter(ch -> ch.equals('e'))
            .forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        // 4. distinct() - Remove duplicate elements
        System.out.println("4. distinct() - Unique sorted values: " +
                list.stream()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList()));
        System.out.println("--------------------------------------------------");
        // 5. sorted() - Sort strings naturally (lexicographically)
        System.out.println("5. sorted() - Sorted strings: " +
                listOfStrings.stream()
                    .sorted()
                    .collect(Collectors.toList()));
        System.out.println("--------------------------------------------------");
        // 6. peek() - Debug/inspect elements in the stream
        System.out.println("6. peek() - Print each element (stream content):");
        list.stream()
            .peek(System.out::println)
            .collect(Collectors.toList());
        System.out.println("--------------------------------------------------");
        // 7. limit() - Get only the first 2 elements
        System.out.println("7. limit() - First 2 elements: " +
                list.stream()
                    .limit(2)
                    .collect(Collectors.toList()));
        System.out.println("--------------------------------------------------");
        // 8. skip() - Skip the first element
        System.out.println("8. skip() - Skip first element: " +
                list.stream()
                    .skip(1)
                    .collect(Collectors.toList()));
        System.out.println("--------------------------------------------------");
    }
}
/*
List of intermediate operations in the Stream interface:-->

filter(Predicate<? super T> predicate): Returns a stream consisting of the elements of this stream that match the given predicate.

map(Function<? super T, ? extends R> mapper): Returns a stream consisting of the results of applying the given function to the elements of this stream.

flatMap(Function<? super T, ? extends Stream<? extends R>> mapper): Returns a stream consisting of the results of replacing each element of this stream with the contents of a mapping stream produced by applying the provided mapping function to each element.

peek(Consumer<? super T> action): Returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are consumed from the resulting stream.

sorted(): Returns a stream consisting of the elements of this stream, sorted according to natural order.

sorted(Comparator<? super T> comparator): Returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.

distinct(): Returns a stream consisting of the distinct elements of this stream.

limit(long maxSize): Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.

skip(long n): Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream.

parallel(): Returns a parallel stream consisting of the same elements as this stream.

sequential(): Returns a sequential stream consisting of the same elements as this stream.

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

/*
--------------------------------------------------
1. filter() - Even numbers: [6, 2, 4, 2]
--------------------------------------------------
2. map() - Elements <= 3, then add 2:
3
4
5
4
--------------------------------------------------
3.a flatMap() - 2nd characters sorted:
[a, b, c, d, e, f]
3.b flatMap() - Filter only 'e' as 3rd char:
e
--------------------------------------------------
4. distinct() - Unique sorted values: [1, 2, 3, 4, 5, 6]
--------------------------------------------------
5. sorted() - Sorted strings: [aaa, bbb, ccc, dddd, eee, fff]
--------------------------------------------------
6. peek() - Print each element (stream content):
6
1
2
3
5
4
2
--------------------------------------------------
7. limit() - First 2 elements: [6, 1]
--------------------------------------------------
8. skip() - Skip first element: [1, 2, 3, 5, 4, 2]
--------------------------------------------------


 */
