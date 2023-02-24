package com.rajeshkawali.designpattern.abstractfactorypattern;

import java.io.File;
import java.util.List;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class AbstractFactoryPatternMain {
	/*
	The Abstract Factory pattern is a creational pattern that provides an interface for creating 
	families of related or dependent objects without specifying their concrete classes. 
	It is useful when there is a need to create related objects without being tightly coupled 
	to the specific classes used in the implementation.

	The Abstract Factory pattern works by defining an abstract factory interface that declares 
	methods for creating related objects. Concrete factories implement this interface, 
	providing specific implementations for creating the related objects. Clients use the 
	abstract factory interface to create the objects they need, without being concerned 
	with the details of how the objects are created.
	*/
	public static void main(String[] args) {
		// Instantiate factories for each format
		ParserFactory csvFactory = new CSVParserFactory();
		ParserFactory excelFactory = new ExcelParserFactory();
		ParserFactory pdfFactory = new PDFParserFactory();

		// Create CSV parser using CSV factory and parse CSV file
		Parser csvParser = csvFactory.createParser();
		List<String> csvData = csvParser.parse(new File("example.csv"));
		for (String line : csvData) {
			System.out.println(line);
		}

		// Create Excel parser using Excel factory and parse Excel file
		Parser excelParser = excelFactory.createParser();
		List<String> excelData = excelParser.parse(new File("example.xlsx"));
		for (String line : excelData) {
			System.out.println(line);
		}

		// Create PDF parser using PDF factory and parse PDF file
		Parser pdfParser = pdfFactory.createParser();
		List<String> pdfData = pdfParser.parse(new File("example.pdf"));
		for (String line : pdfData) {
			System.out.println(line);
		}
	}
}

/*
In this implementation, there is a Parser interface that declares a method for parsing a 
file and returning a list of strings. There is also a ParserFactory interface that declares a 
method for creating a Parser object, and each concrete factory implementation provides a specific 
implementation for creating a parser for a specific format.

The CSVParserFactory and PDFParserFactory implementations create parsers that return a list of strings, 
while the ExcelParserFactory implementation creates a parser that returns a list of strings. 
The concrete parser implementations (CSVParser, ExcelParser, and PDFParser) implement 
the Parser interface and provide the specific implementation for parsing the corresponding file format.

The example usage code demonstrates how to instantiate and use the factories to create 
parsers for each file format, and then use those parsers to parse files of each format. 
The List objects returned by each parser can be further processed or used in other parts of the application as needed.
*/

/*
Here are the steps to consider while creating an Abstract Factory Pattern in Java:-->

Identify the objects that need to be created in your system and group them into related families. 
These related families should have common properties, such as a common interface or a set of related methods.

Create an abstract factory interface that defines a set of methods for creating these families of objects. 
Each method in the abstract factory should return an object that belongs to a specific family.

Implement the abstract factory interface by creating concrete factories for each family of objects. 
Each concrete factory should implement the methods defined in the abstract factory, and should create objects that belong to the specific family of objects.

Create an abstract product interface for each family of objects. 
This interface should define the common properties that all objects in the family should have.

Create concrete product classes that implement the abstract product interface for each family of objects. 
Each concrete product class should have a set of specific properties that make it unique from other products in the family.

Use the abstract factory to create objects in your application. 
The client code should only interact with the abstract factory and the abstract product interfaces, 
and should not be aware of the specific concrete implementations.

If you need to add new families of objects, you can create new abstract product interfaces and concrete product classes, 
and update the abstract factory interface and concrete factory implementations accordingly.
*/



