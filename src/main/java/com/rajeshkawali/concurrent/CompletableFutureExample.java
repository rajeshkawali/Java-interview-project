package com.rajeshkawali.concurrent;

public class CompletableFutureExample {

	public static void main(String[] args) {

		
		
	}

}
/*
Limitations of Future:-->

It cannot be manually completed :
Let’s say that you’ve written a function to fetch the latest price of an e-commerce product from a remote API. Since this API call is time-consuming, you’re running it in a separate thread and returning a Future from your function.
Now, let’s say that If the remote API service is down, then you want to complete the Future manually by the last cached price of the product.
Can you do this with Future? No!

You cannot perform further action on a Future’s result without blocking:
Future does not notify you of its completion. It provides a get() method which blocks until the result is available.
You don’t have the ability to attach a callback function to the Future and have it get called automatically when the Future’s result is available.

Multiple Futures cannot be chained together :
Sometimes you need to execute a long-running computation and when the computation is done, you need to send its result to another long-running computation, and so on.
You can not create such asynchronous workflow with Futures.

You can not combine multiple Futures together :
Let’s say that you have 10 different Futures that you want to run in parallel and then run some function after all of them completes. You can’t do this as well with Future.

No Exception Handling :
Future API does not have any exception handling construct.
*/