package com.rk.calculatortest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rk.calculator.CalculatorImpl;
import com.rk.calculator.OperatorPriority;

public class EvalExpressionTest {

	String arithematicExpression = "4/2+2-2*2%2";

	@Test
	public void test() {
		CalculatorImpl basicCalculatorImpl = new CalculatorImpl(new OperatorPriority());
		assertEquals(4.0, basicCalculatorImpl.evaluate(arithematicExpression), 1e-15);
	}

}
