package com.rajeshkawali.designpattern.abstractfactorypattern;

public class CSVParserFactory implements ParserFactory {
	public Parser createParser() {
		return new CSVParser();
	}
}
