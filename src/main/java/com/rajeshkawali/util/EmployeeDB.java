package com.rajeshkawali.util;

import java.util.Arrays;
import java.util.List;

import com.rajeshkawali.model.Employee;

/**
 * @author Rajesh_Kawali
 *
 */
public class EmployeeDB {

	public static List<Employee> getAllEmployee() {
		List<Employee> employeeList = Arrays.asList(
				new Employee(1, "Rajesh", "Kawali", 35, "rajesh@gmail.com", "9590955557", 45000, "software", Arrays.asList("Trimax", "Diebold", "Capgemini")),
				new Employee(2, "Mahesh", "Koli", 33, "mahesh@yahoo.com", "8990955230", 70000, "admin", Arrays.asList("Dell", "Yantra")),
				new Employee(3, "Vidya", "Kawali", 29, "vidya@gmail.com", "9590955557", 28000, "finance", Arrays.asList("BOM")),
				new Employee(4, "Vikram", "Konkal", 6, "vikram@yahoo.com", "7890955557", 50000, "hr", Arrays.asList("Accenture", "Morgan", "TCS", "Reliance")),
				new Employee(5, "Keshav", "Koli", 24, "keshav@gmail.com", "8590923557", 15000, "software", Arrays.asList("Xangar", "TCS")),
				new Employee(6, "Kiran", "Kamble", 36, "kiran@gmail.com", "9590955644", 50000, "software", Arrays.asList("Takira", "Trimax", "Xangar")),
				new Employee(7, "Arjun", "Naik", 36, "arjun@gmail.com", "8990955507", 35000, "finance", Arrays.asList("IBM", "Concentrix")),
				new Employee(8, "Laksh", "Kawali", 2, "laksh@yahoo.com", "9596555557", 120000, "admin", Arrays.asList("Walmart", "Microsoft", "Amazon", "Google", "Apple")),
				new Employee(9, "Sachin", "Gaikwad", 33, "sachin@gmail.com", "99855557", 10000, "admin", Arrays.asList("Zomato")),
				new Employee(10, "Rajesh", "Nayak", 33, "rajesh@yahoo.com", "9590955337", 30000, "admin", Arrays.asList("Capgemini")));
		return employeeList;
	}
	
	public static List<Employee> getAllEmployeeWithNull() {
		List<Employee> employeeList = Arrays.asList(
				new Employee(1, "Rajesh", "Kawali", 34, "rajesh@gmail.com", "9590955557", 25000, "software", Arrays.asList("Trimax", "Diebold", "Capgemini")),
				new Employee(2, "Mahesh", "Koli", 32, "mahesh@gmail.com", "8990955230", 70000, "admin", null),
				new Employee(3, "Vidya", "Kawali", 23, "vidya@gmail.com", null, 28000, "finance", Arrays.asList("BOM")),
				new Employee(4, "Vikram", null, 6, "vikram@gmail.com", null, 0, "hr", Arrays.asList("Accenture", "Morgan", "TCS", "Reliance")),
				new Employee(5, "Keshav", "Koli", 24, "keshav@gmail.com", "8590923557", 15000, "software", Arrays.asList("Xangar")),
				new Employee(6, "Kiran", "Kamble", 35, null, "9590955644", 50000, "software", Arrays.asList("Takira", "Trimax", "Xangar")),
				new Employee(7, "Arjun", "Naik", 36, "arjun@gmail.com", "8990955507", 35000, "finance", Arrays.asList("IBM", "Concentrix")),
				new Employee(8, "Laksh", "Kawali", 2, "laksh@gmail.com", null, 0, "admin", Arrays.asList("Walmart", "Microsoft", "Amazon", "Google", "Apple")),
				new Employee(9, "Sachin", null, 33, "sachin@gmail.com", "99855557", 10000, "admin", null),
				new Employee(10, "Rajesh", "Kawali", 22, "rajesh@gmail.com", "9590955557", 25000, "software", Arrays.asList("Trimax", "Diebold", "Capgemini")));
		return employeeList;
	}
	
	public static Employee getEmployee() {
		return new Employee(1, "Rajesh", "Kawali", 34, "rajesh@gmail.com", "9590955557", 45000, "software", Arrays.asList("Trimax", "Diebold", "Capgemini"));
	}
	
	public static Employee getEmployeeWithNull() {
		return new Employee(1, "Rajesh", null, 34, null, "9590955557", 45000, "software", Arrays.asList(null, "Trimax", "Diebold", "Capgemini"));
	}
}
