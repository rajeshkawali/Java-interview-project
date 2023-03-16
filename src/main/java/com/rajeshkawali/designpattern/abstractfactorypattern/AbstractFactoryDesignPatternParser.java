package com.rajeshkawali.designpattern.abstractfactorypattern;
/**
 * 
 * @author Rajesh_Kawali
 *
 */
//Abstract Product
interface FileParser {
	void parse(String file);
}

//Concrete Product 1
class ParserCsv implements FileParser {
	@Override
	public void parse(String file) {
		System.out.println("Parsing CSV file: " + file);
	}
}

//Concrete Product 2
class ParserPdf implements FileParser {
	@Override
	public void parse(String file) {
		System.out.println("Parsing PDF file: " + file);
	}
}

//Concrete Product 3
class ParserXlsx implements FileParser {
	@Override
	public void parse(String file) {
		System.out.println("Parsing XLSX file: " + file);
	}
}

// Abstract Factory
interface FileParserFactory {
	FileParser createFileParser();
}

// Concrete Factory 1
class ParserFactoryCsv implements FileParserFactory {
	@Override
	public FileParser createFileParser() {
		return new ParserCsv();
	}
}

// Concrete Factory 2
class ParserFactoryPdf implements FileParserFactory {
	@Override
	public FileParser createFileParser() {
		return new ParserPdf();
	}
}

// Concrete Factory 3
class ParserFactoryXlsx implements FileParserFactory {
	@Override
	public FileParser createFileParser() {
		return new ParserXlsx();
	}
}

// Client
public class AbstractFactoryDesignPatternParser {
	public static void main(String[] args) {
		FileParserFactory csvFactory = new ParserFactoryCsv();
		FileParser csvParser = csvFactory.createFileParser();
		csvParser.parse("file.csv");

		FileParserFactory pdfFactory = new ParserFactoryPdf();
		FileParser pdfParser = pdfFactory.createFileParser();
		pdfParser.parse("file.pdf");

		FileParserFactory xlsxFactory = new ParserFactoryXlsx();
		FileParser xlsxParser = xlsxFactory.createFileParser();
		xlsxParser.parse("file.xlsx");
	}
}
/*
Abstract Factory pattern is a creational design pattern that provides an interface 
for creating families of related or dependent objects without specifying their concrete classes.

The Abstract Factory pattern is used when we need to create objects that are related 
to each other or work together in a system. The pattern allows us to create these objects 
without specifying their concrete classes and decouples the client code from the implementation 
details of the objects it creates. This makes it easier to change the 
way objects are created without affecting the client code.

The Abstract Factory pattern is particularly useful in large-scale applications 
where different parts of the system need to be developed and maintained independently. 
It also promotes the Open/Closed principle by allowing new types of objects 
to be added to the system without changing the existing code.
*/

/*

		+-----------------------------+        							+---------------------------------+
		|   FileParser    		      |        							|   FileParserFactory      		  |
		+-----------------------------+        							+---------------------------------+
		|   +parse()                  |        							|   +createFileParser()    		  |
		+-----------------------------+        							+---------------------------------+
         ^           ^               ^ 										^			^			  ^
         |			 |				 |										|			|			  |
+-------+--------+ +---------------+ +------------+               			|			|			  |
|  ParserCsv     | | ParserPdf     | | ParserXlsx |     +--------------------+ +-------------------+ +-------------------+
+----------------+ +---------------+ +------------+     | ParserFactoryCsv   | | ParserFactoryPdf  | | ParserFactoryXlsx |
|  +parse()      | | +parse()      | | +parse()   |     +--------------------+ +-------------------+ +-------------------+
+----------------+ +---------------+ +------------+     |+createFileParser() | |+createFileParser()| |+createFileParser()|
                            				            +--------------------+ +-------------------+ +-------------------+


The FileParser interface is the abstract product, and the concrete products are ParserCsv, ParserPdf, and ParserXlsx. 
The FileParserFactory interface is the abstract factory, and the concrete factories are 
CsvParserFactory, PdfParserFactory, and XlsxParserFactory.

The client code AbstractFactoryDesignPatternParser creates instances of the concrete factories 
and uses them to create the concrete products.

*/