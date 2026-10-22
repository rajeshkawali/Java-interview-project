# Java Concurrency & JVM Interview Preparation — Questions 1–40

A practical interview-preparation guide with candidate-style answers, examples, production troubleshooting, and quick revision notes.

> **How to answer in an interview:** Start with a direct definition, explain the internal behavior, give a short example, and finish with a production consideration.

## Table of Contents

1. Why is HashMap not thread-safe?
2. How does ConcurrentHashMap work internally?
3. Why doesn't volatile make i++ thread-safe?
4. What happens when two different keys have the same hashCode?
5. When would you choose AtomicInteger over synchronized?
6. How does the JVM decide whether an object is eligible for GC?
7. An application suddenly throws OutOfMemoryError. What do you check first?
8. How can ThreadLocal cause a memory leak?
9. Difference between wait(), sleep(), and join()
10. How do you detect deadlock in production?
11. How does CompletableFuture execute asynchronous tasks?
12. What happens when a Java class is loaded?
13. Why are immutable objects useful in multithreaded applications?
14. How do you troubleshoot frequent long GC pauses?
15. Your application suddenly has thousands of threads. What could cause it?
16. Platform threads vs. virtual threads
17. What happens when an ExecutorService reaches its maximum pool size?
18. How do you identify a thread-pool leak?
19. BLOCKED vs. WAITING vs. TIMED_WAITING
20. Why can increasing the thread pool make performance worse?
21. How do you troubleshoot unable to create native thread?
22. How do virtual threads change thread-pool sizing?
23. What is a race condition, and how do you fix it?
24. synchronized vs. ReentrantLock vs. ReadWriteLock
25. How does AtomicInteger work using CAS?
26. What is CAS and the ABA problem?
27. What is false sharing?
28. How does ForkJoinPool work?
29. How does CompletableFuture handle exceptions and cancellation?
30. How do you design a thread-safe Singleton?
31. What is the Java Memory Model?
32. What is a happens-before relationship?
33. How does volatile work?
34. What is safe publication?
35. Why is HashMap dangerous when modified concurrently?
36. How does ConcurrentHashMap.computeIfAbsent() work?
37. How do you troubleshoot 100% CPU usage?
38. How do you investigate a memory leak using a heap dump?
39. What is a Stop-The-World pause?
40. How do you diagnose a slow application with low CPU usage?

**Additional Resources**

- Quick Revision Table
- Production Troubleshooting Commands

---

## 1. Why is HashMap not thread-safe?

### Candidate answer

`HashMap` is not thread-safe because it does not coordinate concurrent access or provide the necessary visibility guarantees when multiple threads modify it. Concurrent updates can overwrite each other or lead to inconsistent behavior.

```java
Map<String, Integer> map = new HashMap<>();

// If multiple threads modify this map concurrently,
// the application must provide external synchronization.
```

For concurrent access, I would usually choose:

```java
Map<String, Integer> map = new ConcurrentHashMap<>();
```

Alternatively, for simpler cases:

```java
Map<String, Integer> map =
        Collections.synchronizedMap(new HashMap<>());
```

A synchronized wrapper requires care during iteration; synchronize on the wrapper while iterating.

**Interview takeaway:** `HashMap` is appropriate for single-threaded or externally synchronized access. For concurrent updates, use a concurrent collection or explicit synchronization.

## 2. How does ConcurrentHashMap work internally?

### Candidate answer

Modern `ConcurrentHashMap` implementations use a combination of volatile reads/writes, CAS (compare-and-set), and fine-grained synchronization when necessary. They avoid locking the entire map for every operation.

At a high level, a `put` operation hashes the key, identifies a bucket, and then handles the insertion or collision. A heavily collided bucket can be represented as a tree to improve lookup performance.

Important points:

- It supports concurrent reads and updates.
- It does not permit `null` keys or values.
- It is generally preferable to synchronizing every access to a regular `HashMap`.
- Exact implementation details vary by JDK version.

```java
ConcurrentHashMap<String, Integer> counts =
        new ConcurrentHashMap<>();

counts.put("JAVA", 1);
counts.merge("JAVA", 1, Integer::sum);
```

**Interview takeaway:** `ConcurrentHashMap` provides thread-safe map operations with finer-grained coordination than a single synchronized map.

## 3. Why doesn't volatile make i++ thread-safe ?

### Candidate answer

`volatile` provides visibility and ordering guarantees, but it does not make a compound read-modify-write operation atomic.

```java
private volatile int count;

void increment() {
    count++; // Not atomic
}
```

The increment consists conceptually of reading the value, adding one, and writing it back. Two threads can read the same old value and overwrite one another's updates.

Use `AtomicInteger` for a single counter:

