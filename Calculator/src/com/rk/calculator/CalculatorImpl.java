/*
 * Author:Radha Krishna
 * Date:02/14/2017
 * 
 */

package com.rk.calculator;

import java.util.List;

public class CalculatorImpl implements Calculator {

	OperatorPriority operatorPriority;
	List<Double> operands;
	List<Character> operators;

	public CalculatorImpl() {

	}

	public CalculatorImpl(OperatorPriority operatorPriority) {
		this.operatorPriority = operatorPriority;
	}

	// Function to evaluate the input expression
	public double evaluate(String inputArithemeticExpression) {
		// Validate the input expression
		boolean valid = OperationsUtilities.validate(inputArithemeticExpression);
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
	public void performCalRealignLists(int index, Character c) {
		Double a = operands.get(index);
		Double b = operands.get(index + 1);
		BasicOperator op = BasicOperator.getOperator(c);
		switch (op) {
		case ADDITION:
			operands.remove(index + 1);
			operands.set(index, new OperationContext(new AdditionOperation()).executeOperation(a, b));
			operators.remove(index);
			break;
		case SUBTRACTION:
			operands.remove(index + 1);
			operands.set(index, new OperationContext(new SubtractionOperation()).executeOperation(a, b));
			operators.remove(index);
			break;
		case MULTIPLICATION:
			operands.remove(index + 1);
			operands.set(index, new OperationContext(new MultiplicationOperation()).executeOperation(a, b));
			operators.remove(index);
			break;
		case DIVISION:
			operands.remove(index + 1);
			operands.set(index, new OperationContext(new DivisionOperation()).executeOperation(a, b));
			operators.remove(index);
			break;
		case MODULUS:
			operands.remove(index + 1);
			operands.set(index, new OperationContext(new ModulusOperation()).executeOperation(a, b));
			operators.remove(index);
			break;
		}
		// case default: return;
	}

}
