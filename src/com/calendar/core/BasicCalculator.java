/*
 * Author:Radha Krishna
 * Date:2/09/2017
 * Description:Consits of basic core operations like addition,subtraction,multiplication and modulus implemented
 * through Lambda functions using predefined DoubleBinaryOperator functional reference.
 */
package com.calendar.core;

import java.util.function.DoubleBinaryOperator;

public abstract class BasicCalculator {
	DoubleBinaryOperator add = (double a, double b) -> a + b;
	DoubleBinaryOperator sub = (double a, double b) -> a - b;
	DoubleBinaryOperator mul = (double a, double b) -> a * b;
	DoubleBinaryOperator mod = (double a, double b) -> a % b;
	DoubleBinaryOperator div = (double a, double b) -> {
		if (b == 0)
			throw new UnsupportedOperationException("Cannot divide by zero");
		else
			return a / b;
	};

	public abstract double evaluate();
}
