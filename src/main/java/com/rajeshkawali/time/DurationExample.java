package com.rajeshkawali.time;

import java.time.Duration;

public class DurationExample {
	public static void main(String[] args) {
		// Creating a duration of 2 hours, 3 minutes, and 4 seconds
		Duration duration = Duration.ofHours(2).plusMinutes(3).plusSeconds(4);

		// Getting the number of hours in the duration
		long hours = duration.toHours();
		System.out.println("Hours: " + hours);

		// Getting the number of minutes in the duration
		long minutes = duration.toMinutes();
		System.out.println("Minutes: " + minutes);

		// Getting the number of seconds in the duration
		long seconds = duration.getSeconds();
		System.out.println("Seconds: " + seconds);

		// Adding a duration of 1 hour, 2 minutes, and 3 seconds to the existing
		// duration
		Duration newDuration = duration.plusHours(1).plusMinutes(2).plusSeconds(3);
		System.out.println("New Duration: " + newDuration);

		// Subtracting a duration of 1 hour, 2 minutes, and 3 seconds from the existing
		// duration
		Duration newDuration1 = duration.minusHours(1).minusMinutes(2).minusSeconds(3);
		System.out.println("New Duration: " + newDuration1);

		// formatting the duration
		System.out.println("Formatted Duration: " + duration.toString());
	}
}
/*
In Java, the Duration class is also a part of the Java Date and Time API (JSR-310), 
which was introduced in Java 8. The Duration class represents a quantity or amount 
of time in terms of seconds and nanoseconds. It is used to represent a duration of 
time, such as "2 hours, 3 minutes, and 4 seconds." The Duration class is also immutable, 
meaning that once it is created, its value cannot be changed. It provides various 
methods for working with durations, such as adding or subtracting time, comparing 
durations, and formatting them as strings.
*/