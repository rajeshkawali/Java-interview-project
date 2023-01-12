package com.rajeshkawali.stream.intermediate.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationExample {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Using filter() to create a new stream with only even numbers
		Stream<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0);
		evenNumbers.forEach(System.out::println);

		// Using map() to create a new stream with the square of each number
		Stream<Integer> squaredNumbers = numbers.stream().map(n -> n * n);
		squaredNumbers.forEach(System.out::println);

		// Using distinct() to create a new stream with only distinct numbers
		Stream<Integer> distinctNumbers = numbers.stream().distinct();
		distinctNumbers.forEach(System.out::println);

		// Using sorted() to create a new stream with the numbers sorted in ascending
		// order
		Stream<Integer> sortedNumbers = numbers.stream().sorted();
		sortedNumbers.forEach(System.out::println);

		// Using peek() to perform an action for each element in the stream without
		// changing the stream
		Stream<Integer> peekedNumbers = numbers.stream().peek(System.out::println);
		peekedNumbers.forEach(System.out::println);

		// Using limit() to create a new stream with only the first n elements
		Stream<Integer> limitedNumbers = numbers.stream().limit(5);
		limitedNumbers.forEach(System.out::println);

		// Using skip() to create a new stream without the first n elements
		Stream<Integer> skippedNumbers = numbers.stream().skip(5);
		skippedNumbers.forEach(System.out::println);

		// Using flatMap() to create a new stream from the elements of a stream of
		// streams
		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9));
		Stream<Integer> flatMappedNumbers = listOfLists.stream().flatMap(list -> list.stream());
		flatMappedNumbers.forEach(System.out::println);
	}
}
/*
filter(): This method is used to create a new stream with only the elements that match a certain condition specified by a Predicate`.

map(): This method is used to create a new stream with the result of applying a function to each element in the stream. It takes a Function as an argument, which is a function that maps the elements in the stream to new elements.

distinct(): This method is used to create a new stream with only the distinct elements in the stream, based on their natural order or an order specified by a Comparator.

sorted(): This method is used to create a new stream with the elements sorted in their natural order or an order specified by a Comparator.

peek(): This method is used to perform an action for each element in the stream without changing the stream. It takes a Consumer as an argument, which is a function that performs the desired action.

limit(): This method is used to create a new stream with only the first n elements of the stream.

skip(): This method is used to create a new stream without the first n elements of the stream.

flatMap(): This method is used to create a new stream from the elements of a stream of streams. It takes a Function as an argument, which is a function that maps the elements in the stream to new streams.
*/