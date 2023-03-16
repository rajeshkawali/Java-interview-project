package com.rajeshkawali.designpattern.factorypattern;

import java.io.File;
/**
 * @author Rajesh_Kawali
 *
 */
interface FileParser {
	void parse();
}

class CsvFileParser implements FileParser {
	private File file;

	public CsvFileParser(File file) {
		this.file = file;
	}

	@Override
	public void parse() {
		System.out.println("Parsing CSV file: " + file.getName());
	}
}

class PdfFileParser implements FileParser {
	private File file;

	public PdfFileParser(File file) {
		this.file = file;
	}

	@Override
	public void parse() {
		System.out.println("Parsing PDF file: " + file.getName());
	}
}

class ExcelFileParser implements FileParser {
	private File file;

	public ExcelFileParser(File file) {
		this.file = file;
	}

	@Override
	public void parse() {
		System.out.println("Parsing Excel file: " + file.getName());
	}
}

class FileParserFactory {
	public static FileParser getFileParser(File file) {
		String fileName = file.getName().toLowerCase();

		if (fileName.endsWith(".csv")) {
			return new CsvFileParser(file);
		} else if (fileName.endsWith(".pdf")) {
			return new PdfFileParser(file);
		} else if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
			return new ExcelFileParser(file);
		} else {
			throw new IllegalArgumentException("Unsupported file type: " + fileName);
		}
	}
}

public class FactoryDesignPatternFileParser {

	public static void main(String[] args) {
		File csvFile = new File("data.csv");
		File pdfFile = new File("report.pdf");
		File excelFile = new File("data.xlsx");

		FileParser csvParser = FileParserFactory.getFileParser(csvFile);
		csvParser.parse();

		FileParser pdfParser = FileParserFactory.getFileParser(pdfFile);
		pdfParser.parse();

		FileParser excelParser = FileParserFactory.getFileParser(excelFile);
		excelParser.parse();
	}
}
/*
The Factory design pattern is a creational pattern that provides an interface for creating objects 
in a superclass, but allows subclasses to alter the type of objects that will be created. 
The main idea behind the Factory pattern is to provide a way to delegate the creation of objects 
to a separate method or class that knows how to create the objects based on given parameters.
*/

/*

     			+---------------------------------------------+                 +---------------------+
     			|                <<interface>>                |    uses         |     <<static>>      |
     			|                 FileParser             	  |---------------->|   FileParserFactory |
     			+---------------------------------------------+                 +---------------------+
             		^                 ^					  ^
             		|                 |					  |
+---------------------+   +----------------------+	  +---------------------+
|   CsvFileParser     |   |    PdfFileParser     |	  |   ExcelFileParser   |
+---------------------+   +----------------------+	  +---------------------+
| -file: File         |   | -file: File          |	  | -file: File         |
+---------------------+   +----------------------+	  +---------------------+
| +parse(): void      |   | +parse(): void       |	  | +parse(): void      |
+---------------------+   +----------------------+	  +---------------------+

The diagram shows the relationship between the FileParser, CsvFileParser, PdfFileParser, ExcelFileParser, 
and FileParserFactory classes. The FileParserFactory is responsible for creating the appropriate FileParser 
object based on the file type. The CsvFileParser, PdfFileParser, and ExcelFileParser classes implement 
the FileParser interface and define their own parse() methods.
*/