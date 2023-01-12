package com.rajeshkawali.stream.terminal.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOperationExample {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Using toArray() to convert the stream to an array
		Integer[] array = numbers.stream().toArray(Integer[]::new);
		System.out.println("Array: " + Arrays.toString(array));

		// Using collect() to convert the stream to a list
		List<Integer> newNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Even Numbers: " + newNumbers);

		// Using count() to get the number of elements in the stream
		long count = numbers.stream().filter(n -> n % 2 == 0).count();
		System.out.println("Count of even numbers: " + count);

		// Using reduce() to get the sum of the elements in the stream
		int sum = numbers.stream().reduce(0, Integer::sum);
		System.out.println("Sum: " + sum);

		// Using forEach() to print each element in the stream
		numbers.stream().forEach(System.out::println);

		// Using forEachOrdered() to print each element in the stream in order
		numbers.stream().forEachOrdered(System.out::println);

		// Using min() and max() to get the minimum and maximum elements in the stream
		int min = numbers.stream().min(Integer::compareTo).get();
		int max = numbers.stream().max(Integer::compareTo).get();
		System.out.println("Min: " + min + ", Max: " + max);

		// Using anyMatch(), allMatch(), and noneMatch() to check if any, all, or none
		// of the elements in the stream match a certain condition
		boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);
		boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
		boolean noneEven = numbers.stream().noneMatch(n -> n % 2 == 0);
		System.out.println("Any even: " + anyEven + ", All even: " + allEven + ", None even: " + noneEven);

		// Using findAny() and findFirst() to get any or the first element in the stream
		// that matches a certain condition
		int anyOdd = numbers.stream().filter(n -> n % 2 != 0).findAny().get();
		int firstOdd = numbers.stream().filter(n -> n % 2 != 0).findFirst().get();
		System.out.println("Any odd: " + anyOdd + ", First odd: " + firstOdd);
	}
}
/*
terminal operations methods mentioned in your question:

toArray(): This method converts the elements in a stream to an array. It takes a IntFunction<A[]> generator as an argument, which is used to create an array of the desired type and size.

collect(): This method is used to collect the elements of a stream into a collection, such as a list or set. It takes a Collector as an argument, which is an implementation of the Collector interface that defines how the elements should be collected.

count(): This method returns the number of elements in a stream.

reduce(): This method is used to combine the elements of a stream into a single value, using a specified accumulator function. It takes an identity value and a BinaryOperator as arguments, and returns an Optional containing the result.

forEach(): This method performs an action for each element in a stream. It takes a Consumer as an argument, which is a function that performs the desired action.

forEachOrdered(): This method is similar to forEach(), but it guarantees that the elements will be processed in the order they appear in the stream.

min() and max(): These methods return the minimum and maximum elements in a stream, respectively, according to their natural order or an order specified by a Comparator.

anyMatch(), allMatch(), and noneMatch(): These methods return a boolean indicating whether any, all, or none of the elements in a stream match a certain condition specified by a Predicate.

findAny() and findFirst(): These methods return an Optional containing any or the first element in a stream that matches a certain condition specified by a Predicate.

Please note that some of these methods such as reduce(), min(), max(), findAny(), findFirst(), count() etc return Optional, so the returned value has to be unwrapped using the get() method or by using .orElse() method.
*/