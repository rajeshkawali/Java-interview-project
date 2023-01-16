package com.rajeshkawali.concurrent.completablefuture;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
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
public class CompletableFutureHashSetExample {

	public static void main(String[] args) throws Exception {
		String url = "http url";
		ExecutorService threadPool = Executors.newFixedThreadPool(4);

		Set<Integer> sumValues = Collections.synchronizedSet(new HashSet<>());

		CompletableFuture<Void> f1 = CompletableFuture.runAsync(new PriceService(url, sumValues, 1), threadPool);
		CompletableFuture<Void> f2 = CompletableFuture.runAsync(new PriceService(url, sumValues, 2), threadPool);
		CompletableFuture<Void> f3 = CompletableFuture.runAsync(new PriceService(url, sumValues, 3), threadPool);
		
		//We can use without ThreadPool
		//CompletableFuture<Void> f1 = CompletableFuture.runAsync(new PriceService(url, sumValues, 1));
		//CompletableFuture<Void> f2 = CompletableFuture.runAsync(new PriceService(url, sumValues, 2));
		//CompletableFuture<Void> f3 = CompletableFuture.runAsync(new PriceService(url, sumValues, 3));

		// Combine all future response
		CompletableFuture<Void> allPrice = CompletableFuture.allOf(f1, f2, f3);
		
		//This will waits for all task to complete only for 3 seconds 
		allPrice.get(3, TimeUnit.SECONDS);
		
		System.out.println(sumValues);
		
		threadPool.shutdown();
	}
}

class PriceService implements Runnable {

	private final Set<Integer> addprice;
	private final Integer price;
	@SuppressWarnings("unused")
	private final String url;

	public PriceService(String url, Set<Integer> addprice, Integer price) {
		this.url = url;
		this.addprice = addprice;
		this.price = price;
	}

	@Override
	public void run() {
		try {
			// We can make any http call to get the price and add.
			// url
			addprice.add(price);
		} catch (Exception ex) {
			Logger.getLogger(PriceService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
/*
Java program that demonstrates the use of multithreading with CompletableFuture and Collections.synchronizedSet to 
retrieve prices from an HTTP URL and add them to a thread-safe set.

The main method of the program starts by defining an ExecutorService threadPool of fixed size 4 threads 
using Executors.newFixedThreadPool(4). This thread pool will be used to execute the PriceService tasks concurrently.

Then, it creates a synchronized set, which wraps a regular HashSet in a thread-safe wrapper, 
using Collections.synchronizedSet(new HashSet<>()). This set will be used to store the prices retrieved from the HTTP URL.

Then, the program creates 3 CompletableFuture instances, f1, f2 and f3, each representing a PriceService task. 
The runAsync() method is used to submit the PriceService task to the thread pool and returns a 
CompletableFuture<Void> which completes when the PriceService task is completed.

Then, the program creates another CompletableFuture called allPrice, using the allOf() method, 
that completes when all of the provided CompletableFuture instances have completed.

The program calls the get(3, TimeUnit.SECONDS) method on the allPrice future, 
it will wait for the completion of all tasks for 3 seconds, if all the tasks are 
not completed within 3 seconds it will throw a TimeoutException.

Once all the tasks have completed, the main thread can print out the contents 
of the synchronized set using System.out.println(sumValues)

The PriceService class implements the Runnable interface and overrides the run() method, 
this method is responsible for making an HTTP call (or any other code that retrieves a price) 
and adding the retrieved price to the synchronized set.

The use of CompletableFuture and synchronized set in this example allows to retrieve prices 
concurrently and store them in a thread-safe manner, and also provide a way to wait for the 
completion of all tasks with a timeout feature.
*/