```java
private final AtomicInteger count = new AtomicInteger();

void increment() {
    count.incrementAndGet();
}
```

Or use synchronization when the operation involves multiple related pieces of state.

**Interview takeaway:** `volatile` is for visibility and ordering, not general atomicity.

## 4. What happens when two different keys have the same hashCode?

### Candidate answer

A hash collision occurs. Different keys can map to the same bucket, but `HashMap` uses both the hash and `equals()` to distinguish keys.

```java
String first = "FB";
String second = "Ea";

// These strings are a classic example of distinct strings
// with the same hash code.
System.out.println(first.hashCode() == second.hashCode()); // true
System.out.println(first.equals(second));                  // false
```

Both can exist as separate keys because they are not equal. In modern Java implementations, heavily collided buckets may be treeified when the relevant conditions are met.

**Interview takeaway:** A collision does not mean two keys are equal; `equals()` determines key equality.

## 5. When would you choose AtomicInteger over synchronized?

### Candidate answer

I use `AtomicInteger` when I need atomic operations on one variable, such as a counter, retry count, or sequence number.

```java
private final AtomicInteger requests = new AtomicInteger();

void recordRequest() {
    requests.incrementAndGet();
}
```

I use `synchronized` or a lock when several related updates must happen as one indivisible operation.

For example, transferring money between two accounts requires protecting the consistency of both balances, not just making each individual increment atomic.

**Rule of thumb:**

- One independent atomic variable: consider an atomic class.
- Multiple related state changes or invariants: use a lock or another suitable coordination mechanism.

## 6. How does the JVM decide whether an object is eligible for GC?

### Candidate answer

An object is eligible for garbage collection when it is no longer reachable through a strong-reference path from any GC root. Eligibility does not mean the object is collected immediately.

Common GC roots include references from active thread stacks, static fields, JNI references, and certain JVM internal structures.

```java
User user = new User();
user = null; // The object may now be eligible for GC
```

This is only true if no other strong reference to that object remains.

**Interview takeaway:** Reachability from GC roots, rather than simply leaving a method or setting one reference to `null`, determines eligibility.

## 7. An application suddenly throws OutOfMemoryError. What do you check first?

### Candidate answer

I first identify the exact error message instead of immediately increasing the heap.

Examples include:

- `Java heap space`
- `GC overhead limit exceeded`
- `Metaspace`
- `Direct buffer memory`
- `unable to create native thread`

For heap exhaustion, I would inspect GC logs and, when appropriate, capture a heap dump. I would then use a tool such as Eclipse MAT to examine retained sizes and reference paths from GC roots.

For other error types, I would investigate the relevant resource: class metadata, direct memory, native memory, thread counts, or OS/container limits.

**Interview takeaway:** Identify the exact OOM type, gather evidence, and diagnose the resource problem before changing JVM settings.

## 8. How can ThreadLocal cause a memory leak?

### Candidate answer

A `ThreadLocal` stores values in a per-thread map. In the standard implementation, the map's keys are weak references to `ThreadLocal` objects, but the values are not weakly referenced.

If a pooled thread lives for a long time and a value is not removed, that value can remain retained longer than expected.

```java
private static final ThreadLocal<UserContext> CONTEXT =
        new ThreadLocal<>();

void process(UserContext context) {
    try {
        CONTEXT.set(context);
        doWork();
    } finally {
        CONTEXT.remove();
    }
}
```

The `finally` block is especially important when using thread pools.

**Interview takeaway:** `ThreadLocal` is not inherently a leak, but failing to clear thread-local values on long-lived threads can retain objects and potentially leak data between tasks.

## 9. Difference between wait(), sleep(), and join()

### Candidate answer

| Method | Purpose | Releases monitor lock? |
|---|---|---|
| `wait()` | Coordinates threads using an object's monitor | Yes, releases that object's monitor |
| `sleep()` | Pauses the current thread for a period | No |
| `join()` | Waits for another thread to terminate | Does not release monitors held by the waiting thread |

Examples:

```java
Thread.sleep(1000); // Pause current thread
worker.join();      // Wait for worker to terminate
```

`wait()` must be called while owning the relevant object's monitor, normally inside a `synchronized` block. It should generally be used in a loop that checks the condition because wake-ups do not themselves guarantee that the condition is satisfied.

**Interview shortcut:** `wait` = coordination, `sleep` = delay, `join` = wait for another thread to finish.

## 10. How do you detect deadlock in production?

### Candidate answer

A deadlock occurs when threads are permanently waiting for locks held by one another, creating a cycle.

Example:

```text
Thread A holds Lock 1 and waits for Lock 2.
Thread B holds Lock 2 and waits for Lock 1.
```

