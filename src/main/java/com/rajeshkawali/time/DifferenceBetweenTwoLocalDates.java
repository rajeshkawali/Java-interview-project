package com.rajeshkawali.time;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Rajesh_Kawali
 *
 */
public class DifferenceBetweenTwoLocalDates {

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = d1.plusDays(10).plusMonths(5).plusYears(1); // This will add to current date time
		
		int days = Period.between(d1, d2).getDays();
		int months = Period.between(d1, d2).getMonths();
		int years = Period.between(d1, d2).getYears();
		
		System.out.println("Initial Date: " + d1 + " Final Date " + d2);
		System.out.println("Difference in Days: " + days);
		System.out.println("Difference in Months: " + months);
		System.out.println("Difference in Years: " + years);
		System.out.println("------------------------------------------");
		
		System.out.println("------------------------------------------");
	}

}
