package com.rajeshkawali.concepts.general;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class KeywordExample {
    
	/*
	keyword is a word that is reserved by the language and has a 
	specific meaning and purpose. Keywords are used to identify and 
	perform specific operations or actions in a program. They are also 
	used to define the structure and behavior of a program.
	*/
	public static void main(String[] args) {
        // Use of 'final' keyword to define a constant
        final int MAX_SIZE = 10;

        // Use of 'boolean' keyword
        boolean flag = true;
        boolean isValid = false;

        // Use of 'for' and 'if' keywords
        for (int i = 0; i < MAX_SIZE; i++) {
            if (i % 2 == 0) {
                // Use of 'continue' keyword
                continue;
            }
            System.out.println(i);
        }

        // Use of 'while' keyword
        int count = 0;
        while (count < MAX_SIZE) {
            count++;
            // Use of 'break' keyword
            if (count == 5) {
                break;
            }
        }

        // Use of 'try-catch' block
        try {
            // Use of 'throw' keyword
            throw new Exception("An error occurred");
        } catch (Exception e) {
            // Use of 'System.out.println()' method
            System.out.println(e.getMessage());
        }

        // Use of 'ArrayList' class
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Use of 'for-each' loop
        for (Integer i : list) {
            // Use of 'System.out.println()' method
            System.out.println(i);
        }
    }
}
/*
In Java, there are four types of access modifiers:-->

public: A class, method, or variable that is declared public can be accessed from anywhere.

protected: A class, method, or variable that is declared protected can be accessed within the package it is declared in, as well as by any subclass of the class in which it is declared.

default (no explicit modifier): A class, method, or variable that has no explicit access modifier is considered to have default access and can be accessed within the package it is declared in, but not from outside the package.

private: A class, method, or variable that is declared private can only be accessed within the class in which it is declared.
---------------------------------------------------------------------------------------------
In Java, there are several primitive data types with default values and sizes as follows:-->

int (integer): The default value is 0, and the size is 32 bits.

long: The default value is 0L, and the size is 64 bits.

float: The default value is 0.0f, and the size is 32 bits.

double: The default value is 0.0d, and the size is 64 bits.

boolean: The default value is false, and the size is not specified.

char: The default value is '\u0000' (null character), and the size is 16 bits.

byte: The default value is 0, and the size is 8 bits.

short: The default value is 0, and the size is 16 bits.

Additionally, there is also another non-primitive data type 
called "String" which is used to hold a sequence of characters. 
The default value of a string variable is null.

*/

/*
There are a few more non-primitive data types in Java:-->

Array: An array is a group of similar type of elements that have a fixed size. The default value of an array is null.

Class: A class is a blueprint for an object, and the default value of a class variable is null.

Interface: An interface is a collection of abstract methods and constants that a class can implement. The default value of an interface variable is null.

Enum: An enumeration is a special data type that defines a set of named values. The default value of an enumeration variable is the first enumeration value.

Object: The Object class is the parent class of all the classes in Java. The default value of an object variable is null.

Please note that, the sizes of non-primitive data types are not defined in java, 
they are dependent on the underlying platform and JVM implementation.
*/


/*
Java has a total of 53 keywords. The list of all the keywords in Java are:-->

abstract, assert, boolean, break, byte, case, catch, char, class, 
const, continue, default, do, double, else, enum, extends, final, 
finally, float, for, goto, if, implements, import, instanceof, int, 
interface, long, native, new, package, private, protected, public, 
return, short, static, strictfp, super, switch, synchronized, this, 
throw, throws, transient, try, void, volatile, while

Please note that, const and goto are reserved keywords in Java, 
but they are not used in the current version of the language.
*/


/*
abstract: A class or method that is declared as abstract is meant to be subclassed or overridden. An abstract class cannot be instantiated, and an abstract method must be overridden in a subclass.

assert: An assertion is a statement in the form of an expression that is expected to be true. If it is not true, an AssertionError is thrown.

boolean: A primitive data type that can hold a value of true or false.

break: Exits a loop or switch statement.

byte: A primitive data type that can hold a value in the range of -128 to 127. It takes up 1 byte of memory.

case: Specifies a branch of code to be executed in a switch statement when a specific value is matched.

catch: Handles exceptions that are thrown in a try block.

char: A primitive data type that can hold a single character. It takes up 2 bytes of memory.

class: Defines a new class.

const: A reserved keyword that is not used in the current version of Java.

continue: Skips the current iteration of a loop and moves on to the next one.

default: Specifies a default branch of code to be executed in a switch statement when no value is matched.

do: Begins a do-while loop.

double: A primitive data type that can hold a floating-point value. It takes up 8 bytes of memory.

else: Specifies a branch of code to be executed if the preceding conditional statement is false.

enum: Defines a new enumeration type.

extends: Indicates that a class is a subclass of another class or that an interface is a descendant of another interface.

final: When applied to a class, it cannot be subclassed. When applied to a method, it cannot be overridden. When applied to a variable, it can only be assigned a value once.

finally: A block of code that is always executed, regardless of whether an exception is thrown or not.

float: A primitive data type that can hold a floating-point value. It takes up 4 bytes of memory.

for: Begins a for loop.

goto: A reserved keyword that is not used in the current version of Java.

if: Begins a conditional statement.

implements: Indicates that a class implements an interface.

import: Allows a class or package from another package to be used in the current file.

instanceof: Compares an object to a class or interface and returns true if the object is an instance of the class or interface.

int: A primitive data type that can hold an integer value. It takes up 4 bytes of memory.

interface: Defines a new interface.

long: A primitive data type that can hold a larger integer value. It takes up 8 bytes of memory.

native: Indicates that a method is implemented in native code, such as C or C++.

new: Creates a new instance of a class.

package: Declares a package for the current file.

private: When applied to a class, method or variable, it can only be accessed within the class in which it is declared.

protected: When applied to a class, method or variable, it can be accessed within the package in which it is declared and by any subclasses of the class in which it is declared.

public: When applied to a class, method or variable, it can be accessed from anywhere.

return: Returns a value from a method.

short: A primitive data type that can hold a smaller integer value. It takes up 2 bytes of memory.

static: Indicates that a method or variable belongs to the class rather than an instance of the class.

strictfp: Indicates that the floating-point operations used in a class or method will be performed in strictfp mode.

super: Refers to the superclass of the current class.

switch: Begins a switch statement.

synchronized: Indicates that a method can only be accessed by one thread at a time.

this: Refers to the current object.

throw: Throws an exception.

throws: Indicates that a method throws an exception.

transient: Indicates that a variable should not be serialized.

try: Begins a try-catch block.

void: Indicates that a method does not return a value.

volatile: Indicates that a variable's value may change without the program's knowledge.

while: Begins a while loop.


*/