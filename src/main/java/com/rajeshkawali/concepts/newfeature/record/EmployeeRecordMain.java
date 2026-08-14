package com.rajeshkawali.concepts.newfeature.record;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRecordMain {

	public static void main(String[] args) {

		List<String> skills = new ArrayList<>();
		skills.add("Java");
		skills.add("Spring");

		EmployeeRecord emp = new EmployeeRecord(101, "John", skills);

		System.out.println("-------------------------");
		// Auto-generated Accessor Methods
		System.out.println(emp.id());
		System.out.println(emp.name());
		System.out.println("-------------------------");
		// Custom Instance Method
		System.out.println(emp.employeeInfo());
		System.out.println("-------------------------");
		// Overridden toString()
		System.out.println(emp);
		System.out.println("-------------------------");
		// Interface Method
		emp.print();
		System.out.println("-------------------------");
		// Static Method
		EmployeeRecord.displayCompany();
		System.out.println("-------------------------");
		// equals() generated automatically
		EmployeeRecord emp2 = new EmployeeRecord(101, "John", skills);
		System.out.println(emp.equals(emp2));
		System.out.println("-------------------------");
		// hashCode() generated automatically
		System.out.println(emp.hashCode());
		System.out.println("-------------------------");
		// Defensive Copy Demo
		skills.add("Docker");
		// Original record remains unchanged
		System.out.println(emp);
		System.out.println("-------------------------");
		List<String> list = emp.skills();
		list.add("AWS");
		// Again, record remains unchanged
		System.out.println(emp);
	}
}