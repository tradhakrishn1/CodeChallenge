/*
 * Author:Radha Krishna 
 * Date:02/09/2017
 * Description:This is main class in the library which takes the arithmetic expression from console
 * and prints result on to the console.
 * Last Edit:2/14/2017
 */

package com.calendar.core;
import java.util.Scanner;

public class CalculatorMain {
	public static void main(String args[]) {
		boolean oneMoreInput = true;
		while (oneMoreInput) {
			System.out.println("Enter the input arithemetic expression ");
			Scanner sc = new Scanner(System.in);
			try {
				BasicCalculatorImpl basicCalculatorImpl = new BasicCalculatorImpl(new OperatorPriority(), sc.nextLine());
				System.out.println("The evaluated result of the expression is:"+" "+basicCalculatorImpl.evaluate());
				System.out.println("Enter true to continue with one more input, false to exit");
				oneMoreInput = sc.nextBoolean();

			} catch (WrongFormatExpression wf) {
				System.out.println(
						"Make sure the expression has numbers, +,-,*,/,% and right arithemetic order.");
				System.out.println("Enter true to continue with one more input, false to exit");
				oneMoreInput = sc.nextBoolean();
			} catch (UnsupportedOperationException uoe) {
				System.out.println("Make sure to check if there is any divide by zero operation");
				System.out.println("Enter true to continue with one more input, false to exit");
				oneMoreInput = sc.nextBoolean();
			} catch (Exception e) {
			}
		}

	}

}