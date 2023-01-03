package com.rajeshkawali.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Rajesh_Kawali
 *
 */
public class ConversionBetweenOldAndNewClasses {

	public static void main(String[] args) {

		Date d = new Date(); // Old Date
		Calendar c = Calendar.getInstance(); // Old Calendar

		LocalDateTime dateTime1 = LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
		LocalDateTime dateTime2 = LocalDateTime.ofInstant(c.toInstant(), ZoneId.systemDefault());

		System.out.println(dateTime1);
		System.out.println(dateTime2);
	}

}
