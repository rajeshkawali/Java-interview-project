package com.rajeshkawali.concurrent.thread;

/**
*
* @author Rajesh_Kawali
*/
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
				Thread.sleep(1000);
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
					Thread.sleep(1000);
					this.notify(); // Thread is in "Blocked" state
					System.out.println("Thread state: " + Thread.currentThread().getState());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}


/*
In this example, we create a new thread and print out its state at various points in time, 
so you can see the transition of the state of the thread. The Thread.sleep() causes the thread 
to enter the "Timed Waiting" state and Object.wait() causes the thread to enter the "Waiting" state. 
And in the Runnable class, we call this.wait() to put thread in Blocked state and notify 
the main thread to continue executing. Finally, when the thread has finished its execution, 
it will be in the "Terminated" state.
*/

/*

*/
