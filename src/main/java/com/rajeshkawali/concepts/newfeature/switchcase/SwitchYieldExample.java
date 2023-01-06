package com.rajeshkawali.concepts.newfeature.switchcase;

import java.time.Month;

/**
 * @author Rajesh_Kawali
 *
 */
public class SwitchYieldExample {

	/*
	We can use the yield keyword in a switch expression in Java to specify a 
	value for a case and exit the switch expression early.The yield keyword is similar 
	to the break keyword, but it returns a value instead of exiting the switch.
	*/
	public static void main(String[] args) {
		int noOfDaysInMonth = 0;
		Month month = Month.APRIL;

		noOfDaysInMonth = switch (month) {
		case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> {
			System.out.println(month);
			yield 31;
		}
		case FEBRUARY -> {
			System.out.println(month);
			yield 28;
		}
		case APRIL, JUNE, SEPTEMBER, NOVEMBER -> {
			System.out.println(month);
			yield 30;
		}
		default -> throw new IllegalStateException();
		};
		System.out.println(noOfDaysInMonth);
	}
}