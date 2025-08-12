package com.rajeshkawali.stream.employee.question;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.rajeshkawali.model.Employee;
import com.rajeshkawali.util.EmployeeDB;


/**
 * @author Rajesh_Kawali
 *
 */
public class StreamQuestionsUsingDateTime {

    public static void main(String[] args) {
    	
        List<Employee> employees = EmployeeDB.getAllEmployee();
        LocalDate now = LocalDate.now();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("1. Employees who joined after 2015:");
        employees.stream()
                .filter(e -> e.getDateOfJoining().isAfter(LocalDate.of(2015, 12, 31)))
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("2. Average age of employees:");
        double averageAge = employees.stream()
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0);
        System.out.println(averageAge);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("3. Employees sorted by Date of Joining:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getDateOfJoining))
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("4. Youngest employee by Date of Joining:");
        employees.stream()
                .max(Comparator.comparing(Employee::getDateOfJoining))
                .ifPresent(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("5. Employees older than 30:");
        employees.stream()
                .filter(e -> e.getAge() > 30)
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("6. Group employees by year of joining:");
        Map<Integer, List<Employee>> groupByYear = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDateOfJoining().getYear()));
        groupByYear.forEach((year, emps) -> {
            System.out.println("Year: " + year);
            emps.forEach(System.out::println);
        });
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("7. Count of employees joined in each month:");
        Map<Month, Long> joinedByMonth = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDateOfJoining().getMonth(), Collectors.counting()));
        joinedByMonth.forEach((month, count) -> System.out.println(month + ": " + count));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("8. Employees whose work anniversary is today:");
        MonthDay today = MonthDay.from(now);
        employees.stream()
                .filter(e -> MonthDay.from(e.getDateOfJoining()).equals(today))
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("9. Total days worked by all employees:");
        long totalDaysWorked = employees.stream()
                .mapToLong(e -> ChronoUnit.DAYS.between(e.getDateOfJoining(), now))
                .sum();
        System.out.println(totalDaysWorked);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("10. Convert list of date strings to LocalDate:");
        List<String> dateStr = List.of("2021-01-01", "2022-05-05");
        List<LocalDate> dates = dateStr.stream().map(LocalDate::parse).collect(Collectors.toList());
        dates.forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("11. Partition employees into adults (18+) and minors:");
        Map<Boolean, List<Employee>> partition = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() >= 18));
        System.out.println("Adults:");
        partition.get(true).forEach(System.out::println);
        System.out.println("Minors:");
        if (partition.containsKey(false)) {
            partition.get(false).forEach(System.out::println);
        }
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("12. Employee with earliest joining date:");
        employees.stream()
                .min(Comparator.comparing(Employee::getDateOfJoining))
                .ifPresent(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("13. Employees with upcoming anniversaries in next 30 days:");
        employees.stream()
                .filter(e -> {
                    LocalDate anniv = e.getDateOfJoining().withYear(now.getYear());
                    if (anniv.isBefore(now)) anniv = anniv.plusYears(1);
                    return !anniv.isAfter(now.plusDays(30));
                })
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("14. Maximum age among employees:");
        int maxAge = employees.stream()
                .mapToInt(Employee::getAge)
                .max()
                .orElse(0);
        System.out.println(maxAge);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("15. Map of employee full name to age:");
        Map<String, Integer> nameToAge = employees.stream()
                .collect(Collectors.toMap(
                        e -> e.getFirstName() + " " + e.getLastName(),
                        Employee::getAge));
        nameToAge.forEach((name, age) -> System.out.println(name + ": " + age));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("16. Duplicate joining years:");
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = employees.stream()
                .map(e -> e.getDateOfJoining().getYear())
                .filter(year -> !seen.add(year))
                .collect(Collectors.toSet());
        duplicates.forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("17. 5 latest joiners:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getDateOfJoining).reversed())
                .limit(5)
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("18. Total years of experience (sum of all):");
        int totalYears = employees.stream()
                .mapToInt(e -> Period.between(e.getDateOfJoining(), now).getYears())
                .sum();
        System.out.println(totalYears);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("19. Each employee’s name with experience in years:");
        employees.stream()
                .forEach(e -> {
                    int years = Period.between(e.getDateOfJoining(), now).getYears();
                    System.out.println(e.getFirstName() + " " + e.getLastName() + ": " + years + " years");
                });
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("20. Employees whose anniversary falls on weekend this year:");
        employees.stream()
                .filter(e -> {
                    LocalDate anniv = e.getDateOfJoining().withYear(now.getYear());
                    DayOfWeek day = anniv.getDayOfWeek();
                    return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
                })
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        // 21. Employees who have completed at least 5 years of service
        System.out.println("\n21. Employees with 5+ years of service:");
        employees.stream()
            .filter(e -> Period.between(e.getDateOfJoining(), now).getYears() >= 5)
            .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        // 22. Employees sorted by total companies worked in descending order
        System.out.println("22. Employees sorted by number of companies worked (descending):");
        employees.stream()
            .sorted(Comparator.comparingInt((Employee e) -> e.getEmploymentHistory().size()).reversed())
            .forEach(e -> System.out.println(e.getFirstName() + " - " + e.getEmploymentHistory().size() + " companies"));
        System.out.println("--------------------------------------------------------------------------------");
        // 23. List of all unique companies employees have worked for (flatMap)
        System.out.println("23. Unique companies worked for by employees:");
        employees.stream()
            .flatMap(e -> e.getEmploymentHistory().stream())
            .distinct()
            .sorted()
            .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        // 24. Employees whose birthday falls in the current month
        System.out.println("\n24. Employees with birthdays this month:");
        int currentMonth = now.getMonthValue();
        employees.stream()
            .filter(e -> e.getDateOfJoining().getMonthValue() == currentMonth)
            .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        // 25. Employees with longest tenure (max years of service)
        System.out.println("\n25. Employees with longest tenure:");
        int maxTenure = employees.stream()
            .mapToInt(e -> Period.between(e.getDateOfJoining(), now).getYears())
            .max()
            .orElse(0);

        employees.stream()
            .filter(e -> Period.between(e.getDateOfJoining(), now).getYears() == maxTenure)
            .forEach(e -> System.out.println(e.getFirstName() + " - " + maxTenure + " years"));
        System.out.println("--------------------------------------------------------------------------------");
        
        
        System.out.println("--------------------------------------------------------------------------------");
    }
}
