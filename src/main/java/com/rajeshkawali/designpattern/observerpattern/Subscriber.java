package com.rajeshkawali.designpattern.observerpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class Subscriber implements Observer {
	
	private String name;
	private Channel channel = new Channel("Java Channel");

	public Subscriber(String name) {
		this.name = name;
	}

	@Override
	public void update(String videoTitleName) {
		System.out.println("Hi " + name + ", Video Uploaded :" + videoTitleName);
	}

	@Override
	public void subscribeChannel(Channel ch) {
		channel = ch;
	}
}
