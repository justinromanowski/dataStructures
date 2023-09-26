// Name: Justin Romanowski
// Class: CS 3305/W01
// Term: Fall 2023
// Instructor: Sharon Perry
// Assignment: 2 – Part 1 Factorial
import java.util.Scanner;

public class Factorial {
	
	public static long factorial(int n) {
		// is the 'n' passed in greater than or equal to one?
		if(n==1) {
			//if yes, return 1 and end recursion
			return 1;
		} else {
			//if no, perform recursion on n-1
			return n * factorial(n-1);
		}
	}

	public static void main(String[] args) {
		//for easier running/testing
		while (true) {
			//scan user input, run factorial function, & print results
			Scanner scan = new Scanner(System.in);
			System.out.println("Which number would you like to find the factorial of? ");
			int number = scan.nextInt();
			long factorial = factorial(number);
			System.out.println("Factorial of " + number + " is " + factorial);
		}
	}
}