package com.rajeshkawali.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates useful methods of the Java 8 Date and Time API (LocalDateTime).
 * @author Rajesh_Kawali
 * 
 */
public class DateTimeAPI {

    public static void main(String[] args) {

        // Get current date-time
        LocalDateTime currDateTime = LocalDateTime.now();
        System.out.println("Current LocalDateTime using now(): " + currDateTime);

        // -------------------------------
        // GETTERS
        // -------------------------------

        System.out.println("--- Getter Methods ---");

        int year = currDateTime.getYear();
        Month month = currDateTime.getMonth(); // Enum value (e.g., AUGUST)
        int monthValue = currDateTime.getMonthValue(); // Numeric month (e.g., 8)
        int dayOfMonth = currDateTime.getDayOfMonth();
        DayOfWeek dayOfWeek = currDateTime.getDayOfWeek();
        int dayOfYear = currDateTime.getDayOfYear();

        int hour = currDateTime.getHour();
        int minute = currDateTime.getMinute();
        int second = currDateTime.getSecond();
        int nano = currDateTime.getNano();

        System.out.println("Year from getYear(): " + year);
        System.out.println("Month from getMonth(): " + month);
        System.out.println("Month number from getMonthValue(): " + monthValue);
        System.out.println("Day of month from getDayOfMonth(): " + dayOfMonth);
        System.out.println("Day of week from getDayOfWeek(): " + dayOfWeek);
        System.out.println("Day of year from getDayOfYear(): " + dayOfYear);
        System.out.println("Hour from getHour(): " + hour);
        System.out.println("Minute from getMinute(): " + minute);
        System.out.println("Second from getSecond(): " + second);
        System.out.println("Nano from getNano(): " + nano);

        // Access field using ChronoField
        int hourUsingChrono = currDateTime.get(ChronoField.HOUR_OF_DAY);
        System.out.println("Hour using ChronoField.HOUR_OF_DAY: " + hourUsingChrono);

        // -------------------------------
        // WITH methods (immutability - returns new instance)
        // -------------------------------

        System.out.println("--- with() Methods (Returns new LocalDateTime) ---");

        LocalDateTime updatedDateTime = currDateTime.withYear(2022).withMonth(12).withDayOfMonth(25);
        System.out.println("Updated DateTime with withYear(2022), withMonth(12), withDayOfMonth(25): " + updatedDateTime);

        // -------------------------------
        // PLUS and MINUS methods
        // -------------------------------

        System.out.println("--- plus()/minus() Methods ---");

        LocalDateTime plusDays = currDateTime.plusDays(10);
        LocalDateTime minusHours = currDateTime.minusHours(5);
        LocalDateTime plusWeeks = currDateTime.plus(2, ChronoUnit.WEEKS);
        LocalDateTime minusMonths = currDateTime.minus(3, ChronoUnit.MONTHS);

        System.out.println("Add 10 days using plusDays(10): " + plusDays);
        System.out.println("Subtract 5 hours using minusHours(5): " + minusHours);
        System.out.println("Add 2 weeks using plus(2, ChronoUnit.WEEKS): " + plusWeeks);
        System.out.println("Subtract 3 months using minus(3, ChronoUnit.MONTHS): " + minusMonths);

        // -------------------------------
        // Conversion methods
        // -------------------------------

        System.out.println("--- Conversion Methods ---");

        LocalDate datePart = currDateTime.toLocalDate();
        LocalTime timePart = currDateTime.toLocalTime();

        System.out.println("Date part from toLocalDate(): " + datePart);
        System.out.println("Time part from toLocalTime(): " + timePart);

        // -------------------------------
        // Static factory method
        // -------------------------------

        System.out.println("--- Static Factory Method ---");

        // Manually create LocalDateTime
        LocalDateTime customDateTime = LocalDateTime.of(2020, 6, 27, 20, 1, 47, 364623600);
        System.out.println("Custom LocalDateTime using of(...): " + customDateTime);

        // -------------------------------
        // Comparison methods
        // -------------------------------

        System.out.println("--- Comparison Methods ---");

        boolean isBefore = currDateTime.isBefore(customDateTime);
        boolean isAfter = currDateTime.isAfter(customDateTime);
        boolean isEqual = currDateTime.isEqual(currDateTime);

        System.out.println("Is current date-time before customDateTime? (isBefore): " + isBefore);
        System.out.println("Is current date-time after customDateTime? (isAfter): " + isAfter);
        System.out.println("Is current date-time equal to itself? (isEqual): " + isEqual);

        // -------------------------------
        // Truncation (to remove lower units)
        // -------------------------------

        System.out.println("--- Truncation (Remove lower units) ---");

        LocalDateTime truncatedToHours = currDateTime.truncatedTo(ChronoUnit.HOURS);
        System.out.println("Truncated to hours using truncatedTo(ChronoUnit.HOURS): " + truncatedToHours);

        // -------------------------------
        // Adding nanos, seconds, etc.
        // -------------------------------

        System.out.println("--- Add small units (nano, seconds) ---");

        LocalDateTime addNanos = currDateTime.plusNanos(1_000_000);
        LocalDateTime addSeconds = currDateTime.plusSeconds(10);

        System.out.println("Add 1 million nanos using plusNanos(1_000_000): " + addNanos);
        System.out.println("Add 10 seconds using plusSeconds(10): " + addSeconds);
    }
}
