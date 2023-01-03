package com.rajeshkawali.time;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author Rajesh_Kawali
 *
 */
public class DifferenceBetweenTwoLocalTimes {

	public static void main(String[] args) {
		
		LocalTime t1 = LocalTime.now();
		LocalTime t2 = t1.plusHours(10).plusMinutes(5).plusSeconds(15).plusNanos(499409922);

		long secs = Duration.between(t2, t1).getSeconds();
		int nano = Duration.between(t2, t1).getNano();

		System.out.println("Initial Time: " + t1 + ", Final Time: " + t2);
		System.out.println("Difference in Seconds: " + secs);
		System.out.println("Difference in Nano: " + nano);
		
		System.out.println("------------------------------------------");
		
		long hours = ChronoUnit.HOURS.between(t2, t1);
		long mins = ChronoUnit.MINUTES.between(t2, t1);
		long second = ChronoUnit.SECONDS.between(t2, t1);
		
		System.out.println("Initial Time: " + t1 + " Final Time: " + t2);
		System.out.println("Difference in Hours: " + hours);
		System.out.println("Difference in Minutes: " + mins);
		System.out.println("Difference in Seconds: " + second);
	}

}
