package com.rajeshkawali.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Rajesh_Kawali
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String phone;
	private int salary;
	private String department;
	private List<String> employmentHistory;
}