package com.rk.calculatortest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EvalExpressionTest.class, ValidExpressionTest.class })
public class AllTests {

}
