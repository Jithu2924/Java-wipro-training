package Basicprograms;

import java.util.Scanner;

public class StringOperations {

    public static String Operation(String data, int choice) {
        switch (choice) {
            case 1:
                // Add the string to itself
                return data + data;

            case 2:
                // Replace characters at odd positions (1-based indexing) with #
                StringBuilder replace = new StringBuilder(data);
                for (int i = 0; i < data.length(); i++) {
                    if (i % 2 != 0) {  // odd positions
                        replace.setCharAt(i, '#');
                    }
                }
                return replace.toString();

            case 3:
                // Remove duplicate characters
                StringBuilder unique = new StringBuilder();
                for (int i = 0; i < data.length(); i++) {
                    char ch = data.charAt(i);
                    if (unique.indexOf(String.valueOf(ch)) == -1) {
                        unique.append(ch);
                    }
                }
                return unique.toString();

            case 4:
                // Change characters at odd positions to uppercase
                StringBuilder result = new StringBuilder(data);
                for (int i = 0; i < data.length(); i++) {
                    if (i % 2 != 0) {  // odd index
                        result.setCharAt(i, Character.toUpperCase(data.charAt(i)));
                    }
                }
                return result.toString();

            default:
                return "Invalid choice";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String data = sc.nextLine();

        System.out.println("\nChoose an operation:");
        System.out.println("1. Add the string to itself");
        System.out.println("2. Replace odd positions with #");
        System.out.println("3. Remove duplicate characters");
        System.out.println("4. Change odd characters to upper case");
        System.out.print("Enter your choice (1-4): ");
        int choice = sc.nextInt();

        String output = Operation(data, choice);
        System.out.println("\nResult: " + output);
    }
}

