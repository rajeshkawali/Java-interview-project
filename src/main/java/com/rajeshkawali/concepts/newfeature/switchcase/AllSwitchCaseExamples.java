package com.rajeshkawali.concepts.newfeature.switchcase;
public class AllSwitchCaseExamples {

    public static void main(String[] args) {
        traditionalSwitch();
        switchWithString();
        enhancedSwitchExpression();
        switchWithYield();
        //patternMatchingSwitch();
        //patternMatchingWithGuards();
    }

    // 1. Traditional switch (Java 1.0)
    public static void traditionalSwitch() {
        System.out.println("=== Traditional switch (Java 1.0) ===");
        int day = 2;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            default:
                System.out.println("Other day");
        }
    }

    // 2. Switch with String (Java 7)
    public static void switchWithString() {
        System.out.println("\n=== Switch with String (Java 7) ===");
        String color = "Red";

        switch (color) {
            case "Red":
                System.out.println("Color is Red");
                break;
            case "Blue":
                System.out.println("Color is Blue");
                break;
            default:
                System.out.println("Unknown Color");
        }
    }

    // 3. Enhanced switch expression (Java 14+, finalized in Java 17)
    public static void enhancedSwitchExpression() {
        System.out.println("\n=== Enhanced switch expression (Java 14+) ===");
        String dayName = "MONDAY";

        String type = switch (dayName) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
            case "SATURDAY", "SUNDAY" -> "Weekend";
            default -> "Invalid day";
        };

        System.out.println("Day type: " + type);
    }

    // 4. Enhanced switch with yield (Java 14+)
    public static void switchWithYield() {
        System.out.println("\n=== Switch with yield (Java 14+) ===");
        int number = 3;

        String result = switch (number) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> {
                System.out.println("Processing case 3");
                yield "Three";
            }
            default -> "Other number";
        };

        System.out.println("Result: " + result);
    }
/*
    // 5. Pattern matching for switch (Java 17 preview, finalized in Java 21)
    public static void patternMatchingSwitch() {
        System.out.println("\n=== Pattern matching in switch (Java 21) ===");
        Object obj = 42;

        switch (obj) {
            case String s -> System.out.println("It's a String: " + s);
            case Integer i -> System.out.println("It's an Integer: " + i);
            default -> System.out.println("Unknown type");
        }
    }

    // 6. Pattern matching with guards (Java 21)
    public static void patternMatchingWithGuards() {
        System.out.println("\n=== Pattern matching with guards (Java 21) ===");
        Object message = "Hello, Java!";

        switch (message) {
            case String s when s.length() > 10 -> System.out.println("Long string: " + s);
            case String s -> System.out.println("Short string: " + s);
            default -> System.out.println("Not a string");
        }
    }
*/
}
