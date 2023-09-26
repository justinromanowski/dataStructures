// Name: Justin Romanowski
// Class: CS 3305/W01
// Term: Fall 2023
// Instructor: Sharon Perry
// Assignment: 2 – Part 2 Recursion
import java.util.Scanner;

public class Recursion {
	public static void spacer(int x) {
		//control number of spaces using for loop
		for (int i = 0; i<x; i++) {
			System.out.print(" ");
		}		
	}

	public static void recurser(int max,int currCall) {
		//
		currCall++;

		//check if call number = max # of calls
		if(max>=currCall) {
			spacer(currCall);
			System.out.println("This was written by call " + currCall);
			recurser(max,currCall);
			spacer(currCall);
			System.out.println("This was ALSO written by call " + currCall);
		}
	}
	
	public static void main(String[] args) {
		//for easier running/testing
		while (true) {
			//scan user input
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter an integer for the number of repetitions: ");
			int number = scan.nextInt();
			recurser(number,0);
		}
	}
}
