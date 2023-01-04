package com.rajeshkawali.concurrent;

import java.util.concurrent.Exchanger;

/**
 * 
 * @author Rajesh_Kawali
 */
public class ExchangerExample {
/*
 The Exchanger class:- is allows two threads to exchange objects at a rendezvous point. 
 It has a exchange() method that blocks the calling thread until another thread arrives at 
 the rendezvous point and calls the exchange() method. When both threads have arrived, 
 they exchange the objects they brought and continue execution.
 
 The Exchanger class is useful for exchanging data between two threads in a synchronous manner. 
 It can be used to synchronize the processing of data by different threads, 
 or to transfer data between threads in a pipeline-like manner.
 */
	public static void main(String[] args) {

		// create an Exchanger
		Exchanger<String> exchanger = new Exchanger<>();

		// create and start two threads that exchange strings
		new Thread(new StringProducer(exchanger)).start();
		new Thread(new StringConsumer(exchanger)).start();
	}
}

class StringProducer implements Runnable {

	private Exchanger<String> exchanger;
	private String string;

	public StringProducer(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
		this.string = "Hello";
	}

	@Override
	public void run() {
		try {
			System.out.println("Producer before exchange: " + string);
			// exchange the string with the consumer
			string = exchanger.exchange(string);
			System.out.println("Producer after exchange: " + string);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class StringConsumer implements Runnable {

	private Exchanger<String> exchanger;
	private String string;

	public StringConsumer(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
		this.string = "World";
	}

	@Override
	public void run() {
		try {
			System.out.println("Consumer before exchange: " + string);
			// exchange the string with the producer
			string = exchanger.exchange(string);
			System.out.println("Consumer after exchange: " + string);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/*
1.exchange(V x):- Blocks the calling thread until another thread arrives at the rendezvous point and calls the exchange() method. When both threads have arrived, they exchange the objects they brought and continue execution.
2.exchange(V x, long timeout, TimeUnit unit):- Blocks the calling thread until another thread arrives at the rendezvous point and calls the exchange() method, or until the specified timeout has expired. When both threads have arrived, they exchange the objects they brought and continue execution. If the timeout expires before the other thread arrives, the exchange() method throws a TimeoutException.
3.reset():- Resets the Exchanger to its initial state. This method is useful if you want to reuse the Exchanger multiple times.
*/

/*
Rendezvous point:- Means (also called a "barrier" or a "handshake") is a point at which multiple threads or processes 
synchronize their execution and exchange data. At the rendezvous point, the threads or processes stop their 
execution and wait for each other to arrive. When all threads or processes have arrived, they exchange data and continue execution.
 */







