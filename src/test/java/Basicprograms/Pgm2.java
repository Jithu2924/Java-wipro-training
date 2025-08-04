package Basicprograms;

import java.util.Scanner;

public class Pgm2 {
//Write a program to accept a number from user as a command line argument and 
//check  whether the given number is positive or negative number.
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number:");
		int num=sc.nextInt();
		if(num>0) {
			System.out.println("The number is positive");
		}else{
			System.out.println("The number is negative");
		}
	}
}
