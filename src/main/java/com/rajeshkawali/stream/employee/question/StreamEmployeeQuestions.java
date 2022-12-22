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
		// Given the list of employees, find the employee with name “Mahesh”
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
		// Join the all employee names with “,” using java 8?
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
[Rajesh, Mahesh, Vidya, Kiran, Arjun, Sachin, Rajesh]
--------------------------------------------------------------------------------1
Number of employees with age 25 are : 7
--------------------------------------------------------------------------------2
Employee(id=2, firstName=Mahesh, lastName=Koli, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra])
--------------------------------------------------------------------------------3
Maximum age of Employee: 36
--------------------------------------------------------------------------------4
Employee(id=8, firstName=Laksh, lastName=Kawali, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple])
Employee(id=4, firstName=Vikram, lastName=Konkal, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance])
Employee(id=5, firstName=Keshav, lastName=Koli, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS])
Employee(id=3, firstName=Vidya, lastName=Kawali, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM])
Employee(id=2, firstName=Mahesh, lastName=Koli, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra])
Employee(id=9, firstName=Sachin, lastName=Gaikwad, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato])
Employee(id=10, firstName=Rajesh, lastName=Nayak, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini])
Employee(id=1, firstName=Rajesh, lastName=Kawali, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini])
Employee(id=6, firstName=Kiran, lastName=Kamble, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar])
Employee(id=7, firstName=Arjun, lastName=Naik, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])
--------------------------------------------------------------------------------5
Employees are: Laksh,Vikram,Keshav,Vidya,Mahesh,Sachin,Rajesh,Rajesh,Kiran,Arjun
Employees are: Laksh, Vikram, Keshav, Vidya, Mahesh, Sachin, Rajesh, Rajesh, Kiran, Arjun
--------------------------------------------------------------------------------6
Name: Kiran ==>[Employee(id=6, firstName=Kiran, lastName=Kamble, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar])]
Name: Vidya ==>[Employee(id=3, firstName=Vidya, lastName=Kawali, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM])]
Name: Keshav ==>[Employee(id=5, firstName=Keshav, lastName=Koli, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS])]
Name: Laksh ==>[Employee(id=8, firstName=Laksh, lastName=Kawali, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple])]
Name: Rajesh ==>[Employee(id=10, firstName=Rajesh, lastName=Nayak, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini]), Employee(id=1, firstName=Rajesh, lastName=Kawali, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini])]
Name: Mahesh ==>[Employee(id=2, firstName=Mahesh, lastName=Koli, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra])]
Name: Arjun ==>[Employee(id=7, firstName=Arjun, lastName=Naik, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])]
Name: Vikram ==>[Employee(id=4, firstName=Vikram, lastName=Konkal, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance])]
Name: Sachin ==>[Employee(id=9, firstName=Sachin, lastName=Gaikwad, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato])]
--------------------------------------------------------------------------------7
[[Walmart, Microsoft, Amazon, Google, Apple], [Accenture, Morgan, TCS, Reliance], [Xangar, TCS], [BOM], [Dell, Yantra], [Zomato], [Capgemini], [Trimax, Diebold, Capgemini], [Takira, Trimax, Xangar], [IBM, Concentrix]]
--------------------------------------------------------------------------------8
[Walmart, Microsoft, Amazon, Google, Apple, Accenture, Morgan, TCS, Reliance, Xangar, TCS, BOM, Dell, Yantra, Zomato, Capgemini, Trimax, Diebold, Capgemini, Takira, Trimax, Xangar, IBM, Concentrix]
--------------------------------------------------------------------------------9
[BOM, Dell, Apple, TCS, IBM]
--------------------------------------------------------------------------------10
[laksh@yahoo.com, vikram@yahoo.com, mahesh@yahoo.com, rajesh@yahoo.com]
--------------------------------------------------------------------------------11
{software=3, admin=4, hr=1, finance=2}
--------------------------------------------------------------------------------12
{software=Employee(id=6, firstName=Kiran, lastName=Kamble, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar]), admin=Employee(id=8, firstName=Laksh, lastName=Kawali, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple]), hr=Employee(id=4, firstName=Vikram, lastName=Konkal, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance]), finance=Employee(id=7, firstName=Arjun, lastName=Naik, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])}
--------------------------------------------------------------------------------13
{software=[Employee(id=5, firstName=Keshav, lastName=Koli, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS]), Employee(id=1, firstName=Rajesh, lastName=Kawali, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini]), Employee(id=6, firstName=Kiran, lastName=Kamble, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar])], admin=[Employee(id=8, firstName=Laksh, lastName=Kawali, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple]), Employee(id=2, firstName=Mahesh, lastName=Koli, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra]), Employee(id=9, firstName=Sachin, lastName=Gaikwad, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato]), Employee(id=10, firstName=Rajesh, lastName=Nayak, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini])], hr=[Employee(id=4, firstName=Vikram, lastName=Konkal, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance])], finance=[Employee(id=3, firstName=Vidya, lastName=Kawali, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM]), Employee(id=7, firstName=Arjun, lastName=Naik, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])]}
--------------------------------------------------------------------------------14
[rajesh, mahesh, kawali, koli]
--------------------------------------------------------------------------------15
[A, B, C]
--------------------------------------------------------------------------------16
4.25
--------------------------------------------------------------------------------17
-1444170382
301085490
1301493462
1469782393
--------------------------------------------------------------------------------18
{Kiran=[Employee(id=6, firstName=Kiran, lastName=Kamble, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar])], Vidya=[Employee(id=3, firstName=Vidya, lastName=Kawali, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM])], Keshav=[Employee(id=5, firstName=Keshav, lastName=Koli, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS])], Laksh=[Employee(id=8, firstName=Laksh, lastName=Kawali, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple])], Rajesh=[Employee(id=10, firstName=Rajesh, lastName=Nayak, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini]), Employee(id=1, firstName=Rajesh, lastName=Kawali, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini])], Mahesh=[Employee(id=2, firstName=Mahesh, lastName=Koli, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra])], Arjun=[Employee(id=7, firstName=Arjun, lastName=Naik, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])], Vikram=[Employee(id=4, firstName=Vikram, lastName=Konkal, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance])], Sachin=[Employee(id=9, firstName=Sachin, lastName=Gaikwad, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato])]}
--------------------------------------------------------------------------------19
0
1
2
--------------------------------------------------------------------------------20
{software=3, admin=4, hr=1, finance=2}
--------------------------------------------------------------------------------21
{software=3, admin=4, hr=1, finance=2}
--------------------------------------------------------------------------------22
Laksh
Mahesh
Vikram
--------------------------------------------------------------------------------23
{Keshav=software, Laksh=admin, Vikram=hr}
--------------------------------------------------------------------------------24
Laksh, Vikram, Keshav, Vidya, Mahesh, Sachin, Rajesh, Rajesh, Kiran, Arjun
--------------------------------------------------------------------------------25
[Employee(id=7, firstName=Arjun, lastName=Naik, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix]), Employee(id=5, firstName=Keshav, lastName=Koli, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS]), Employee(id=6, firstName=Kiran, lastName=Kamble, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar]), Employee(id=8, firstName=Laksh, lastName=Kawali, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple]), Employee(id=2, firstName=Mahesh, lastName=Koli, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra]), Employee(id=1, firstName=Rajesh, lastName=Kawali, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini]), Employee(id=10, firstName=Rajesh, lastName=Nayak, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini]), Employee(id=9, firstName=Sachin, lastName=Gaikwad, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato]), Employee(id=3, firstName=Vidya, lastName=Kawali, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM]), Employee(id=4, firstName=Vikram, lastName=Konkal, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance])]
--------------------------------------------------------------------------------26
additionOptional: 14, addition: 14, multiplication: 120
--------------------------------------------------------------------------------27
Second highest salary of the employee: [Employee(id=2, firstName=Mahesh, lastName=Koli, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra])]
Third highest salary of the employee: Vikram
--------------------------------------------------------------------------------28
[Koli, Kawali]
--------------------------------------------------------------------------------29
[Kamble, Naik, Koli, Kawali, Gaikwad, Konkal, Nayak]
--------------------------------------------------------------------------------30
--------------------------------------------------------------------------------31
--------------------------------------------------------------------------------32
java.util.stream.ReferencePipeline$4@3b81a1bc
java.util.stream.SortedOps$OfInt@64616ca2
java.util.stream.SliceOps$2@13fee20c
java.util.stream.SliceOps$2@4e04a765
java.util.stream.IntPipeline$9@180bc464
java.util.stream.IntPipeline$4@62043840
java.util.stream.IntPipeline$1@5315b42e
9
28
OptionalDouble[3.111111111111111]
OptionalInt[7]
OptionalInt[0]
java.util.stream.IntPipeline$8@12843fce
--------------------------------------------------------------------------------
1
2
3
4

 */
