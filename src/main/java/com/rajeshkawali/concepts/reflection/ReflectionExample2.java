package com.rajeshkawali.concepts.reflection;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.List;
/**
 * @author Rajesh_Kawali
 *
 */
public class ReflectionExample2 {

  @SuppressWarnings("rawtypes")
public static void main(String[] args) throws Exception {
		    // Example for Class
		    Class<Person> personClass = Person.class;
		    System.out.println("Class Name: " + personClass.getName());

		    // Example for Method
		    Method method = personClass.getMethod("getName", null);
		    System.out.println("Method Name: " + method.getName());

		    // Example for Field
		    Field field = personClass.getDeclaredField("age");
		    System.out.println("Field Name: " + field.getName());

		    // Example for Constructor
		    Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
		    System.out.println("Constructor: " + constructor);

		    // Example for Modifier
		    int modifiers = constructor.getModifiers();
		    System.out.println("Is Constructor Public? " + Modifier.isPublic(modifiers));

		    // Example for Parameter
		    Parameter[] parameters = constructor.getParameters();
		    for (Parameter parameter : parameters) {
		      System.out.println("Parameter Name: " + parameter.getName());
		      System.out.println("Parameter Type: " + parameter.getType().getName());
		    }

		    // Example for Array
		    int[] intArray = (int[]) Array.newInstance(int.class, 10);
		    System.out.println("Array Length: " + intArray.length);

		    // Example for Type
		    Type type = personClass.getGenericSuperclass();
		    System.out.println("Type: " + type.getTypeName());

		    // Example for TypeVariable
		    TypeVariable<Class<Person>>[] typeVariables = personClass.getTypeParameters();
		    for (TypeVariable typeVariable : typeVariables) {
		      System.out.println("Type Variable Name: " + typeVariable.getName());
		      System.out.println("Type Variable Type: " + typeVariable.getGenericDeclaration());
		    }

		   // Example for WildcardType
		   // WildcardType wildcardType = (WildcardType) ((ParameterizedType) List.class.getTypeParameters()[0]).getUpperBounds()[0];
		   // System.out.println("Wildcard Type: " + wildcardType);
		   // ParameterizedType example
	        List<String> list = List.of("foo", "bar", "baz");
	        Type type1 = list.getClass().getGenericSuperclass();
	        if (type instanceof ParameterizedType) {
	            ParameterizedType parameterizedType = (ParameterizedType) type1;
	            System.out.println("Raw type: " + parameterizedType.getRawType());
	            Type[] typeArguments = parameterizedType.getActualTypeArguments();
	            for (Type typeArgument : typeArguments) {
	                System.out.println("Type argument: " + typeArgument);
	            }
	        }
	        

		    // Example for GenericArrayType
		    Type genericSuperclass = intArray.getClass().getGenericSuperclass();
		    if (genericSuperclass instanceof GenericArrayType) {
		      GenericArrayType genericArrayType = (GenericArrayType) genericSuperclass;
		      System.out.println("Generic Array Type: " + genericArrayType.getGenericComponentType().getTypeName());
		    }

		    // Example for ParameterizedType
		    //ParameterizedType parameterizedType = (ParameterizedType) List.class.getGenericSuperclass();
		    //System.out.println("Parameterized Type: " + parameterizedType.getTypeName());
		    
		    System.out.println("----------------------------------------------------------------------");
		 // Parameter example
	        Method method2 = getMethod();
	        for (Parameter parameter : method2.getParameters()) {
	            System.out.println("Parameter name: " + parameter.getName());
	            System.out.println("Parameter type: " + parameter.getType());
	        }
	        
	        // Array example
	        int[] array = (int[]) Array.newInstance(int.class, 10);
	        System.out.println("Array length: " + array.length);
	        
	        // Type example
	        Type type2 = String.class;
	        System.out.println("Type name: " + type2.getTypeName());
	        
	        // TypeVariable example
	        class Example<T> {
	            public void method(T t) {}
	        }
	        TypeVariable<?>[] typeParameters = Example.class.getTypeParameters();
	        for (TypeVariable<?> typeParameter : typeParameters) {
	            System.out.println("Type parameter name: " + typeParameter.getName());
	            System.out.println("Type parameter bounds: " + Arrays.toString(typeParameter.getBounds()));
	        }
	        
	        // WildcardType example
	        List<?> list2 = List.of(1, 2, 3);
	        Type listType = list2.getClass().getGenericSuperclass();
	        if (listType instanceof ParameterizedType) {
	            Type[] typeArguments = ((ParameterizedType) listType).getActualTypeArguments();
	            for (Type typeArgument : typeArguments) {
	                if (typeArgument instanceof WildcardType) {
	                    Type[] upperBounds = ((WildcardType) typeArgument).getUpperBounds();
	                    Type[] lowerBounds = ((WildcardType) typeArgument).getLowerBounds();
	                    System.out.println("Wildcard type upper bounds: " + Arrays.toString(upperBounds));
	                    System.out.println("Wildcard type lower bounds: " + Arrays.toString(lowerBounds));
	                }
	            }
	        }
	        
	        // GenericArrayType example
	        class Example2<T> {
	            public T[] method() { return null; }
	        }
	        Method method3 = null;
	        try {
	            method3 = Example2.class.getDeclaredMethod("method");
	        } catch (NoSuchMethodException | SecurityException e) {
	            e.printStackTrace();
	        }
	        Type returnType = method3.getGenericReturnType();
	        if (returnType instanceof GenericArrayType) {
	            Type componentType = ((GenericArrayType) returnType).getGenericComponentType();
	            System.out.println("Generic array type component type: " + componentType);
	        }
	        
	        // ParameterizedType example
	        List<String> stringList = List.of("foo", "bar", "baz");
	        Type stringListType = stringList.getClass().getGenericSuperclass();
	        if (stringListType instanceof ParameterizedType) {
	            Type[] typeArguments = ((ParameterizedType) stringListType).getActualTypeArguments();
	            for (Type typeArgument : typeArguments) {
	                System.out.println("Parameterized type argument: " + typeArgument);
	            }
	        }
	    }
	    
	    public static void exampleMethod(String arg1, int arg2, Object arg3) {}
	    
	    public static Method getMethod() {
	        try {
	            return ReflectionExample.class.getMethod("exampleMethod", String.class, int.class, Object.class);
	        } catch (NoSuchMethodException | SecurityException e) {
	            e.printStackTrace();
	            return null;
	        }
	    
		  }
		}

		class Person {
		  private String name;
		  private int age;

		  public Person(String name, int age) {
		    this.name = name;
		    this.age = age;
		  }

		  public String getName() {
		    return name;
		  }

		  public int getAge() {
		    return age;
		  }
		}