I would capture a thread dump:

```bash
jcmd <pid> Thread.print
```

or:

```bash
jstack <pid>
```

I would look for threads waiting on locks owned by other threads and check for a cycle. JVM thread-dump tools may explicitly report detected deadlocks.

Prevention techniques include consistent lock ordering, reducing nested locking, keeping critical sections short, and using timed `tryLock()` where appropriate.

**Interview takeaway:** Use thread dumps to identify lock ownership and cycles, then fix the lock design rather than merely restarting the application.

## 11. How does CompletableFuture execute asynchronous tasks?

### Candidate answer

`CompletableFuture` represents a computation that may complete later and supports composing dependent stages.

```java
CompletableFuture<String> future =
        CompletableFuture.supplyAsync(() -> loadUser())
                .thenApply(user -> user.getName());
```

Important differences:

- `supplyAsync()` starts a task asynchronously.
- A non-async continuation such as `thenApply()` may execute on the thread completing the previous stage or another thread performing completion.
- An async continuation such as `thenApplyAsync()` uses an executor; without an explicit executor, it normally uses the common pool for applicable async stages.

For important production workloads, I usually pass a managed executor:

```java
CompletableFuture<User> future =
        CompletableFuture.supplyAsync(this::loadUser, applicationExecutor);
```

**Interview takeaway:** `CompletableFuture` provides asynchronous composition; it does not automatically create a new thread for every stage.

## 12. What happens when a Java class is loaded?

### Candidate answer

At a high level, class processing has three stages:

1. **Loading:** The JVM obtains the class's binary representation and creates its runtime class representation.
2. **Linking:** Verification, preparation, and resolution take place. Resolution may occur lazily.
3. **Initialization:** Class initialization runs, including static field initializers and static initializer blocks.

Simplified class-loader delegation:

```text
Bootstrap ClassLoader
        ↓
Platform ClassLoader
        ↓
Application ClassLoader
```

Example:

```java
class Example {
    static int value = initialize();

    static {
        System.out.println("Class initialized");
    }

    static int initialize() {
        return 10;
    }
}
```

The initialization process executes the static initialization code according to JVM rules.

**Interview takeaway:** Remember loading → linking (verification, preparation, resolution) → initialization.

## 13. Why are immutable objects useful in multithreaded applications?

### Candidate answer

An immutable object cannot change its observable state after construction. This makes it easier to share between threads because there are no later mutations that need coordination.

```java
public final class User {
    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

For a robust immutable class, I would also avoid leaking mutable internal objects and make defensive copies where necessary.

Benefits include easier reasoning, safer sharing, reliable map keys, and fewer synchronization requirements.

**Interview takeaway:** Immutability reduces shared mutable state and therefore eliminates many common race conditions.

## 14. How do you troubleshoot frequent long GC pauses?

### Candidate answer

I would not immediately increase the heap. First, I would inspect GC logs to understand pause duration, pause frequency, allocation rate, and the live set after collection.

For modern JDKs, GC logging can be enabled with:

```bash
-Xlog:gc*
```

I would compare memory before and after GC:

- High memory before GC but much lower memory after GC can indicate substantial temporary allocation.
- Memory remaining high after GC, especially if it grows over time, can indicate a large live set or retention problem.

I would check unbounded caches, static collections, `ThreadLocal` values, listeners, sessions, and excessive object creation. I would also examine the selected collector, heap size, CPU availability, and container limits.

Useful tools include GC logs, JFR, JDK Mission Control, `jcmd`, and heap-dump analyzers.

**Interview takeaway:** Distinguish high allocation rate, a large retained live set, and poor configuration before tuning GC.

## 15. Your application suddenly has thousands of threads. What could cause it?

### Candidate answer

I would suspect unbounded thread creation, a misconfigured executor, blocked requests, slow downstream dependencies, a thread leak, or a library creating threads unexpectedly.

First, capture a thread dump:

```bash
jcmd <pid> Thread.print
```

Then examine thread names, states, and repeated stack traces. Thread names often reveal the owning executor or library.

Common causes:

- Creating `new Thread(...)` for every task
- Creating new executors repeatedly without managing their lifecycle
- Very large `maximumPoolSize` values
- Threads blocked on database connections or external calls
- Lock contention
- Library or scheduler misconfiguration

For example, repeatedly creating an executor inside a frequently called method is dangerous:

```java
void process() {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    executor.submit(this::doWork);
    // Executor lifecycle is not managed here.
}
```

A managed, shared executor is generally preferable.

I would correlate thread dumps with request rate, database-pool metrics, executor queue sizes, and external-service latency.

**Interview takeaway:** Find out who created the threads and what they are waiting for; don't just raise the thread limit.

## 16. Platform threads vs. virtual threads

### Candidate answer

Platform threads are backed by operating-system threads. Virtual threads are lightweight Java threads scheduled by the JVM and are particularly useful for high-concurrency workloads that spend substantial time waiting on I/O.

```java
// Platform thread
Thread platform = new Thread(() -> callService());
platform.start();

