package com.rajeshkawali.concepts.newfeature.string;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringFeaturesJDK8ToJDK25 {

	/*
	 * ============================================================
	 * String Features from Java 8 to Java 25
	 * ============================================================
	 *
	 * String is an immutable class in the java.lang package.
	 * Once a String object is created, its value cannot be changed.
	 *
	 * Java Version Features:
	 *
	 * Java 8  -> String.join(), StringJoiner
	 * Java 9  -> chars(), codePoints()
	 * Java 11 -> isBlank(), strip(), stripLeading(),
	 *            stripTrailing(), repeat(), lines()
	 * Java 12 -> indent(), transform()
	 * Java 15 -> Text Blocks, formatted(),
	 *            stripIndent(), translateEscapes()
	 * Java 16 - Java 25 -> No major String API methods added.
	 */

	public static void main(String[] args) {

		System.out.println("============ StringJoiner (Java 8) ============");
		/*
		StringJoiner (Java 8)
		---------------------
		Used to efficiently join multiple strings with a delimiter.
		It also supports optional prefix and suffix.
		*/
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		joiner.add("Java").add("Spring").add("Hibernate");
		System.out.println(joiner);

		System.out.println("\n============ String.join() (Java 8) ============");
		/*
		String.join() (Java 8)
		----------------------
		A utility method to join multiple strings or collections
		using a specified delimiter.
		*/
		System.out.println(String.join(" -> ",
				"Java",
				"Spring",
				"Microservices"));
		List<String> list = Arrays.asList("HTML", "CSS", "JavaScript");
		System.out.println(String.join(", ", list));

		System.out.println("\n============ chars() (Java 9) ============");
		/*
		chars() (Java 9)
		----------------
		Returns an IntStream of UTF-16 characters.
		Useful for processing characters using Stream API.
		*/
		"JAVA".chars()
				.mapToObj(ch -> (char) ch)
				.forEach(System.out::println);

		System.out.println("\n============ codePoints() (Java 9) ============");
		/*
		codePoints() (Java 9)
		---------------------
		Returns an IntStream of Unicode code points.
		Preferred over chars() when working with Unicode characters
		like emojis.
		*/
		"Hello".codePoints()
				.forEach(cp -> System.out.println((char) cp));

		System.out.println("\n============ repeat() (Java 11) ============");
		/*
		repeat() (Java 11)
		------------------
		Repeats the given string specified number of times.
		*/
		System.out.println("*".repeat(10));

		System.out.println("\n============ isBlank() (Java 11) ============");
		/*
		isBlank() (Java 11)
		-------------------
		Returns true if the string is empty or contains only
		whitespace characters.
		*/
		String blank = "   ";
		System.out.println("isBlank : " + blank.isBlank());
		System.out.println("isEmpty : " + blank.isEmpty());

		System.out.println("\n============ strip() (Java 11) ============");
		/*
		strip() (Java 11)
		-----------------
		Removes leading and trailing Unicode whitespace.
		Better than trim().
		*/
		String text = "   Hello Java   ";
		System.out.println("strip() : " + text.strip());
		System.out.println("trim()  : " + text.trim());

		System.out.println("\n============ stripLeading() (Java 11) ============");
		/*
		stripLeading() (Java 11)
		------------------------
		Removes only leading whitespace.
		*/
		System.out.println("'" + text.stripLeading() + "'");

		System.out.println("\n============ stripTrailing() (Java 11) ============");
		/*
		stripTrailing() (Java 11)
		-------------------------
		Removes only trailing whitespace.
		*/
		System.out.println("'" + text.stripTrailing() + "'");

		System.out.println("\n============ lines() (Java 11) ============");
		/*
		lines() (Java 11)
		-----------------
		Splits a multiline string into a Stream<String>.
		Useful for processing text line by line.
		*/
		String lines = """
				Java
				Spring
				Hibernate
				""";
		lines.lines().forEach(System.out::println);

		System.out.println("\n============ indent() (Java 12) ============");
		/*
		indent() (Java 12)
		------------------
		Adds or removes indentation from every line of a string.
		Positive value -> Adds spaces.
		Negative value -> Removes spaces.
		*/
		System.out.println(lines.indent(4));

		System.out.println("\n============ transform() (Java 12) ============");
		/*
		transform() (Java 12)
		---------------------
		Passes the entire string to a lambda expression and
		returns the transformed result.
		Useful for chaining string operations.
		*/
		String result = "java"
				.transform(String::toUpperCase)
				.transform(s -> s.concat(" Programming"));
		System.out.println(result);

		System.out.println("\n============ Text Blocks (Java 15) ============");
		/*
		Text Blocks (Java 15)
		---------------------
		Provides a clean way to write multi-line strings
		without using \n or string concatenation.
		Useful for JSON, SQL, XML and HTML.
		*/
		String json = """
				{
				    "id" : 101,
				    "name" : "Rajesh",
				    "course" : "Java"
				}
				""";
		System.out.println(json);

		System.out.println("\n============ formatted() (Java 15) ============");
		/*
		formatted() (Java 15)
		---------------------
		Formats a string using placeholders.
		Acts as an instance version of String.format().
		*/
		String message = "Welcome %s, your age is %d.";
		System.out.println(message.formatted("Rajesh", 35));

		System.out.println("\n============ String.format() ============");
		/*
		String.format()
		---------------
		Formats a string using format specifiers like %s, %d, %f.
		Returns a formatted string.
		*/
		System.out.println(String.format("%s is platform independent.", "Java"));

		System.out.println("\n============ stripIndent() (Java 15) ============");
		/*
		stripIndent() (Java 15)
		-----------------------
		Removes common leading indentation from every line
		of a text block.
		*/
		String indentText = """
				    Line 1
				    Line 2
				    Line 3
				""";
		System.out.println(indentText.stripIndent());

		System.out.println("\n============ translateEscapes() (Java 15) ============");
		/*
		translateEscapes() (Java 15)
		----------------------------
		Converts escape sequences like \n, \t, \\ into their
		actual characters.
		*/
		String escape = "Hello\\nWorld\\tJava";

		System.out.println(escape.translateEscapes());

		System.out.println("\n============ Java 16 - Java 25 ============");
		/*
		====================================================
		Java 16 - Java 25
		====================================================

		No major String API methods were introduced.
		The String class remains stable.
		Most improvements are in the JVM and language features.
		*/
		System.out.println("No major String API methods were introduced.");
	}
}