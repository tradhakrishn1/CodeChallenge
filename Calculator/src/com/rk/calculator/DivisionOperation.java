/*
 * Author:Radha Krishna
 * Date:02/14/2017
 * 
 */

package com.rk.calculator;

public class DivisionOperation implements Operation {
	public double operate(double operandOne, double operandTwo) {
		if (operandTwo == 0)
			throw new UnsupportedOperationException("Cannot divide by zero");
		else
			return operandOne / operandTwo;
	}
}