// Virtual thread (Java 21+)
Thread.startVirtualThread(() -> callService());
```

A virtual-thread-per-task executor is another option:

```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> callDatabase());
    executor.submit(() -> callExternalApi());
}
```

Virtual threads can make blocking-style code scale to many concurrent tasks, but they do not make CPU-bound work run faster than the available CPU capacity. Blocking behavior and pinning details depend on the JDK version and operation.

**Interview takeaway:** Virtual threads improve scalability for many concurrent tasks, especially I/O-bound ones; downstream capacity still needs protection.

## 17. What happens when an ExecutorService reaches its maximum pool size?

### Candidate answer

For `ThreadPoolExecutor`, behavior depends on its core size, maximum size, work queue, and rejection policy.

The simplified process is:

1. Create workers until the core pool size is reached.
2. Try to queue subsequent tasks.
3. If queueing fails, create workers up to the maximum pool size.
4. If the pool is at maximum and the queue cannot accept the task, invoke the rejection policy.

```java
ThreadPoolExecutor executor = new ThreadPoolExecutor(
        5,
        20,
        60,
        TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(100),
        new ThreadPoolExecutor.AbortPolicy()
);
```

With `AbortPolicy`, rejected submissions cause `RejectedExecutionException`.

**Interview takeaway:** Pool sizing must account for task characteristics and downstream capacity. More threads are not always better.

## 18. How do you identify a thread-pool leak?

### Candidate answer

I would inspect thread names in thread dumps and monitor executor metrics. A rapidly growing group of similarly named threads can indicate repeated executor creation or a pool that is not being shut down.

For a `ThreadPoolExecutor`, useful metrics include:

```java
executor.getPoolSize();
executor.getActiveCount();
executor.getQueue().size();
executor.getCompletedTaskCount();
```

A common mistake is creating an executor on every method call instead of managing one at the component or application level.

I would also investigate libraries, scheduled tasks, and application lifecycle hooks.

**Interview takeaway:** Correlate thread names, executor metrics, thread-creation rate, and code paths that create or own executors.

## 19. BLOCKED vs. WAITING vs. TIMED_WAITING

### Candidate answer

| State | Meaning | Example |
|---|---|---|
| `BLOCKED` | Waiting to acquire a monitor lock | Entering a `synchronized` block owned by another thread |
| `WAITING` | Waiting indefinitely for another action | `Object.wait()`, `Thread.join()` without timeout |
| `TIMED_WAITING` | Waiting for a specified time | `Thread.sleep()`, timed `wait()` or `join()` |

These are Java thread states, not complete diagnoses by themselves. A thread dump's stack trace and lock information help explain why a thread is in a particular state.

**Interview shortcut:** `BLOCKED` = monitor acquisition; `WAITING` = indefinite wait; `TIMED_WAITING` = timed wait.

## 20. Why can increasing the thread pool make performance worse?

### Candidate answer

Threads consume resources and require scheduling. For CPU-bound workloads, excessive threads can cause more context switching and contention without increasing the available CPU capacity.

For I/O-bound workloads, additional concurrency may help, but it can also overload a database, external service, or connection pool.

Example:

```text
Application concurrency: 5,000 tasks
Database connection pool: 50 connections
```

Many tasks may simply wait for database connections.

I would determine whether the workload is CPU-bound or I/O-bound, measure queueing and latency, and check downstream limits before changing pool size.

**Interview takeaway:** More threads do not automatically mean more throughput.

## 21. How do you troubleshoot unable to create native thread?

### Candidate answer

`OutOfMemoryError: unable to create native thread` generally means the JVM or operating system cannot create another native thread. It is different from `Java heap space`.

I would investigate:

- Current and peak thread counts
- Thread leaks and repeated executor creation
- Native memory pressure
- OS process/thread limits
- Container PID limits
- Thread stack size (`-Xss`)
- Overall container and process resource usage

Useful starting points include:

```bash
jcmd <pid> Thread.print
ps -eLf
```

The exact commands and permissions depend on the operating system and container.

I would not blindly reduce `-Xss` or increase limits without first understanding the cause.

**Interview takeaway:** Diagnose native thread creation, memory, and OS/container limits rather than treating this as a normal Java heap problem.

## 22. How do virtual threads change thread-pool sizing?

### Candidate answer

With platform threads, bounded pools are often used partly because each thread has a relatively high resource cost. Virtual threads make it practical to use a virtual thread per task for many I/O-heavy workloads.

```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    for (int i = 0; i < 10_000; i++) {
        executor.submit(() -> callExternalService());
    }
}
```

This does not mean unlimited concurrency is safe. The database, external API, rate limit, or connection pool may still be the bottleneck.

I would limit access to scarce resources with appropriate semaphores, connection pools, rate limiters, or other backpressure mechanisms.

**Interview takeaway:** With virtual threads, thread cost is less often the main constraint; downstream resource capacity remains important.

## 23. What is a race condition, and how do you fix it?

### Candidate answer

A race condition occurs when concurrent operations access shared state and the result depends on their timing or ordering.

```java
class Counter {
    private int count;

