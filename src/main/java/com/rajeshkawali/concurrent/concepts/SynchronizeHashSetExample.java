package com.rajeshkawali.concurrent.concepts;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Rajesh_Kawali
 * 
 */
public class SynchronizeHashSetExample {

	public static void main(String[] args) throws Exception {
		String url = "http url";
		ExecutorService threadPool = Executors.newFixedThreadPool(4);

		Set<Integer> sumValues = Collections.synchronizedSet(new HashSet<>());

		CountDownLatch latch = new CountDownLatch(3);

		threadPool.submit(new PriceService(url, sumValues, 1, latch));
		threadPool.submit(new PriceService(url, sumValues, 2, latch));
		threadPool.submit(new PriceService(url, sumValues, 3, latch));

		latch.await(3, TimeUnit.SECONDS);

		System.out.println(sumValues);
		// We can return reult if we created this method in separate -> return sumValues;
		
		threadPool.shutdown();
	}
}

class PriceService implements Runnable {

	private final Set<Integer> addprice;
	private final Integer price;
	@SuppressWarnings("unused")
	private final String url;
	private final CountDownLatch latch;

	public PriceService(String url, Set<Integer> addprice, Integer price, CountDownLatch latch) {
		this.url = url;
		this.addprice = addprice;
		this.price = price;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			// We can make any http call to get the price and add.
			// url
			addprice.add(price);
			latch.countDown();
		} catch (Exception ex) {
			Logger.getLogger(PriceService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
/*
This code creates a thread pool using the Executors.newFixedThreadPool(4) method, which creates a fixed-size thread pool with 4 threads. 
It then creates a synchronized set using the Collections.synchronizedSet(new HashSet<>()) method, 
which wraps a regular HashSet in a thread-safe wrapper.

The code then creates a CountDownLatch with a count of 3, and submits 3 tasks to the thread pool, 
each represented by an instance of the PriceService class. These tasks are responsible for making an 
HTTP call (or any other code that retrieves a price) and adding the retrieved price to the synchronized set. 
After adding the price to the set, the task calls the countDown() method on the latch to decrement the count.

The main thread then calls the await() method on the latch, which blocks until the count reaches 0. 
Once the count reaches 0, it means that all the tasks have completed and the main thread can print out the
contents of the synchronized set using System.out.println(sumValues).

This code is using CountDownLatch to synchronize the threads and wait for all the threads to complete 
execution before printing the result. The synchronized set is used to ensure that only one thread can 
access the set at a time, preventing concurrent modification exceptions.
*/