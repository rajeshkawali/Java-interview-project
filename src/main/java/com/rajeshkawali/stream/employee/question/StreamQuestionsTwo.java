package com.rajeshkawali.stream.employee.question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.rajeshkawali.model.Employee;
import com.rajeshkawali.util.EmployeeDB;

/**
 * @author Rajesh_Kawali
 *
 */
public class StreamQuestionsTwo {

	public static void main(String[] args) {

		List<Employee> empList = EmployeeDB.getAllEmployee();
		
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the two strings are anagram or not");
		String s1 = "abc";
		String s2 = "acb";
		Boolean result = s1.chars().sorted().mapToObj(c->(char)c).toList().equals(s2.chars().sorted().mapToObj(c->(char)c).toList());
		System.out.println(result);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the sum of 10 natural digits");
		Integer sum = IntStream.rangeClosed(1, 10).sum();
		System.out.println(sum);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the most repeated element in array");
		int arrays[] = {2,80,1,90,10,30,58,30,96,36,7,50,90,30,33};
		Entry<Integer, Long> max = Arrays.stream(arrays).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get();
		System.out.println(max);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Print first 10 even numbers");
		IntStream.range(0, 20).filter(x->x%2==0).boxed().collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the char with minimum frequencey");
		String str = "banana is good";
		str = str.replaceAll("\\s", "");
		str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().min(Comparator.comparingLong(Map.Entry::getValue)).ifPresent(entry ->
        System.out.println("Character with minimum frequency: '" + entry.getKey() +"' appears " + entry.getValue() + " time(s)"));
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("convert a List<String> into a Map<String, Boolean> in Java using streams. The key will be the word, and the value will be true if the word is a palindrome, otherwise false.");
		List<String> names = List.of("level", "Keshav", "madam", "Iran", "Rajesh", "Sonu");
		Map<String, Boolean> m1 = names.stream().collect(Collectors.toMap(
				name -> name,
				name -> {
					String lower = name.toLowerCase();
					return new StringBuilder(lower).reverse().toString().equals(lower);
				}));
		System.out.println(m1);
		
		Map<String, Boolean> m2 = names.stream().collect(Collectors.toMap(
				name -> name, 
				name -> {
						String lower = name.toLowerCase();
						int len = lower.length();
						for (int i = 0; i < len / 2; i++) {
							if (lower.charAt(i) != lower.charAt(len - 1 - i)) {
								return false;
							}
						}
						return true;
				}));
		System.out.println(m2);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("print map -> Key will be first letter of the word and value will be word");
		Map<Character, String> map=names.stream().collect(Collectors.toMap(name->name.charAt(0), name->name));
		System.out.println(map);
		Map<Character, List<String>> grouped = names.stream()
		        .collect(Collectors.groupingBy(name -> Character.toLowerCase(name.charAt(0))));
		System.out.println(grouped);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("How to create infinit stream");
		Stream<Integer> m = Stream.iterate(0, i->i+1);
		m.limit(10).forEach(System.out::println); // limited to 10 digits
		
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the highest salary of employee and add them Rs.2000 bonus");
		Employee sal = empList.stream().max(Comparator.comparingDouble(Employee::getSalary)).get(); // Highest salary
		System.out.println(sal);
		List<Integer> empSal = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(1).map(emp-> emp.getSalary() + 2000).collect(Collectors.toList());
		System.out.println(empSal);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the highest salary of employee from each department and give them Rs.2000 bonus");
        Map<String, Employee> empSalDept = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                optionalEmp -> {
                                    optionalEmp.ifPresent(e -> e.setSalary(e.getSalary() + 2000));
                                    return optionalEmp.orElse(null);
                                }
                        )
                ));
        System.out.println(empSalDept);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the longest word in the string");
		String str1 = "Java is programming language and Java java";
		List<String> longestWord= Arrays.stream(str1.split(" ")).sorted(Comparator.comparing(String::length).reversed()).limit(1).collect(Collectors.toList());
		System.out.println(longestWord);
		
		String longestWord2 = Arrays.stream(str1.split(" ")).max(Comparator.comparing(String::length)).get();
		System.out.println(longestWord2);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Sort(Desc) a List of Decimals Using Streams");
		List<Double> decimals = List.of(3.14, 3.4, 6.7, 0.47 ,2.71, 1.41, 4.67, 0.99);
		List<Double> decimalSorted = decimals.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(decimalSorted);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Check weather given string palindrom or not using Stream");
		String word = "madam";
		Boolean  flag =IntStream.range(0, word.length() / 2).allMatch(i-> word.charAt(i) == word.charAt(word.length()-1-i));
		System.out.println(flag);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Check weather given list of string start with digit");
		List<String> nameList = List.of("Laksh", "2eshav", "madam", "7iran", "Rajesh", "Sonu");
		List<String> numName = nameList.stream().filter(n-> !n.isEmpty() && Character.isDigit(n.charAt(0))).collect(Collectors.toList());		
		System.out.println(numName);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find first non repeated character in a string");
		String nonRepeatedString = "madam";
		Entry<Character, Long> s = nonRepeatedString.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(x ->x.getValue()==1).findFirst().get();
		System.out.println(s);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("find the sum/multiplication of the first two numbers in a list using Java Streams");
		List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        int sumFirstTwo = numbers.stream().limit(2).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of first two numbers: " + sumFirstTwo);
        int sum2 = numbers.stream().limit(2).reduce(0, Integer::sum);
        System.out.println(sum2);
        int multi = numbers.stream().limit(2).reduce((a,b)->a*b).get();
        System.out.println("multiplication of first two numbers: " + multi);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("find the number of vowels (k) in each word of a sentence using Java Streams");
		String sentence = "Java streams are very powerful";
		long k = 2;
		List<String> count = Arrays.stream(word.split(" ")).filter(w-> getCount(w) == k).collect(Collectors.toList());
		System.out.println(count);
		Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Map<String, Long> wordToVowelCount = Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.toMap(
                        word1 -> word1,
                        word1 -> word1.toLowerCase().chars()
                                .filter(c -> vowels.contains((char) c))
                                .count()
                ));
        wordToVowelCount.forEach((word1, count1) ->System.out.println(word1 + " -> " + count1 + " vowels"));
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("find prime numbers in a list using Java Streams");
		List<Integer> integers = List.of(2, 3, 4, 5, 10, 13, 17, 20, 23, 29, 30);
        List<Integer> primes = integers.stream().filter(i->isPrime(i)).collect(Collectors.toList());
        System.out.println("Prime numbers: " + primes);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("find a substring inside a string using Java Streams");
		String s3 = "java is best programming language";
        String pattern = "gram";
        boolean found = IntStream.range(0, s3.length() - pattern.length() + 1)
                .anyMatch(i -> s3.substring(i, i + pattern.length()).equals(pattern));
        System.out.println("Using Stream (IntStream): " + found);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("find the duplicate numbers in a list which more than once repeated using Java Streams");
		List<Integer> listInt = Arrays.asList(10, 20, 30, 55, 11, 20, 33, 4, 44, 55, 20);
		listInt.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(e->e.getValue()>1)
		.map(e->e.getKey())
		.forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Count the occurrence of each name using Java Streams:");
        List<String> nList = List.of("laksh", "keshav", "madan", "kiran", "laksh", "madan");
        Map<String, Long> nameCount = nList.stream().collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()));
        nameCount.forEach((name, count3) -> System.out.println(name + " => " + count3));
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find nth smallest element in array");
		int n = 3;
		int nThSmallestElement = Arrays.stream(arrays).sorted().skip(n-1).findFirst().getAsInt();
		System.out.println(nThSmallestElement);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Print duplicate element in array");
		int arra[] = {90,2,80,1,90,10,30,58,30,90,36,7,50,90,30,33};
		Arrays.stream(arra).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Print the word count map for each sublist, including both duplicates and non-duplicates");
        List<List<String>> wordsPerBook = Arrays.asList(
            Arrays.asList("My", "team", "is", "Orange", "Orange", "fruit"),
            Arrays.asList("team", "team", "fruit", "fruit", "fruit"),
            Arrays.asList("Orange", "Orange", "Orange", "team", "fruit")
        );
        IntStream.range(0, wordsPerBook.size())
            .mapToObj(i -> {
                List<String> wordList = wordsPerBook.get(i);
                // Count all words in sublist
                Map<String, Long> wordCountMap = wordList.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                // Format word count map as string
                String formatted = wordCountMap.entrySet().stream()
                    .map(e -> "(key=" + e.getKey() + ", value=" + e.getValue() + ")")
                    .collect(Collectors.joining(", "));
                return "key " + (i + 1) + " -> Map(" + formatted + ")";
            })
            .forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("");
		
		
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");
		
	
	}
	
	public static long getCount(String word) {
		return Arrays.stream(word.split("")).filter(w-> "aeiouAEIOU".indexOf(w) != -1).count();
	}

	// Check if a number is prime (basic logic)
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                //.allMatch(i -> n % i != 0);
        		.noneMatch(i -> n % i == 0);
    }
    
    private static boolean isPrime7(int n) {
        if (n < 2) return false;
        // Check divisors from 2 up to n/2 (instead of sqrt)
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