    void increment() {
        count++; // Not atomic
    }

    int getCount() {
        return count;
    }
}
```

Two threads can read the same value and overwrite one another's increments.

**Fix using synchronization:**

```java
synchronized void increment() {
    count++;
}
```

**Fix using an atomic variable:**

```java
private final AtomicInteger count = new AtomicInteger();

void increment() {
    count.incrementAndGet();
}
```

I would choose based on the invariant: an atomic counter is suitable for one independent value; multiple related updates may require a lock or transaction.

**Interview takeaway:** Establish the required atomicity and visibility, or remove shared mutable state.

## 24. synchronized vs. ReentrantLock vs. ReadWriteLock

### Candidate answer

| Mechanism | Best suited for | Main characteristics |
|---|---|---|
| `synchronized` | Straightforward critical sections | Automatic monitor release when the block exits |
| `ReentrantLock` | Cases needing explicit lock control | `tryLock`, timed and interruptible acquisition, multiple conditions |
| `ReadWriteLock` | Read-heavy shared state | Multiple readers may proceed concurrently; writers need exclusive access |

Example using `ReentrantLock`:

```java
private final ReentrantLock lock = new ReentrantLock();

void update() {
    lock.lock();
    try {
        updateState();
    } finally {
        lock.unlock();
    }
}
```

The `finally` block is essential to avoid accidentally retaining the lock.

For `ReadWriteLock`, I would consider the actual read/write ratio and contention; it is not automatically faster than a simple lock.

**Interview takeaway:** Choose the simplest locking mechanism that satisfies the correctness and performance requirements.

## 25. How does AtomicInteger work using CAS?

### Candidate answer

CAS means compare-and-set. Conceptually, it updates a value only if the current value still matches an expected value.

```java
AtomicInteger count = new AtomicInteger(0);
count.incrementAndGet();
```

Conceptually, the implementation reads a value, calculates the new value, and attempts an atomic update. If another thread changes the value first, the update may need to retry. The exact implementation is JDK-dependent.

Atomic classes provide useful atomic operations without requiring the caller to write explicit monitor locking for every operation.

They are suitable for counters and other independent state. They do not automatically make a multi-variable transaction atomic.

**Interview takeaway:** CAS conditionally updates a value based on its expected current state.

## 26. What is CAS and the ABA problem?

### Candidate answer

The ABA problem occurs when a value changes from A to B and then back to A. A CAS operation that checks only the current value may see A and incorrectly assume nothing changed.

```text
Initial value: A
Another thread changes A → B → A
First thread performs CAS(expected A, new C)
```

A stamped or versioned reference can detect that the value changed in between. Java provides `AtomicStampedReference` for use cases requiring a reference plus a stamp.

**Interview takeaway:** ABA is an undetected intermediate change; a version or stamp can help detect it.

## 27. What is false sharing?

### Candidate answer

False sharing is a performance issue in which threads update different variables that happen to occupy the same CPU cache line. Cache-coherence traffic can cause the line to move between CPU cores, reducing performance.

The variables are logically independent, so this is not necessarily a correctness bug.

False sharing is most relevant in highly performance-sensitive concurrent code, such as low-latency counters or queues. I would use a profiler or benchmark to establish that false sharing is actually a bottleneck before changing memory layout.

**Interview takeaway:** Independent variables sharing a cache line can cause unnecessary cache-coherence overhead.

## 28. How does ForkJoinPool work?

### Candidate answer

`ForkJoinPool` is designed for tasks that can be recursively split into smaller tasks and then combined. It uses work stealing to help keep worker threads busy: an idle worker can take tasks from another worker's queue.

This model works well for suitable CPU-bound divide-and-conquer computations.

Fork/join tasks can be submitted to a pool, and some Java APIs—including parallel streams—use the common fork/join pool by default.

Blocking I/O inside fork/join workers can reduce parallelism if workers remain occupied waiting. For blocking tasks, consider a more appropriate executor or virtual threads.

**Interview takeaway:** Fork/join combines task decomposition with work stealing.

## 29. How does CompletableFuture handle exceptions and cancellation?

### Candidate answer

`CompletableFuture` supports several exception-handling stages.

**`exceptionally()`** provides a fallback result when the preceding stage fails:

```java
future.exceptionally(ex -> "default");
```

**`handle()`** receives both the result and exception, allowing success and failure to be processed in one stage:

```java
future.handle((result, ex) -> {
    if (ex != null) {
        return "fallback";
    }
    return result;
});
```

**`whenComplete()`** is useful for logging or observing completion without intentionally replacing the outcome:

```java
future.whenComplete((result, ex) -> {
    if (ex != null) {
        log.error("Operation failed", ex);
    }
});
```

Cancellation needs care. Calling `cancel(true)` marks the future as cancelled, but it does not guarantee that the underlying computation is forcibly stopped.

For production code, I would also define timeouts, use a suitable executor, and consider how errors are propagated through dependent stages.

**Interview takeaway:** Use the completion stage that matches the recovery or observation requirement; don't assume cancellation always stops the underlying task.

## 30. How do you design a thread-safe Singleton?

### Candidate answer

Two simple options are the enum Singleton and initialization-on-demand holder idiom.

**Option 1: Enum**

```java
public enum AppConfig {
    INSTANCE;

