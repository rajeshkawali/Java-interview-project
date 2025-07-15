package com.rajeshkawali.solid.designprinciples;

interface Flyable {
    void fly();
}

interface Singable {
    void sing();
}

class Bird1 implements Flyable, Singable {
    @Override
    public void fly() {
        // code to make the bird fly
        System.out.println("Bird is flying");
    }

    @Override
    public void sing() {
        // code to make the bird sing
        System.out.println("Bird is singing");
    }
}

public class InterfaceSegregationPrinciple {
    /*
     Interface Segregation Principle (ISP):

     A class should not be forced to implement interfaces it doesn't use.
     For example, imagine an interface named "Animals" that contains methods for "fly", "swim", and "sing".
     A class named "Bird" should only implement "fly" and "sing" since birds can fly and sing, but can't swim.
     By splitting the large interface into smaller, more specific interfaces like "Flyable" and "Singable",
     we ensure that classes only implement methods relevant to them.
    */

    public static void main(String[] args) {
        Bird1 bird = new Bird1();
        bird.fly();   // Output: Bird is flying
        bird.sing();  // Output: Bird is singing
    }
}
