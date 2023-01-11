package com.rajeshkawali.concurrent.concepts;

import java.util.LinkedList;

/**
 * @author Rajesh_Kawali
 *
 */
public class ProducerConsumerMain {

	public static void main(String[] args) {
		
		ProducerConsumer pc = new ProducerConsumer();
		
		Thread t1 = new Thread(() -> {
			try {
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				pc.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t1.start();
		t2.start();
	}
}

class ProducerConsumer {
	private LinkedList<Integer> queue = new LinkedList<>();
	private final int LIMIT = 10;
	private final Object lock = new Object();

	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (lock) {
				while (queue.size() == LIMIT) {
					lock.wait();
				}
				queue.add(value++);
				lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (lock) {
				while (queue.size() == 0) {
					lock.wait();
				}
				int value = queue.remove();
				System.out.println("Consumed " + value);
				lock.notify();
			}
			Thread.sleep(1000);
		}
	}
}

/*
In this example, the ProducerConsumer class has an instance variable queue which is a 
LinkedList that holds the shared data, and a LIMIT variable that defines the maximum 
size of the queue. The class also has an instance variable 
lock which is an Object used for synchronizing access to the queue.

The produce() method adds an element to the queue in an infinite loop, 
but it will only do so if the queue is not at capacity. If the queue is at capacity, 
the thread will wait until it is notified by the consumer that an element has been removed.

The consume() method removes an element from the queue and prints it in an 
infinite loop, but it will only do so if the queue is not empty. If the queue is empty, 
the thread will wait until it is notified by the producer that an element has been added.
*/