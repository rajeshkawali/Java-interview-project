package com.rajeshkawali.designpattern.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajesh_Kawali
 *
 */
public class Channel implements Subject {
	/*
	The Observer design pattern is a behavioral pattern that allows an object, 
	called the subject, to notify other objects, called observers, about changes in its state. 
	The Observer pattern is useful when you want to create one-to-many relationships between objects, 
	where one subject object is associated with multiple observer objects, 
	and when you want to be able to notify multiple observer objects 
	about changes in the subject object's state.

	*/
	private List<Subscriber> subscribers;
	private String videoTitleName;

	public Channel(String videoTitleName) {
		this.videoTitleName = videoTitleName;
		subscribers = new ArrayList<Subscriber>();
	}

	@Override
	public void subscribe(Subscriber sub) {
		subscribers.add(sub);
	}

	@Override
	public void unSubscribe(Observer sub) {
		subscribers.remove(sub);
	}

	@Override
	public void notifySubscriber() {
		for (Observer subscriber : subscribers) {
			subscriber.update(videoTitleName);
		}
	}

	@Override
	public void upload(String videoTitleName) {
		this.videoTitleName = videoTitleName;
		notifySubscriber();
	}

}
