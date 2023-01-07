package com.rajeshkawali.stream.employee.question;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
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
		// Given the list of employees, find the employee with name "Mahesh"
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
		// Join the all employee names with "," using java 8?
		List<String> employeeNames = employeeList.stream().map(Employee::getFirstName).collect(Collectors.toList());
		String employeeNamesStr = String.join(",", employeeNames);
		System.out.println("Employees are: " + employeeNamesStr);
		String employeeNamesJoin = employeeList.stream().map(Employee::getFirstName).collect(Collectors.joining(", "));
		System.out.println("Employees are: " + employeeNamesJoin);
		System.out.println("--------------------------------------------------------------------------------6");
		// Given the list of employee, group them by employee gender ?
		Map<String, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender));
		map.forEach((name, employeeListTemp) -> System.out.println("Name: " + name + " ==>" + employeeListTemp));
		System.out.println("--------------------------------------------------------------------------------7");
		// Print all the Employment History(Which is in List of List)
		List<List<String>> employeePhone = employeeList.stream().map(Employee::getEmploymentHistory)
				.collect(Collectors.toList());
		System.out.println(employeePhone);
		System.out.println("--------------------------------------------------------------------------------8");
		// Print all the Unique Employment History in one List using flatMap(flattening)
		List<String> flatteredHistory = employeeList.stream()
				.flatMap(employee -> employee.getEmploymentHistory().stream()).distinct().collect(Collectors.toList());
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
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
		System.out.println(groupList);
		System.out.println("----------------------------------------");
		employeeList.stream()
		.collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.collectingAndThen(
				Collectors.maxBy(Comparator.comparingDouble(e -> e.getSalary())), Optional::get))).entrySet().forEach((v)->{
					System.out.println("Department = "+v.getKey()+", FirstName = "+v.getValue().getFirstName());
				});
		System.out.println("--------------------------------------------------------------------------------13");
		// Group by Department
		Map<String, List<Employee>> groupByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment()));
		System.out.println(groupByDepartment);
		System.out.println("--------------------------------------------------------------------------------14");
		// Retrieve the list of list using flatMap
		List<List<String>> dupList = Arrays.asList(
				Arrays.asList("rajesh","vidya","laksh"), 
				Arrays.asList("mahesh","chandru"),
				Arrays.asList("kawali"), 
				Arrays.asList("koli","shiva"));
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
		System.out.println("Count the number of employees in each department?");
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
		Map<String, String> emp = employeeList.stream().limit(6)
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
		System.out.println("How many male and female employees are there in the organization?");
		Map<String, Long> gender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(gender);
		System.out.println("--------------------------------------------------------------------------------31");
		System.out.println("Print the name of all departments in the organization?");
		List<String> dept = employeeList.stream().map(Employee::getDepartment).distinct().toList();
		System.out.println(dept);
		System.out.println("--------------------------------------------------------------------------------32");
		System.out.println("What is the average age of male and female employees?");
		Map<String, Double> genderMandF = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingLong(Employee::getAge)));
		System.out.println(genderMandF);
		System.out.println("--------------------------------------------------------------------------------33");
		System.out.println("Get the details of highest paid employee firstName in the organization?");
		Employee emphighestSalary =  employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(emphighestSalary.getFirstName());
		Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println(highestPaidEmployeeWrapper.get().getFirstName());
		System.out.println("--------------------------------------------------------------------------------34");
		System.out.println("Get the names of all employees who have age greater than 30?");
		employeeList.stream().filter(e -> e.getAge() > 30).map(Employee::getFirstName)
		.forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------------------35");
		System.out.println("What is the average salary of each department?");
		Map<String, Double> avgSalary = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingLong(Employee::getSalary)));
		System.out.println(avgSalary);
		System.out.println("--------------------------------------------------------------------------------36");
		System.out.println("Get the details of youngest male employee in the Software department?");
		Optional<Employee> youngestEmp = employeeList.stream().filter(d->d.getDepartment().equals("software"))
				.filter(g->g.getGender().equals("male")).collect(Collectors.minBy(Comparator.comparing(Employee::getAge)));
		System.out.println(youngestEmp.get());
		Employee youngestEmp2 = employeeList.stream().filter(e -> e.getGender()=="male" && e.getDepartment()=="software")
		.min(Comparator.comparingInt(Employee::getAge)).get();
		System.out.println(youngestEmp2.getFirstName());
		System.out.println("--------------------------------------------------------------------------------37");
		System.out.println("Get the details of Oldest employee in the admin department?");
		Optional<Employee> OldestEmp = employeeList.stream().filter(d->d.getDepartment().equals("admin"))
				.max(Comparator.comparing(Employee::getAge));
		System.out.println(OldestEmp.get());
		System.out.println("--------------------------------------------------------------------------------38");
		System.out.println("Who has worked in more organizations(more employmentHistory)?");
		Map<String, Long> empWorkHistory = employeeList.stream().collect(Collectors.groupingBy(Employee::getFirstName, 
				Collectors.flatMapping(e->e.getEmploymentHistory().stream(), Collectors.counting())));
		System.out.println(empWorkHistory);
		Map.Entry<String, Long> maxEntry = empWorkHistory.entrySet().stream()
			    .max(Comparator.comparingLong(Map.Entry::getValue))
			    .orElse(null);
		System.out.println(maxEntry.getKey() + ": " + maxEntry.getValue());
		System.out.println("--------------------------------------------------------------------------------39");
		System.out.println("How many male and female employees are there in the software team?");
		Map<String, Long> countMaleFemaleEmployeesInSoftware=
				employeeList.stream().filter(e -> e.getDepartment().equalsIgnoreCase("software"))
				            .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
				System.out.println(countMaleFemaleEmployeesInSoftware);
		System.out.println("--------------------------------------------------------------------------------40");
		System.out.println("What is the average salary of male and female employees?");
		Map<String, Double> avgSalaryOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgSalaryOfMaleAndFemaleEmployees);
		System.out.println("--------------------------------------------------------------------------------41");
		System.out.println("List FirstNames of all employees in each department?");
		Map<String, List<String>> namesOfEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getFirstName, Collectors.toList())));
		System.out.println(namesOfEmployees);		
		System.out.println("--------------------------------------------------------------------------------42");
		System.out.println("What is the average salary and total salary of the whole organization?");
		DoubleSummaryStatistics employeeSalaryStatistics=
				employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
				System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());
				System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());
		System.out.println("--------------------------------------------------------------------------------43");
		System.out.println("Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.");
		Map<Boolean, List<Employee>> employeesByAge = employeeList.stream()
			    .collect(Collectors.partitioningBy(e -> e.getAge() <= 25));
		List<Employee> youngerEmployees = employeesByAge.get(true);
		List<Employee> olderEmployees = employeesByAge.get(false);
		System.out.println("Younger employees: " + youngerEmployees);
		System.out.println("Older employees: " + olderEmployees);
		System.out.println("--------------------------------------------------------------------------------44");
		
		System.out.println("--------------------------------------------------------------------------------45");
		
		System.out.println("--------------------------------------------------------------------------------46");
		
		System.out.println("--------------------------------------------------------------------------------47");
		
		System.out.println("--------------------------------------------------------------------------------48");
		
		System.out.println("--------------------------------------------------------------------------------49");
		
		System.out.println("--------------------------------------------------------------------------------50");
		
		System.out.println("--------------------------------------------------------------------------------51");
		
		System.out.println("--------------------------------------------------------------------------------52");
		
		System.out.println("--------------------------------------------------------------------------------53");
		
		System.out.println("--------------------------------------------------------------------------------54");
		
		System.out.println("--------------------------------------------------------------------------------55");
		
		System.out.println("--------------------------------------------------------------------------------56");
		
		System.out.println("--------------------------------------------------------------------------------57");
		
		System.out.println("--------------------------------------------------------------------------------58");
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
		System.out.println("--------------------------------------------------------------------------------59");
		IntStream.range(1, 5).forEach(System.out::println); // Print 1 to 5 numbers
		IntStream.range(1, 5).toArray(); // collect into array
		IntStream.range(1, 5).boxed().collect(Collectors.toList()); // collect into List
		System.out.println("--------------------------------------------------------------------------------60");
	}
}
/*
[Rajesh, Mahesh, Vidya, Kiran, Arjun, Sachin, Rajesh]
--------------------------------------------------------------------------------1
Number of employees with age 25 are : 7
--------------------------------------------------------------------------------2
Employee(id=2, firstName=Mahesh, lastName=Koli, gender=male, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra])
--------------------------------------------------------------------------------3
Maximum age of Employee: 36
--------------------------------------------------------------------------------4
Employee(id=8, firstName=Laksh, lastName=Kawali, gender=male, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple])
Employee(id=4, firstName=Vikram, lastName=Konkal, gender=male, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance])
Employee(id=10, firstName=Arti, lastName=Pantigi, gender=female, age=21, email=arti@gmail.com, phone=9590955457, salary=18000, department=software, employmentHistory=[SBI, Axis])
Employee(id=5, firstName=Keshav, lastName=Koli, gender=male, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS])
Employee(id=3, firstName=Vidya, lastName=Kawali, gender=female, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM])
Employee(id=2, firstName=Mahesh, lastName=Koli, gender=male, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra])
Employee(id=9, firstName=Sachin, lastName=Gaikwad, gender=male, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato])
Employee(id=11, firstName=Rajesh, lastName=Nayak, gender=male, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini])
Employee(id=1, firstName=Rajesh, lastName=Kawali, gender=male, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini])
Employee(id=6, firstName=Kiran, lastName=Kamble, gender=male, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar])
Employee(id=7, firstName=Arjun, lastName=Naik, gender=male, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])
--------------------------------------------------------------------------------5
Employees are: Laksh,Vikram,Arti,Keshav,Vidya,Mahesh,Sachin,Rajesh,Rajesh,Kiran,Arjun
Employees are: Laksh, Vikram, Arti, Keshav, Vidya, Mahesh, Sachin, Rajesh, Rajesh, Kiran, Arjun
--------------------------------------------------------------------------------6
Name: female ==>[Employee(id=10, firstName=Arti, lastName=Pantigi, gender=female, age=21, email=arti@gmail.com, phone=9590955457, salary=18000, department=software, employmentHistory=[SBI, Axis]), Employee(id=3, firstName=Vidya, lastName=Kawali, gender=female, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM])]
Name: male ==>[Employee(id=8, firstName=Laksh, lastName=Kawali, gender=male, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple]), Employee(id=4, firstName=Vikram, lastName=Konkal, gender=male, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance]), Employee(id=5, firstName=Keshav, lastName=Koli, gender=male, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS]), Employee(id=2, firstName=Mahesh, lastName=Koli, gender=male, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra]), Employee(id=9, firstName=Sachin, lastName=Gaikwad, gender=male, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato]), Employee(id=11, firstName=Rajesh, lastName=Nayak, gender=male, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini]), Employee(id=1, firstName=Rajesh, lastName=Kawali, gender=male, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini]), Employee(id=6, firstName=Kiran, lastName=Kamble, gender=male, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar]), Employee(id=7, firstName=Arjun, lastName=Naik, gender=male, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])]
--------------------------------------------------------------------------------7
[[Walmart, Microsoft, Amazon, Google, Apple], [Accenture, Morgan, TCS, Reliance], [SBI, Axis], [Xangar, TCS], [BOM], [Dell, Yantra], [Zomato], [Capgemini], [Trimax, Diebold, Capgemini], [Takira, Trimax, Xangar], [IBM, Concentrix]]
--------------------------------------------------------------------------------8
[Walmart, Microsoft, Amazon, Google, Apple, Accenture, Morgan, TCS, Reliance, SBI, Axis, Xangar, BOM, Dell, Yantra, Zomato, Capgemini, Trimax, Diebold, Takira, IBM, Concentrix]
--------------------------------------------------------------------------------9
[BOM, Dell, Apple, TCS, IBM, SBI, Axis]
--------------------------------------------------------------------------------10
[laksh@yahoo.com, vikram@yahoo.com, mahesh@yahoo.com, rajesh@yahoo.com]
--------------------------------------------------------------------------------11
{software=4, admin=4, hr=1, finance=2}
--------------------------------------------------------------------------------12
{software=Employee(id=6, firstName=Kiran, lastName=Kamble, gender=male, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar]), admin=Employee(id=8, firstName=Laksh, lastName=Kawali, gender=male, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple]), hr=Employee(id=4, firstName=Vikram, lastName=Konkal, gender=male, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance]), finance=Employee(id=7, firstName=Arjun, lastName=Naik, gender=male, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])}
----------------------------------------
Department = software, FirstName = Kiran
Department = admin, FirstName = Laksh
Department = hr, FirstName = Vikram
Department = finance, FirstName = Arjun
--------------------------------------------------------------------------------13
{software=[Employee(id=10, firstName=Arti, lastName=Pantigi, gender=female, age=21, email=arti@gmail.com, phone=9590955457, salary=18000, department=software, employmentHistory=[SBI, Axis]), Employee(id=5, firstName=Keshav, lastName=Koli, gender=male, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS]), Employee(id=1, firstName=Rajesh, lastName=Kawali, gender=male, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini]), Employee(id=6, firstName=Kiran, lastName=Kamble, gender=male, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar])], admin=[Employee(id=8, firstName=Laksh, lastName=Kawali, gender=male, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple]), Employee(id=2, firstName=Mahesh, lastName=Koli, gender=male, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra]), Employee(id=9, firstName=Sachin, lastName=Gaikwad, gender=male, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato]), Employee(id=11, firstName=Rajesh, lastName=Nayak, gender=male, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini])], hr=[Employee(id=4, firstName=Vikram, lastName=Konkal, gender=male, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance])], finance=[Employee(id=3, firstName=Vidya, lastName=Kawali, gender=female, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM]), Employee(id=7, firstName=Arjun, lastName=Naik, gender=male, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])]}
--------------------------------------------------------------------------------14
[rajesh, vidya, laksh, mahesh, chandru, kawali, koli, shiva]
--------------------------------------------------------------------------------15
[A, B, C]
--------------------------------------------------------------------------------16
4.25
--------------------------------------------------------------------------------17
-1691505469
-952354924
241215667
2010215056
--------------------------------------------------------------------------------18
{Kiran=[Employee(id=6, firstName=Kiran, lastName=Kamble, gender=male, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar])], Vidya=[Employee(id=3, firstName=Vidya, lastName=Kawali, gender=female, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM])], Keshav=[Employee(id=5, firstName=Keshav, lastName=Koli, gender=male, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS])], Laksh=[Employee(id=8, firstName=Laksh, lastName=Kawali, gender=male, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple])], Rajesh=[Employee(id=11, firstName=Rajesh, lastName=Nayak, gender=male, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini]), Employee(id=1, firstName=Rajesh, lastName=Kawali, gender=male, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini])], Arti=[Employee(id=10, firstName=Arti, lastName=Pantigi, gender=female, age=21, email=arti@gmail.com, phone=9590955457, salary=18000, department=software, employmentHistory=[SBI, Axis])], Mahesh=[Employee(id=2, firstName=Mahesh, lastName=Koli, gender=male, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra])], Arjun=[Employee(id=7, firstName=Arjun, lastName=Naik, gender=male, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])], Vikram=[Employee(id=4, firstName=Vikram, lastName=Konkal, gender=male, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance])], Sachin=[Employee(id=9, firstName=Sachin, lastName=Gaikwad, gender=male, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato])]}
--------------------------------------------------------------------------------19
0
1
2
--------------------------------------------------------------------------------20
Count the number of employees in each department?
{software=4, admin=4, hr=1, finance=2}
--------------------------------------------------------------------------------21
{software=4, admin=4, hr=1, finance=2}
--------------------------------------------------------------------------------22
Laksh
Mahesh
Vikram
--------------------------------------------------------------------------------23
{Keshav=software, Vidya=finance, Laksh=admin, Arti=software, Mahesh=admin, Vikram=hr}
--------------------------------------------------------------------------------24
Laksh, Vikram, Arti, Keshav, Vidya, Mahesh, Sachin, Rajesh, Rajesh, Kiran, Arjun
--------------------------------------------------------------------------------25
[Employee(id=7, firstName=Arjun, lastName=Naik, gender=male, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix]), Employee(id=10, firstName=Arti, lastName=Pantigi, gender=female, age=21, email=arti@gmail.com, phone=9590955457, salary=18000, department=software, employmentHistory=[SBI, Axis]), Employee(id=5, firstName=Keshav, lastName=Koli, gender=male, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS]), Employee(id=6, firstName=Kiran, lastName=Kamble, gender=male, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar]), Employee(id=8, firstName=Laksh, lastName=Kawali, gender=male, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple]), Employee(id=2, firstName=Mahesh, lastName=Koli, gender=male, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra]), Employee(id=1, firstName=Rajesh, lastName=Kawali, gender=male, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini]), Employee(id=11, firstName=Rajesh, lastName=Nayak, gender=male, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini]), Employee(id=9, firstName=Sachin, lastName=Gaikwad, gender=male, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato]), Employee(id=3, firstName=Vidya, lastName=Kawali, gender=female, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM]), Employee(id=4, firstName=Vikram, lastName=Konkal, gender=male, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance])]
--------------------------------------------------------------------------------26
additionOptional: 14, addition: 14, multiplication: 120
--------------------------------------------------------------------------------27
Second highest salary of the employee: [Employee(id=2, firstName=Mahesh, lastName=Koli, gender=male, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra])]
Third highest salary of the employee: Vikram
--------------------------------------------------------------------------------28
[Koli, Kawali]
--------------------------------------------------------------------------------29
[Kamble, Naik, Koli, Kawali, Gaikwad, Konkal, Pantigi, Nayak]
--------------------------------------------------------------------------------30
How many male and female employees are there in the organization?
{female=2, male=9}
--------------------------------------------------------------------------------31
Print the name of all departments in the organization?
[admin, hr, software, finance]
--------------------------------------------------------------------------------32
What is the average age of male and female employees?
{female=25.0, male=26.444444444444443}
--------------------------------------------------------------------------------33
Get the details of highest paid employee firstName in the organization?
Laksh
Laksh
--------------------------------------------------------------------------------34
Get the names of all employees who have age greater than 30?
Mahesh
Sachin
Rajesh
Rajesh
Kiran
Arjun
--------------------------------------------------------------------------------35
What is the average salary of each department?
{software=32000.0, admin=57500.0, hr=50000.0, finance=31500.0}
--------------------------------------------------------------------------------36
Get the details of youngest male employee in the Software department?
Employee(id=5, firstName=Keshav, lastName=Koli, gender=male, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS])
Keshav
--------------------------------------------------------------------------------37
Get the details of Oldest employee in the admin department?
Employee(id=2, firstName=Mahesh, lastName=Koli, gender=male, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra])
--------------------------------------------------------------------------------38
Who has worked in more organizations(more employmentHistory)?
{Kiran=3, Vidya=1, Keshav=2, Laksh=5, Rajesh=4, Arti=2, Mahesh=2, Arjun=2, Vikram=4, Sachin=1}
Laksh: 5
--------------------------------------------------------------------------------39
How many male and female employees are there in the software team?
{female=1, male=3}
--------------------------------------------------------------------------------40
What is the average salary of male and female employees?
{female=23000.0, male=47222.22222222222}
--------------------------------------------------------------------------------41
List FirstNames of all employees in each department?
{software=[Arti, Keshav, Rajesh, Kiran], admin=[Laksh, Mahesh, Sachin, Rajesh], hr=[Vikram], finance=[Vidya, Arjun]}
--------------------------------------------------------------------------------42
What is the average salary and total salary of the whole organization?
Average Salary = 42818.181818181816
Total Salary = 471000.0
--------------------------------------------------------------------------------43
Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
Younger employees: [Employee(id=8, firstName=Laksh, lastName=Kawali, gender=male, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple]), Employee(id=4, firstName=Vikram, lastName=Konkal, gender=male, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance]), Employee(id=10, firstName=Arti, lastName=Pantigi, gender=female, age=21, email=arti@gmail.com, phone=9590955457, salary=18000, department=software, employmentHistory=[SBI, Axis]), Employee(id=5, firstName=Keshav, lastName=Koli, gender=male, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS])]
Older employees: [Employee(id=3, firstName=Vidya, lastName=Kawali, gender=female, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM]), Employee(id=2, firstName=Mahesh, lastName=Koli, gender=male, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra]), Employee(id=9, firstName=Sachin, lastName=Gaikwad, gender=male, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato]), Employee(id=11, firstName=Rajesh, lastName=Nayak, gender=male, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini]), Employee(id=1, firstName=Rajesh, lastName=Kawali, gender=male, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini]), Employee(id=6, firstName=Kiran, lastName=Kamble, gender=male, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar]), Employee(id=7, firstName=Arjun, lastName=Naik, gender=male, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])]
--------------------------------------------------------------------------------44
--------------------------------------------------------------------------------45
--------------------------------------------------------------------------------46
--------------------------------------------------------------------------------47
--------------------------------------------------------------------------------48
--------------------------------------------------------------------------------49
--------------------------------------------------------------------------------50
--------------------------------------------------------------------------------51
--------------------------------------------------------------------------------52
--------------------------------------------------------------------------------53
--------------------------------------------------------------------------------54
--------------------------------------------------------------------------------55
--------------------------------------------------------------------------------56
--------------------------------------------------------------------------------57
--------------------------------------------------------------------------------58
java.util.stream.ReferencePipeline$4@694f9431
java.util.stream.SortedOps$OfInt@f2a0b8e
java.util.stream.SliceOps$2@593634ad
java.util.stream.SliceOps$2@20fa23c1
java.util.stream.IntPipeline$10@2530c12
java.util.stream.IntPipeline$4@7e0b37bc
java.util.stream.IntPipeline$1@3b95a09c
9
28
OptionalDouble[3.111111111111111]
OptionalInt[7]
OptionalInt[0]
java.util.stream.IntPipeline$9@5fcfe4b2
--------------------------------------------------------------------------------59
1
2
3
4
--------------------------------------------------------------------------------60


 */
