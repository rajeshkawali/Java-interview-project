package com.rajeshkawali.time;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author Rajesh_Kawali
 *
 */
public class DateClass {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println("Date: " + date);

		int dayOfMonth = date.getDayOfMonth();
		int month = date.getMonthValue();
		int year = date.getYear();
		int dayOfYear = date.getDayOfYear();
		int lengthOfYear = date.lengthOfYear();
		int lengthOfMonth = date.lengthOfMonth();
		Month monthName = date.getMonth();
		System.out.println("------------------------------------------");
		System.out.println("dayOfMonth: " + dayOfMonth);
		System.out.println("month: " + month);
		System.out.println("year: " + year);
		System.out.println("dayOfYear: " + dayOfYear);
		System.out.println("lengthOfYear: " + lengthOfYear);
		System.out.println("lengthOfMonth: " + lengthOfMonth);
		System.out.println("monthName: " + monthName);
		System.out.println("------------------------------------------");
		System.out.println("Is a leap year : " + date.isLeapYear());
		System.out.println("------------------------------------------");
		LocalDate currDate = LocalDate.now();
		LocalDate tomorrow = currDate.plusDays(1);
		LocalDate yesterday = currDate.minusDays(1);
		System.out.println("Current date: " + currDate);
		System.out.println("Current date plus 1 day: " + tomorrow);
		System.out.println("Current date minus 1 day: " + yesterday);
		System.out.println("Current date is after yesterday's date: " + currDate.isAfter(yesterday));
		System.out.println("Current date is before tomorrow's date: " + currDate.isBefore(tomorrow));
		System.out.println("------------------------------------------");
		boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
		boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));
		System.out.println("notBefore: "+notBefore+", isAfter: "+isAfter);
		System.out.println("------------------------------------------");

		System.out.println("------------------------------------------");

	}
}

//https://www.studytonight.com/java-examples/java-8-date-and-time-api