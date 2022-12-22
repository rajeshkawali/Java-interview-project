package com.rajeshkawali.stream.employee.question;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.rajeshkawali.model.Employee;
import com.rajeshkawali.util.EmployeeDB;

/**
 * @author Rajesh_Kawali
 *
 */
public class StreamEmployeeQuestions {

	public static void main(String[] args) {

		List<Employee> employeeList = EmployeeDB.getAllEmployee();
		// Given a list of employees, you need to filter all the employee whose age is
		// greater than 25 and print the employee names
		List<String> employeeFilteredList = employeeList.stream().filter(e -> e.getAge() > 25)
				.map(Employee::getFirstName).collect(Collectors.toList());
		System.out.println(employeeFilteredList);
		System.out.println("--------------------------------------------------------------------------------1");
		// Given the list of employees, count number of employees with age 25
		long count = employeeList.stream().filter(e -> e.getAge() > 25).count();
		System.out.println("Number of employees with age 25 are : " + count);
		System.out.println("--------------------------------------------------------------------------------2");
		// Given the list of employees, find the employee with name �Mahesh�
		Optional<Employee> e1 = employeeList.stream().filter(e -> e.getFirstName().equalsIgnoreCase("Mahesh"))
				.findAny();
		if (e1.isPresent()) {
			System.out.println(e1.get());
		}
		System.out.println("--------------------------------------------------------------------------------3");
		// Given a list of employee, find maximum age of employee?
		OptionalInt max = employeeList.stream().mapToInt(Employee::getAge).max();
		if (max.isPresent()) {
			System.out.println("Maximum age of Employee: " + max.getAsInt());
		}
		System.out.println("--------------------------------------------------------------------------------4");
		// Given a list of employees, sort all the employee on the basis of age?
		employeeList.sort((e11, e22) -> e11.getAge() - e22.getAge());
		employeeList.forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------------5");
		// Join the all employee names with �,� using java 8?
		List<String> employeeNames = employeeList.stream().map(Employee::getFirstName).collect(Collectors.toList());
		String employeeNamesStr = String.join(",", employeeNames);
		System.out.println("Employees are: " + employeeNamesStr);
		String employeeNamesJoin = employeeList.stream().map(Employee::getFirstName).collect(Collectors.joining(", "));
		System.out.println("Employees are: " + employeeNamesJoin);
		System.out.println("--------------------------------------------------------------------------------6");
		// Given the list of employee, group them by employee name?
		Map<String, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getFirstName));
		map.forEach((name, employeeListTemp) -> System.out.println("Name: " + name + " ==>" + employeeListTemp));
		System.out.println("--------------------------------------------------------------------------------7");
		// Print all the Employment History(Which is in List of List)
		List<List<String>> employeePhone = employeeList.stream().map(Employee::getEmploymentHistory)
				.collect(Collectors.toList());
		System.out.println(employeePhone);
		System.out.println("--------------------------------------------------------------------------------8");
		// Print all the Employment History in one List using flatMap(flattening)
		List<String> flatteredHistory = employeeList.stream()
				.flatMap(employee -> employee.getEmploymentHistory().stream()).collect(Collectors.toList());
		System.out.println(flatteredHistory);
		System.out.println("--------------------------------------------------------------------------------9");
		// Print all the Employment History which has length <= 5 with Unique.
		Set<String> flatteredComapnyHistory = employeeList.stream()
				.flatMap(employee -> employee.getEmploymentHistory().stream().filter(company -> company.length() <= 5))
				.collect(Collectors.toSet());
		System.out.println(flatteredComapnyHistory);
		System.out.println("--------------------------------------------------------------------------------10");
		// Print all the yahoo emails present in employee list.
		List<String> employeeEmail = employeeList.stream().map(Employee::getEmail)
				.filter(email -> email.contains("@yahoo.com")).collect(Collectors.toList());
		System.out.println(employeeEmail);
		System.out.println("--------------------------------------------------------------------------------11");
		// Get the all employees in each department with employee count
		Map<String, Long> deptCount = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(deptCount);
		System.out.println("--------------------------------------------------------------------------------12");
		// Top paid salary of an employee from each department (for minimum paid salary
		// use minBy() instead maxBy()
		Map<String, Employee> groupList = employeeList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(e -> e.getSalary())), Optional::get)));
		System.out.println(groupList);
		System.out.println("--------------------------------------------------------------------------------13");
		// Group by Department
		Map<String, List<Employee>> groupByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment()));
		System.out.println(groupByDepartment);
		System.out.println("--------------------------------------------------------------------------------14");
		// Retrieve the list of list using flatMap
		List<List<String>> dupList = Arrays.asList(
				Arrays.asList("rajesh"), 
				Arrays.asList("mahesh"),
				Arrays.asList("kawali"), 
				Arrays.asList("koli"));
		System.out.println(dupList.stream().flatMap(Collection::stream).collect(Collectors.toList()));
		System.out.println("--------------------------------------------------------------------------------15");
		// To make upper case
		List<String> list = Stream.of("a", "b", "c").map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(list);
		System.out.println("--------------------------------------------------------------------------------16");
		// To get the Average of given numbers
		List<Integer> numbers = Arrays.asList(2, 8, 3, 4, 6, 7, 3, 1);
		IntSummaryStatistics summaryStatistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println(summaryStatistics.getAverage());
		System.out.println("--------------------------------------------------------------------------------17");
		// To generate Random number only 4 times
		Random random = new Random();
		random.ints().limit(4).sorted().forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------------18");
		// Group by names
		System.out.println(employeeList.stream().collect(Collectors.groupingBy(e -> e.getFirstName())));
		System.out.println("--------------------------------------------------------------------------------19");
		int[] number = { 2, 4, 3, 1, 6, 0, 5, 7, 0 };
		// Print 3 min numbers from array
		IntStream.of(number).distinct().sorted().limit(3).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------------20");
		// To Count the employee in each department
		Map<String, Long> empCount = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(empCount);
		System.out.println("--------------------------------------------------------------------------------21");
		// If you have more than 10000 elements in the list then we can use parallel
		// stream to divide the task in multiple threads.
		Map<String, Long> empCountParalle = employeeList.stream().parallel()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(empCountParalle);
		System.out.println("--------------------------------------------------------------------------------22");
		// Print employee highest salary of first 3 employees
		employeeList.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).limit(3)
				.map(Employee::getFirstName).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------------23");
		// convert stream to Map
		Map<String, String> emp = employeeList.stream().limit(3)
				.collect(Collectors.toMap(e -> e.getFirstName(), e -> e.getDepartment()));
		System.out.println(emp);
		System.out.println("--------------------------------------------------------------------------------24");
		// To join the names with comma separated
		String empNames = employeeList.stream().map(Employee::getFirstName).collect(Collectors.joining(", "));
		System.out.println(empNames);
		System.out.println("--------------------------------------------------------------------------------25");
		//Sort first name and last name using comparator.
		Comparator<Employee> groupSorting = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
		List<Employee> empName =  employeeList.stream().distinct().sorted(groupSorting).collect(Collectors.toList());
		System.out.println(empName);
		System.out.println("--------------------------------------------------------------------------------26");
		//Add/Multiply all numbers given in the array
		Integer aNumbers[] = {2,3,4,5};
		List<Integer> numbersList = Arrays.asList(aNumbers);
		Optional<Integer> additionOptional = numbersList.stream().reduce((x,y)->x+y);
		Integer addition = numbersList.stream().reduce(0,(x,y)->x+y);
		Integer multiplication = numbersList.stream().reduce(1,(x,y)->x*y);
		System.out.println("additionOptional: "+additionOptional.get()+", addition: "+addition+", multiplication: "+multiplication);
		System.out.println("--------------------------------------------------------------------------------27");
		//Find second/Third highest salary of the employees
		List<Employee> empSalary2 =  employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).limit(1).collect(Collectors.toList());
		String empSalary3 =  employeeList.stream()
				.sorted((emp1,emp2) -> (int)(emp2.getSalary() - emp1.getSalary())) // Sort salary based on descending
				.skip(2) // Skip first 2 employee
				.limit(1) // Limit to one employee
				.map(Employee::getFirstName) // To get only first name
				.findFirst() // find first name of list
				.get(); // get value from Optional object.
		System.out.println("Second highest salary of the employee: "+empSalary2);
		System.out.println("Third highest salary of the employee: "+empSalary3);
		System.out.println("--------------------------------------------------------------------------------28");
		//Find duplicate last name of given employee list.
		List<String> empLastNameList = employeeList.stream().map(Employee::getLastName).collect(Collectors.toList());
		Set<String> empLastNameDuplicate = employeeList.stream().map(Employee::getLastName)
		.filter(lastName->Collections.frequency(empLastNameList, lastName) > 1)
		.collect(Collectors.toSet());
		System.out.println(empLastNameDuplicate);
		System.out.println("--------------------------------------------------------------------------------29");
		//print unique last names of given employee list.
		Set<String> empLastNameUnique = employeeList.stream().map(Employee::getLastName)
				.collect(Collectors.toSet());
				System.out.println(empLastNameUnique);
		System.out.println("--------------------------------------------------------------------------------30");
		
		
		System.out.println("--------------------------------------------------------------------------------31");
		
		
		System.out.println("--------------------------------------------------------------------------------32");
		// This is only for showing the methods in the stream
		System.out.println(IntStream.of(number).distinct()); // Print unique values
		System.out.println(IntStream.of(number).sorted()); // Sort
		System.out.println(IntStream.of(number).limit(3)); // Print only first 3 numbers
		System.out.println(IntStream.of(number).skip(3)); // Skip first 3 numbers
		System.out.println(IntStream.of(number).filter(data -> data % 2 == 0)); // Print only even numbers
		System.out.println(IntStream.of(number).map(num -> num * 2)); // Double the number
		System.out.println(IntStream.of(number).boxed()); // Convert each number to Integer
		System.out.println(IntStream.of(number).count()); // Count the no of elements
		System.out.println(IntStream.of(number).sum()); // Add all the elements and return sum
		System.out.println(IntStream.of(number).average()); // Print the avg of array
		System.out.println(IntStream.of(number).max()); // Print maximum number in the array
		System.out.println(IntStream.of(number).min()); // Print minimum number in array
		System.out.println(IntStream.of(number).unordered()); // Returns an equivalent stream that is unordered.
		System.out.println("--------------------------------------------------------------------------------");
		IntStream.range(1, 5).forEach(System.out::println); // Print 1 to 5 numbers
		IntStream.range(1, 5).toArray(); // collect into array
		IntStream.range(1, 5).boxed().collect(Collectors.toList()); // collect into List
	}
}
/*
 * 
 * [Rajesh, Mahesh, Vidya]
 * -----------------------------------------------------------------------------
 * ---1 Number of employees with age 25 are : 3
 * -----------------------------------------------------------------------------
 * ---2 Employee [id=2, name=Mahesh, age=29, email=mahesh@gmail.com,
 * phone=[91445935, 7948559447]]
 * -----------------------------------------------------------------------------
 * ---3 Maximum age of Employee: 32
 * -----------------------------------------------------------------------------
 * ---4 Employee [id=5, name=Vikram, age=6, email=vikram@gmail.com,
 * phone=[81937, 94068]] Employee [id=4, name=Rajesh, age=18,
 * email=rajesh@gmail.com, phone=[94937, 8946069767]] Employee [id=6,
 * name=Keshav, age=22, email=keshav@gmail.com, phone=[9164937447, 9478683067]]
 * Employee [id=7, name=Kiran, age=22, email=kiran@gmail.com, phone=[91937447,
 * 947683067]] Employee [id=3, name=Vidya, age=27, email=vidya@gmail.com,
 * phone=[869493, 89454]] Employee [id=2, name=Mahesh, age=29,
 * email=mahesh@gmail.com, phone=[91445935, 7948559447]] Employee [id=1,
 * name=Rajesh, age=32, email=rajesh@gmail.com, phone=[8169447937, 839409467]]
 * -----------------------------------------------------------------------------
 * ---5 Employees are: Vikram,Rajesh,Keshav,Kiran,Vidya,Mahesh,Rajesh
 * -----------------------------------------------------------------------------
 * ---6 Name: Kiran ==>[Employee [id=7, name=Kiran, age=22,
 * email=kiran@gmail.com, phone=[91937447, 947683067]]] Name: Vidya ==>[Employee
 * [id=3, name=Vidya, age=27, email=vidya@gmail.com, phone=[869493, 89454]]]
 * Name: Keshav ==>[Employee [id=6, name=Keshav, age=22, email=keshav@gmail.com,
 * phone=[9164937447, 9478683067]]] Name: Rajesh ==>[Employee [id=4,
 * name=Rajesh, age=18, email=rajesh@gmail.com, phone=[94937, 8946069767]],
 * Employee [id=1, name=Rajesh, age=32, email=rajesh@gmail.com,
 * phone=[8169447937, 839409467]]] Name: Mahesh ==>[Employee [id=2, name=Mahesh,
 * age=29, email=mahesh@gmail.com, phone=[91445935, 7948559447]]] Name: Vikram
 * ==>[Employee [id=5, name=Vikram, age=6, email=vikram@gmail.com, phone=[81937,
 * 94068]]]
 * -----------------------------------------------------------------------------
 * ---7 [[81937, 94068], [94937, 8946069767], [9164937447, 9478683067],
 * [91937447, 947683067], [869493, 89454], [91445935, 7948559447], [8169447937,
 * 839409467]]
 * -----------------------------------------------------------------------------
 * ---8 [81937, 94068, 94937, 8946069767, 9164937447, 9478683067, 91937447,
 * 947683067, 869493, 89454, 91445935, 7948559447, 8169447937, 839409467]
 * -----------------------------------------------------------------------------
 * ---9 [8946069767, 9164937447, 9478683067, 7948559447, 8169447937]
 * -----------------------------------------------------------------------------
 * ---10 [vikram@gmail.com, rajesh@gmail.com, keshav@gmail.com, kiran@gmail.com,
 * vidya@gmail.com, mahesh@gmail.com, rajesh@gmail.com]
 * -----------------------------------------------------------------------------
 * ---11 {software=2, admin=2, finance=3}
 * -----------------------------------------------------------------------------
 * ---12 {software=Employee [id=1, name=Rajesh, age=32, email=rajesh@gmail.com,
 * phone=[8169447937, 839409467]], admin=Employee [id=7, name=Kiran, age=22,
 * email=kiran@gmail.com, phone=[91937447, 947683067]], finance=Employee [id=6,
 * name=Keshav, age=22, email=keshav@gmail.com, phone=[9164937447, 9478683067]]}
 * -----------------------------------------------------------------------------
 * ---13 {software=[Employee [id=5, name=Vikram, age=6, email=vikram@gmail.com,
 * phone=[81937, 94068]], Employee [id=1, name=Rajesh, age=32,
 * email=rajesh@gmail.com, phone=[8169447937, 839409467]]], admin=[Employee
 * [id=7, name=Kiran, age=22, email=kiran@gmail.com, phone=[91937447,
 * 947683067]], Employee [id=3, name=Vidya, age=27, email=vidya@gmail.com,
 * phone=[869493, 89454]]], finance=[Employee [id=4, name=Rajesh, age=18,
 * email=rajesh@gmail.com, phone=[94937, 8946069767]], Employee [id=6,
 * name=Keshav, age=22, email=keshav@gmail.com, phone=[9164937447, 9478683067]],
 * Employee [id=2, name=Mahesh, age=29, email=mahesh@gmail.com, phone=[91445935,
 * 7948559447]]]}
 * -----------------------------------------------------------------------------
 * ---14 [Rajesh, mahesh, kawali, koli]
 * -----------------------------------------------------------------------------
 * ---15 [A, B, C]
 * -----------------------------------------------------------------------------
 * ---16 4.25
 * -----------------------------------------------------------------------------
 * ---17 -1403215214 -992478650 1158383422 1576700893
 * -----------------------------------------------------------------------------
 * ---18 {Kiran=[Employee [id=7, name=Kiran, age=22, email=kiran@gmail.com,
 * phone=[91937447, 947683067]]], Vidya=[Employee [id=3, name=Vidya, age=27,
 * email=vidya@gmail.com, phone=[869493, 89454]]], Keshav=[Employee [id=6,
 * name=Keshav, age=22, email=keshav@gmail.com, phone=[9164937447,
 * 9478683067]]], Rajesh=[Employee [id=4, name=Rajesh, age=18,
 * email=rajesh@gmail.com, phone=[94937, 8946069767]], Employee [id=1,
 * name=Rajesh, age=32, email=rajesh@gmail.com, phone=[8169447937, 839409467]]],
 * Mahesh=[Employee [id=2, name=Mahesh, age=29, email=mahesh@gmail.com,
 * phone=[91445935, 7948559447]]], Vikram=[Employee [id=5, name=Vikram, age=6,
 * email=vikram@gmail.com, phone=[81937, 94068]]]}
 * -----------------------------------------------------------------------------
 * ---19 0 1 2
 * -----------------------------------------------------------------------------
 * ---20 {software=2, admin=2, finance=3}
 * -----------------------------------------------------------------------------
 * ---21 {software=2, admin=2, finance=3}
 * -----------------------------------------------------------------------------
 * ---22 Kiran Rajesh Keshav
 * -----------------------------------------------------------------------------
 * ---23 {Keshav=finance, Rajesh=finance, Vikram=software}
 * -----------------------------------------------------------------------------
 * ---24 Vikram, Rajesh, Keshav, Kiran, Vidya, Mahesh, Rajesh
 * -----------------------------------------------------------------------------
 * ---25 java.util.stream.ReferencePipeline$4@25f38edc
 * java.util.stream.SortedOps$OfInt@1a86f2f1
 * java.util.stream.SliceOps$2@3eb07fd3 java.util.stream.SliceOps$2@506c589e
 * java.util.stream.IntPipeline$9@4b85612c
 * java.util.stream.IntPipeline$3@7aec35a
 * java.util.stream.IntPipeline$4@67424e82 9 28
 * OptionalDouble[3.111111111111111] OptionalInt[7] OptionalInt[0]
 * java.util.stream.IntPipeline$8@6e5e91e4
 * -----------------------------------------------------------------------------
 * ---26 1 2 3 4
 * 
 */
