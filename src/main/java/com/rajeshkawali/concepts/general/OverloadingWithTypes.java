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