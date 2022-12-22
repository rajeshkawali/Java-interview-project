package com.rajeshkawali.stream.employee.optional;

import java.util.List;
import java.util.Optional;

import com.rajeshkawali.model.Employee;
import com.rajeshkawali.util.EmployeeDB;

/**
 * @author Rajesh_Kawali
 *
 */
public class OptionalExample {

	// Optional -->A container object which may or may not contain a non-null value.
	// If a value is present, isPresent() will return true and get() will return the value.
	//There are 3 static methods --> 1)empty 2)of 3)ofNullable
	public static void main(String[] args) {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Optional.empty() --> Which Returns an empty Optional instance. No value is present for this Optional.");
		// Optional.empty() --> Which Returns an empty Optional instance. No value is present for this Optional.
		Optional<Object> emptyOptional = Optional.empty();
		System.out.println(emptyOptional);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Optional.of() --> It must be non-null. Which will throw exception if provided values contain null(java.lang.NullPointerException).");
		// Optional.of() --> It must be non-null. Which will throw exception if provided values contain null(java.lang.NullPointerException).
		Optional<List<Employee>> employeeListNonNull = Optional.of(EmployeeDB.getAllEmployee());
		System.out.println(employeeListNonNull);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Optional.ofNullable() -->It can be null(Not throwing any exception). Returns an Optional describing the specified value, if non-null, otherwise returns an empty Optional.");
		// Optional.ofNullable() -->It can be null(Not throwing any exception). Returns an Optional describing the specified value, if non-null, otherwise returns an empty Optional.
		Optional<List<Employee>> employeeListWithNull = Optional.ofNullable(EmployeeDB.getAllEmployeeWithNull());
		System.out.println(employeeListWithNull);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("get() --> If value is present in this Optional, returns the value, otherwise throws NoSuchElementException");
		Optional<String> emailOptional = Optional.ofNullable(EmployeeDB.getEmployee().getEmail());
		System.out.println("Optional<String> -->"+emailOptional); // Optional[rajesh@gmail.com]
		if(emailOptional.isPresent()){
			System.out.println("Value is :"+emailOptional.get());// rajesh@gmail.com
		}
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("isPresent() -> This is used to check if value present in this Optional then return true, otherwise false.");
		Optional<String> emailNullOptional = Optional.ofNullable(EmployeeDB.getEmployeeWithNull().getEmail());
		System.out.println("Optional<String> -->"+emailNullOptional); // Optional.empty
		if(emailNullOptional.isPresent()){
			System.out.println("Value is :"+emailNullOptional.get());
		}
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("orElse() -> This is used to assign default value if value is not present in this Optional.");
		Optional<String> emailNullOrElse = Optional.ofNullable(EmployeeDB.getEmployeeWithNull().getEmail());
		System.out.println("Optional<String> -->"+emailNullOrElse.orElse("default value")); // default value
		if(emailNullOrElse.isPresent()){
			System.out.println("Value is :"+emailNullOrElse.get());
		} else {
			System.out.println("Value is :"+emailNullOrElse.orElse("If value of email is null then Print default value"));
		}
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("orElseGet(supplier) -> This is used to assign default value if value is not present in this Optional.");
		//If value of email is null then Print default value using orElseGet(supplier)"
		Optional<String> emailNullOrElseGet = Optional.ofNullable(EmployeeDB.getEmployeeWithNull().getEmail());
		System.out.println("Optional<String> -->"+emailNullOrElseGet.orElseGet(()->"default value")); // default value
		if(emailNullOrElseGet.isPresent()){
			System.out.println("Value is :"+emailNullOrElseGet.get());
		} else {
			System.out.println("Value is :"+emailNullOrElseGet.orElseGet(()-> "If value of email is null then Print default value"));
		}
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("orElseThrow() --> If value present, return the contained value, otherwise throw an exceptionto be created by the provided supplier.");
		//Optional<String> emailNullOrElseThrow = Optional.ofNullable(EmployeeDB.getEmployeeWithNull().getEmail());
		//System.out.println(emailNullOrElseThrow.orElseThrow(() -> new IllegalArgumentException("Value of the email is null, throw exception")));
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the employee using the name and get all the details of that employee.");
		Optional<Employee> employeeName = getEmployeeByName("Rajesh");
		System.out.println(employeeName);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the email in the list and get it with upper case.");
		String email = getEmployeeByEmailWithUpperCase("rajesh@gmail.com");
		System.out.println(email);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find the company in Employee nested List.");
		String company = getEmployeeByEmploymentHistory("Trimax");
		System.out.println(company);
		System.out.println("--------------------------------------------------------------------------------");

	}
	
	public static Optional<Employee> getEmployeeByName(String firstName) {
		List<Employee> employeeList = EmployeeDB.getAllEmployee();
		return Optional.of(employeeList.stream()
				//.parallel() // If List has duplicate names then we can't predict which name it will select using findAny()
				.filter(employee -> employee.getFirstName().equals(firstName)) // find the firstName in the employee list
				.findAny() // Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty. 
				.orElse(new Employee())); // or default values
	}
	
	public static String getEmployeeByEmailWithUpperCase(String email) {
		List<Employee> employeeList = EmployeeDB.getAllEmployee();
		return employeeList.stream()
				.filter(employee -> employee.getEmail().equals(email))
				.map(employee ->employee.getEmail().toUpperCase())
				.findFirst()// find the email in the employee list
				.orElseGet(()->"Not Found");
	}
	
