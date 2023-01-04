package com.rajeshkawali.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * 
 * @author Rajesh_Kawali
 */
public class CompletableFutureExceptionally {

	public static void main(String[] args) {

		/*
		 * completeExceptionally(): Operation can be completed exceptionally, indicating
		 * a failure in the computation. Separate “handler” stage, exceptionHandler,
		 * that handles any exception by returning another message "message upon
		 * cancel".Next, we explicitly complete the second stage with an exception.
		 */

		CompletableFuture<String> f1 = CompletableFuture.completedFuture("message");
		f1.completeExceptionally(new RuntimeException("completed exceptionally"));
		System.out.println(f1);
		System.out.println("--------------------------------------------------------------------");
		/*
		 * exceptionally(): Returns a new CompletableFuture that is completed when this
		 * CompletableFuture completes, with the result of the given function of the
		 * exception triggering this CompletableFuture’s completion when it completes
		 * exceptionally; otherwise, if this CompletableFuture completes normally.
		 */
		CompletableFuture<String> f11 = CompletableFuture.completedFuture("message");
		CompletableFuture<String> f2 = f11.exceptionally(throwable -> "canceled message");
		System.out.println(f2);
		System.out.println("--------------------------------------------------------------------");
		CompletableFuture.supplyAsync(() -> getOrder())
		.thenApply(order -> orderEnrich(order))
				.thenApply(order -> orderCreated(order))
				.exceptionally(e -> orderFailedWithException(e)) // Catch if exception
				.thenApply(order -> sendOrderCreatedNotification(order))
				.thenAccept(order -> deliverOrder(order));
		System.out.println("--------------------------------------------------------------------");
	}

	private static String orderFailedWithException(Throwable e) {
		System.out.println(e.getMessage());
		return e.getMessage();
	}

	private static String getOrder() {
		return "order request";
	}

	private static String orderEnrich(String order) {
		//int result = 10/0; // Uncomment this will generate exception
		return order + ", order enrich";
	}

	private static String orderCreated(String order) {
		return order + ", order created";
	}

	private static String sendOrderCreatedNotification(String order) {
		return order + ", send order notification";
	}

	private static void deliverOrder(String order) {
		System.out.println(order);
	}

}
