package com.rajeshkawali.designpattern.abstractfactorypattern;

public class ExcelParserFactory implements ParserFactory {
	public Parser createParser() {
		return new ExcelParser();
	}
}
