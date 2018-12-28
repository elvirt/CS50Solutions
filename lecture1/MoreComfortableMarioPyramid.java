package com.cs50.lecture1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MoreComfortableMarioPyramid {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int height = 0;
		int rows = 0;
		int spaces = 0;
		int hashes = 0;
		
		do {
			try {
			System.out.println("Enter a number: ");
			height = input.nextInt();
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Wrong data type!!!");
			}
		} while ((height < 0) || (height > 23));
		
		
		for (rows = 0; rows < height; rows++) {
			
			//print spaces for left pyramid
			for (spaces = (height - rows); spaces > 0; spaces--) {
				System.out.print(" ");
			}
			//print hashes for left pyramid
			for (hashes = 0; hashes < (rows + 1); hashes++) {
				System.out.print("#");
			}
			//print gap
			System.out.print("  ");
			
			//print hashes for right pyramid
			for (hashes = 0; hashes < (rows + 1); hashes++) {
				System.out.print("#");
			}
			//print new line
			System.out.println();
		}
	}

}
