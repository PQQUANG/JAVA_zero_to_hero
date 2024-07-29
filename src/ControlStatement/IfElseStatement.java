package ControlStatement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IfElseStatement {

	private static final int HIGH = 9;
	private static final int MIDDLE = 8;
	private static final int LOW = 5;
	private static final int AGE = 18;
	private static final char[] LISTVOWEL = { 'U', 'E', 'A', 'O', 'I' };
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Main loop for menu-driven program
		boolean exit = false;
		while (!exit) {
			System.out.println("===== Menu =====");
			System.out.println("1. Excercise 1: Check Even or Odd");
			System.out.println("2. Excercise 2: Compare Two Numbers");
			System.out.println("3. Excercise 3: Check Positive, Negative or Zero");
			System.out.println("4. Excercise 4: Calculate Average Score");
			System.out.println("5. Excercise 5: Check Leap Year");
			System.out.println("6. Excercise 6: Check Voting Eligibility");
			System.out.println("7. Excercise 7: Check Vowel or Consonant");
			System.out.println("8. Exit");
			System.out.println("Please enter the number to choose the functionality");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Let's start with Excercise 1");
				checkEvenorOdd();
				break;

			case 2:
				System.out.println("The Exercise 2");
				compareTwoNumber();
				break;

			case 3:
				System.out.println("The Excercise 3");
				checkPosNegZero();
				break;

			case 4:
				System.out.println("The Exercise 4");
				calculateAVGScore();
				break;

			case 5:
				System.out.println("The Excercise 5");
				checkLeapYear();
				break;

			case 6:
				System.out.println("The Excercise 6");
				checkVotingEligibility();
				break;

			case 7:
				System.out.println("The Excercise 7");
				checkVowelOrConsonant();
				break;

			case 8:
				exit = true;
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
			System.out.println();
		}
		scanner.close();
	}

	/**
	 * Checks if the given character is a vowel or consonant.
	 * 
	 * @param character The character to check.
	 * @return True if the character is a vowel, otherwise false.
	 */
	private static boolean checkCharacter(char character) {
		char charCheck = Character.toUpperCase(character);
		for (char vowel : LISTVOWEL) {
			if (vowel == charCheck) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Prompts the user to enter a character and determines if it is a vowel or
	 * consonant.
	 */
	private static void checkVowelOrConsonant() {
		System.out.println("Please enter only one character:");
		String input = scanner.next();

		if (input.length() != 1) {
			System.out.println("Please enter exactly one character.");
			return;
		}
		char character = input.charAt(0);
		if (checkCharacter(character)) {
			System.out.println(character + " is a vowel.");
		} else {
			System.out.println(character + " is a consonant.");
		}
	}

	/**
	 * Checks if the given age qualifies a person for voting.
	 * 
	 * @param ageCheck The age to check.
	 * @return True if the age is greater than or equal to the voting age, otherwise
	 *         false.
	 */
	private static boolean checkAge(int ageCheck) {
		return ageCheck >= AGE;
	}

	/**
	 * Prompts the user to enter ages and checks voting eligibility.
	 */
	private static void checkVotingEligibility() {
		System.out.println("Please enter the age you want to check:");
		int age = scanner.nextInt();
		boolean isEligible = checkAge(age);
		if (isEligible) {
			System.out.println("The person is eligible to vote.");
		} else {
			System.out.println("The person is not eligible to vote.");
		}
	}

	/**
	 * Prompts the user to enter a range of years and prints all leap years within
	 * that range.
	 */
	private static void checkLeapYear() {
		System.out.println("Please enter the starting year:");
		int fromYear = scanner.nextInt();
		System.out.println("Please enter the ending year:");
		int toYear = scanner.nextInt();

		List<Integer> listLeapYear = getYearLeap(fromYear, toYear);
		System.out.println("The leap years in the range are: " + listLeapYear);
	}

	/**
	 * Determines if a given year is a leap year.
	 * 
	 * @param year The year to check.
	 * @return True if the year is a leap year, otherwise false.
	 */
	private static boolean checkIsLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	/**
	 * Returns a list of leap years between the given start year and end year.
	 * 
	 * @param startYear The starting year.
	 * @param endYear   The ending year.
	 * @return A list of leap years within the range.
	 */
	private static List<Integer> getYearLeap(int startYear, int endYear) {
		List<Integer> listYearLeap = new ArrayList<>();
		for (int i = startYear; i <= endYear; i++) {
			if (checkIsLeapYear(i)) {
				listYearLeap.add(i);
			}
		}
		return listYearLeap;
	}

	/**
	 * Prompts the user to enter scores for various subjects and calculates the
	 * average score.
	 * 
	 * Rounds the average score to one decimal place and determines the student's
	 * grade based on the average score.
	 */
	private static void calculateAVGScore() {
		System.out.println("Please enter the scores for the subjects:");

		System.out.println("Score of Math: ");
		float mathScore = scanner.nextFloat();

		System.out.println("Score of English: ");
		float englishScore = scanner.nextFloat();

		System.out.println("Score of Physical: ");
		float physicalScore = scanner.nextFloat();

		float avgScore = (mathScore + englishScore + physicalScore) / 3;
		double avgScoreRounded = roundToDecimalPlaces(avgScore, 1);

		System.out.println("Average Score: " + avgScoreRounded);

		if (avgScoreRounded >= HIGH) {
			System.out.println("This student is in the Excellent grade.");
		} else if (avgScoreRounded >= MIDDLE) {
			System.out.println("This student is in the Good grade.");
		} else if (avgScoreRounded >= LOW) {
			System.out.println("This student is in the Average grade.");
		} else {
			System.out.println("This student is in the Poor grade.");
		}
	}

	/**
	 * Rounds a number to the specified number of decimal places.
	 * 
	 * @param number        The number to round.
	 * @param decimalPlaces The number of decimal places to round to.
	 * @return The rounded number.
	 */
	private static double roundToDecimalPlaces(double number, int decimalPlaces) {
		double scale = Math.pow(10, decimalPlaces);
		return Math.round(number * scale) / scale;
	}

	/**
	 * Checks if the given number is even or odd.
	 * 
	 * @param number The number to check.
	 */
	public static void checkEvenorOdd() {
		System.out.println("Please enter the number to check:");
		int numberCheck = scanner.nextInt();
		if (numberCheck % 2 == 0) {
			System.out.println("The number is even.");
		} else {
			System.out.println("The number is odd.");
		}
	}

	/**
	 * Compares two numbers and prints which one is greater.
	 * 
	 * @param firstNumber  The first number to compare.
	 * @param secondNumber The second number to compare.
	 */
	private static void compareTwoNumber() {
		System.out.println("Please enter the first number:");
		double firstNumber = scanner.nextDouble();

		System.out.println("Please enter the second number:");
		double secondNumber = scanner.nextDouble();

		if (firstNumber > secondNumber) {
			System.out.println("The first number is greater than the second number.");
		} else {
			System.out.println("The first number is less than or equal to the second number.");
		}
	}

	/**
	 * Checks if the given number is positive, negative, or zero.
	 * 
	 * @param number The number to check.
	 */
	private static void checkPosNegZero() {
		System.out.println("Please enter the number to check:");
		int number = scanner.nextInt();

		if (number > 0) {
			System.out.println("The number is positive.");
		} else if (number < 0) {
			System.out.println("The number is negative.");
		} else {
			System.out.println("The number is zero.");
		}
	}
}
