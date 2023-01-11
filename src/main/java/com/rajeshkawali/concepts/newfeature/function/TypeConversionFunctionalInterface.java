package com.rajeshkawali.concepts.newfeature.function;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * @author Rajesh_Kawali
 *
 */
public class TypeConversionFunctionalInterface {

	public static void main(String[] args) {
		//ToIntFunction: This functional interface takes an object of a certain type and returns an int value.
		ToIntFunction<String> stringLength = str -> str.length();
        int length = stringLength.applyAsInt("Hello, ToIntFunction!");
        System.out.println(length);  // Output: 23
        
        //ToLongFunction: This functional interface takes an object of a certain type and returns a long value.
        ToLongFunction<String> stringHashCode = str -> (long) str.hashCode();
        long hashCode = stringHashCode.applyAsLong("Hello, ToLongFunction!");
        System.out.println(hashCode);

        //ToDoubleFunction: This functional interface takes an object of a certain type and returns a double value.
        ToDoubleFunction<String> stringToDouble = Double::parseDouble;
        double doubleValue = stringToDouble.applyAsDouble("3.14");
        System.out.println(doubleValue);  // Output: 3.14
        
        //IntFunction, LongFunction, DoubleFunction : These functional interfaces take an int, long, double respectively and returns a result of any type.
        IntFunction<String> intToString = String::valueOf;
        String str = intToString.apply(5);
        System.out.println(str);  // Output: "5"
        
        //IntPredicate, LongPredicate, DoublePredicate : These functional interfaces take an int, long, double respectively and returns a boolean.
        IntPredicate isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(5));  // Output: false
        System.out.println(isEven.test(6));  // Output: true
        
        //IntConsumer, LongConsumer, DoubleConsumer : These functional interfaces take an int, long, double respectively and returns nothing.
        IntConsumer printer = System.out::println;
        printer.accept(5);  // Output: 5
        
        //IntSupplier, LongSupplier, DoubleSupplier : These functional interfaces take nothing but returns an int, long, double respectively.
        IntSupplier randomNum = () -> (int)(Math.random()*100);
        System.out.println(randomNum.getAsInt());
        
        //ObjIntConsumer: This functional interface takes an object of a certain type and an int and doesn't return any value.
        ObjIntConsumer<String> insertNumber = (str1,num) -> System.out.println(str1+num);
        insertNumber.accept("The number is: ", 5);  // Output: "The number is: 5"
        
        //ObjLongConsumer and ObjDoubleConsumer : These functional interfaces take an object of a certain type and a long and double respectively and doesn't return any value.
        ObjLongConsumer<String> printTimestamp = (str2,timestamp) -> System.out.println(str2+timestamp);
        printTimestamp.accept("Timestamp: ", System.currentTimeMillis());
        
        //ObjDoubleConsumer: This functional interface takes an object of a certain type and an double and doesn't return any value.
        ObjDoubleConsumer<String> insert2Number = (str1,num) -> System.out.println(str1+num);
        insert2Number.accept("The number is: ", 5);  // Output: "The number is: 5"
	}

}
