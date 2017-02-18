/*
 * Author:Radha Krishna
 * Date:02/14/2017
 * 
 */
package com.rk.calculator;

public class OperationContext {
	private Operation operation;

	public OperationContext(Operation operation) {
		this.operation = operation;
	}

	public double executeOperation(double operandOne, double operandTwo) {
		return operation.operate(operandOne, operandTwo);
	}
}
