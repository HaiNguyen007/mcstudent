package com.caramelcode.mcstudent.questions;

import com.caramelcode.mcstudent.forge.ConfigHelper;
import com.caramelcode.mcstudent.util.NumberHelper;

/**
 * This class generates math fact questions +, -, *, / based on grade level.
 * 
 * @author jsprague
 *
 */
public class MathFactQuestionFactory {
	private MathFactQuestionFactory() {
	}

	public static IQuestion buildArithmeticQuestion() {
		ArithmeticQuestion question = null;
		int studentGrade = ConfigHelper.getStudentGrade();
		int opIndex;

		switch (studentGrade) {
			case 1:
				opIndex = NumberHelper.randRange(1, 2); // include +, -
				break;
			case 2:
			case 3:
				opIndex = NumberHelper.randRange(1, 3); // include: +, -, x
				break;
			case 4:
				opIndex = NumberHelper.randRange(3, 4); // include: x, /
				break;
			default:
				opIndex = 1; // default to just Plus (+)
				break;
		}

		// pick a random operation and formulate the question
		switch (opIndex) {
			case 1:
				question = new ArithmeticQuestion('+', studentGrade);
				break;
			case 2:
				question = new ArithmeticQuestion('-', studentGrade);
				break;
			case 3:
				question = new ArithmeticQuestion('x', studentGrade);
				break;
			case 4:
				question = new ArithmeticQuestion('/', studentGrade);
				break;
		}

		return question;
	}
}
