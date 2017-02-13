/*
 * Author:Radha Krishna
 * Date:2/09/2017
 * Description:This class is Basic calculator binary arithmetic expression implementer taking operator precedence
 * into account.This class extends from the BasicCalculator abstract class which holds the implementation methods for
 * basic arithmetic operations.
 */

package com.calendar.core;

import java.util.List;

public class BasicCalculatorImpl extends BasicCalculator {
	OperatorPriority operatorPriority;
	String processingString;
	List<Double> operands;
	List<Character> operators;

	public BasicCalculatorImpl(OperatorPriority operatorPriority, String processingString) {
		this.operatorPriority = operatorPriority;
		this.processingString = processingString;
	}

	// Function to evaluate the input expression
	public double evaluate() {
		// Validate the input expression
		boolean valid = OperationsUtilities.validate(processingString);
		if (!valid)
			throw new WrongFormatExpression();
		// Load the operands from input expression
		this.operands = OperationsUtilities.loadOperands();
		// Load the operators from input expression
		this.operators = OperationsUtilities.loadOperators();
		// When the number of operands are more than or equal to 2 apply below
		// logic else return the same element
		while (operands.size() >= 2) {
			int highestIndex = 0;// Start zeroth index as highest priority and
									// keep assigning when there is new highest
									// priority index
			Character highestIndexOperator = operators.get(0);
			for (int j = 0; j < operators.size() - 1; j++) {
				if (operatorPriority.getHm().get(operators.get(j + 1)) > operatorPriority.getHm()
						.get(highestIndexOperator)) {
					highestIndex = j + 1;
					highestIndexOperator = operators.get(highestIndex);
				}
			}
			performCalRealignLists(highestIndex, operators.get(highestIndex));
		}
		return operands.get(0);
	}

	// Function to perform Highest Priority operation and update and realign the
	// array lists after calculation
	private void performCalRealignLists(int index, Character c) {
		Double a = operands.get(index);
		Double b = operands.get(index + 1);
		BasicOperator op = BasicOperator.getOperator(c);
		switch (op) {
		case ADDITION:
			operands.remove(index + 1);
			operands.set(index, add.applyAsDouble(a, b));
			operators.remove(index);
			break;
		case SUBTRACTION:
			operands.remove(index + 1);
			operands.set(index, sub.applyAsDouble(a, b));
			operators.remove(index);
			break;
		case MULTIPLICATION:
			operands.remove(index + 1);
			operands.set(index, mul.applyAsDouble(a, b));
			operators.remove(index);
			break;
		case DIVISION:
			operands.remove(index + 1);
			operands.set(index, div.applyAsDouble(a, b));
			operators.remove(index);
			break;
		case MODULUS:
			operands.remove(index + 1);
			operands.set(index, mod.applyAsDouble(a, b));
			operators.remove(index);
			break;
		}
		// case default: return;
	}
}
