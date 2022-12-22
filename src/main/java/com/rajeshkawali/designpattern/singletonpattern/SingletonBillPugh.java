package com.rajeshkawali.designpattern.singletonpattern;

public class SingletonBillPugh {

	private SingletonBillPugh() {
	}

	// Inner class to provide instance of SingletonBillPugh class
	private static class BillPugh {
		private static final SingletonBillPugh instance = new SingletonBillPugh();
	}

	public static SingletonBillPugh getInstance() {
		return BillPugh.instance;
	}
}

/*
When the singleton class is loaded, inner class is not loaded and hence doesn’t create object when loading the class. Inner class is created only when getInstance() method is called. So it may seem like eager initialization but it is lazy initialization. 
This is the most widely used approach as it doesn’t use synchronization.
*/