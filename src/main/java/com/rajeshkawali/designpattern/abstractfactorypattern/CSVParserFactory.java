package com.rajeshkawali.designpattern.abstractfactorypattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class CSVParserFactory implements ParserFactory {
	public Parser createParser() {
		return new CSVParser();
	}
}
