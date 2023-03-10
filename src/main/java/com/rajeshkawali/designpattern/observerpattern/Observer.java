package com.rajeshkawali.designpattern.observerpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public interface Observer {

	void update(String channelName);

	void subscribeChannel(Channel ch);

}