/*
 * Author:Radha Krishna
 * Date:02/09/2017
 * 
 */

package com.calendar.core;

public enum BasicOperator {
	ADDITION('+'), SUBTRACTION('-'), MULTIPLICATION('*'), DIVISION('/'), MODULUS('%');
	private final char symbol;
	BasicOperator(char symbol) {
		this.symbol = symbol;
	}
	public char getSymbol() {
		return symbol;
	}
	public static BasicOperator getOperator(char symbol) {
		switch (symbol) {
		case '+':
			return ADDITION;
		case '-':
			return SUBTRACTION;
		case '*':
			return MULTIPLICATION;
		case '/':
			return DIVISION;
		case '%':
			return MODULUS;
		default:
			return null;
		}

	}

}
