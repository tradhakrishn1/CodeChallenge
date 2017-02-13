package com.calendar.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.calendar.core.BasicCalculatorImpl;
import com.calendar.core.OperatorPriority;

public class EvalExpressionTest {

	String arithematicExpression="4/2+2-2*2%2";

	@Test
	public void test() {
		BasicCalculatorImpl basicCalculatorImpl = new BasicCalculatorImpl(new OperatorPriority(),arithematicExpression);
		assertEquals(4.0, basicCalculatorImpl.evaluate(), 1e-15);
		
	}

}