    public void load() {
        // Application logic
    }
}
```

Usage:

```java
AppConfig.INSTANCE.load();
```

Enums provide strong serialization guarantees and resist ordinary reflective instantiation better than many hand-written Singleton implementations.

**Option 2: Initialization-on-demand holder**

```java
public final class AppConfig {
    private AppConfig() {}

    private static class Holder {
        private static final AppConfig INSTANCE = new AppConfig();
    }

    public static AppConfig getInstance() {
        return Holder.INSTANCE;
    }
}
```

Class initialization is thread-safe, and the holder is initialized when first referenced.

Double-checked locking is another option, but it requires a `volatile` instance field and careful implementation.

**Interview takeaway:** Prefer the enum or holder idiom for a simple Singleton unless the requirements call for something else.

## 31. What is the Java Memory Model?

### Candidate answer

The Java Memory Model (JMM) defines the rules for how threads interact through memory. It specifies visibility and ordering guarantees and helps determine which concurrent behaviors are permitted.

Without proper synchronization, one thread is not necessarily guaranteed to observe another thread's updates in the way the programmer expects.

Common mechanisms that establish concurrency guarantees include `synchronized`, `volatile`, locks, atomic classes, and thread-start/join relationships.

```java
private volatile boolean running = true;
```

A volatile flag is useful when one thread updates a status and another thread polls it, provided no compound atomic operation is required.

**Interview takeaway:** The JMM defines visibility and ordering rules for concurrent Java programs.

## 32. What is a happens-before relationship?

### Candidate answer

If action A happens-before action B, the effects of A are guaranteed to be visible to B under the Java Memory Model. It is a formal ordering and visibility guarantee, not necessarily a claim about wall-clock timing.

Examples include:

- Unlocking a monitor happens-before a subsequent lock of that same monitor.
- A volatile write happens-before a subsequent read of that same variable.
- Actions before `Thread.start()` happen-before actions in the started thread.
- All actions in a thread happen-before another thread successfully returns from joining it.
- Actions in an asynchronous computation happen-before actions following the corresponding successful completion retrieval according to the relevant API contract.

**Interview takeaway:** Happens-before is a key way to reason about safe visibility and ordering across threads.

## 33. How does volatile work?

### Candidate answer

`volatile` provides visibility and ordering guarantees for a field. It does not make compound operations such as `count++` atomic.

```java
private volatile boolean ready;
private int value;

// Thread 1
value = 100;
ready = true;

// Thread 2
if (ready) {
    System.out.println(value);
}
```

The volatile write to `ready` happens-before a subsequent read of `ready`. If Thread 2 observes `ready == true`, it can also observe the preceding write to `value` under the JMM rules.

For a counter, use `AtomicInteger` or synchronization if atomic increments are required.

**Interview shortcut:**

- `volatile`: visibility and ordering for a field
- Atomic classes: atomic operations on supported state
- `synchronized`: mutual exclusion plus memory-visibility guarantees

## 34. What is safe publication?

### Candidate answer

Safe publication means making an object available to other threads in a way that ensures they see its properly initialized state.

Common mechanisms include:

- Initializing an object through a static initializer
- Publishing it through a volatile field
- Publishing it while holding and later acquiring the same lock
- Storing and retrieving it through properly synchronized or concurrent structures
- Using immutable objects with correctly initialized `final` fields, while still ensuring appropriate publication and avoiding constructor escape

Example:

```java
public final class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

