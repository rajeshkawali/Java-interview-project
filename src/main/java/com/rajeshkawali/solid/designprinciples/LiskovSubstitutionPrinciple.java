package com.rajeshkawali.solid.designprinciples;

abstract class Animal {
    // Abstract method that must be implemented by subclasses
    public abstract void move();
}

class Bird extends Animal {
    @Override
    public void move() {
        // Bird moves by flying
        System.out.println("Bird is flying");
    }
}

class Fish extends Animal {
    @Override
    public void move() {
        // Fish moves by swimming
        System.out.println("Fish is swimming");
    }
}

public class LiskovSubstitutionPrinciple {
	
	/*
	 Liskov Substitution Principle:
	 A derived class should be able to replace its base class without altering the correctness of the program.
	 For example, in Java, consider a class named "Bird" that extends the base class "Animal".
	 The "Bird" class should be able to replace the "Animal" class without altering the program's correctness.
	 This means that the "Bird" class should override the methods of the "Animal"
	 class in a way that is consistent with the behavior of the base class.
	*/
	public static void main(String[] args) {
        // Animal reference can point to any subclass object
        Animal myBird = new Bird();
        Animal myFish = new Fish();

        // Both objects can be used interchangeably without breaking program behavior
        moveAnimal(myBird);  // Output: Bird is flying
        moveAnimal(myFish);  // Output: Fish is swimming
    }

    // This method demonstrates polymorphism: it works with any Animal subclass
    public static void moveAnimal(Animal animal) {
        animal.move();
    }

}


/*
Liskov Substitution Principle (LSP):

This principle states that objects of a superclass should be replaceable with objects of a subclass
without affecting the correctness of the program.

In this example, the abstract class "Animal" defines an abstract method "move()".
Subclasses like "Bird" and "Fish" extend "Animal" and provide their own implementations of "move()".

Because "Bird" and "Fish" override the "move()" method in ways consistent with the behavior expected from "Animal",
instances of these subclasses can be used wherever "Animal" references are expected,
without breaking the program's behavior.

This demonstrates that subclasses can substitute their base class safely,
fulfilling the Liskov Substitution Principle.
*/