
package com.rajeshkawali.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * =====================================================
 * Virtual Threads in Java (Java 21+)
 * =====================================================
 *
 * Virtual threads are lightweight threads managed
 * by the JVM instead of directly mapping each thread
 * to a dedicated operating system thread.
 *
 * They are useful for running many concurrent tasks,
 * especially tasks that spend time waiting for I/O.
 *
 * Executors.newVirtualThreadPerTaskExecutor()
 * creates a new virtual thread for each submitted task.
 */

public class VirtualThreadExample {

    public static void main(String[] args) {

        /*
         * Create an ExecutorService that starts
         * a new virtual thread for each task.
         *
         * try-with-resources automatically closes
         * the executor and waits for tasks to finish.
         */
        try (ExecutorService executor =
                Executors.newVirtualThreadPerTaskExecutor()) {

            /* Submit 100 tasks using virtual threads. */
            for (int i = 0; i < 100; i++) {
                executor.submit(new Worker());
            }

            System.out.println(
                    "Thread Name From Main: "
                    + Thread.currentThread().getName());
        }
    }
}

class Worker implements Runnable {

    @Override
    public void run() {

        System.out.println(
                "Thread Name: "
                + Thread.currentThread().getName()
                + " | Is Virtual: "
                + Thread.currentThread().isVirtual());
    }
}

/*
 * POSSIBLE OUTPUT:
 *
 * Thread Name From Main: main
 * Thread Name:  | Is Virtual: true
 * Thread Name:  | Is Virtual: true
 * Thread Name:  | Is Virtual: true
 * ...
 *
 * NOTE:
 * Virtual threads are unnamed by default.
 * Output order is not guaranteed.
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * 1. Virtual threads became a standard feature in Java 21.
 *
 * 2. They are lightweight and managed by the JVM.
 *
 * 3. A new virtual thread is created for each task.
 *
 * 4. Virtual threads are not pooled like platform threads.
 *
 * 5. Best suited for high-concurrency, blocking I/O tasks.
 *
 * 6. They do not automatically make CPU-intensive
 *    tasks execute faster.
 *
 * 7. Thread.currentThread().isVirtual()
 *    checks whether a thread is virtual.
 *
 * =====================================================
 */


/*
 * =====================================================
 * Virtual Threads in Java (Java 21+)
 * =====================================================
 *
 * DEFINITION:
 *
 * Virtual Threads are lightweight threads managed
 * by the JVM, designed to handle a large number
 * of concurrent tasks efficiently.
 *
 * They are especially useful for I/O-bound tasks
 * such as database calls, API calls, and file operations.
 *
 * IMPORTANT POINTS:
 *
 * 1. Introduced as a standard feature in Java 21.
 *
 * 2. Lightweight compared to platform threads.
 *
 * 3. Managed and scheduled by the JVM.
 *
 * 4. Can create thousands or millions of virtual
 *    threads, depending on available resources.
 *
 * 5. Best suited for blocking I/O operations.
 *
 * 6. Not intended to make CPU-intensive tasks faster.
 *
 * 7. Virtual threads are not pooled or reused.
 *
 * EXAMPLE:
 *
 * ExecutorService executor =
 *         Executors.newVirtualThreadPerTaskExecutor();
 *
 * executor.execute(() ->
 *         System.out.println("Virtual Thread Task")
 * );
 *
 * executor.close();
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * Platform Thread -> Heavier, OS-managed thread.
 * Virtual Thread  -> Lightweight, JVM-managed thread.
 *
 * =====================================================
 */




/*
 * =====================================================
 * Types of Executors in Java
 * =====================================================
 *
 * 1. newFixedThreadPool(n)
 *    -> Fixed number of reusable threads.
 *
 * 2. newCachedThreadPool()
 *    -> Creates threads as needed and reuses idle ones.
 *
 * 3. newSingleThreadExecutor()
 *    -> Executes tasks sequentially using one thread.
 *
 * 4. newScheduledThreadPool(n)
 *    -> Executes delayed and periodic tasks.
 *
 * 5. newSingleThreadScheduledExecutor()
 *    -> Executes scheduled tasks using one thread.
 *
 * 6. newWorkStealingPool()
 *    -> Uses work stealing for parallel processing.
 *
 * 7. newVirtualThreadPerTaskExecutor()
 *    -> Creates a new virtual thread per task.
 *       Available from Java 21.
 *
 * 8. newThreadPerTaskExecutor(factory)
 *    -> Creates a new thread per task.
 *       Available from Java 21.
 *
 * IMPORTANT:
 *
 * - Most methods also support a custom ThreadFactory.
 * - Scheduled executors return ScheduledExecutorService.
 * - Other methods above return ExecutorService.
 * - Always close or shut down executors when finished.
 * - Fixed and single-thread pools use unbounded queues.
 * - Cached and thread-per-task executors can create
 *   an unbounded number of threads.
 *
 * =====================================================
 */

