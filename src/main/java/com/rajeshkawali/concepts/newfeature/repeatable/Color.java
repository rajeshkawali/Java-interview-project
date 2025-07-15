package com.rajeshkawali.concepts.newfeature.repeatable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Rajesh_Kawali
 *
 */
//Container annotation to hold multiple Color annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // Can be applied on classes or interfaces
@interface Colors {
	Color[] value();
}

//Repeatable annotation linked to Colors container
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // Can be applied on classes or interfaces
@Repeatable(Colors.class)
@interface Color {
	String name();
}
