package com.rajeshkawali.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Rajesh_Kawali
 *
 */
public class DateTimeFormatterClass {

	public static void main(String[] args) {

		// will give us the current time and date
		LocalDateTime current = LocalDateTime.now();
		System.out.println("Current date and time: " + current);
		System.out.println("------------------------------------------");
		// to print in a particular format
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatedDateTime = current.format(format);
		System.out.println("Formatted Date Time: " + formatedDateTime);
		System.out.println("------------------------------------------");
		// printing some specified date
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.of(1947, 8, 15);
		System.out.println("Independence day :" + date.format(format2));
		System.out.println("------------------------------------------");
		LocalDate dateParse = LocalDate.parse("2021-09-24");
		System.out.println("Date parsed: " + dateParse);
		System.out.println("------------------------------------------");
		// printing date with current time.
		LocalDateTime specificDate = current.withNano(100000021).withSecond(47).withMinute(10).withHour(17).withMonth(9)
				.withYear(2021).withDayOfMonth(24);
		System.out.println("Specific date with current time : " + specificDate);
		System.out.println("------------------------------------------");
		String dateStr1 = current.format(DateTimeFormatter.ofPattern("dd ** MM ** YYYY"));
		System.out.print(dateStr1);
		System.out.println("------------------------------------------");
	}

}
