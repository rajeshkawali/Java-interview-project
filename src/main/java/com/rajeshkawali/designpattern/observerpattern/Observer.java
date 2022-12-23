package com.rajeshkawali.designpattern.observerpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public interface Observer {

	void update();

	void subscribeChannel(Channel ch);

}