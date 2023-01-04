package com.rajeshkawali.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * 
 * @author Rajesh_Kawali
 */
public class CompletedFutureExample {
    public static void main(String[] args) throws Exception {
        // Create a CompletableFuture that is already completed with the value "Hello, World!"
        CompletableFuture<String> future = CompletableFuture.completedFuture("Hello, World!");

        // Print the value of the CompletableFuture using the get method (blocking)
        System.out.println(future.get());

        // Print the value of the CompletableFuture using the join method (blocking)
        System.out.println(future.join());

        // Print the value of the CompletableFuture using the thenApply method (non-blocking)
        future.thenApply(s -> s + "!").thenAccept(s -> System.out.println(s));

        // Print the value of the CompletableFuture using the thenAccept method (non-blocking)
        future.thenAccept(s -> System.out.println(s));

        // Print the value of the CompletableFuture using the thenRun method (non-blocking)
        future.thenRun(() -> System.out.println("Done!"));
    }
}
/*
1.The get() method is used to block until the CompletableFuture is complete and then retrieve the result.

2.The join() method is used to block until the CompletableFuture is complete and then retrieve the result.

3.The thenApply() method is used to apply a function to the result of the CompletableFuture, and the thenAccept method is used to consume the result of the CompletableFuture. These methods are non-blocking, meaning that they do not block the calling thread.

4.The thenRun() method is used to execute a runnable after the CompletableFuture is complete. This method is also non-blocking.
*/