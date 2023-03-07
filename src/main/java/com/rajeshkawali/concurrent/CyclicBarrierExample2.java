package com.rajeshkawali.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample2 {

	public static void main(String[] args) {

		// Create a CyclicBarrier with a party size of 3
		CyclicBarrier barrier = new CyclicBarrier(3);

		// Create and start the three worker threads
		Thread worker1 = new Thread(new Worker(barrier, "Worker 1"));
		Thread worker2 = new Thread(new Worker(barrier, "Worker 2"));
		Thread worker3 = new Thread(new Worker(barrier, "Worker 3"));
		worker1.start();
		worker2.start();
		worker3.start();
	}

	static class Worker implements Runnable {

		private CyclicBarrier barrier;
		private String name;

		public Worker(CyclicBarrier barrier, String name) {
			this.barrier = barrier;
			this.name = name;
		}

		public void run() {
			System.out.println(name + " started working");
			try {
				// Simulate some work
				Thread.sleep((int) (Math.random() * 1000));
				System.out.println(name + " finished working and waiting at the barrier");
				// Wait for the other threads to finish their work
				barrier.await();
				System.out.println(name + " passed the barrier and continued working");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}
}
/*
In this example, we create a CyclicBarrier with a party size of 3, which
means that the barrier will only open when 3 threads are waiting at the
barrier. Then we create 3 worker threads, each of which performs some work,
waits at the barrier, and then continues working once the other threads have
also finished their work.
 */