package com.rajeshkawali.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
 * ==========================================================
 * CYCLICBARRIER IN JAVA
 * ==========================================================
 *
 * CyclicBarrier allows a fixed number of threads
 * to wait for each other at a common synchronization point.
 *
 * Once all required threads call await(), the barrier
 * opens and all waiting threads can continue.
 *
 * IMPORTANT:
 * - Reusable across multiple phases.
 * - await() blocks until all parties arrive.
 * - reset() breaks the current barrier and resets it.
 * - An optional barrier action runs when all parties arrive.
 */

public class CyclicBarrierExample2 {

    public static void main(String[] args)
            throws InterruptedException {

        /* Create a barrier requiring 3 threads. */
        CyclicBarrier barrier = new CyclicBarrier(3);

        /* Create worker threads sharing the same barrier. */
        Thread worker1 =
                new Thread(new Worker(barrier, "Worker 1"));

        Thread worker2 =
                new Thread(new Worker(barrier, "Worker 2"));

        Thread worker3 =
                new Thread(new Worker(barrier, "Worker 3"));

        /* Start all three threads concurrently. */
        worker1.start();
        worker2.start();
        worker3.start();

        /* Wait until all worker threads finish. */
        worker1.join();
        worker2.join();
        worker3.join();

        System.out.println("Main thread completed.");
    }

    /*
     * Worker implements Runnable so its task
     * can execute in a separate thread.
     */
    static class Worker implements Runnable {

        /* Shared barrier used by all workers. */
        private final CyclicBarrier barrier;

        /* Name used to identify each worker. */
        private final String name;

        /* Constructor initializes worker details. */
        public Worker(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {

            System.out.println(name + " started working");

            try {

                /* Simulate work taking 0 to 999 milliseconds. */
                Thread.sleep((int) (Math.random() * 1000));

                System.out.println(
                        name + " finished work and reached barrier");

                /*
                 * Wait until all 3 workers call await().
                 *
                 * First two arriving threads wait.
                 * Third arriving thread completes the group.
                 * Then all three can continue.
                 */
                barrier.await();

                /* Executes only after barrier is crossed. */
                System.out.println(
                        name + " passed barrier and continued");

            } catch (InterruptedException e) {

                /* Restore interrupted status. */
                Thread.currentThread().interrupt();

                System.out.println(name + " was interrupted");

            } catch (BrokenBarrierException e) {

                /*
                 * Occurs if barrier breaks due to
                 * interruption, timeout, or reset.
                 */
                System.out.println(name + " barrier was broken");
            }
        }
    }
}

/*
 * ==========================================================
 * POSSIBLE OUTPUT
 * ==========================================================
 *
 * Worker 1 started working
 * Worker 2 started working
 * Worker 3 started working
 *
 * Worker 2 finished work and reached barrier
 * Worker 1 finished work and reached barrier
 * Worker 3 finished work and reached barrier
 *
 * Worker 3 passed barrier and continued
 * Worker 1 passed barrier and continued
 * Worker 2 passed barrier and continued
 *
 * Main thread completed.
 *
 * NOTE:
 * Thread execution order may change on each run.
 * But all 3 workers must reach the barrier before
 * any worker can print "passed barrier".
 *
 * ==========================================================
 * IMPORTANT INTERVIEW POINTS
 * ==========================================================
 *
 * 1. CyclicBarrier is in java.util.concurrent.
 *
 * 2. new CyclicBarrier(3):
 *    Requires 3 await() calls from participating threads
 *    in each barrier cycle.
 *
 * 3. await():
 *    Blocks until all required parties arrive.
 *
 * 4. Reusability:
 *    The same barrier can be used in multiple phases.
 *
 * 5. getParties():
 *    Returns total required parties (3).
 *
 * 6. getNumberWaiting():
 *    Returns number of threads currently waiting.
 *
 * 7. isBroken():
 *    Checks whether the barrier is broken.
 *
 * 8. reset():
 *    Breaks the current cycle and resets the barrier.
 *    Currently waiting threads get BrokenBarrierException.
 *
 * 9. CyclicBarrier vs CountDownLatch:
 *    CyclicBarrier -> Threads wait for each other.
 *    CountDownLatch -> Threads wait for a count to reach 0.
 *
 * ==========================================================
 */
