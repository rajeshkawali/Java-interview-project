package com.rajeshkawali.designpattern.abstractfactorypattern;

public class PDFParserFactory implements ParserFactory {
	public Parser createParser() {
		return new PDFParser();
	}
}
