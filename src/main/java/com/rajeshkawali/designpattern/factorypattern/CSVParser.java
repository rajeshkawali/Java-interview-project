package com.rajeshkawali.designpattern.factorypattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class CSVParser implements Parser{

	@Override
	public String parser(String msg) {
		System.out.println("CSVParser.parser()");
		String msgParser = "CSV-"+msg;
		return msgParser;
	}

}
