package com.rajeshkawali.concepts.cache;



/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class TimeAwareLRUCacheMain {
	
	
	public static void main(String[] args) throws InterruptedException {
		// Create a cache with 3-entry limit and 5-second TTL
		TimeAwareLRUCache<String, String> sessionCache = new TimeAwareLRUCache<>(3, 5);

		sessionCache.save("token1", "user-A");
		sessionCache.save("token2", "user-B");

		System.out.println(sessionCache.retrieve("token1")); // Output: user-A

		Thread.sleep(6000); // Wait for expiration
		System.out.println(sessionCache.retrieve("token1")); // Output: null (expired)
	}
}
