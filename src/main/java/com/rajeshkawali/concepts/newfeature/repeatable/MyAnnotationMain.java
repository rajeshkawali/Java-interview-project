package com.rajeshkawali.concepts.newfeature.repeatable;

/**
 * @author Rajesh_Kawali
 *
 */

/*
 * Step 2: Use the custom annotation in a class
 */
public class MyAnnotationMain {

    /*
     * Annotate this method with @MyAnnotation
     * Provide the value "Hello from annotation"
     */
    @MyAnnotation("Hello from annotation")
    public void sayHello() {
        System.out.println("Inside sayHello() method");
    }

    /*
     * Main method to demonstrate reading annotation at runtime using reflection
     */
    public static void main(String[] args) throws NoSuchMethodException {
        MyAnnotationMain obj = new MyAnnotationMain();

        // Get the Method object for sayHello()
        var method = obj.getClass().getMethod("sayHello");

        // Check if the method has @MyAnnotation
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            // Retrieve the annotation instance from the method
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

            // Access the value element of the annotation
            System.out.println("Annotation value: " + annotation.value());
        }

        // Call the actual method
        obj.sayHello();
    }
}