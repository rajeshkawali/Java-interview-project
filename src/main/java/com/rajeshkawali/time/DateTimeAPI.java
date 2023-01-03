package com.rajeshkawali.time;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * @author Rajesh_Kawali
 *
 */
public class DateTimeAPI {

	public static void main(String[] args) {

		LocalDateTime currDateTime = LocalDateTime.now();
		
		int hour = currDateTime.getHour();
		int dayOfMonth = currDateTime.getDayOfMonth();
		Month month = currDateTime.getMonth();
		
		System.out.println(currDateTime);
		System.out.println("Hour: " + hour);
		System.out.println("Day of Month: " + dayOfMonth);
		System.out.println("Month: " + month);
		
		//We can pass date time to this API
		LocalDateTime dateTime2 = LocalDateTime.of(2020, 06, 27, 20, 01, 47, 364623600);
		System.out.println(dateTime2);
		
		
		
		
	}
}
