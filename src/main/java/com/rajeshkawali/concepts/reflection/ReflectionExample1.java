package com.rajeshkawali.concepts.reflection;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
/**
 * @author Rajesh_Kawali
 *
 */
public class ReflectionExample1 {
    public static void main(String[] args) {
        ReflectionExample1 reflectionExamples = new ReflectionExample1();
        reflectionExamples.exampleClass();
        reflectionExamples.exampleMethod();
        reflectionExamples.exampleField();
        reflectionExamples.exampleConstructor();
        reflectionExamples.exampleModifier();
        reflectionExamples.exampleAnnotation();
    }

    public void exampleClass() {
        try {
            Class<?> cls = Class.forName("java.util.ArrayList");
            System.out.println("Class name: " + cls.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exampleMethod() {
        try {
            Class<?> cls = Class.forName("java.util.ArrayList");
            Method method = cls.getMethod("add", Object.class);
            System.out.println("Method name: " + method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exampleField() {
        try {
            Class<?> cls = Class.forName("java.util.ArrayList");
            Field field = cls.getDeclaredField("elementData");
            System.out.println("Field name: " + field.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exampleConstructor() {
        try {
            Class<?> cls = Class.forName("java.util.ArrayList");
            Constructor<?> constructor = cls.getConstructor();
            System.out.println("Constructor name: " + constructor.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exampleModifier() {
        try {
            Class<?> cls = Class.forName("java.util.ArrayList");
            Method method = cls.getMethod("add", Object.class);
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                System.out.println("Method is public");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exampleAnnotation() {
        try {
            Class<?> cls = Class.forName("java.util.ArrayList");
            Annotation[] annotations = cls.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("Annotation: " + annotation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
