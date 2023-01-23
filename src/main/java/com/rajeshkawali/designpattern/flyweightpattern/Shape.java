package com.rajeshkawali.designpattern.flyweightpattern;

interface Shape {
	void draw();
}

/*
Here are some key points to remember about the Flyweight design pattern:-->

The Flyweight design pattern is a structural pattern that allows you to share objects to reduce the number of objects created, and to decrease memory usage and increase performance.
The Flyweight pattern is useful when you need to create a large number of similar objects, and you want to minimize the amount of memory used by those objects.
The Flyweight pattern involves three key components: the Flyweight interface, the Concrete Flyweight class, and the Flyweight Factory.
The Flyweight interface defines the methods that the flyweight objects must implement.
The Concrete Flyweight class implements the Flyweight interface and defines the intrinsic state that is shared among all objects.
The Flyweight Factory creates and manages the flyweight objects. It uses a HashMap or other collection to store the flyweight objects and it returns an existing flyweight object if it already exists, or it creates a new flyweight object if it doesn't exist.
The Flyweight pattern allows you to create a large number of similar objects without using a lot of memory by sharing common state among multiple objects.
The Flyweight pattern promotes the separation of concerns between the intrinsic and extrinsic state of the objects, allowing you to minimize the amount of memory used while still allowing for customization.
The Flyweight pattern is often used in conjunction with the factory pattern to manage the creation and management of the shared objects.
The Flyweight pattern is used in various software development fields such as web development, game development and so on.
*/