Immutability makes safe sharing easier, but it is still important not to leak `this` during construction.

**Interview takeaway:** Safe publication ensures other threads can observe a correctly initialized object.

## 35. Why is HashMap dangerous when modified concurrently?

### Candidate answer

`HashMap` does not guarantee correct behavior under concurrent structural modification. Unsynchronized access can result in lost updates, inconsistent observations, and other unpredictable outcomes.

Use a `ConcurrentHashMap` when concurrent map operations are needed, or use appropriate external synchronization.

```java
Map<String, Integer> map = new ConcurrentHashMap<>();
map.merge("JAVA", 1, Integer::sum);
```

Historical discussions of older JDKs sometimes mention resize-related pathological behavior. In an interview, I would focus on the fundamental point: `HashMap` is not thread-safe and offers no concurrent mutation guarantees.

**Interview takeaway:** Do not use `HashMap` for unsynchronized concurrent updates.

## 36. How does ConcurrentHashMap.computeIfAbsent() work?

### Candidate answer

`computeIfAbsent()` computes and associates a value when a key does not already have a mapping, with atomicity guarantees for the map operation.

```java
ConcurrentHashMap<String, List<String>> map =
        new ConcurrentHashMap<>();

map.computeIfAbsent("JAVA", key -> new ArrayList<>())
   .add("Spring");
```

The map's atomicity guarantee applies to establishing the mapping. It does **not** make the returned `ArrayList` thread-safe. If multiple threads modify the list, additional coordination or a concurrent value type is required.

The mapping function should be short and should not perform slow I/O or recursively modify the same map in problematic ways.

For concurrent counters, `merge()` is often more direct:

```java
ConcurrentHashMap<String, Integer> counts =
        new ConcurrentHashMap<>();

counts.merge("JAVA", 1, Integer::sum);
```

**Interview takeaway:** `computeIfAbsent()` is useful for lazy mapping initialization, but thread safety of the mapped value is a separate concern.

## 37. How do you troubleshoot 100% CPU usage?

### Candidate answer

I would identify the process and hot thread, correlate the operating-system thread with the JVM thread dump, and inspect the stack trace. If needed, I would use a profiler to determine where CPU time is spent.

Typical steps:

```bash
top
top -H -p <pid>
jcmd <pid> Thread.print
```

A thread ID from an OS tool may need conversion to hexadecimal before matching the `nid` in a Java thread dump.

Possible causes include infinite loops, busy polling, inefficient algorithms, excessive serialization, regex issues, high traffic, or GC overhead.

Useful profiling tools include Java Flight Recorder (JFR), JDK Mission Control, and async-profiler.

**Interview takeaway:** Find the hot thread, inspect its stack, and profile before making a code or configuration change.

## 38. How do you investigate a memory leak using a heap dump?

### Candidate answer

I first determine whether memory remains high after garbage collection and whether the retained live set is growing over time. High memory use alone does not prove a leak.

When appropriate, I capture a heap dump:

```bash
jcmd <pid> GC.heap_dump /tmp/app.hprof
```

I analyze it with Eclipse MAT or another suitable heap analyzer, focusing on:

- Object counts
- Retained size
- Large collections
- GC roots and reference chains
- Objects that remain reachable unexpectedly

Common causes include unbounded caches, static collections, `ThreadLocal` values, listeners that are never deregistered, and queues that grow without bounds.

**Interview takeaway:** Find what retains the memory by tracing objects back to their GC roots.

## 39. What is a Stop-The-World pause?

### Candidate answer

A Stop-The-World (STW) pause is a period when application threads are paused for a JVM operation. Garbage collection is a common example, though not every part of every GC cycle must be STW.

Modern collectors perform significant work concurrently to reduce pause times, but they can still have STW phases.

Long pauses can increase request latency, cause timeouts, and lead to queue buildup. I would inspect GC logs, pause duration and frequency, allocation rate, live-set size, collector configuration, CPU availability, and container limits.

**Interview takeaway:** STW pauses temporarily stop normal application-thread execution and can directly affect latency.

## 40. How do you diagnose a slow application with low CPU usage?

### Candidate answer

Low CPU with high latency often suggests that threads are waiting rather than doing CPU-intensive work.

I would inspect request latency, thread dumps, database metrics, connection-pool saturation, external API latency, network and disk I/O, lock contention, and queue sizes.

Example:

```text
Database pool maximum: 50
Active connections:    50
Waiting requests:      1,500
Application CPU:       Low
```

This suggests requests may be waiting for database connections. I would then investigate why connections are held too long, such as slow queries or downstream latency.

