package com.rajeshkawali.concepts.newfeature.repeatable;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Rajesh_Kawali
 *
 */
@Repeatable(Colors.class)
@interface Color {
	String name();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Colors {
	Color[] value();
}

