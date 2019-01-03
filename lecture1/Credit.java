package com.cs50.lecture1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Based on the given valid credit card number the program can determine whether
 * it as Visa, American Express, or MasterCard.
 * 
 * There might be only 13-, 15- and 16-digit Credit Card Numbers.
 * 
 * American Express numbers all start with 34 or 37; MasterCard numbers start
 * with 51, 52, 53, 54, or 55; Visa numbers all start with 4;
 * 
 * All Credit Card Numbers have a "checksum" built into them. It is a
 * mathematical relationship between at least one number and others. This
 * checksum enable computers to detect typos, without having to query database,
 * which can be slow. So most cards use an algorithm invented by Hans Peter
 * Lunh, which looks like the following: 0. Multiply every other digit by 2,
 * starting with the number's second-to-last digit, and then add those products'
 * digits together.\ 1. Add the sum to the sum of the digits that weren't
 * multiplied by 2. 2. If the total's last digit is 0(or if the total modulo 10
 * is congruent to 0), the number if valid!
 * 
 * @author Liubomyr Virt
 *
 */
public class Credit {

	public static Scanner input = new Scanner(System.in);
	private long creditCard; // credit card number given by the user;
	private boolean isValid = false; // changes to true in case of a valid number;
	private long checkSum; //
	private int digits; // keeps track of the number of digits on a card

	public static void main(String[] args) {
		Credit cardOne = new Credit();
		cardOne.getUserCreditCard();
		cardOne.calcCheckSum(cardOne.getCreditCard());
		cardOne.getCardsCompany(cardOne.getCreditCard());
	}

	/**
	 * prompts the user for an input
	 */
	public void getUserCreditCard() {
		do {
			try {
				System.out.print("Enter a credit card number: ");
				this.creditCard = input.nextLong();
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println();
				System.out.println("Wrong type of data!");
				break;
			}

		} while (!checkIfValid());
	}

	/**
	 * checks if the user entered a valid number of digits (13, 15, or 16) returns
	 * true if the number of digits equals 13, 15, or 16;
	 */
	public boolean checkIfValid() {
		long creditCardValidator = getCreditCard();
		while (creditCardValidator > 0) {
			creditCardValidator /= 10;
			digits++;
		}
		if (digits == 13 || digits == 15 || digits == 16) {
			isValid = true;
		} else {
			System.out.println("INVALID");
		}

		return isValid;
	}

	public long getCreditCard() {
		return this.creditCard;
	}

	/*
	 * calculates the checkSum of the credit card if checkSum's last number is 0,
	 * credit Card is valid, else - Invalid
	 */
	public void calcCheckSum(long creditCardNumber) {
		if (isValid == true) {

			long everyLastDigit = 0;
			long sumOfLastDigits = 0;

			long everyFirstDigit = 0;
			long sumOfFirstDigits = 0;

			while (creditCardNumber > 0) {

				everyFirstDigit = creditCardNumber % 10;
				sumOfFirstDigits += everyFirstDigit;

				// get rid of the last number
				creditCardNumber /= 10;
				// get second digit
				everyLastDigit = creditCardNumber % 10;
				// multiply it by 2
				everyLastDigit *= 2;
				// if it consists of two digit, split them too
				if (everyLastDigit >= 10) {
					long secondDigit = (everyLastDigit % 10);
					long firstDigit = (everyLastDigit / 10);
					sumOfLastDigits += (secondDigit + firstDigit);
				} else {
					sumOfLastDigits += everyLastDigit;
				}
				creditCardNumber /= 10;
			}

			// calculating checksum
			checkSum = (sumOfFirstDigits + sumOfLastDigits);

			if (checkSum % 10 > 0) {
				System.out.println("INVALID");
			} else
				System.out.println("VALID");
		}
	}

	/*
	 * get the last two digits of the credit card to find out if it's a VISA,
	 * MASTERCARD OR AMERICAN EXPRESS
	 */
	public void getCardsCompany(long creditCardNumber) {
		while (creditCardNumber > 0) {
			if (creditCardNumber < 100) {
				if (creditCardNumber >= 51 && creditCardNumber <= 55) {
					System.out.print("MasterCard");
				}
				if (creditCardNumber == 34 || creditCardNumber == 37) {
					System.out.print("American Express");
				}
				creditCardNumber /= 10;
			}

			if (creditCardNumber == 4) {
				System.out.print("VISA");
			}
			creditCardNumber /= 10;
		}
	}
}
