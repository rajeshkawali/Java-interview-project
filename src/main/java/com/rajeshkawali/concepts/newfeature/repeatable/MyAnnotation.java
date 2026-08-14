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


/*
Meta-Annotations in Java

Meta-annotations are annotations that are used to define the behavior
of other annotations.

1. @Retention
Specifies how long an annotation is available.

- SOURCE  -> Available only in source code.
             Removed by the compiler.
             Example: @Override

- CLASS   -> Stored in the .class file.
             Not available at runtime.
             (Default retention policy)

- RUNTIME -> Available during runtime.
             Can be accessed using Reflection.
--------------------------------------------------
2. @Target
Specifies where an annotation can be applied.

Common ElementTypes:
- TYPE         -> Class, Interface, Record, Enum
- METHOD       -> Method
- FIELD        -> Variable
- CONSTRUCTOR  -> Constructor
- PARAMETER    -> Method Parameter
- LOCAL_VARIABLE -> Local Variable
--------------------------------------------------
3. @Documented
Includes the annotation in the generated Javadoc.
--------------------------------------------------
4. @Inherited
Allows a custom annotation to be inherited by subclasses.
Only works for class-level annotations.
--------------------------------------------------
5. @Repeatable (Java 8)
Allows the same annotation to be applied multiple times
to the same declaration.
--------------------------------------------------
Interview Points

- @Retention -> Lifetime of annotation.
- @Target -> Where annotation can be used.
- @Documented -> Included in Javadoc.
- @Inherited -> Inherited by subclasses.
- @Repeatable -> Same annotation can be used multiple times.
*/