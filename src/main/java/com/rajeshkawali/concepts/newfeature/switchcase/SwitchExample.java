package com.rajeshkawali.concepts.newfeature.switchcase;

import java.time.LocalDate;

/**
 * @author Rajesh_Kawali
 *
 */
public class SwitchExample {

	/*
	Switch expressions are a new feature introduced in Java (JDK) 12. 
	They allow you to use a switch statement as an expression, 
	rather than as a statement, and return a value from the switch.
	
	you need to use the -> operator instead of the : operator to separate 
	the cases, and you can specify a value for each case using the -> operator. 
	*/
	public static void main(String[] args) {

		LocalDate date = LocalDate.now();

		int weekDay = switch(date.getDayOfWeek()) {
		case MONDAY -> 1;
		case TUESDAY -> 2;
		case WEDNESDAY -> 3;
		case THURSDAY -> 4;
		case FRIDAY -> 5;
		case SATURDAY -> 6;
		case SUNDAY -> 7;
		default -> 0;
		};
		System.out.println("Week Day Number is : "+weekDay);
	}
}
/*
Some key points to remember when using switch expressions in Java:-->

1.Switch expressions are a new feature introduced in Java 12 that allow you to use a switch statement as an expression, rather than as a statement, and return a value from the switch.

2.To use a switch expression, you need to use the -> operator instead of the : operator to separate the cases, and you can specify a value for each case using the -> operator.

3.You can use the yield keyword in a switch expression to specify a value for a case and exit the switch expression early.

4.Switch expressions can make your code more concise and easier to read, especially when you need to return a value based on a series of conditions.

5.It is important to use switch expressions judiciously, as they can make your code more difficult to understand if used excessively or in place of more appropriate constructs.
*/