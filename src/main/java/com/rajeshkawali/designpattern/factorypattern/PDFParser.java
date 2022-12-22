package com.rajeshkawali.designpattern.factorypattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class PDFParser implements Parser {

	@Override
	public String parser(String msg) {
		System.out.println("PDFParser.parser()");
		String msgParser = "PDF-"+msg;
		return msgParser;
	}

}
