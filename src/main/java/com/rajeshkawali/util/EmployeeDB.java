package com.rajeshkawali.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.rajeshkawali.model.Employee;
import com.rajeshkawali.model.Gender;

/**
 * @author Rajesh_Kawali
 *
 */
public class EmployeeDB {

	public static List<Employee> getAllEmployee() {
		List<Employee> employeeList = Arrays.asList(
				new Employee(1, "Rajesh", "Kawali",Gender.MALE, LocalDate.of(2015, 9, 9), 35, "rajesh@gmail.com", "9590955557", 45000, "software", Arrays.asList("Trimax", "Diebold", "Capgemini")),
				new Employee(2, "Mahesh", "Koli",Gender.MALE, LocalDate.of(1990, 5, 20), 33, "mahesh@yahoo.com", "8990955230", 70000, "admin", Arrays.asList("Dell", "Yantra")),
				new Employee(3, "Vidya", "Kawali",Gender.FEMALE, LocalDate.of(2008, 4, 10), 29, "vidya@gmail.com", "9590955557", 28000, "finance", Arrays.asList("BOM")),
				new Employee(4, "Vikram", "Konkal",Gender.MALE, LocalDate.of(2018, 1, 2), 6, "vikram@yahoo.com", "7890955557", 50000, "hr", Arrays.asList("Accenture", "Morgan", "TCS", "Reliance")),
				new Employee(5, "Keshav", "Koli",Gender.MALE, LocalDate.of(2021, 8, 20), 24, "keshav@gmail.com", "8590923557", 15000, "software", Arrays.asList("Xangar", "TCS")),
				new Employee(6, "Kiran", "Kamble",Gender.MALE, LocalDate.of(2014, 6, 30), 36, "kiran@gmail.com", "9590955644", 50000, "software", Arrays.asList("Takira", "Trimax", "Xangar")),
				new Employee(7, "Arjun", "Naik",Gender.MALE, LocalDate.of(2009, 7, 17), 36, "arjun@gmail.com", "8990955507", 35000, "finance", Arrays.asList("IBM", "Concentrix")),
				new Employee(8, "Laksh", "Kawali",Gender.MALE, LocalDate.of(2021, 9, 24), 2, "laksh@yahoo.com", "9596555557", 120000, "admin", Arrays.asList("Walmart", "Microsoft", "Amazon", "Google", "Apple")),
				new Employee(9, "Sachin", "Gaikwad",Gender.MALE, LocalDate.of(2002, 5, 10), 33, "sachin@gmail.com", "99855557", 10000, "admin", Arrays.asList("Zomato")),
				new Employee(10, "Arti", "Pantigi",Gender.FEMALE, LocalDate.of(2000, 5, 22), 21, "arti@gmail.com", "9590955457", 18000, "software", Arrays.asList("SBI","Axis")),
				new Employee(11, "Rajesh", "Nayak",Gender.MALE, LocalDate.of(2015, 9, 9), 33, "rajesh@yahoo.com", "9590955337", 30000, "admin", Arrays.asList("Capgemini")));
		return employeeList;
	}
	
	public static List<Employee> getAllEmployeeWithNull() {
		List<Employee> employeeList = Arrays.asList(
				new Employee(1, "Rajesh", "Kawali",Gender.MALE,LocalDate.of(2015, 9, 9), 34, "rajesh@gmail.com", "9590955557", 25000, "software", Arrays.asList("Trimax", "Diebold", "Capgemini")),
				new Employee(2, "Mahesh", "Koli",Gender.MALE,LocalDate.of(1990, 5, 20), 32, "mahesh@gmail.com", "8990955230", 70000, "admin", null),
				new Employee(3, "Vidya", "Kawali",Gender.FEMALE,LocalDate.of(2008, 4, 10), 23, "vidya@gmail.com", null, 28000, "finance", Arrays.asList("BOM")),
				new Employee(4, "Vikram", null,Gender.MALE, null, 6, "vikram@gmail.com", null, 0, "hr", Arrays.asList("Accenture", "Morgan", "TCS", "Reliance")),
				new Employee(5, "Keshav", "Koli",Gender.MALE,LocalDate.of(1990, 5, 23), 24, "keshav@gmail.com", "8590923557", 15000, "software", Arrays.asList("Xangar")),
				new Employee(6, "Kiran", "Kamble",Gender.MALE,LocalDate.of(1990, 5, 25), 35, null, "9590955644", 50000, "software", Arrays.asList("Takira", "Trimax", "Xangar")),
				new Employee(7, "Arjun", "Naik",Gender.MALE,LocalDate.of(2012, 5, 21), 36, "arjun@gmail.com", "8990955507", 35000, "finance", Arrays.asList("IBM", "Concentrix")),
				new Employee(8, "Laksh", "Kawali",Gender.MALE, null, 2, "laksh@gmail.com", null, 0, "admin", Arrays.asList("Walmart", "Microsoft", "Amazon", "Google", "Apple")),
				new Employee(9, "Sachin", null,Gender.MALE,LocalDate.of(2008, 6, 23), 33, "sachin@gmail.com", "99855557", 10000, "admin", null),
				new Employee(10, "Arti", "Pantigi",Gender.FEMALE,LocalDate.of(1999, 7, 20), 21, null, "9590955457", 18000, "finance", Arrays.asList("SBI","Axis")),
				new Employee(11, "Rajesh", "Kawali",Gender.MALE,LocalDate.of(2015, 9, 9), 22, "rajesh@gmail.com", "9590955557", 25000, "software", Arrays.asList("Trimax", "Diebold", "Capgemini")));
		return employeeList;
	}
	
	public static Employee getEmployee() {
		return new Employee(1, "Rajesh", "Kawali",Gender.MALE,LocalDate.of(2015, 5, 24), 34, "rajesh@gmail.com", "9590955557", 45000, "software", Arrays.asList("Trimax", "Diebold", "Capgemini"));
	}
	
	public static Employee getEmployeeWithNull() {
		return new Employee(1, "Rajesh", null, Gender.MALE, LocalDate.of(2015, 9, 20), 34, null, "9590955557", 45000, "software", Arrays.asList(null, "Trimax", "Diebold", "Capgemini"));
	}
}
