package com.cs50.lecture1;

import java.util.*;
/**
 * 
 * @author Liubomyr Virt
 * 
 * The program toDo list:
 *  1. prompt a user for an amount of change
 *  2. always use the largest coin possible
 *  3. keep track of coins used
 *     3a) how many coins to be returned
 *     3b) amount to be returned
 *  4. print the final number of coins
 *
 */
public class Greedy {

	public static Scanner input = new Scanner(System.in);
	public static final float QUATER = 0.25f;
	public static final float DIME = 0.1f;
	public static final float NICKEL = 0.05f;
	public static final float PENNY = 0.01f;
	
	
	public static void main(String[] args) {
		
		int usedCoins = 0;  // number of coins used for exchange
		float centsToBeChanged = 0; //number of coins a user wants to change
		
		
		
		do {
			try {
				System.out.println("How much do you want to change?");
				centsToBeChanged = input.nextFloat();
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Wrong data type!!!");
				break;
			}
		} while (centsToBeChanged < 0);
		
		System.out.println("Amount to be changed is " + centsToBeChanged + "$");
		
		while (centsToBeChanged >= QUATER) {
			usedCoins++;
			centsToBeChanged -= QUATER;
		}
		while (centsToBeChanged >= DIME) {
			usedCoins++;
			centsToBeChanged -= DIME;
		}
		while (centsToBeChanged >= NICKEL) {
			usedCoins++;
			centsToBeChanged -= NICKEL;
		}
		
		while (centsToBeChanged >= PENNY) {
			usedCoins++;
			centsToBeChanged -= PENNY;
		}
		
		System.out.println("The number of coins used: " + usedCoins);
		
	}

}
