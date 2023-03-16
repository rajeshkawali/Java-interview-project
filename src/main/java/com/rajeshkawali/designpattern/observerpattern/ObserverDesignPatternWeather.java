package com.rajeshkawali.designpattern.observerpattern;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Rajesh_Kawali
 *
 */
// The subject interface
interface WeatherSubject {
	void registerObserver(WeatherObserver o);
	void removeObserver(WeatherObserver o);
	void notifyObservers();
}

// The observer interface
interface WeatherObserver {
	void update(float temperature, float humidity, float pressure);
}

// The concrete subject
class WeatherStation implements WeatherSubject {
	private List<WeatherObserver> observers = new ArrayList<>();
	private float temperature;
	private float humidity;
	private float pressure;

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	private void measurementsChanged() {
		notifyObservers();
	}

	@Override
	public void registerObserver(WeatherObserver o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(WeatherObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (WeatherObserver observer : observers) {
			observer.update(temperature, humidity, pressure);
		}
	}
}

// The concrete observers
class CurrentConditionsDisplay implements WeatherObserver {
	private float temperature;
	private float humidity;
	private float pressure;
	private WeatherSubject weatherStation;

	public CurrentConditionsDisplay(WeatherSubject weatherStation) {
		this.weatherStation = weatherStation;
		weatherStation.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

	private void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}
}

class ForecastDisplay implements WeatherObserver {
	private float temperature;
	private float humidity;
	private float pressure;
	private WeatherSubject weatherStation;

	public ForecastDisplay(WeatherSubject weatherStation) {
		this.weatherStation = weatherStation;
		weatherStation.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

	private void display() {
		System.out.println("Forecast: More of the same");
	}
}

// The client code
public class ObserverDesignPatternWeather {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherStation);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherStation);

		weatherStation.setMeasurements(80, 65, 30.4f);
		weatherStation.setMeasurements(82, 70, 29.2f);
	}
}
/*
The Observer pattern is a behavioral design pattern that allows objects 
to subscribe to an event and get notified when the state of the observed object changes. 
In this pattern, there are two types of objects: the subject (or observable) and the observer. 
The subject maintains a list of observers, and notifies them when its state changes.

When to use the Observer pattern:-->

When you need to maintain consistency between related objects without tightly coupling them
When you need to notify multiple objects about changes to the state of another object
When you need to reduce the coupling between objects and make them more reusable and extensible
When you want to build a system that can be easily modified without affecting other parts of the system.
Some examples of applications where the Observer pattern can be used are:

A stock market application where the stock prices are observed by multiple users and changes to the stock prices are notified to all the users
A weather forecasting application where weather conditions are observed by multiple users and changes to weather conditions are notified to all the users
A user interface in which one object observes another object for changes and updates the display accordingly.
*/

/*
+--------------------+       +------------------+          						+-------------------------------------+
|  WeatherSubject    |       |  WeatherObserver |          						|CurrentConditionsDisplay             |
+--------------------+       +------------------+          						+-------------------------------------+
| registerObserver(o)|<>-----| update(temperature,humidity,pressure)| <|--------|+weatherStation: WeatherSubject      |
| removeObserver(o)  |       |                  |                				|                 +temperature: float |
| notifyObservers()  |       +------------------+               				|                 +humidity: float    |
+--------------------+                 											|                 +pressure: float    |
                                                             					+-------------------------------------+
                                                                       				^
                                                                       				|
                                                               				+----------------------------------------+
                                                               				| ForecastDisplay                        |
                                                               				+----------------------------------------+
                                                               				| +weatherStation: WeatherSubject        |
                                                               				| update(temperature, humidity, pressure)|
                                                               				| display() 							 |
                                                               				+----------------------------------------+


The UML diagram shows the relationship between three classes: WeatherSubject, WeatherObserver, CurrentConditionsDisplay, and ForecastDisplay. 
WeatherSubject is an interface that defines the contract for a subject to which observers can subscribe. 
WeatherObserver is an interface that defines the contract for an observer that receives updates from the subject.

The WeatherStation class is the concrete implementation of WeatherSubject and maintains a list of registered observers. 
It also has a method for notifying observers when its state changes.

The CurrentConditionsDisplay and ForecastDisplay classes are concrete implementations of WeatherObserver 
and display the current weather conditions and forecast respectively. They both register themselves with the 
WeatherStation during initialization and receive updates from it when the weather conditions change.

The client code is shown in the ObserverDesignPatternWeather class and demonstrates the usage of the Observer Pattern. 
It creates a WeatherStation, registers two observers (CurrentConditionsDisplay and ForecastDisplay), and sets the weather conditions.
*/