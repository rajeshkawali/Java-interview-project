package com.rajeshkawali.designpattern.abstractfactorypattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class ExcelParserFactory implements ParserFactory {
	public Parser createParser() {
		return new ExcelParser();
	}
}