Adding application threads would not fix an exhausted database pool and could make queueing worse.

**Interview takeaway:** Low CPU plus high latency often means waiting or resource contention; find the actual bottleneck.

---

# Quick Revision Table

| # | Topic | One-line answer |
|---:|---|---|
| 1 | HashMap thread safety | Not safe for concurrent mutation without synchronization |
| 2 | ConcurrentHashMap | Uses fine-grained concurrency mechanisms |
| 3 | `volatile` and `i++` | Visibility does not make compound updates atomic |
| 4 | Hash collisions | Hash plus `equals()` distinguish keys |
| 5 | AtomicInteger vs. synchronized | Atomic for one variable; lock for compound invariants |
| 6 | GC eligibility | Determined by reachability from GC roots |
| 7 | OutOfMemoryError | Identify the exact error type and investigate the relevant resource |
| 8 | ThreadLocal leak | Remove values when long-lived threads are reused |
| 9 | wait/sleep/join | Coordination / delay / wait for thread termination |
| 10 | Deadlock | Find lock cycles in thread dumps |
| 11 | CompletableFuture | Compose asynchronous stages with suitable executors |
| 12 | Class loading | Loading → linking → initialization |
| 13 | Immutability | Reduces shared mutable state |
| 14 | Long GC pauses | Separate allocation pressure, retained live set, and configuration |
| 15 | Thousands of threads | Inspect thread dumps, executors, and blocked dependencies |
| 16 | Virtual threads | Lightweight concurrency, especially for I/O-bound tasks |
| 17 | Executor saturation | Tasks queue, workers may grow, and submissions may be rejected |
| 18 | Thread-pool leak | Track thread names, pool metrics, and executor lifecycle |
| 19 | Thread states | BLOCKED / WAITING / TIMED_WAITING |
| 20 | Larger pools | Can increase contention without increasing throughput |
| 21 | Native thread OOM | Check thread count, native memory, OS/container limits |
| 22 | Virtual thread sizing | Still protect scarce downstream resources |
| 23 | Race condition | Fix shared-state atomicity and visibility |
| 24 | Lock types | Use the simplest lock that meets requirements |
| 25 | CAS | Conditional atomic update |
| 26 | ABA | A → B → A can hide an intermediate change |
| 27 | False sharing | Cache-line contention hurts performance |
| 28 | ForkJoinPool | Task decomposition and work stealing |
| 29 | Future errors/cancellation | Handle failures explicitly; cancellation may not stop underlying work |
| 30 | Singleton | Enum or holder idiom are robust choices |
| 31 | JMM | Rules for visibility and ordering between threads |
| 32 | Happens-before | Guarantees visibility and ordering |
| 33 | `volatile` | Visibility/order, not compound-operation atomicity |
| 34 | Safe publication | Ensure other threads see initialized state |
| 35 | Concurrent HashMap access | Use a concurrent collection or synchronization |
| 36 | `computeIfAbsent` | Atomically establish an absent mapping; mapped value may need its own protection |
| 37 | High CPU | Find hot thread and profile |
| 38 | Heap dump | Trace retained objects to GC roots |
| 39 | STW | Application threads pause during certain JVM operations |
| 40 | Slow app, low CPU | Investigate waiting, I/O, locks, and resource pools |

# Production Troubleshooting Commands

> Commands vary by JDK, operating system, container setup, and permissions. Use them according to your production access and operational policies.

```bash
# Print JVM thread dump
jcmd <pid> Thread.print

# Alternative thread dump command
jstack <pid>

# Capture a heap dump
jcmd <pid> GC.heap_dump /tmp/app.hprof

# Inspect process threads on Linux
ps -eLf

# Observe per-thread CPU usage on Linux
top -H -p <pid>
```

For deeper diagnostics, consider:

- **JFR (Java Flight Recorder):** CPU, allocation, locks, and runtime events
- **JDK Mission Control:** Analyze JFR recordings
- **Eclipse MAT:** Heap dump and retained-object analysis
- **GC logs:** Pause duration, collection frequency, and heap behavior
- **Application metrics:** Request latency, executor queues, pool saturation, and downstream service timing

---

## A strong interview answer structure

For most concurrency and JVM troubleshooting questions, use this sequence:

1. **Direct answer:** Define the concept in one or two sentences.
2. **Internal behavior:** Explain what the JVM or concurrency mechanism does.
3. **Example:** Give a short code sample or production scenario.
4. **Diagnosis/fix:** Explain how you would verify and resolve the issue.
5. **Trade-off:** Mention one important limitation or production consideration.

**Final preparation tip:** Understand why the code works, not just the one-line definition. Interviewers often follow a definition question with a debugging scenario or a request to explain the memory-model guarantees.
