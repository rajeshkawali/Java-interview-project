package com.rajeshkawali.concurrent;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 
 * @author Rajesh_Kawali
 */
public class ReadWriteLockExample {
	/*
	 ReadWriteLock is a synchronizer that can be used to control access to a
	 shared resource in a multi-threaded environment. It allows multiple threads
	 to read from the shared resource concurrently, but only allows a single
	 thread to write to the shared resource at a time.
	 
	 The ReadWriteLock interface defines two methods: readLock() and writeLock().
	 The readLock() method returns a Lock object that can be used to acquire a
	 shared lock for reading, while the writeLock() method returns a Lock object
	 that can be used to acquire an exclusive lock for writing.
	 */
	public static void main(String[] args) {
		// create a read-write lock
		ReadWriteLock lock = new ReentrantReadWriteLock();

		// create and start three threads that use the lock
		new Thread(new Reader(lock)).start();
		new Thread(new Reader(lock)).start();
		new Thread(new Writer(lock)).start();
	}

	static class Reader implements Runnable {
		private ReadWriteLock lock;

		public Reader(ReadWriteLock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			// acquire the shared lock for reading
			lock.readLock().lock();
			try {
				// read from the shared resource
				System.out.println("Reader: reading from the shared resource");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				// release the shared lock
				lock.readLock().unlock();
			}
		}
	}

	static class Writer implements Runnable {
		private ReadWriteLock lock;

		public Writer(ReadWriteLock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			// acquire the exclusive lock for writing
			lock.writeLock().lock();
			try {
				// write to the shared resource
				System.out.println("Writer: writing to the shared resource");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				// release the exclusive lock
				lock.writeLock().unlock();
			}
		}
	}
}

/*
Some useful methods of the Lock interface, which is returned by the readLock() and writeLock() methods of ReadWriteLock:-

lock(): acquires the lock. If the lock is not available, the thread is blocked until the lock becomes available.

lockInterruptibly(): acquires the lock, blocking the thread until the lock becomes available or the thread is interrupted.

tryLock(): attempts to acquire the lock, returning true if the lock is acquired and false if the lock is not available.

tryLock(long timeout, TimeUnit unit): attempts to acquire the lock, blocking the thread until the lock becomes available or the specified timeout has elapsed, or the thread is interrupted.

unlock(): releases the lock.
*/

/*
key points to consider when using ReadWriteLock in Java:-

ReadWriteLock allows multiple threads to read from a shared resource concurrently, but only allows a single thread to write to the shared resource at a time.

ReadWriteLock is useful for improving the performance of multi-threaded programs by allowing multiple threads to read from the shared resource concurrently, while still protecting the resource from concurrent writes.

The readLock() method returns a Lock object that can be used to acquire a shared lock for reading, while the writeLock() method returns a Lock object that can be used to acquire an exclusive lock for writing.

It is recommended to use the tryLock() or tryLock(long, TimeUnit) methods to acquire the lock, as they allow the thread to continue execution if the lock is not available.

The lock() and lockInterruptibly() methods should be used with caution, as they can cause the thread to block indefinitely if the lock is not available.

The unlock() method must be called to release the lock after the shared resource has been accessed.

ReadWriteLock is not suitable for long-term blocking, as it can lead to deadlock and livelock if used improperly. For long-term blocking, it is better to use other synchronization mechanisms such as CountDownLatch, CyclicBarrier, or Semaphore.
*/