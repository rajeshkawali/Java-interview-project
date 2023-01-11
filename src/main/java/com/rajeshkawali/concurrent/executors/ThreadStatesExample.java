package com.rajeshkawali.concurrent.executors;

public class ThreadStatesExample {
	public static void main(String[] args) {
		Thread thread = new Thread(new MyRunnable());
		// The thread is in the "New" state
		System.out.println("Thread state: " + thread.getState());

		thread.start();
		// The thread is in the "Runnable" state
		System.out.println("Thread state: " + thread.getState());

		try {
			Thread.sleep(1000); // Thread is in "Timed Waiting" state
			System.out.println("Thread state: " + thread.getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (thread) {
			try {
				thread.wait(); // Thread is in "Waiting" state
				System.out.println("Thread state: " + thread.getState());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Thread state: TERMINATED
		System.out.println("Thread state: " + thread.getState());
	}

	private static class MyRunnable implements Runnable {
		public void run() {
			synchronized (this) {
				try {
					System.out.println("Thread state: " + Thread.currentThread().getState());
					this.wait(); // Thread is in "Blocked" state
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Thread state: " + Thread.currentThread().getState());
			// ...do some work
		}
	}
}
