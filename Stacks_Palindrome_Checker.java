// Name:		Justin Romanowski
// Class:	  CS 3305/W01
// Term:		  Fall 2023
// Instructor:  Sharon Perry
// Assignment:  4-Part-2-Palindromes


package Assignment_4;

import java.util.Stack;
import java.util.Scanner;

public class Part2 {
	
	static boolean palindromeChecker(Stack<Character> sA, Stack<Character> sB) {
		System.out.println(sA + " " + sB);
		if(sA.equals(sB)) {
			return true;
		} else {
			return false;
		}
	}
	
	static Stack<Character> popAndPush(Stack<Character> sA){
		Stack<Character> sB = new Stack<>();
		
		// pop sA & push onto sB if sA is empty
		while(!sA.isEmpty()) {
			sB.push(sA.pop());
		}
		
		return sB;
	}
	
	// take a string and push it onto a stack of chars
	static Stack<Character> stringToStack(String s) {
		Stack<Character> stack = new Stack<>();
		
		//iterate over string & push each char onto stack
		for(int i = 0; i<s.length(); i++) {
			stack.push(s.charAt(i));
		}
		return stack;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		Stack<Character> stack3 = new Stack<>();
		
		String input;
		
		while(true) {
			System.out.println("Enter a string to check for palindrome:");
			input = scan.nextLine();
			
			// create stack1 and stack2
			stack1 = stringToStack(input);
			stack2 = stringToStack(input);
			//System.out.println(stack1);
			
			// create empty stack3, pop stack1 & push onto stack3
			// with how I set up my functions stack2 is redundant, however I included & used it to be consistent w/ prompt
			stack3 = popAndPush(stack1);
			
			boolean palindrome = palindromeChecker(stack2, stack3);
			System.out.println(palindrome);
		}
	}

}
