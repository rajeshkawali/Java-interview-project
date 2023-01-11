package com.rajeshkawali.concepts.general;

import java.lang.reflect.Method;


/**
 * @author Rajesh_Kawali
 *
 */
class PrivateMethodClass {
	@SuppressWarnings("unused")
	private void displayMessage() {
		System.out.println("Message from Private method of another class");
	}
}

public class AccessPrivateMethodInOtherClass {

	public static void main(String[] args) throws Exception {
		PrivateMethodClass obj = new PrivateMethodClass();
		// Class c = Class.forName("PrivateMethodClass");
		// Object obj = c.newInstance();
		// Method m = c.getDeclaredMethod("displayMessage", null);
		Method m = PrivateMethodClass.class.getDeclaredMethod("displayMessage", null);
		m.setAccessible(true);
		m.invoke(obj, null);
	}
}
