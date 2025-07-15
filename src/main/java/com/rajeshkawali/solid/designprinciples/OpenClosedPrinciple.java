package com.rajeshkawali.solid.designprinciples;

abstract class Shape {
    // Abstract method to calculate area, to be implemented by subclasses
    public abstract double calculateArea();
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        // Area of triangle = 0.5 * base * height
        return 0.5 * base * height;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        // Area of rectangle = length * width
        return length * width;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        // Area of circle = π * radius^2
        return Math.PI * radius * radius;
    }
}

public class OpenClosedPrinciple {
    /*
     Open-Closed Principle (OCP):

     Software entities (classes, modules, functions) should be open for extension but closed for modification.
     For example, consider a base class "Shape" with a method "calculateArea()".
     We extend this base class to create different shapes like "Triangle", "Rectangle", and "Circle".
     If we want to add new shapes, we can create new classes extending "Shape" without modifying existing code.
     This makes the system extensible and reduces the risk of introducing bugs when adding features.
    */

    public static void main(String[] args) {
        Shape triangle = new Triangle(5, 10);
        Shape rectangle = new Rectangle(4, 6);
        Shape circle = new Circle(7);

        System.out.println("Triangle area: " + triangle.calculateArea());   // 25.0
        System.out.println("Rectangle area: " + rectangle.calculateArea()); // 24.0
        System.out.println("Circle area: " + circle.calculateArea());       // ~153.94
    }
}
