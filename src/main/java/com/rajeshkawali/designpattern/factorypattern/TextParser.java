package com.rajeshkawali.designpattern.factorypattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class TextParser implements Parser {

	@Override
	public String parser(String msg) {
		System.out.println("TextParser.parser()");
		String msgParser = "TXT-"+msg;
		return msgParser;
	}
}
