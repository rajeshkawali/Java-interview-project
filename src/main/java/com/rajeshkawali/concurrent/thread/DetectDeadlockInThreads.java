package com.rajeshkawali.concurrent.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
/**
 * @author Rajesh_Kawali
 * 
 */
class Shared {
	synchronized void methodOne(Shared s) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + "is executing methodOne...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName() + "is calling methodTwo...");
		s.methodTwo(this);
		System.out.println(t.getName() + "is finished executing methodOne...");
	}

	synchronized void methodTwo(Shared s) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + "is executing methodTwo...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName() + "is calling methodOne...");
		s.methodOne(this);
		System.out.println(t.getName() + "is finished executing methodTwo...");
	}
}

public class DetectDeadlockInThreads {
	public static void main(String[] args) {
		final Shared s1 = new Shared();
		final Shared s2 = new Shared();
		Thread t1 = new Thread() {
			public void run() {
				s1.methodOne(s2);
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				s2.methodTwo(s1);
			}
		};
		t1.start();
		t2.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		long ids[] = bean.findMonitorDeadlockedThreads();
		if (ids != null) {
			ThreadInfo threadInfo[] = bean.getThreadInfo(ids);
			for (ThreadInfo threadInfo1 : threadInfo) {
				System.out.println(threadInfo1.getThreadId()); // Prints the ID of deadlocked thread
				System.out.println(threadInfo1.getThreadName()); // Prints the name of deadlocked thread
				System.out.println(threadInfo1.getLockName()); // Prints the string representation of an object for which thread has entered into deadlock.
				System.out.println(threadInfo1.getLockOwnerId()); // Prints the ID of thread which currently owns then object lock
				System.out.println(threadInfo1.getLockOwnerName()); // Prints name of the thread which currently owns the object lock.
			}
		} else {
			System.out.println("No Deadlocked Threads");
		}
	}
}
/*
Ways to detect deadlocks in Java :-->

Thread Dump Analysis:- A thread dump provides a snapshot of all the threads that are 
			currently running in a Java process, along with their current state and stack trace. 
			By analyzing the thread dump, it's possible to identify any threads that are stuck in 
			a blocked state, which may indicate a deadlock.

Using JConsole or VisualVM:- These tools can be used to monitor a running Java process 
			and provide real-time information about thread activity, including thread count, 
			CPU usage, and memory usage. By monitoring the thread activity, it may be possible 
			to identify threads that are stuck in a blocked state, which may indicate a deadlock.

Using ThreadMXBean:- The ThreadMXBean class provides programmatic access to information 
			about threads in a Java process. It can be used to query information about a specific 
			thread or to get a list of all threads in the process. By examining the state of each 
			thread, it may be possible to identify threads that are stuck in a blocked state, 
			which may indicate a deadlock.

Using third-party tools:- There are several third-party tools available for detecting 
			and analyzing deadlocks in Java, including JProfiler, YourKit, and Eclipse MAT.
*/