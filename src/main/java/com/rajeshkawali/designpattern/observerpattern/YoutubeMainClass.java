package com.rajeshkawali.designpattern.observerpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class YoutubeMainClass {

	public static void main(String[] args) {

		Channel channel = new Channel();

		//Users or Subscriber
		Subscriber subscriber1 = new Subscriber("Rajesh");
		Subscriber subscriber2 = new Subscriber("Mahesh");
		Subscriber subscriber3 = new Subscriber("Vidya");

		//Users subscribing channel
		subscriber1.subscribeChannel(channel);
		subscriber2.subscribeChannel(channel);
		subscriber3.subscribeChannel(channel);
		
		//Users subscribing notification
		channel.subscribe(subscriber1);
		channel.subscribe(subscriber2);
		channel.subscribe(subscriber3);
		
		//Uploading new video
		channel.upload("Spring boot microservice");
		
		System.out.println("Subscriber2 is unSubscribed from the channel");
		channel.unSubscribe(subscriber2);
		
		//Uploading new video
		channel.upload("Spring boot with kafka and mongodb");
	}
}

/*
Observer is a behavioral design pattern that lets you define a 
subscription mechanism to notify multiple objects about any events 
that happen to the object they’re observing.

Observer pattern is used when there is one-to-many relationship between objects 
such as if one object is modified, its depenedent objects are to be notified automatically. 
Observer pattern falls under behavioral pattern category.

*/
