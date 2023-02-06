package com.rajeshkawali.concepts.exception;

@SuppressWarnings("unused")
public class ReturnStatement {

	public static void main(String[] args) {

		method1();
		method2();
		method3();
		method4();
		method5();
		method6();
		method7();
		method8();
		method9();

	}

	public static int method1() {
		//If we are not having else part then we will get -> This method must return a result of type int
		if (true) {
			return 10;
		} 
		else {
			return 0; // If we comment this --> This method must return a result of type int
		}
		//return 0; //Unreachable code
	}

	public static int method2() {
		try {
			return 10;
		} catch (NumberFormatException e) {
			return 20; // If we comment this -> This method must return a result of type int
		}
		//return 30; //Unreachable code
	}

	public static int method3() {
		try {
			return 10;
		} catch (NumberFormatException e) {
			return 20; // If we comment this ->  This method must return a result of type int
		} catch (Exception e) {
			return 30; // If we comment this ->  This method must return a result of type int
		}
		//return 40; //Unreachable code
	}

	public static int method4() {
		try {
		} catch (NumberFormatException e) {
		} catch (Exception e) {
		}
		return 40;
	}
	
	public static int method5() {
		try {
			return 10;
		} catch (NumberFormatException e) {
			return 20;
		} catch (Exception e) {
			//return 30;
		}
		return 40;
	}
	
	public static int method6() {
		try {
			
		} catch (NumberFormatException e) {
			return 20;
		} catch (Exception e) {
			return 30;
		}
		return 40;
	}
	
	@SuppressWarnings("finally")
	public static int method7() {
		try {
			return 10;
		} catch (NumberFormatException e) {
			return 20;
		} finally {
			return 30;
		}
		//return 40; //Unreachable code
	}
	
	public static int method8() {
		try {
		} catch (NumberFormatException e) {
			return 20;
		} finally {
		}
		return 40;
	}
	
	public static int method9() {
		try {
			//return 10; // If Uncomment this then "return 50" will be --> Unreachable code
		} catch (NumberFormatException e) {
			return 20;
		} catch (Exception e) {
			return 30;
		} finally {
			//return 40;// If Uncomment this then "return 50" will be --> Unreachable code
		}
		return 50;
	}

}
