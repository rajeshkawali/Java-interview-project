package com.rajeshkawali.designpattern.observerpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class YoutubeMainClass {

	/*
	Observer is a behavioral design pattern that lets you define a 
	subscription mechanism to notify multiple objects about any events 
	that happen to the object they are observing.

	Observer pattern is used when there is one-to-many relationship between objects 
	such as if one object is modified, its depenedent objects are to be notified automatically. 
	Observer pattern falls under behavioral pattern category.

	*/
	public static void main(String[] args) {

		Channel channel = new Channel("Java Channel");

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
The Observer design pattern is a behavioral design pattern that allows objects to be 
notified of changes in the state of other objects. In the context of a YouTube example, 
the observer pattern can be used to notify subscribers of a channel about new notifications, 
such as new videos being uploaded or live streams starting.

Here is an example of how the observer pattern could be implemented in a YouTube application:

The Channel class represents a YouTube channel and contains information such as the channel's name and the videos it has uploaded.
The Subscriber class represents a user who has subscribed to a channel.
The Notification class represents a notification that is sent to subscribers, such as a new video being uploaded or a live stream starting.
The Channel class would have a list of Subscriber objects that are subscribed to it. When a new video is uploaded or a live stream starts, the Channel class would create a new Notification object and then notify all of its subscribers by calling a method on the Subscriber objects, passing the Notification object as an argument.

The Subscriber class would have a method that is called by the Channel 
class when a new notification is sent. This method would take the Notification 
object as an argument and handle it accordingly, for example, by displaying a message to the user.
*/
