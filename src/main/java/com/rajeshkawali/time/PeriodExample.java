package com.rajeshkawali.time;

import java.time.Period;

public class PeriodExample {
	public static void main(String[] args) {
		// Creating a period of 2 years, 3 months, and 4 days
		Period period = Period.of(2, 3, 4);

		// Getting the number of years in the period
		int years = period.getYears();
		System.out.println("Years: " + years);

		// Getting the number of months in the period
		int months = period.getMonths();
		System.out.println("Months: " + months);

		// Getting the number of days in the period
		int days = period.getDays();
		System.out.println("Days: " + days);

		// Adding a period of 1 year, 2 months, and 3 days to the existing period
		Period newPeriod = period.plusYears(1).plusMonths(2).plusDays(3);
		System.out.println("New Period: " + newPeriod);

		// Subtracting a period of 1 year, 2 months, and 3 days from the existing period
		Period newPeriod1 = period.minusYears(1).minusMonths(2).minusDays(3);
		System.out.println("New Period: " + newPeriod1);

		// formatting the period
		System.out.println("Formatted Period: " + period.toString());
	}
}
/*
Period class is a part of the Java Date and Time API (JSR-310), 
which was introduced in Java 8. The Period class represents a 
quantity or amount of time in terms of years, months, and days. 
It is used to represent a duration of time, such as "2 years, 3 months, and 4 days." 
The Period class is immutable, meaning that once it is created, its value cannot be changed. 
It provides various methods for working with periods, such as adding or subtracting time, 
comparing periods, and formatting them as strings.
*/