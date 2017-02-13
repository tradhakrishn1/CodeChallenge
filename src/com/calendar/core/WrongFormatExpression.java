/*
 * Author:Radha Krishna
 * Date:02/09/2017
 * Description:This exception is raised when your format of the arithmetic expression is incorrect.
 */

package com.calendar.core;

public class WrongFormatExpression extends RuntimeException {
	private static final long serialVersionUID = 214608615428211114L;

	WrongFormatExpression() {
		super("Expression is in wrong format.Please check the expression.");
	}

}
