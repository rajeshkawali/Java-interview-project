package com.rajeshkawali.stream.employee.grouping;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.rajeshkawali.model.Employee;
import com.rajeshkawali.util.EmployeeDB;

/**
 * @author Rajesh_Kawali
 *
 */
public class StreamGrouping {

	public static void main(String[] args) {

		List<Employee> employeeList = EmployeeDB.getAllEmployee();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Group by Department\n");
		Map<String, List<Employee>> groupByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(groupByDepartment);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Get all the employees in each department with employee count\n");
		//Count the employee in each department
		Map<String, Long> deptCount = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(deptCount);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Given the list of employees, group them by employee last name.\n");
		Map<String, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getLastName));
		map.forEach((name, employeeListTemp) -> System.out.println("Name: " + name + " ==>" + employeeListTemp));
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Print highest paid salary of an employee from each department (for minimum paid salary use minBy() instead maxBy() ).\n");
		Map<String, Employee> groupList = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(emp -> emp.getSalary())), Optional::get)));
		System.out.println(groupList);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Get all the employees Employment History with join comma\n");
		Map<Object, List<Employee>> dept22Count = employeeList.stream()
				.collect(Collectors.groupingBy(employee -> employee.getEmploymentHistory().stream().collect(Collectors.joining(", "))));
		System.out.println(dept22Count);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Print employee highest salary of first 2 employees.\n");
		List<String> name = employeeList.stream()
				.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
				.limit(2)
				.map(Employee::getFirstName)
				.collect(Collectors.toList());
		System.out.println(name);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Print all employee first name group by age.\n");
		Map<Integer, List<String>> groupByAge = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getFirstName, Collectors.toList())));
		System.out.println(groupByAge);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Print all employee first name group by age with age ascending.\n");
		Map<Integer, List<String>> groupByAgeWithAsc = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getAge, TreeMap::new,Collectors.mapping(Employee::getFirstName, Collectors.toList())));
		System.out.println(groupByAgeWithAsc);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the number of time each character occur.\n");
		String str = "abcdefRajeshABCDef";
		Map<Character, Long> duplicateChar = str.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s)))
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(duplicateChar);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the number of time each number occur.\n");
		Integer num[] = {4,1,3,2,1,4,2,2,1,2};
		List<Integer> number = Arrays.asList(num);
		Map<Integer, Long> duplicateNumbers = number.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(duplicateNumbers);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the first non repeated character in given string.\n");
		String string = "abcdefRajeshABCDef";
		Entry<Character, Long> uniqueChar = string.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s)))
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().filter(v->v.getValue() == 1L)
		.findFirst().get();
		System.out.println(uniqueChar);
		System.out.println("--------------------------------------------------------------------------------");

		System.out.println("--------------------------------------------------------------------------------");

		System.out.println("--------------------------------------------------------------------------------");

	}
}
