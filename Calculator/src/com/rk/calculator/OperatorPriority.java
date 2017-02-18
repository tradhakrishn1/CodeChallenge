/*
 * Author:Radha Krishna
 * Date:02/09/2017
 * Description:This class holds the operator priorities for various operators and instrumental in operator precedence 
 * implementation.You can add new priorities to the hash map when you have new operators.
 */

package com.rk.calculator;
import java.util.HashMap;

public class OperatorPriority {
	private HashMap<Character, Integer> hm;

	public void setHm(HashMap<Character, Integer> hm) {
		this.hm = hm;
	}

	public OperatorPriority(HashMap<Character, Integer> hm) {
		this.hm = hm;
	}

	public OperatorPriority() {
		this.hm = new HashMap<>();
		hm.put(BasicOperator.ADDITION.getSymbol(), 1);
		hm.put(BasicOperator.SUBTRACTION.getSymbol(), 1);
		hm.put(BasicOperator.MULTIPLICATION.getSymbol(), 2);
		hm.put(BasicOperator.DIVISION.getSymbol(), 2);
		hm.put(BasicOperator.MODULUS.getSymbol(), 2);
	}

	public HashMap<Character, Integer> getHm() {
		return hm;
	}

}
