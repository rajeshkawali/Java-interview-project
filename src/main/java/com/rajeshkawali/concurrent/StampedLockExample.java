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
 * =====================================================
 * Optimistic vs Pessimistic Locking in Java
 * =====================================================
 *
 * 1. Pessimistic Locking:
 *
 *    Assumes conflicts are likely to occur.
 *    Acquires a lock before accessing shared data.
 *    Other conflicting threads must wait.
 *
 *    Examples: synchronized, ReentrantLock,
 *              StampedLock.readLock()/writeLock().
 *
 *    Advantage: Prevents conflicting access.
 *    Disadvantage: May reduce performance due to blocking.
 *
 * 2. Optimistic Locking:
 *
 *    Assumes conflicts are rare.
 *    Allows operations without locking first.
 *    Checks for conflicts before accepting results.
 *    If a conflict occurs, retry or handle it.
 *
 *    Examples: AtomicInteger (CAS),
 *              StampedLock.tryOptimisticRead().
 *
 *    Advantage: Better concurrency when conflicts are rare.
 *    Disadvantage: Requires validation or retry logic.
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * Pessimistic -> Lock first, then access data.
 * Optimistic  -> Access first, then check for conflicts.
 *
 * =====================================================
 */


/*
Pessimistic Locking:
Assumes conflicts are likely. Threads acquire a lock before accessing shared data,
allowing only one thread at a time. Safer but may reduce performance.

Optimistic Locking:
Assumes conflicts are rare. Threads access data without locking and verify before
updating. If a conflict occurs, the operation is retried. Faster with better concurrency.
*/



/*
 * =====================================================
 * StampedLock in Java
 * =====================================================
 *
 * StampedLock is a synchronization utility introduced
 * in Java 8, available in java.util.concurrent.locks.
 *
 * It allows multiple threads to read shared data
 * concurrently, but only one thread to write at a time.
 *
 * Unlike ReadWriteLock, StampedLock also supports
 * optimistic reading, which can improve performance
 * when reads are frequent and writes are rare.
 *
 * THREE LOCKING MODES:
 *
 * 1. Read Lock:
 *    readLock() acquires a shared lock.
 *    Multiple threads can read simultaneously.
 *
 * 2. Write Lock:
 *    writeLock() acquires an exclusive lock.
 *    Only one thread can write at a time.
 *
 * 3. Optimistic Read:
 *    tryOptimisticRead() returns a stamp without
 *    acquiring a traditional read lock.
 *    validate(stamp) checks whether a write lock
 *    was acquired since the stamp was obtained.
 *
 * IMPORTANT METHODS:
 *
 * readLock()              -> Acquires a shared read lock.
 * writeLock()             -> Acquires an exclusive write lock.
 * tryOptimisticRead()     -> Returns an optimistic read stamp.
 * validate(stamp)         -> Validates an optimistic read.
 * tryConvertToWriteLock() -> Attempts conversion to write lock.
 * unlockRead(stamp)       -> Releases a read lock.
 * unlockWrite(stamp)      -> Releases a write lock.
 * unlock(stamp)           -> Releases a held read/write lock.
 *
 * IMPORTANT POINTS:
 *
 * 1. StampedLock supports multiple readers
 *    but only one writer at a time.
 *
 * 2. Optimistic reading does not block writers.
 *    Read data must be validated before use.
 *
 * 3. Each successful lock acquisition returns
 *    a stamp (long) used to manage that lock.
 *
 * 4. tryConvertToWriteLock(stamp) attempts to
 *    convert a valid stamp to a write-lock stamp.
 *    It returns 0 if conversion fails.
 *
 * 5. StampedLock is NOT reentrant.
 *    The same thread cannot safely reacquire
 *    a lock it already holds.
 *
 * 6. Always release acquired read/write locks
 *    in a finally block using the correct stamp.
 *
 * 7. Optimistic reads do not require unlock().
 *
 * 8. StampedLock does not guarantee fairness,
 *    so thread starvation is possible.
 *
 * COMMON USE CASES:
 *
 * - Read-heavy applications.
 * - Shared counters or coordinate data.
 * - Applications with frequent reads and rare writes.
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * readLock()          -> Shared reading.
 * writeLock()         -> Exclusive writing.
 * tryOptimisticRead() -> Read without locking,
 *                        then validate the result.
 *
 * ReentrantReadWriteLock -> Reentrant, no optimistic read.
 * StampedLock            -> Non-reentrant, supports
 *                           optimistic reading.
 *
 * =====================================================
 */
