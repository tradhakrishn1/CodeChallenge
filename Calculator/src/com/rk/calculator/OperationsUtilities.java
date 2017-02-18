/*
 * Author:Radha Krishna
 * Date:02/09/2017
 * Description:This is a utility class which can be used by other Calculator implementation classes to load operands 
 * ,operators and validate the expression entered.
 * Last Edit:2/14/2017
 */

package com.rk.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationsUtilities {
	final static String REGEX = "([0-9]*[+-/%*]?[0-9]*)*";
	final static String REGEX_STRING_SPLIT = "[+-/%*]";
	static List<String> allowedOperators = Arrays.asList("+", "-", "*", "/", "%");
	private static List<Double> operands;
	private static List<Character> operators;

	static void loadOperandsandOperators(String expressionToBeProcessed) {
		// Function for storing the operands and operators from the input
		operands = Stream.of(expressionToBeProcessed.split(REGEX_STRING_SPLIT)).filter(x -> !x.isEmpty())
				.map(x -> Double.parseDouble(x)).collect(Collectors.toList());
		operators = Stream.of(expressionToBeProcessed.split("")).filter(x -> allowedOperators.contains(x))
				.map(x -> x.charAt(0)).collect(Collectors.toList());
	}

	public static List<String> getAllowedOperators() {
		return allowedOperators;
	}

	public static void setAllowedOperators(List<String> allowedOperators) {
		OperationsUtilities.allowedOperators = allowedOperators;
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
