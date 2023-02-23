package com.rajeshkawali.concurrent;

import java.util.concurrent.locks.StampedLock;

/**
 *
 * @author Rajesh_Kawali
 */
public class StampedLockExample {
	/*
	 StampedLock is a synchronizer introduced in Java 8 that combines the features of a 
	 ReadWriteLock and a Lock. It allows multiple threads to read from a shared resource concurrently, 
	 and allows a single thread to write to the shared resource optimistically or pessimistically.
	 
	 The StampedLock class defines three methods for acquiring locks: readLock(), writeLock(), and tryConvertToWriteLock(). 
	 The readLock() method returns a stamp that can be used to acquire a shared lock for reading, 
	 while the writeLock() method returns a stamp that can be used to acquire an exclusive lock for writing. 
	 The tryConvertToWriteLock() method attempts to convert a shared lock to an exclusive lock optimistically, 
	 returning a new stamp if the conversion is successful and zero if the conversion is not possible.
	 */
	public static void main(String[] args) {
		// create a stamped lock
		StampedLock lock = new StampedLock();

		// create and start three threads that use the lock
		new Thread(new Reader(lock)).start();
		new Thread(new Reader(lock)).start();
		new Thread(new Writer(lock)).start();
	}

	static class Reader implements Runnable {
		private StampedLock lock;

		public Reader(StampedLock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			// acquire the shared lock for reading
			long stamp = lock.readLock();
			try {
				// read from the shared resource
				System.out.println("Reader: reading from the shared resource");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				// release the shared lock
				lock.unlockRead(stamp);
			}
		}
	}

	static class Writer implements Runnable {
		private StampedLock lock;

		public Writer(StampedLock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			// try to convert the shared lock to an exclusive lock optimistically
			long stamp = lock.tryConvertToWriteLock(1);
			if (stamp != 0L) {
				// the conversion was successful, write to the shared resource
				System.out.println("Writer: writing to the shared resource optimistically");
				lock.unlockWrite(stamp);
			} else {
				// the conversion was not successful, acquire the exclusive lock pessimistically
				stamp = lock.writeLock();
				try {
					// write to the shared resource
					System.out.println("Writer: writing to the shared resource pessimistically");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					// release the exclusive lock
					lock.unlockWrite(stamp);
				}
			}
		}
	}
}
/*
The terms "optimistic" and "pessimistic" refer to different approaches to 
handling shared resources and synchronization between threads:-->

Pessimistic locking:- is a strategy that assumes that conflicts between threads accessing 
shared resources are likely to occur, and therefore attempts to minimize the likelihood of 
such conflicts by imposing strict synchronization constraints. In Java, this can be implemented using 
constructs such as synchronized blocks or ReentrantLocks. With pessimistic locking, threads typically 
acquire locks on shared resources before accessing them, and release the locks once they are done. 
This ensures that only one thread can access the resource at a time, and reduces the risk of data 
corruption or race conditions. However, this approach can also result in reduced concurrency and 
slower performance, as threads may need to wait for locks to be released.

Optimistic locking:- on the other hand, assumes that conflicts between threads accessing shared 
resources are less likely to occur, and therefore allows multiple threads to access the same 
resource simultaneously, without imposing strict synchronization constraints. In Java, this can be 
implemented using constructs such as atomic variables or optimistic locking mechanisms. With optimistic locking, 
threads attempt to access the shared resource without acquiring locks first, but check for conflicts or 
modifications before making any updates. If a conflict is detected, the thread retries the operation with 
updated information. This approach can result in better performance and higher concurrency, 
but also requires careful handling to ensure that conflicts are properly detected and resolved. 
*/
