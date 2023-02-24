package com.rajeshkawali.designpattern.abstractfactorypattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class PDFParserFactory implements ParserFactory {
	public Parser createParser() {
		return new PDFParser();
	}
}
