package com.rajeshkawali.concepts.newfeature.switchcase;

/**
 * @author Rajesh_Kawali
 *
 */
public class SwitchCaseLegacy {
	public static void main(String[] args) {
		int day = 4;
		switch (day) {
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
		case 8:
			System.out.println("Monday");
			break;
		default:
			System.out.println("Weekend");
		}
	}
}