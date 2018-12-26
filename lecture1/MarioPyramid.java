package com.cs50.lecture1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * in this program we are building up a pyramid of hashes(#)
 * Example(height 4):
 *    ##
 *   ###
 *  ####
 * #####
 * the pyramid is not going to be more than 23 rows and not less than 0
 * 
 * @author Liubomyr Virt
 * 
 *
 */

public class MarioPyramid {
	

	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		
		int height = 0;
		int numberOfHashes = 0;
		int numberOfSpaces = 0;
		int numberOfRows = 0;
		
		
		do {
			try {
			System.out.println("Enter a number from 0 to 23: ");
			
			height = input.nextInt();
			} catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Wrong data type, try again");
			}
		} while ((height < 0) || (height > 23));
		
		
		//loop that makes our pyramid
		
		//this part of loop says how many rows(steps) is going to be there
		//I'm starting with 1 because it is easier to count
		for (numberOfRows = 1; numberOfRows <= height; numberOfRows++) {
			
			//this part of loop says how many spaces there's going be in each row
			for(numberOfSpaces = (height - numberOfRows); numberOfSpaces > 0; numberOfSpaces--) {
				System.out.printf(" ");
			}
			
			//this part of loop says how many hashes each row will contain
			for (numberOfHashes = 1; numberOfHashes <= (numberOfRows + 1); numberOfHashes++) {
				System.out.printf("#");
			}
			
			//finally, we need to start each row with a new line, simple println will help
			System.out.println();
		}
	}

}
