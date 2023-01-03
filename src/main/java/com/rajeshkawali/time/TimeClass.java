package com.rajeshkawali.time;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author Rajesh_Kawali
 *
 */
public class TimeClass {

	public static void main(String[] args) {
		LocalTime time = LocalTime.now();
		System.out.println("Time: "+time);
		int hour = time.getHour();
		int min = time.getMinute();
		int sec = time.getSecond();
		int nanoSec = time.getNano();
		System.out.println("----------------------------------------");
		System.out.println("Hour: "+hour);
		System.out.println("Minute: "+min);
		System.out.println("Second: "+sec);
		System.out.println("Nano Second: "+nanoSec);
		System.out.println("----------------------------------------");
		LocalTime currTime = LocalTime.now();
		LocalTime t1 = LocalTime.of(5, 32, 44);
		LocalTime t2 = LocalTime.parse("05:32:44");
		System.out.println(currTime);
		System.out.println(t1);
		System.out.println(t2);
		System.out.println("----------------------------------------");
		LocalTime t11 = LocalTime.of(5, 33, 47);
		LocalTime t22 = t11.plus(2, ChronoUnit.HOURS);
		LocalTime t33 = t11.plus(10, ChronoUnit.MINUTES);
		System.out.println(t11);
		System.out.println(t22);
		System.out.println(t33);
		System.out.println("----------------------------------------");
		LocalTime time1 = LocalTime.of(6, 12, 14);
		LocalTime time2 = time1.plus(1, ChronoUnit.HOURS);
		boolean b = time1.isAfter(time2);
		System.out.println(b);
	}
}
//https://www.studytonight.com/java-examples/java-8-date-and-time-api