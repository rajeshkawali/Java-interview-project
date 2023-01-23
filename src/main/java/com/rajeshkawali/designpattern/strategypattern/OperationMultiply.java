package com.rajeshkawali.designpattern.strategypattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class OperationMultiply implements Strategy {
	public int doOperation(int num1, int num2) {
		return num1 * num2;
	}
}