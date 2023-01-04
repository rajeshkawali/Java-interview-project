package com.rajeshkawali.stream.employee.grouping;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
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
		System.out.println("Group the employees by their department and find the highest salary in each group");
        Map<String, Employee> highestSalariesByDepartment = employeeList.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                    Optional::get)));
        System.out.println("Highest salaries by department: " + highestSalariesByDepartment);
		System.out.println("--------------------------------------------------------------------------------");

		System.out.println("--------------------------------------------------------------------------------");

	}
}

/*
--------------------------------------------------------------------------------
Group by Department

{software=[Employee(id=1, firstName=Rajesh, lastName=Kawali, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini]), Employee(id=5, firstName=Keshav, lastName=Koli, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS]), Employee(id=6, firstName=Kiran, lastName=Kamble, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar])], admin=[Employee(id=2, firstName=Mahesh, lastName=Koli, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra]), Employee(id=8, firstName=Laksh, lastName=Kawali, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple]), Employee(id=9, firstName=Sachin, lastName=Gaikwad, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato]), Employee(id=10, firstName=Rajesh, lastName=Nayak, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini])], hr=[Employee(id=4, firstName=Vikram, lastName=Konkal, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance])], finance=[Employee(id=3, firstName=Vidya, lastName=Kawali, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM]), Employee(id=7, firstName=Arjun, lastName=Naik, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])]}
--------------------------------------------------------------------------------
Get all the employees in each department with employee count

{software=3, admin=4, hr=1, finance=2}
--------------------------------------------------------------------------------
Given the list of employees, group them by employee last name.

Name: Naik ==>[Employee(id=7, firstName=Arjun, lastName=Naik, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])]
Name: Kamble ==>[Employee(id=6, firstName=Kiran, lastName=Kamble, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar])]
Name: Koli ==>[Employee(id=2, firstName=Mahesh, lastName=Koli, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra]), Employee(id=5, firstName=Keshav, lastName=Koli, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS])]
Name: Gaikwad ==>[Employee(id=9, firstName=Sachin, lastName=Gaikwad, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato])]
Name: Kawali ==>[Employee(id=1, firstName=Rajesh, lastName=Kawali, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini]), Employee(id=3, firstName=Vidya, lastName=Kawali, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM]), Employee(id=8, firstName=Laksh, lastName=Kawali, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple])]
Name: Konkal ==>[Employee(id=4, firstName=Vikram, lastName=Konkal, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance])]
Name: Nayak ==>[Employee(id=10, firstName=Rajesh, lastName=Nayak, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini])]
--------------------------------------------------------------------------------
Print highest paid salary of an employee from each department (for minimum paid salary use minBy() instead maxBy() ).

{software=Employee(id=6, firstName=Kiran, lastName=Kamble, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar]), admin=Employee(id=8, firstName=Laksh, lastName=Kawali, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple]), hr=Employee(id=4, firstName=Vikram, lastName=Konkal, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance]), finance=Employee(id=7, firstName=Arjun, lastName=Naik, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])}
--------------------------------------------------------------------------------
Get all the employees Employment History with join comma

{Accenture, Morgan, TCS, Reliance=[Employee(id=4, firstName=Vikram, lastName=Konkal, age=6, email=vikram@yahoo.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance])], BOM=[Employee(id=3, firstName=Vidya, lastName=Kawali, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM])], Zomato=[Employee(id=9, firstName=Sachin, lastName=Gaikwad, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato])], Dell, Yantra=[Employee(id=2, firstName=Mahesh, lastName=Koli, age=33, email=mahesh@yahoo.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra])], Trimax, Diebold, Capgemini=[Employee(id=1, firstName=Rajesh, lastName=Kawali, age=35, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini])], Takira, Trimax, Xangar=[Employee(id=6, firstName=Kiran, lastName=Kamble, age=36, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar])], Walmart, Microsoft, Amazon, Google, Apple=[Employee(id=8, firstName=Laksh, lastName=Kawali, age=2, email=laksh@yahoo.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple])], IBM, Concentrix=[Employee(id=7, firstName=Arjun, lastName=Naik, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix])], Capgemini=[Employee(id=10, firstName=Rajesh, lastName=Nayak, age=33, email=rajesh@yahoo.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini])], Xangar, TCS=[Employee(id=5, firstName=Keshav, lastName=Koli, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS])]}
--------------------------------------------------------------------------------
Print employee highest salary of first 2 employees.

[Laksh, Mahesh]
--------------------------------------------------------------------------------
Print all employee first name group by age.

{33=[Mahesh, Sachin, Rajesh], 2=[Laksh], 35=[Rajesh], 36=[Kiran, Arjun], 6=[Vikram], 24=[Keshav], 29=[Vidya]}
--------------------------------------------------------------------------------
Print all employee first name group by age with age ascending.

{2=[Laksh], 6=[Vikram], 24=[Keshav], 29=[Vidya], 33=[Mahesh, Sachin, Rajesh], 35=[Rajesh], 36=[Kiran, Arjun]}
--------------------------------------------------------------------------------
Find the number of time each character occur.

{a=3, r=1, b=2, s=1, c=2, d=2, e=3, f=2, h=1, j=1}
--------------------------------------------------------------------------------
Find the number of time each number occur.

{1=3, 2=4, 3=1, 4=2}
--------------------------------------------------------------------------------
Find the first non repeated character in given string.

r=1
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------

 */

