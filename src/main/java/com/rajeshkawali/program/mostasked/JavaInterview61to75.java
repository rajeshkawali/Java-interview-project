package com.rajeshkawali.program.mostasked;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaInterview61to75 {
	static class Employee {
		final String name, department;
		final int salary;

		Employee(String name, String department, int salary) {
			this.name = name;
			this.department = department;
			this.salary = salary;
		}

		@Override
		public String toString() {
			return name + "=" + salary;
		}
	}

	public static void main(String[] args) {
		List<Integer> nums61 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		System.out.println("61. Even: " + nums61.stream().filter(x -> x % 2 == 0).collect(Collectors.toList())
				+ "; Odd: " + nums61.stream().filter(x -> x % 2 != 0).collect(Collectors.toList()));
		List<Integer> nums62 = Arrays.asList(10, 40, 20, 5, 90, 30);
		System.out
				.println("62. Max: " + nums62.stream().max(Integer::compareTo).orElseThrow(NoSuchElementException::new)
						+ "; Min: " + nums62.stream().min(Integer::compareTo).orElseThrow(NoSuchElementException::new));
		List<Employee> employees = Arrays.asList(new Employee("Asha", "IT", 60000), new Employee("Ravi", "HR", 45000),
				new Employee("Neha", "IT", 75000), new Employee("Kiran", "Finance", 90000),
				new Employee("Priya", "HR", 80000));
		System.out.println("63. Top 3 salaries: "
				+ employees.stream().sorted(Comparator.comparingInt((Employee e) -> e.salary).reversed()).limit(3)
						.collect(Collectors.toList()));
		Map<String, Optional<Employee>> highest = employees.stream().collect(Collectors.groupingBy(e -> e.department,
				TreeMap::new, Collectors.maxBy(Comparator.comparingInt(e -> e.salary))));
		Map<String, Employee> highestDisplay = new TreeMap<>();
		highest.forEach((department, employee) -> highestDisplay.put(department,
				employee.orElseThrow(NoSuchElementException::new)));
		System.out.println("64. Highest by department: " + highestDisplay);
		Map<String, Double> averages = employees.stream().collect(
				Collectors.groupingBy(e -> e.department, TreeMap::new, Collectors.averagingInt(e -> e.salary)));
		System.out.println("65. Average by department: " + averages);
		Map<String, Integer> salaryMap = employees.stream().collect(
				Collectors.toMap(e -> e.name, e -> e.salary, (oldValue, newValue) -> newValue, LinkedHashMap::new));
		System.out.println("66. List to Map: " + salaryMap);
		List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "Spring", "JUnit");
		System.out.println(
				"67. Starts with J: " + languages.stream().filter(s -> s.startsWith("J")).collect(Collectors.toList()));
		System.out.println("68. Joining: "
				+ Arrays.asList("Java", "Spring", "Hibernate").stream().collect(Collectors.joining(", ", "[", "]")));
		Map<Boolean, List<Integer>> parts = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
				.collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println("69. Even: " + parts.get(true) + "; Odd: " + parts.get(false));
		int[] arr = { 1, 2, 2, 3, 3, 3, 4 };
		System.out.println("70. Frequency: " + Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting())));
		Map<String, Integer> scores = new HashMap<>();
		scores.put("Java", 80);
		scores.put("Python", 70);
		scores.put("Spring", 90);
		Map<String, Integer> sorted = scores.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
		System.out.println("71. Sorted by values: " + sorted);
		List<List<Integer>> nested = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
		System.out.println("72. Flatten: " + nested.stream().flatMap(List::stream).collect(Collectors.toList()));
		System.out.println("73. Longest String: " + Arrays.asList("Java", "Microservices", "Spring", "Hibernate")
				.stream().max(Comparator.comparingInt(String::length)).orElse(""));
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		Set<Integer> lookup = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));
		System.out.println("74. Common elements: "
				+ list1.stream().filter(lookup::contains).distinct().collect(Collectors.toList()));
		List<Integer> nums75 = Arrays.asList(10, 40, 20, 50, 30, 50);
		int k = 3;
		System.out.println("75. Kth highest distinct: "
				+ nums75.stream().distinct().sorted(Comparator.reverseOrder()).skip(k - 1).findFirst().orElse(null));
	}
}
