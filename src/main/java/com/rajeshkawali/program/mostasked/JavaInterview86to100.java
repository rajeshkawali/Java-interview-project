package com.rajeshkawali.program.mostasked;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class JavaInterview86to100 {
	static class CustomHashMap<K, V> {
		static class Entry<K, V> {
			K key;
			V value;
			Entry<K, V> next;

			Entry(K k, V v, Entry<K, V> n) {
				key = k;
				value = v;
				next = n;
			}
		}

		private final Entry<K, V>[] buckets;

		@SuppressWarnings("unchecked")
		CustomHashMap(int capacity) {
			if (capacity <= 0)
				throw new IllegalArgumentException();
			buckets = (Entry<K, V>[]) new Entry[capacity];
		}

		private int index(K key) {
			return Math.floorMod(Objects.hashCode(key), buckets.length);
		}

		void put(K key, V value) {
			int i = index(key);
			for (Entry<K, V> e = buckets[i]; e != null; e = e.next) {
				if (Objects.equals(e.key, key)) {
					e.value = value;
					return;
				}
			}
			buckets[i] = new Entry<>(key, value, buckets[i]);
		}

		V get(K key) {
			for (Entry<K, V> e = buckets[index(key)]; e != null; e = e.next)
				if (Objects.equals(e.key, key))
					return e.value;
			return null;
		}

		V remove(K key) {
			int i = index(key);
			Entry<K, V> prev = null, e = buckets[i];
			while (e != null) {
				if (Objects.equals(e.key, key)) {
					if (prev == null)
						buckets[i] = e.next;
					else
						prev.next = e.next;
					return e.value;
				}
				prev = e;
				e = e.next;
			}
			return null;
		}
	}

	static class Employee {
		final String name;
		final int salary;

		Employee(String n, int s) {
			name = n;
			salary = s;
		}

		public String toString() {
			return name + "=" + salary;
		}
	}

	static class Student {
		final int id;
		final String name;

		Student(int i, String n) {
			id = i;
			name = n;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof Student))
				return false;
			Student s = (Student) o;
			return id == s.id && Objects.equals(name, s.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, name);
		}
	}

	static final class ImmutableEmployee {
		private final String name;
		private final Date joiningDate;

		ImmutableEmployee(String n, Date d) {
			name = Objects.requireNonNull(n);
			joiningDate = new Date(Objects.requireNonNull(d).getTime());
		}

		String getName() {
			return name;
		}

		Date getJoiningDate() {
			return new Date(joiningDate.getTime());
		}
	}

	static final class Singleton {
		private Singleton() {
		}

		private static class Holder {
			static final Singleton INSTANCE = new Singleton();
		}

		static Singleton getInstance() {
			return Holder.INSTANCE;
		}
	}

	static class NumberPrinter {
		private int next = 1;
		private final int limit;

		NumberPrinter(int limit) {
			this.limit = limit;
		}

		synchronized void print(boolean odd) {
			while (next <= limit) {
				while (next <= limit && (next % 2 == 1) != odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						notifyAll();
						return;
					}
				}
				if (next > limit)
					break;
				System.out.println("94. " + (odd ? "Odd" : "Even") + ": " + next++);
				notifyAll();
			}
			notifyAll();
		}
	}

	static class Node {
		int value;
		Node next;

		Node(int v) {
			value = v;
		}
	}

	static Node reverse(Node head) {
		Node previous = null;
		while (head != null) {
			Node next = head.next;
			head.next = previous;
			previous = head;
			head = next;
		}
		return previous;
	}

	static boolean hasCycle(Node head) {
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

	static String show(Node head) {
		StringJoiner sj = new StringJoiner(" -> ");
		while (head != null) {
			sj.add(String.valueOf(head.value));
			head = head.next;
		}
		return sj.toString();
	}

	static class ArrayStack {
		private final int[] values;
		private int size = 0;

		ArrayStack(int capacity) {
			values = new int[capacity];
		}

		void push(int v) {
			if (size == values.length)
				throw new IllegalStateException("Stack full");
			values[size++] = v;
		}

		int pop() {
			if (size == 0)
				throw new NoSuchElementException("Stack empty");
			return values[--size];
		}

		int peek() {
			if (size == 0)
				throw new NoSuchElementException("Stack empty");
			return values[size - 1];
		}
	}

	static class ArrayQueue {
		private final int[] values;
		private int front = 0, size = 0;

		ArrayQueue(int capacity) {
			if (capacity <= 0)
				throw new IllegalArgumentException();
			values = new int[capacity];
		}

		void enqueue(int v) {
			if (size == values.length)
				throw new IllegalStateException("Queue full");
			values[(front + size) % values.length] = v;
			size++;
		}

		int dequeue() {
			if (size == 0)
				throw new NoSuchElementException("Queue empty");
			int v = values[front];
			front = (front + 1) % values.length;
			size--;
			return v;
		}

		int peek() {
			if (size == 0)
				throw new NoSuchElementException("Queue empty");
			return values[front];
		}
	}

	static class LRUCache<K, V> extends LinkedHashMap<K, V> {
		private final int capacity;

		LRUCache(int c) {
			super(16, .75f, true);
			if (c <= 0)
				throw new IllegalArgumentException();
			capacity = c;
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
			return size() > capacity;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CustomHashMap<String, Integer> custom = new CustomHashMap<>(8);
		custom.put("Java", 100);
		custom.put("Python", 200);
		System.out.println("86. Custom HashMap get(Java): " + custom.get("Java"));
		List<Integer> nums = Arrays.asList(10, 20, 10, 30, 20, 40);
		System.out.println("87. Unique ArrayList: " + new ArrayList<>(new LinkedHashSet<>(nums)));
		Map<String, Integer> map = new HashMap<>();
		map.put("Java", 80);
		map.put("Python", 70);
		map.put("Spring", 90);
		System.out.println("88. Sorted by key: " + new TreeMap<>(map));
		Map<String, Integer> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
		System.out.println("88. Sorted by value: " + sorted);
		List<Employee> employees = Arrays.asList(new Employee("Ravi", 50000), new Employee("Asha", 70000),
				new Employee("Neha", 60000));
		System.out.println("89. Employees by salary: " + employees.stream()
				.sorted(Comparator.comparingInt((Employee e) -> e.salary).reversed()).collect(Collectors.toList()));
		Student s1 = new Student(101, "Ravi"), s2 = new Student(101, "Ravi");
		System.out.println("90. equals: " + s1.equals(s2) + ", same hash: " + (s1.hashCode() == s2.hashCode()));
		Date source = new Date(0);
		ImmutableEmployee immutable = new ImmutableEmployee("Asha", source);
		source.setTime(100000);
		Date returned = immutable.getJoiningDate();
		returned.setTime(200000);
		System.out.println("91. Immutable joining timestamp: " + immutable.getJoiningDate().getTime());
		System.out.println("92. Same Singleton: " + (Singleton.getInstance() == Singleton.getInstance()));
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
		List<Integer> consumed = Collections.synchronizedList(new ArrayList<>());
		Thread producer = new Thread(() -> {
			try {
				for (int i = 1; i <= 5; i++)
					queue.put(i);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		Thread consumer = new Thread(() -> {
			try {
				for (int i = 1; i <= 5; i++)
					consumed.add(queue.take());
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		producer.start();
		consumer.start();
		producer.join();
		consumer.join();
		System.out.println("93. Consumed: " + consumed);
		NumberPrinter printer = new NumberPrinter(10);
		Thread odd = new Thread(() -> printer.print(true)), even = new Thread(() -> printer.print(false));
		odd.start();
		even.start();
		odd.join();
		even.join();
		AtomicInteger counter = new AtomicInteger();
		Runnable increment = () -> {
			for (int i = 0; i < 1000; i++)
				counter.incrementAndGet();
		};
		Thread t1 = new Thread(increment), t2 = new Thread(increment);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("95. Thread-safe counter: " + counter.get());
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		System.out.println("96. Reversed list: " + show(reverse(head)));
		Node cycle = new Node(1);
		cycle.next = new Node(2);
		cycle.next.next = new Node(3);
		cycle.next.next.next = cycle.next;
		System.out.println("97. Cycle detected: " + hasCycle(cycle));
		ArrayStack stack = new ArrayStack(3);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("98. Stack pop: " + stack.pop() + ", peek: " + stack.peek());
		ArrayQueue aq = new ArrayQueue(3);
		aq.enqueue(10);
		aq.enqueue(20);
		aq.enqueue(30);
		System.out.println("99. Queue dequeue: " + aq.dequeue() + ", peek: " + aq.peek());
		LRUCache<Integer, String> cache = new LRUCache<>(2);
		cache.put(1, "One");
		cache.put(2, "Two");
		cache.get(1);
		cache.put(3, "Three");
		System.out.println("100. LRU contains key 2: " + cache.containsKey(2) + ", keys LRU to MRU: " + cache.keySet());
	}
}
