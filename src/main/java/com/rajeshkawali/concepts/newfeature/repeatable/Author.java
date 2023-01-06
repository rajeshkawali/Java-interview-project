package com.rajeshkawali.concepts.newfeature.repeatable;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author Rajesh_Kawali
 *
 */
@Repeatable(Authors.class)
public @interface Author {
	/*
	Repeating annotations are a feature introduced in Java(JDK) 8. 
	They allow you to apply the same annotation multiple times 
	to a single element or to multiple elements in your code.

	To create a repeating annotation, you need to use the @Repeatable annotation 
	and specify the container annotation type, which is the annotation 
	that contains the repeated annotations.
	*/
	
	String firstname();

	String lastname();
}

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Authors {
	Author[] value();
}


/*
we have defined a repeating annotation called Author and a container annotation called Authors. 
The Author annotation has a single element called firstname and lastname, and the Authors annotation 
has an element called value that is an array of Author annotations.
*/


/*
Some key points to remember when using repeating annotations in Java:-->

1.Repeating annotations are a feature introduced in Java 8 that allow you to apply the same annotation multiple times to a single element or to multiple elements.

2.To create a repeating annotation, you need to use the @Repeatable annotation and specify the container annotation type, which is the annotation that contains the repeated annotations.

3.To use a repeating annotation, you can apply it multiple times to a single element or to multiple elements using the same syntax as any other annotation.

4.Repeating annotations are stored in the container annotation, which is accessed using reflection or by using the getAnnotationsByType() method in the Java Reflection API.

5.Repeating annotations can be useful when you need to apply the same annotation multiple times to a single element or to multiple elements in your code, as they allow you to do so without having to use an array of annotations or create a custom container annotation.
*/