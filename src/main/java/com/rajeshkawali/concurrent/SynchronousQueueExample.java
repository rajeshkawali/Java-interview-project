package com.rajeshkawali.concurrent;

import java.util.concurrent.SynchronousQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * @author Rajesh_Kawali
 */
public class SynchronousQueueExample {

	/*
	SynchronousQueue is a type of blocking queue in which each insert operation must 
	wait for a corresponding remove operation by another thread, and vice versa. 
	It is a type of "rendezvous" queue, in which producers must wait for consumers 
	to take elements from the queue, and consumers must wait for producers to add elements to the queue.

	A SynchronousQueue does not have any internal capacity, which means that it 
	cannot store elements. This means that every insert operation must wait for a 
	corresponding remove operation, and every remove operation must wait for a corresponding insert operation.
	*/
	public static void main(String[] args) throws InterruptedException {

		SynchronousQueue<Integer> queue = new SynchronousQueue<>();

		Thread t1 = new Thread(new SynchronousQueueProducer(queue, 1), "Thread 1");
		Thread t2 = new Thread(new SynchronousQueueConsumer(queue), "Thread 2");
		Thread t3 = new Thread(new SynchronousQueueProducer(queue, 3), "Thread 3");
		Thread t4 = new Thread(new SynchronousQueueConsumer(queue), "Thread 4");
		Thread t5 = new Thread(new SynchronousQueueProducer(queue, 5), "Thread 5");
		Thread t6 = new Thread(new SynchronousQueueConsumer(queue), "Thread 6");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();

		Thread.sleep(500);
		System.out.println(queue.remainingCapacity());
	}
}

class SynchronousQueueConsumer implements Runnable {

	private SynchronousQueue<Integer> queue;

	public SynchronousQueueConsumer(SynchronousQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			int element = queue.take();
			System.out.println(
					Thread.currentThread().getName() + " - Consumer took an element from the queue: " + element);
		} catch (Exception ex) {
			Logger.getLogger(SynchronousQueueConsumer.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

class SynchronousQueueProducer implements Runnable {

	private Integer value;

	private SynchronousQueue<Integer> queue;

	public SynchronousQueueProducer(SynchronousQueue<Integer> queue, Integer value) {
		this.queue = queue;
		this.value = value;
	}

	@Override
	public void run() {
		try {
			queue.put(value);
			System.out
					.println(Thread.currentThread().getName() + " - Producer added an element to the queue: " + value);
		} catch (Exception ex) {
			Logger.getLogger(SynchronousQueueConsumer.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
/*
Most commonly used methods of the SynchronousQueue class in Java:-->

1.put(E e): Inserts the specified element into the queue, waiting if necessary for another thread to remove it.
2.take(): Retrieves and removes the head of the queue, waiting if necessary for another thread to insert it.
3.offer(E e): Inserts the specified element into the queue, waiting up to the specified wait time if necessary for another thread to remove it.
4.poll(long timeout, TimeUnit unit): Retrieves and removes the head of the queue, waiting up to the specified wait time if necessary for another thread to insert it.
5.remainingCapacity(): Returns the number of additional elements that this queue can ideally (in the absence of memory or resource constraints) accept without blocking. This method always returns zero for a SynchronousQueue, since it has no capacity.

The put() and take() methods are the most commonly used methods of the SynchronousQueue class. 
The put() method allows you to insert an element into the queue, while the take() method 
allows you to retrieve and remove the head of the queue.

The offer() and poll() methods are similar to the put() and take() methods, but they 
allow you to specify a time limit for waiting. If the element cannot be inserted or 
removed within the specified time limit, these methods return false.

The remainingCapacity() method returns the number of additional elements that the 
queue can accept without blocking. Since a SynchronousQueue has no capacity, this method always returns zero.
*/

/*
Some key points to remember when using the SynchronousQueue class in Java:-->

1.SynchronousQueue is a type of blocking queue that does not have any internal capacity. 
This means that each insert operation must wait for a corresponding remove operation, and vice versa.

2.SynchronousQueue is a useful class for cases where you want to transfer elements directly 
from producers to consumers without storing them in an intermediate buffer.

3.The put() and take() methods are the most commonly used methods of the SynchronousQueue class. 
The put() method inserts an element into the queue, while the take() method retrieves and removes the head of the queue.

4.The offer() and poll() methods are similar to the put() and take() methods, but they allow 
you to specify a time limit for waiting. If the element cannot be inserted or removed within 
the specified time limit, these methods return false.

5.The remainingCapacity() method returns the number of additional elements that the queue 
can accept without blocking. Since a SynchronousQueue has no capacity, this method always returns zero.

*/
