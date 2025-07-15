package com.rajeshkawali.concepts.reflection;
import java.lang.reflect.*;
/**
 * @author Rajesh_Kawali
 *
 */
public class ReflectionExample {
	/*
	In Java, Reflection is a feature in the Java programming language that allows code to 
	inspect and manipulate the properties of a class, including its methods, fields, and 
	constructors, at runtime. It is an advanced feature of Java that enables developers 
	to create dynamic and flexible applications by examining and modifying the 
	behavior of classes, interfaces, and objects.

	Reflection is implemented using the java.lang.reflect package, which provides classes 
	and interfaces that enable reflection-based programming. With reflection, you can perform tasks such as:

	Determine the class of an object at runtime
	Discover the methods and fields of a class
	Create new instances of classes
	Access and modify private fields and methods
	Invoke methods dynamically

	Reflection should be used with caution, as it can have a negative 
	impact on the performance of your application, and it can also 
	compromise the security of your application if not used properly. 
	Additionally, reflection can make your code harder to maintain, 
	as it can make it difficult to understand how an application is functioning.
	*/
	
    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static void main(String[] args) throws Exception {
        Class cls = Class.forName("java.util.Date");
        Method method = cls.getMethod("toString");
        Object obj = cls.newInstance();
        Object result = method.invoke(obj);
        System.out.println(result);
    }
}
/*
In this example, the Class.forName method is used to obtain a 
Class object for the java.util.Date class. The getMethod method 
is then used to obtain a reference to the toString method of 
the java.util.Date class, and the invoke method is used to 
call the toString method on an instance of the java.util.Date class.
*/


/*
Here are some of the most important classes and interfaces in the java.lang.reflect package:-->

Class: Represents a class in the Java virtual machine. You can use the forName method to obtain a Class object for a particular class.

Method: Represents a method in a class. You can use the getMethod method to obtain a Method object for a particular method, and the invoke method to invoke the method.

Field: Represents a field in a class. You can use the getField and getDeclaredField methods to obtain a Field object for a particular field, and the get and set methods to access the value of the field.

Constructor: Represents a constructor in a class. You can use the getConstructor and getDeclaredConstructor methods to obtain a Constructor object for a particular constructor, and the newInstance method to create a new instance of the class using the constructor.

Modifier: Represents the access modifiers (e.g., public, private, protected) for classes, interfaces, methods, and fields. You can use the isPublic, isPrivate, isProtected, and other methods to determine the access modifiers for a particular class, interface, method, or field.

Annotation: Represents an annotation in a class, interface, method, or field. You can use the getAnnotation method to obtain an annotation for a particular class, interface, method, or field.

Parameter: Represents a parameter in a method or constructor. You can use the getName method to obtain the name of the parameter, and the getType method to obtain its type.

Array: Represents an array in the Java virtual machine. You can use the newInstance method to create a new array of a particular type and length.

Type: Represents a type in the Java virtual machine, such as a class, interface, or array type.

TypeVariable: Represents a type variable, such as a generic type parameter.

WildcardType: Represents a wildcard type, such as the type ?.

GenericArrayType: Represents an array type that has a generic component type, such as T[].

ParameterizedType: Represents a parameterized type, such as List<String>.

InvocationHandler: An interface that must be implemented by the invocation handler of a proxy instance.

Proxy: A class that is used to create proxy instances. You can use the newProxyInstance method to create a new proxy instance that implements a particular set of interfaces.

AccessibleObject: A superclass of Field, Method, and Constructor that provides a means to suppress the access checks for private members.

Member: An interface that is implemented by Field, Method, and Constructor, and provides a common superclass for these classes.

Executable: An abstract class that is a common superclass of Method and Constructor.

ReflectPermission: A security permission that is required to use certain sensitive reflection operations, such as accessing private members.

*/


/*

*/
