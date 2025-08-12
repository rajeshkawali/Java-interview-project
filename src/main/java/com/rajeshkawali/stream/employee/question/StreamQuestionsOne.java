package com.rajeshkawali.stream.employee.question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.rajeshkawali.model.Employee;
import com.rajeshkawali.util.EmployeeDB;


/**
 * @author Rajesh_Kawali
 *
 */
public class StreamQuestionsOne {

public static void main(String[] args) {
		
		List<Employee> empList = EmployeeDB.getAllEmployee();
		List<String> names = List.of("Laksh", "Keshav", "Mahesh", "Kiran", "Rajesh", "Sonu");
		List<Integer> numbers = Arrays.asList(10, 20, 30, 55, 11, 20, 33, 4, 44, 55, 20);
		String str = "Java is programming language and Java java";
		String oneWord = "abrajeshab";
		String twoWord = "rajesh ab";
		int arrays[] = {2,80,1,14,10,30,58,31,96,36,7,50,90,53,33};
		int arr[] = {2,1,4,3,6,7,5,3,2};

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given a sentence find the word that has the highest length");
		String highestLenStr = Arrays.stream(str.split(" ")).max(Comparator.comparing(String::length)).get();
		System.out.println(highestLenStr);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Remove duplicates from the string and return in the same order");
		oneWord.chars().distinct().mapToObj(x->(char)x).forEach(System.out::print);
		System.out.println();
		Arrays.stream(oneWord.split("")).distinct().forEach(System.out::print);
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given a sentence find the 2nd highest length word");
		String secondWord = Arrays.stream(str.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).limit(1).findFirst().get();
		System.out.println(secondWord);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given a sentence find the 2nd highest length word, print number");
		int secondLen = Arrays.stream(str.split(" ")).map(String::length).sorted(Comparator.reverseOrder()).skip(1).limit(1).findFirst().get();
		System.out.println(secondLen);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given a sentence find the occurence of each word");
		Map<String, Long> occurenceOfWords = Arrays.stream(str.split(" ")).map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(occurenceOfWords);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given a sentence find exactly 2 vowels in word and print them");
		Arrays.stream(str.split(" ")).filter(x->x.replaceAll("[^aeiouAEIOU]", "").length() == 2).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given a intger list, print separate list for odd and even numbers");
		Map<Boolean, List<Integer>> evenOdd = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(x->x%2==0, Collectors.toList()));
		System.out.println(evenOdd);
		List<List<Integer>> evenOdd2 = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(x->x%2==0, Collectors.toList()))
				.entrySet().stream().map(x->x.getValue()).toList();
		System.out.println(evenOdd2);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given a word find the occurence of each charachter");
		Map<String, Long> eachCharOcc = Arrays.stream(oneWord.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(eachCharOcc);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given int array, print them in asc and desc order");
		System.out.println(Arrays.stream(arr).boxed().sorted().distinct().collect(Collectors.toList()));
		System.out.println(Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList()));
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given int array, find the sum of unique elements");
		int sum = Arrays.stream(arr).distinct().sum();
		System.out.println(sum);
		int sumReduce = Arrays.stream(arr).distinct().reduce((a,b)-> a+b).getAsInt();
		System.out.println(sumReduce);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given a String, find the first non-repeated charachter");
		String firstChar2 = Arrays.stream(twoWord.split("")).filter(x->x.indexOf(x)==x.lastIndexOf(x)).findFirst().get();
		System.out.println(firstChar2);  
		char firstChar = twoWord.chars()
			    .mapToObj(c -> (char) c)
			    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
			    .entrySet().stream()
			    .filter(e -> e.getValue() == 1)
			    .map(Map.Entry::getKey)
			    .findFirst().get();
		System.out.println(firstChar);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given a String, find the first repeated charachter");
		char repeatedChar = twoWord.chars()
			    .mapToObj(c -> (char) c)
			    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
			    .entrySet().stream()
			    .filter(e -> e.getValue() > 1)
			    .map(Map.Entry::getKey)
			    .findFirst().get();
		System.out.println(repeatedChar);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given a array, group them by they belongs to the range");
		Map<Object, List<Integer>> grp = Arrays.stream(arrays).boxed().collect(Collectors.groupingBy(x->x/10*10, Collectors.toList()));
		System.out.println(grp);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Group/Pair anagrams from a list of Strings");
		String[] input = {"Listen", "silent", "enlist", "hello", "below", "elbow", "bowl", "lowb"};
		Map<Object, List<String>> anagramList = Arrays.stream(input)
				.collect(Collectors.groupingBy(x->Arrays.stream(x.toLowerCase().split("")).sorted().collect(Collectors.toList())));
		System.out.println(anagramList);
		Map<String, List<String>> anagramList2 = Arrays.stream(input)
			    .collect(Collectors.groupingBy(
			        x -> {
			            char[] chars = x.toLowerCase().toCharArray();
			            Arrays.sort(chars);
			            return new String(chars);
			        }    
			    ));
		System.out.println(anagramList2);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Write a Java Stream program to multiply every alternate number in an integer array.");
		int[] arr1 = {1, 2, 3, 4, 5, 6};
		// Stream through indices of the array
        int result = IntStream.range(0, arr1.length)
                .filter(i -> i % 2 == 0)       // Select even indices: 0, 2, 4...
                .map(i -> arr1[i])              // Get the elements at those indices
                .reduce(1, (a, b) -> a * b);   // Multiply them together
        System.out.println("Product of elements at even indexes: " + result);
        // Stream through indices of the array
        int result1 = IntStream.range(0, arr1.length)
                .filter(i -> i % 2 != 0)       // Select odd indices: 1, 3, 5...
                .map(i -> arr1[i])              // Get the elements at those indices
                .reduce(1, (a, b) -> a * b);   // Multiply them together
        System.out.println("Product of elements at odd indexes: " + result1);
        System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Write a program to multiply 1st and last element, 2nd and 2nd last element");
		int[] arr3 = {2, 4, 6, 8, 10, 12};
		List<Integer> prod = IntStream.range(0, arr3.length/2).boxed().map(i->arr3[i]*arr3[arr3.length-i-1]).collect(Collectors.toList());
		System.out.println(prod);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Write a program to ");
		//Java 8 Stream API-19
		
	}

}
