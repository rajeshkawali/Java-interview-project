package com.rajeshkawali.designpattern.facadepattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class FacadeParserClass {

	private TextParser textParser;
	private CSVParser csvParser;
	private PDFParser pdfParser;

	public FacadeParserClass() {
		textParser = new TextParser();
		csvParser = new CSVParser();
		pdfParser = new PDFParser();
	}

	public void textParser() {
		textParser.parser();
	}

	public void csvParser() {
		csvParser.parser();
	}

	public void pdfParser() {
		pdfParser.parser();
	}
}
