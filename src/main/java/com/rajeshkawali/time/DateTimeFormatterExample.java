package com.rajeshkawali.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Rajesh_Kawali
 *
 */
public class DateTimeFormatterExample {
	public static void main(String[] args) {
		// Create a LocalDateTime object
		LocalDateTime now = LocalDateTime.now();

		// Format the LocalDateTime object using DateTimeFormatter
		String format1 = now.format(DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("Basic ISO date format: " + format1);

		String format2 = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println("ISO local date and time format: " + format2);

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String format3 = now.format(formatter1);
		System.out.println("Custom date and time format: " + format3);

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
		String format4 = now.format(formatter2);
		System.out.println("Custom date format: " + format4);

		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("hh:mm a");
		String format5 = now.format(formatter3);
		System.out.println("Custom time format: " + format5);

		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dateStr = "24/12/2022";
		LocalDateTime date = LocalDate.parse(dateStr, formatter4).atStartOfDay();
		System.out.println("Parsed date: " + date);

		String dateStr2 = "24-12-2022 00:00:00";
		DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime date2 = LocalDateTime.parse(dateStr2, formatter6);
		System.out.println("Parsed date with time set to midnight: " + date2);

		DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String dateTimeStr = "24/12/2022 19:30";
		LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter5);
		System.out.println("Parsed date and time: " + dateTime);

	}
}
