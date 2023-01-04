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