	public static String getEmployeeByEmploymentHistory(String company) {
		List<Employee> employeeList = EmployeeDB.getAllEmployee();
		return employeeList.stream()
				.flatMap(employee ->employee.getEmploymentHistory().stream().filter(eh->eh.equals(company)))
				.findAny()// find the company in the employee list
				.orElseGet(()->"Not Found");
	}

}

/*
--------------------------------------------------------------------------------
Optional.empty() --> Which Returns an empty Optional instance. No value is present for this Optional.
Optional.empty
--------------------------------------------------------------------------------
Optional.of() --> It must be non-null. Which will throw exception if provided values contain null(java.lang.NullPointerException).
Optional[[Employee(id=1, firstName=Rajesh, lastName=Kawali, age=34, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini]), Employee(id=2, firstName=Mahesh, lastName=Koli, age=32, email=mahesh@gmail.com, phone=8990955230, salary=70000, department=admin, employmentHistory=[Dell, Yantra]), Employee(id=3, firstName=Vidya, lastName=Kawali, age=29, email=vidya@gmail.com, phone=9590955557, salary=28000, department=finance, employmentHistory=[BOM]), Employee(id=4, firstName=Vikram, lastName=Konkal, age=6, email=vikram@gmail.com, phone=7890955557, salary=50000, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance]), Employee(id=5, firstName=Keshav, lastName=Koli, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar, TCS]), Employee(id=6, firstName=Kiran, lastName=Kamble, age=35, email=kiran@gmail.com, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar]), Employee(id=7, firstName=Arjun, lastName=Naik, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix]), Employee(id=8, firstName=Laksh, lastName=Kawali, age=2, email=laksh@gmail.com, phone=9596555557, salary=120000, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple]), Employee(id=9, firstName=Sachin, lastName=Gaikwad, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=[Zomato]), Employee(id=10, firstName=Rajesh, lastName=Nayak, age=33, email=rajesh@gmail.com, phone=9590955337, salary=30000, department=admin, employmentHistory=[Capgemini])]]
--------------------------------------------------------------------------------
Optional.ofNullable() -->It can be null(Not throwing any exception). Returns an Optional describing the specified value, if non-null, otherwise returns an empty Optional.
Optional[[Employee(id=1, firstName=Rajesh, lastName=Kawali, age=34, email=rajesh@gmail.com, phone=9590955557, salary=25000, department=software, employmentHistory=[Trimax, Diebold, Capgemini]), Employee(id=2, firstName=Mahesh, lastName=Koli, age=32, email=mahesh@gmail.com, phone=8990955230, salary=70000, department=admin, employmentHistory=null), Employee(id=3, firstName=Vidya, lastName=Kawali, age=23, email=vidya@gmail.com, phone=null, salary=28000, department=finance, employmentHistory=[BOM]), Employee(id=4, firstName=Vikram, lastName=null, age=6, email=vikram@gmail.com, phone=null, salary=0, department=hr, employmentHistory=[Accenture, Morgan, TCS, Reliance]), Employee(id=5, firstName=Keshav, lastName=Koli, age=24, email=keshav@gmail.com, phone=8590923557, salary=15000, department=software, employmentHistory=[Xangar]), Employee(id=6, firstName=Kiran, lastName=Kamble, age=35, email=null, phone=9590955644, salary=50000, department=software, employmentHistory=[Takira, Trimax, Xangar]), Employee(id=7, firstName=Arjun, lastName=Naik, age=36, email=arjun@gmail.com, phone=8990955507, salary=35000, department=finance, employmentHistory=[IBM, Concentrix]), Employee(id=8, firstName=Laksh, lastName=Kawali, age=2, email=laksh@gmail.com, phone=null, salary=0, department=admin, employmentHistory=[Walmart, Microsoft, Amazon, Google, Apple]), Employee(id=9, firstName=Sachin, lastName=null, age=33, email=sachin@gmail.com, phone=99855557, salary=10000, department=admin, employmentHistory=null), Employee(id=10, firstName=Rajesh, lastName=Kawali, age=22, email=rajesh@gmail.com, phone=9590955557, salary=25000, department=software, employmentHistory=[Trimax, Diebold, Capgemini])]]
--------------------------------------------------------------------------------
get() --> If value is present in this Optional, returns the value, otherwise throws NoSuchElementException
Optional<String> -->Optional[rajesh@gmail.com]
Value is :rajesh@gmail.com
--------------------------------------------------------------------------------
isPresent() -> This is used to check if value present in this Optional then return true, otherwise false.
Optional<String> -->Optional.empty
--------------------------------------------------------------------------------
orElse() -> This is used to assign default value if value is not present in this Optional.
Optional<String> -->default value
Value is :If value of email is null then Print default value
--------------------------------------------------------------------------------
orElseGet(supplier) -> This is used to assign default value if value is not present in this Optional.
Optional<String> -->default value
Value is :If value of email is null then Print default value
--------------------------------------------------------------------------------
orElseThrow() --> If value present, return the contained value, otherwise throw an exceptionto be created by the provided supplier.
--------------------------------------------------------------------------------
Find the employee using the name and get all the details of that employee.
Optional[Employee(id=1, firstName=Rajesh, lastName=Kawali, age=34, email=rajesh@gmail.com, phone=9590955557, salary=45000, department=software, employmentHistory=[Trimax, Diebold, Capgemini])]
--------------------------------------------------------------------------------
Find the email in the list and get it with upper case.
RAJESH@GMAIL.COM
--------------------------------------------------------------------------------
Find the company in Employee nested List.
Trimax
--------------------------------------------------------------------------------

*/