package com.rajeshkawali.concepts.newfeature.repeatable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author Rajesh_Kawali
 *
 */
/*
 * Step 1: Define a custom annotation
 *
 * @interface keyword is used to declare an annotation type.
 *
 * @Retention specifies how long the annotation should be retained:
 *   - RetentionPolicy.RUNTIME means the annotation is available at runtime via reflection.
 *
 * @Target specifies where the annotation can be applied:
 *   - ElementType.METHOD means this annotation can be applied only to methods.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    // Define an element named 'value' for this annotation
    // This acts like a parameter that can be set when using the annotation
    String value();
}