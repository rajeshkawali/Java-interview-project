package com.rajeshkawali.time;

import java.time.Duration;
import java.time.LocalTime;

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
		
		System.out.println("-------------------------------------------------------");
		// Creating durations
        Duration durationVar = Duration.ofHours(3);
        Duration anotherDuration = Duration.ofMinutes(30);

        // Getting duration in hours, minutes, seconds and nanoseconds
        long hours1 = durationVar.toHours();
        long minutes1 = durationVar.toMinutes();
        long seconds1 = durationVar.getSeconds();
        long nanos = durationVar.getNano();

        // Adding durations
        Duration sum = durationVar.plus(anotherDuration);

        // Subtracting durations
        Duration difference = durationVar.minus(anotherDuration);

        // Multiplying and dividing duration
        Duration multiplied = durationVar.multipliedBy(2);
        Duration divided = durationVar.dividedBy(2);

        // Comparing durations
        boolean isGreaterThan = durationVar.compareTo(anotherDuration) > 0;
        boolean isEqual = durationVar.equals(anotherDuration);

        // Checking if duration is negative
        boolean isNegative = durationVar.isNegative();

        // Checking if duration is zero
        boolean isZero = durationVar.isZero();

        // Parsing duration from string
        Duration parsedDuration = Duration.parse("PT2H30M");

        // Converting duration to string
        String durationString = durationVar.toString();

        // Applying duration to time
        LocalTime localTime = LocalTime.of(10, 30);
        LocalTime updatedTime = localTime.plus(durationVar);

        // Printing results
        System.out.println("Duration in hours: " + hours1);
        System.out.println("Duration in minutes: " + minutes1);
        System.out.println("Duration in seconds: " + seconds1);
        System.out.println("Duration in nanoseconds: " + nanos);
        System.out.println("Sum of durations: " + sum);
        System.out.println("Difference of durations: " + difference);
        System.out.println("Multiplied duration: " + multiplied);
        System.out.println("Divided duration: " + divided);
        System.out.println("Is duration greater than another duration? " + isGreaterThan);
        System.out.println("Is duration equal to another duration? " + isEqual);
        System.out.println("Is duration negative? " + isNegative);
        System.out.println("Is duration zero? " + isZero);
        System.out.println("Parsed duration: " + parsedDuration);
        System.out.println("Duration as string: " + durationString);
        System.out.println("Updated time: " + updatedTime);
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