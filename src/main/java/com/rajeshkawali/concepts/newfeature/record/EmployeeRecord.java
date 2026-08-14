package com.rajeshkawali.concepts.newfeature.record;

import java.util.ArrayList;
import java.util.List;

// Records are implicitly final.
// public final record EmployeeRecord(...) {} // final is added automatically
record EmployeeRecord(int id, String name, List<String> skills) implements Printable {

	// Static field (Allowed)
	static String company = "MyCompany";

	// Static Initialization Block (Allowed)
	static {
		System.out.println("Employee Record Loaded...");
	}

	// Compact (Canonical) Constructor
	// Used for validation or normalization.
	public EmployeeRecord {

		if (id <= 0) {
			throw new IllegalArgumentException("Id must be positive.");
		}

		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}

		// Normalize input
		name = name.toUpperCase();

		// Defensive copy because List is mutable
		skills = new ArrayList<>(skills);
	}

	// Instance Method (Allowed)
	public String employeeInfo() {
		return id + " - " + name;
	}

	// Override generated method (Allowed)
	@Override
	public String toString() {
		return "Employee{id=" + id + ", name='" + name + '\'' + ", skills=" + skills + '}';
	}

	// Interface Method
	@Override
	public void print() {
		System.out.println("Employee : " + name);
	}

	// Static Method (Allowed)
	public static void displayCompany() {
		System.out.println(company);
	}

	// Override accessor to return defensive copy
	@Override
	public List<String> skills() {
		return new ArrayList<>(skills);
	}
    /*
    NOT ALLOWED

	1.Records cannot declare additional instance fields.
    private int age;        // Compilation Error

	2.No setters because records are immutable.
    public void setName(String name){
    }
    
	3.Records are final and cannot be inherited.
    class Manager extends Employee{
    }
    
    */
}

/*
✘ Cannot extend another class.
✘ Cannot be inherited (implicitly final).
✘ Cannot declare additional instance fields.
✘ No setter methods.
✘ Mutable components (List, Map, etc.) require defensive copies to maintain immutability.
*/