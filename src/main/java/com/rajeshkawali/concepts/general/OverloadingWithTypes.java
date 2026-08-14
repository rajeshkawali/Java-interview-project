package com.rajeshkawali.concepts.general;
/**
 * @author Rajesh_Kawali
 *
 */
class OverloadingWithTypes {

	public void method(byte b) {
		System.out.println("byte: " + b);
	}

	public void method(short s) {
		System.out.println("short: " + s);
	}

	public void method(int i) {
		System.out.println("int: " + i);
	}

	public void method(long l) {
		System.out.println("long: " + l);
	}

	public void method(float f) {
		System.out.println("float: " + f);
	}

	public void method(double d) {
		System.out.println("double: " + d);
	}

	public void method(Byte b) {
		System.out.println("Byte: " + b);
	}

	public void method(Short s) {
		System.out.println("Short: " + s);
	}

	public void method(Integer i) {
		System.out.println("Integer: " + i);
	}

	public void method(Long l) {
		System.out.println("Long: " + l);
	}

	public void method(Float f) {
		System.out.println("Float: " + f);
	}

	public void method(Double d) {
		System.out.println("Double: " + d);
	}

	public void method(Number n) {
		System.out.println("Number: " + n);
	}

	public void method(Object o) {
		System.out.println("Object: " + o);
	}

	public void method(String... args) {
		System.out.println("Varargs: " + String.join(", ", args));
	}

	@SuppressWarnings("removal")
	public static void main(String[] args) {
		OverloadingWithTypes obj = new OverloadingWithTypes();
		obj.method((byte) 10);
		obj.method((short) 100);
		obj.method(1000);
		obj.method(10000L);
		obj.method(3.14f);
		obj.method(3.14);
		obj.method(new Integer(1000));
		obj.method(new Object());
		obj.method("Hello", "World");
	}
}

/*
Method Overloading Resolution Order in Java

Java follows this order to find the best matching overloaded method:

1. Exact Match
   byte -> method(byte)

2. Primitive Widening
   byte -> short -> int -> long -> float -> double

3. Autoboxing
   byte -> Byte

4. Widening Reference
   Byte -> Number -> Object

5. Varargs
   method(String... args)

Rule:
- Java always selects the first and most specific matching method.
- Once a suitable method is found, it stops searching.

Example:
byte value

method(byte)      ✓ Exact Match
method(short)     ✓ Widening
method(Byte)      ✓ Autoboxing
method(Number)    ✓ Widening Reference
method(Object)    ✓ Widening Reference
method(String...) ✓ Varargs

Java will call method(byte) because it has the highest priority.

Priority Order:
Exact Match
    ↓
Primitive Widening
    ↓
Autoboxing
    ↓
Widening Reference
    ↓
Varargs
*/