package com.calendar.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.calendar.core.OperationsUtilities;

public class ValidExpressionTest {
	String stringToBeValidated="1+2";

	@Test
	public void test() {
		assertTrue(OperationsUtilities.validate(stringToBeValidated)==true);
	}

}
