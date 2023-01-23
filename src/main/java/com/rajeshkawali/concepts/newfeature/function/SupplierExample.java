package com.rajeshkawali.concepts.newfeature.function;
import java.util.function.Supplier;

/**
 * @author Rajesh_Kawali
 *
 */
public class SupplierExample {
    public static void main(String[] args) {
        // Use the get() method
        Supplier<String> randomString = () -> "Random String: " + Math.random();
        System.out.println(randomString.get());  // Output: "Random String: 0.463748398475738" (example)

    }
}
/*
Supplier interface is a functional interface that returns a single output value. 
It is part of the java.util.function package, and it has a single abstract method T get().

Some of the static methods of the Supplier interface include:

get() : it returns the output value from a supplier. 
which can be used to get a value of the specified type. 
It does not have any other methods or any static methods.
*/