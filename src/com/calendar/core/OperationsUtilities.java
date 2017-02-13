/*
 * Author:Radha Krishna
 * Date:02/09/2017
 * Description:This is a utility class which can be used by other Calculator implementation classes to load operands 
 * ,operators and validate the expression entered.
 */

package com.calendar.core;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationsUtilities {
	final static String REGEX = "([0-9]*[+-/%*]?[0-9]*)*";
	private static List<Double> operands = null;
	private static List<Character> operators = null;

	static void loadOperandsandOperators(String expressionToBeProcessed) {
		// Function for storing the operands and operators from the input
		// expression
		operands = new ArrayList<Double>();
		operators = new ArrayList<Character>();
		for (int i = 0; i < expressionToBeProcessed.length(); i++) {
			String numPart = "";
			while ((i < expressionToBeProcessed.length()) && (Character.isDigit(expressionToBeProcessed.charAt(i)))) {
				numPart += expressionToBeProcessed.charAt(i);
				i++;
			}
			if (!numPart.isEmpty())
				operands.add(new Double(numPart));
			// Storing the operands on to Array List variable operands
			if (i < expressionToBeProcessed.length()) {
				operators.add(expressionToBeProcessed.charAt(i));
				// Storing the operator symbols on to Array List operators
				// variable
			}
		}
	}

	public static ArrayList<Character> loadOperators() {
		return (ArrayList<Character>) operators;
	}

	public static ArrayList<Double> loadOperands() {
		return (ArrayList<Double>) operands;
	}

	public static boolean validate(String inputExpression) {
		// Function to validate the input string
		boolean validInput = false;
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(inputExpression);
		validInput = matcher.matches();
		if (validInput) {
			loadOperandsandOperators(inputExpression);
			if (!(operators.size() == (operands.size() - 1))) {
				validInput = false;
			}
		}
		return validInput;

	}

}
