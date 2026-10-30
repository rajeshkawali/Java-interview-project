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
 * =====================================================
 * ReadWriteLock in Java
 * =====================================================
 *
 * ReadWriteLock is a synchronization interface from
 * java.util.concurrent.locks that provides separate
 * locks for reading and writing shared data.
 *
 * ReentrantReadWriteLock is its common implementation.
 *
 * HOW IT WORKS:
 *
 * 1. READ LOCK:
 *    Multiple threads can read simultaneously,
 *    as long as no other thread holds the write lock.
 *
 * 2. WRITE LOCK:
 *    Only one thread can hold the write lock.
 *    It prevents other threads from reading or writing.
 *
 * 3. readLock():
 *    Returns a shared Lock for reading.
 *
 * 4. writeLock():
 *    Returns an exclusive Lock for writing.
 *
 * IMPORTANT METHODS:
 *
 * lock()              -> Waits until lock is available.
 * tryLock()           -> Acquires lock if immediately available.
 * tryLock(time, unit) -> Waits up to the specified timeout.
 * lockInterruptibly() -> Waits but responds to interruption.
 * unlock()            -> Releases the acquired lock.
 *
 * IMPORTANT POINTS:
 *
 * 1. Useful when reads are frequent and writes are rare.
 *
 * 2. Multiple readers can access shared data concurrently.
 *
 * 3. Writers require exclusive access to shared data.
 *
 * 4. Always release locks in a finally block to
 *    prevent locks from remaining held accidentally.
 *
 * 5. lock() may block indefinitely if the lock
 *    never becomes available.
 *
 * 6. tryLock() is useful when a thread should avoid
 *    waiting or needs a timeout.
 *    It is not mandatory or always preferable.
 *
 * 7. ReentrantReadWriteLock supports reentrancy:
 *    A thread can reacquire a lock it already holds.
 *
 * 8. Lock downgrading is supported:
 *    A writer can acquire the read lock before
 *    releasing its write lock.
 *
 * 9. Lock upgrading is NOT directly supported:
 *    Trying to acquire the write lock while holding
 *    only the read lock can cause deadlock.
 *
 * 10. ReentrantReadWriteLock supports fair and
 *     non-fair modes. Non-fair is the default.
 *
 * 11. ReadWriteLock does not always improve performance.
 *     For short operations or frequent writes,
 *     synchronization overhead may outweigh benefits.
 *
 * 12. Incorrect lock ordering or unreleased locks
 *     can cause deadlocks or thread starvation.
 *
 * COMMON USE CASES:
 *
 * - Read-heavy caches.
 * - Shared configuration data.
 * - In-memory data structures with frequent reads.
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * readLock()  -> Multiple readers allowed.
 * writeLock() -> One writer, exclusive access.
 *
 * Read + Read   -> Allowed.
 * Read + Write  -> Not allowed simultaneously
 *                  across different threads.
 * Write + Write -> Not allowed simultaneously.
 *
 * Always use unlock() inside finally.
 *
 * =====================================================
 */
