package com.rk.calculatortest;

import static org.junit.Assert.*;
import org.junit.Test;
import com.rk.calculator.OperationsUtilities;

public class ValidExpressionTest {
	String stringToBeValidated = "1+2";

	@Test
	public void test() {
		assertTrue(OperationsUtilities.validate(stringToBeValidated) == true);
	}

}
