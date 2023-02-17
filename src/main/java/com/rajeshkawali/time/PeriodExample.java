package com.rajeshkawali.time;

import java.time.LocalDate;
import java.time.Period;
/**
 * @author Rajesh_Kawali
 *
 */
public class PeriodExample {
	public static void main(String[] args) {
		// Creating a period of 2 years, 3 months, and 4 days
		Period periodVar = Period.of(2, 3, 4);

		// Getting the number of years in the period
		int years1 = periodVar.getYears();
		System.out.println("Years: " + years1);

		// Getting the number of months in the period
		int months1 = periodVar.getMonths();
		System.out.println("Months: " + months1);

		// Getting the number of days in the period
		int days1 = periodVar.getDays();
		System.out.println("Days: " + days1);

		// Adding a period of 1 year, 2 months, and 3 days to the existing period
		Period newPeriod = periodVar.plusYears(1).plusMonths(2).plusDays(3);
		System.out.println("New Period: " + newPeriod);

		// Subtracting a period of 1 year, 2 months, and 3 days from the existing period
		Period newPeriod1 = periodVar.minusYears(1).minusMonths(2).minusDays(3);
		System.out.println("New Period: " + newPeriod1);

		// formatting the period
		System.out.println("Formatted Period: " + periodVar.toString());
		System.out.println("-------------------------------------------------------");
		// Create two LocalDate objects
        LocalDate date1 = LocalDate.of(2022, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 2, 15);
        
        // Create a Period object representing the time between the two dates
        Period period = Period.between(date1, date2);
        
        // Access individual parts of the period
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        System.out.println("Period between " + date1 + " and " + date2 + " is " + years + " years, " + months + " months, and " + days + " days");
        
        // Add and subtract periods from LocalDate objects
        LocalDate date3 = date1.plus(period);
        LocalDate date4 = date2.minus(period);
        System.out.println("Adding period to " + date1 + " results in " + date3);
        System.out.println("Subtracting period from " + date2 + " results in " + date4);
        
        // Check if a period is negative
        Period negativePeriod = Period.between(date2, date1);
        boolean isNegative = negativePeriod.isNegative();
        System.out.println("Is the period between " + date2 + " and " + date1 + " negative? " + isNegative);
        
        // Create a period using a string
        Period stringPeriod = Period.parse("P1Y2M3D");
        System.out.println("String period P1Y2M3D is " + stringPeriod);
		
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