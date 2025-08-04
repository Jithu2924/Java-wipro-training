package Basicprograms;

import java.util.Scanner;

public class Lab9 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String word=sc.next();
		word.toUpperCase();
		for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) > word.charAt(i + 1)) {
            	System.out.println("Not positive");
            	break;
            }
        }
		System.out.println("Positive");
	}

}
