package com.rajeshkawali.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * 
 * @author Rajesh_Kawali
 * 
 * @see https://www.callicoder.com/java-8-completablefuture-tutorial/
 */
public class CompletableFutureExample {

	public static void main(String[] args) throws Exception {
		/*
		 CompletableFuture is a class that represents the result of an asynchronous computation. 
		 It allows you to write asynchronous code in a way that is more similar to synchronous code, 
		 using a fluent API and method chaining.
		 */
		//CompletableFuture<String> completableFuture = new CompletableFuture<>();
		System.out.println("------------------------------------------------------");
		/*
		  runAsync():  takes Runnable as input parameter and returns CompletableFuture<Void>, 
		  which means it does not return any result.
		 */
		CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> System.out.println("Computation finished."));
		System.out.println(runAsync.get());// null - runAsync does not return anything. //get() - Block the thread
		System.out.println("------------------------------------------------------");
		/*
		  supplyAsync(): takes Supplier as argument and returns the CompletableFuture<U> with result value, 
		  which means it does not take any input parameters but it returns result as output.
		 */
		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
	        System.out.println("CompletableFuture supplyAsync() example");
	        return "result printed on console";
	    });
		System.out.println(supplyAsync.get()); //get() - Block the thread
		System.out.println("------------------------------------------------------");
		/*
		 thenApply(): Takes function and apply it on to the result of the previous stage. 
		 Remember that thenApply() is a synchronous mapping function. 
		 It returns a CompletionStage holding the result of the function.
		 
		 thenApply() is executed in the same thread where the supplyAsync() task is executed, 
		 or in the main thread if the supplyAsync() task completes immediately (try removing sleep() call to verify).
		 */
		CompletableFuture.supplyAsync(() -> getOrder())
        .thenApply(order -> orderEnrich(order))
        .thenApply(order -> orderCreated(order))
        .thenApply(order -> sendOrderCreatedNotification(order))
        .thenAccept(order -> deliverOrder(order));
		System.out.println("------------------------------------------------------");
		//thenApplyAsync() --> If you use thenApplyAsync() callback, then it will be executed in a different thread obtained from ForkJoinPool.commonPool()
		/*
    	1.thenApply(fn) :- runs fn on a thread defined by the CompleteableFuture on which it is called, so you generally cannot know where this will be executed. It might immediately execute if the result is already available.
    	2.thenApplyAsync(fn) :- runs fn on a environment-defined executor regardless of circumstances. For CompletableFuture this will generally be ForkJoinPool.commonPool().
    	3.thenApplyAsync(fn,exec) :- runs fn on exec.
		 */
		CompletableFuture<Integer> cFuture = CompletableFuture.supplyAsync(() -> 0);
		cFuture.thenApplyAsync(x -> x + 1) // call 1
        .thenApplyAsync(x -> x + 1)
        .thenAccept(x -> System.out.println("async result: " + x));

		cFuture.thenApply(x -> x + 1) // call 2
        .thenApply(x -> x + 1)
        .thenAccept(x -> System.out.println("sync result:" + x));
		System.out.println("------------------------------------------------------");
		CompletableFuture.supplyAsync(() -> getOrder())
        .thenApplyAsync(order -> orderEnrich(order))
        .thenApplyAsync(order -> orderCreated(order))
        .thenApplyAsync(order -> sendOrderCreatedNotification(order))
        .thenAccept(order -> deliverOrder(order));
		System.out.println("------------------------------------------------------");
		/*
		  thenRun(): Executes a Runnable and returns CompletionStage<Void>. 
		  It will not even be having access to final value in the pipeline.
		 */
		CompletableFuture<String> f1 = new CompletableFuture<>();
		CompletableFuture<Void> f2 = f1.thenRun(() -> System.out.println("Computation finished."));
		System.out.println(f2);
		System.out.println("------------------------------------------------------");
		/*
		 thenCombine(): Takes BiFunction and acts upon the result of the previous two stages in the pipeline. 
		 It returns CompletionStage holding the result of the Function.
		 */
		CompletableFuture<Integer> future = 
			    CompletableFuture.supplyAsync(() -> 1)
			                     .thenApply(x -> x+1)
			                     .thenCombine(CompletableFuture.supplyAsync(() -> 3), (value1, value2) -> value1 + value2);
		System.out.println(future.get());
		System.out.println("------------------------------------------------------");
		/*
		 thenAccept(): Takes a consumer and returns CompletionStage<Void>. thenAccept() is usually 
		 called during the final stages of pipeline and returns a final value.
		 */
        CompletableFuture<Void> futureCompose = 
        	    CompletableFuture.supplyAsync(() -> 1)
        	                     .thenCompose(x -> CompletableFuture.supplyAsync(()-> x+1))
        	                     .thenAccept(System.out::println);
        System.out.println(futureCompose);
		System.out.println("------------------------------------------------------");
		/*
		 runAfterBoth(): Returns a new CompletionStage that, when this and the other 
		 given stage both complete normally, executes the given action.
		 */
		String original = "message";
		StringBuilder result = new StringBuilder();
		CompletableFuture.completedFuture(original)
		.thenApply(String::toUpperCase)
		.runAfterBoth(CompletableFuture.completedFuture(original)
		.thenApply(String::toLowerCase),() -> result.append("done"))
		.thenAccept(System.out::println);
		System.out.println("------------------------------------------------------");
		/*
		 thenAcceptBoth(): Takes a BiConsumer and returns CompletionStage<Void>. thenAccept() is 
		 usually called during the final stages of pipeline and returns a final value.
		 */
		CompletableFuture.completedFuture(original)
		.thenApply(String::toUpperCase)
		.thenAcceptBoth(CompletableFuture.completedFuture(original)
		.thenApply(String::toLowerCase),(s1, s2) -> result.append(s1 + s2));
		System.out.println("------------------------------------------------------");
		CompletableFuture.supplyAsync(() -> getOrder())
        .thenApply(order -> orderEnrich(order))
        .thenApply(order -> orderCreated(order))
        .thenApply(order -> sendOrderCreatedNotification(order))
        .thenAccept(order -> deliverOrder(order));
		System.out.println("------------------------------------------------------");

		System.out.println("------------------------------------------------------");

	}

	private static String getOrder() {
		return "order request";
	}

	private static String orderEnrich(String order) {
		return order+", order enrich";
	}

	private static String orderCreated(String order) {
		return order+", order created";
	}
	
	private static String sendOrderCreatedNotification(String order) {
		return order+", send order notification";
	}
	
	private static void deliverOrder(String order) {
		System.out.println(order);
	}
}
/*
  Limitations of Future:-->
  
  1.It cannot be manually completed :- 
  Let’s say that you’ve written a function
  to fetch the latest price of an e-commerce product from a remote API. Since
  this API call is time-consuming, you’re running it in a separate thread and
  returning a Future from your function. Now, let’s say that If the remote API
  service is down, then you want to complete the Future manually by the last
  cached price of the product. Can you do this with Future? No!
  
  2.You cannot perform further action on a Future’s result without blocking:-
  Future does not notify you of its completion. It provides a get() method
  which blocks until the result is available. You don’t have the ability to
  attach a callback function to the Future and have it get called automatically
  when the Future’s result is available.
  
  3.Multiple Futures cannot be chained together :- 
  Sometimes you need to
  execute a long-running computation and when the computation is done, you need
  to send its result to another long-running computation, and so on. You can
  not create such asynchronous workflow with Futures.
  
  4.You can not combine multiple Futures together :- 
  Let’s say that you have 10
  different Futures that you want to run in parallel and then run some function
  after all of them completes. You can’t do this as well with Future.
  
  5.No Exception Handling :- 
  Future API does not have any exception handling construct.
  
  
  Limitations of Future: 
  1.Action performing on Future’s result was blocking.
  2.A Future cannot be mutually completed. 
  3.No exception handling techniques were provided for Futures. 
  4.Multiple Futures were not able to combine
  
*/
 