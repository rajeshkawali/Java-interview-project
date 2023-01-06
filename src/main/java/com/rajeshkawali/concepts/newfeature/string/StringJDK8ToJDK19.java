package com.rajeshkawali.concepts.newfeature.string;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Rajesh_Kawali
 *
 */
public class StringJDK8ToJDK19 {

	/*
	 String is an object that represents a sequence of characters. It is defined
	 in the java.lang package and is an immutable class, which means that once it
	 is created, its value cannot be changed.
	 */
	public static void main(String[] args) {
		String str = "Java Programming Language";

		System.out.println("------------|StringJoiner|------------");
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		joiner.add("Hello").add("World").add("!");
		String result = joiner.toString();
		System.out.println(result);
		System.out.println("------------|String.join()|------------");
		String joinResult = String.join("_", "Hello", "World", "!");
		System.out.println(joinResult);
		List<String> languageList = Arrays.asList("Java", "HTML", "Python", "CSS", "PHP");
		System.out.println(String.join(", ", languageList));
		System.out.println("------------|String.repeat()|------------");
		String repeatResult = "Hello".repeat(3);
		System.out.println(repeatResult);
		System.out.println("------------|String.chars()|------------");
		String charsResult = "Hello, Java";
		IntStream chars = charsResult.chars();
		chars.forEach(ch -> System.out.println((char) ch));
		System.out.println("------------|String.lines()|------------");
		String linesResult = "Line 1\nLine 2\nLine 3";
		System.out.println("line count: " + linesResult.lines().count());
		Stream<String> lines = linesResult.lines();
		lines.forEach(System.out::println);
		System.out.println("------------|String.codePoints()|------------");
		String codePointsResult = "Hello, World!";
		IntStream codePoints = codePointsResult.codePoints();
		codePoints.forEach(codePoint -> System.out.println(codePoint));
		// codePointsResult.codePoints().forEach(System.out::println);
		System.out.println("------------|String.isBlank()|------------");
		String isBlankResult = "   ";
		boolean blank = isBlankResult.isBlank();
		boolean empty = isBlankResult.isEmpty();
		System.out.println(blank);
		System.out.println(empty);
		System.out.println("------------|String.strip()|------------");
		String stripResult = "  \t Hello, World!  \n ";
		String strippedStrip = stripResult.strip();
		String strippedTrim = stripResult.trim();
		System.out.println(strippedStrip);
		System.out.println(strippedTrim);
		System.out.println("------------|String.stripLeading()|------------");
		String stripLeadingResult = "   Hello, World!   ";
		String stripLeadingText = stripLeadingResult.stripLeading();
		System.out.println(stripLeadingText);
		System.out.println("------------|String.stripTrailing()|------------");
		String stripTrailingResult = "   Hello, World!   ";
		String stripTrailingText = stripTrailingResult.stripTrailing();
		System.out.println(stripTrailingText);
		System.out.println("------------|String.indent()|------------");
		String indentResult = "Line 1\nLine 2\nLine 3";
		String indentedText = indentResult.indent(2);
		System.out.println(indentedText);
		System.out.println("------------|String.transform()|------------");
		String transformResult = "Hello, World!";
		String transformedUpper = transformResult.transform(s -> s.toUpperCase());
		String transformedLower = transformResult.transform(String::toLowerCase);
		String transformedConcat = transformResult.transform(s -> s.concat(" Using Java"));
		System.out.println(transformedUpper);
		System.out.println(transformedLower);
		System.out.println(transformedConcat);
		System.out.println("------------|String.describeConstable()|------------");
		String describeConstableResult = "Hello, World!";
		Optional<String> constable = describeConstableResult.describeConstable();
		System.out.println(constable.get());
		System.out.println("------------|String.resolveConstantDesc()|------------");
		String resolveConstantDescResult = "Hello, World!";
		String handle = resolveConstantDescResult.resolveConstantDesc(MethodHandles.lookup());
		System.out.println(handle);
		System.out.println("------------|String.stripIndent()|------------");
		String stripIndentResult = "    Line 1\n    Line 2\n    Line 3";
		String stripIndentText = stripIndentResult.stripIndent();
		System.out.println(stripIndentText);
		System.out.println("------------|String.translateEscapes()|------------");
		String translateEscapesResult = "Hello, \\nWorld!";
		String translatedText = translateEscapesResult.translateEscapes();
		System.out.println(translatedText);
		System.out.println("------------|String.formatted() and String.format()|------------");
		String formatterResult = "Hello, %s!";
		String formattedResult = formatterResult.formatted("World");
		System.out.println(formattedResult);
		String formatResult = String.format("%s is platform independent.", str);
		System.out.println(formatResult);
		System.out.println("------------||------------");

		System.out.println("------------||------------");
	}
}
/*
New features that have been introduced in the String class in Java from version 8 to version 19:-->

Java 8:
StringJoiner class: This class allows you to concatenate String values using a delimiter and optional prefix and suffix.
String.join() method: This method allows you to concatenate String values using a delimiter.

Java 9:
String.chars() method: This method allows you to obtain a Stream of int values that represent the characters in a String. 
String.codePoints() method: This method allows you to obtain a Stream of int values that represent the Unicode code points in a String.

Java 11:
String.strip() method: This method allows you to remove leading and trailing whitespace from a String.
String.stripLeading() method: This method allows you to remove leading whitespace from a String.
String.stripTrailing() method: This method allows you to remove trailing whitespace from a String.
String.isBlank() method: This method allows you to check if a String is empty or consists only of whitespace.
String.repeat() method: This method allows you to repeat a String a specified number of times.
String.lines() method: This method allows you to split a String into a Stream of lines.

Java 12:
String.indent() method: This method allows you to add whitespace at the beginning of each line in a String.
String.transform() method: This method allows you to apply a function to each char in a String and return a new String with the transformed characters.
String.describeConstable() method: This method allows you to obtain a description of a String that can be used to create a Constable object.
String.resolveConstantDesc() method: It allows you to obtain a MethodHandle for a String that represents a constant value. A MethodHandle is an object that represents a method or constructor and can be used to invoke it.
 
Java 13:
Text blocks: This feature allows you to create multi-line String literals("""Example text"""), which can make your code more readable and easier to maintain.

Java 15:
String.formatted() method: This method allows you to create a Formatter object for a String.
String.stripIndent() method: This method allows you to remove common leading whitespace from all lines in a String.
String.translateEscapes() method: This method allows you to translate escape sequences in a String into the corresponding characters. 

Java 16:
Java 17:
Java 18:
Java 19:
----------------------------------------------------------------------------------------
Most commonly used methods in the String class in Java:-->

1) length(): Returns the number of characters in a String.
2) charAt(int index): Returns the character at a specified index in a String.
3) indexOf(int ch): Returns the index of the first occurrence of a specified character in a String.
4) lastIndexOf(int ch): Returns the index of the last occurrence of a specified character in a String.
5) substring(int beginIndex): Returns a new String that is a substring of the original String, starting at a specified index.
6) toLowerCase(): Returns a new String with all characters in lowercase.
7) toUpperCase(): Returns a new String with all characters in uppercase.
8) trim(): Returns a new String with leading and trailing whitespace characters removed.
9) replace(char oldChar, char newChar): Returns a new String with all occurrences of a specified character replaced with another character.
10) split(String regex): Returns an array of Strings by splitting the original String at each occurrence of a specified regular expression.
11) concat(String str): Returns a new String by concatenating the original String with another String.
12) startsWith(String prefix): Returns true if the original String starts with a specified prefix.
13) endsWith(String suffix): Returns true if the original String ends with a specified suffix.
14) equals(Object anObject): Returns true if the original String is equal to another object.
15) equalsIgnoreCase(String anotherString): Returns true if the original String is equal to another String, ignoring case.
16) compareTo(String anotherString): Compares the original String to another String and returns an integer value indicating their lexicographic order.
17) compareToIgnoreCase(String str): Compares the original String to another String, ignoring case, and returns an integer value indicating their lexicographic order.
18) toCharArray(): Returns an array of characters that represents the original String.
19) getBytes(): Returns an array of bytes that represents the original String in a specified character encoding.
20) valueOf(Object obj): Returns the String representation of an object.
21) matches(String regex): Returns true if the original String matches a specified regular expression.
22) replaceFirst(String regex, String replacement): Returns a new String with the first occurrence of a specified regular expression replaced with a replacement string.
23) replaceAll(String regex, String replacement): Returns a new String with all occurrences of a specified regular expression replaced with a replacement string.
24) replace(CharSequence target, CharSequence replacement): Returns a new String with all occurrences of a specified character sequence replaced with a replacement character sequence.
25) codePointAt(int index): Returns the Unicode code point at a specified index in the original String.
26) codePointBefore(int index): Returns the Unicode code point before a specified index in the original String.
27) codePointCount(int beginIndex, int endIndex): Returns the number of Unicode code points in the original String within a specified range.
28) offsetByCodePoints(int index, int codePointOffset): Returns the index within the original String that is offset by a specified number of code points.
29) intern(): Returns a canonical representation for the original String.
30) format(String format, Object... args): Returns a String formatted according to a specified format string and arguments.

*/