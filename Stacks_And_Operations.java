// Name:		Justin Romanowski
// Class:	      CS 3305/W01
// Term:		  Fall 2023
// Instructor:  Sharon Perry
// Assignment:  4-Part-1-Stacks


package Assignment_4;

import java.util.Scanner;

public class Part1 {
	
	static class Stack {
		private
			// array acting as stack
			int arr[] = new int[25];
		
			int size_a = 0;			// a starts @ head of stack
			int size_b = 24;			// b starts @ tail of stack
			
			int top_a = -1;
			int top_b = -1;
			
		public
			void push_a(int x) {
			// since indexing begins @ 0, size = "register" above top of stack
			if(size_a<size_b) {
				arr[size_a] = x;
				top_a = x;
				size_a++;
				System.out.println(x + " pushed onto Stack A");
			} else {
				System.out.println("Stack is full");
				} 
			}
			
			void push_b(int y) {
				// since indexing begins @ 24, size = "register" above top of stack
				if(size_a<size_b) {
					arr[size_b] = y;
					top_b = y;
					size_b--;
					System.out.println(y + " pushed onto Stack B");
				} else {
					System.out.println("Stack is full");
				} 
			}
			
			int pop_a() {
				// size - 1 = top of stack, so decrease size by 1 & get value
				if(size_a>1) {
					size_a--;
					System.out.println(top_a + " popped off Stack A");
					top_a = arr[size_a-1];
					return arr[size_a];
				} else if (size_a == 1) {
					size_a--;
					System.out.println(top_a + " popped off Stack A");
					top_a = -1; // no more variables left on stack
					// dont decrement past 0
					return arr[size_a];
				} else {
					System.out.println("Stack A is empty");
					return -1;
				}
				
			}
			
			int pop_b() {
				// size + 1 = top of stack, so increase size by 1 & get value
				if(size_b<23) {
					size_b++;
					System.out.println(top_b + " popped off Stack B");
					top_b = arr[size_b+1];
					return arr[size_b];
				} else if (size_b == 23) {
					// dont increment past 24
					size_b++;
					System.out.println(top_b + " popped off Stack B");
					top_b = -1; // no more variables left on stack
					return arr[size_b];
				} else {
					System.out.println("Stack B is empty");
					return -1;
				}
			}
			
			int get_top_a() {
				// return top_a
				return top_a;
			}
			
			int get_top_b() {
				// return top_b
				return top_b;
			}
			
			boolean is_empty_a() {
				// first index of a == 0, so if size==0 then A is empty
				if(size_a==0) {
					return true;
				} else {
					return false;
				}
			}
			
			boolean is_empty_b() {
				// first index of b == 24, so if size==24 then B is empty
				if(size_b==24) {
					return true;
				} else {
					return false;
				}
			}
			
			boolean is_full() {
				// stack is full if a==b
				if(size_a==size_b) {
					return true;
				} else {
					return false;
				}
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		
		// test data 
		int arr_a[] = {123,564,723,255,847,514,632,826,925,015,416};
		int arr_b[] = {155,613,826,351,643,754,975,245,133,021,313};
		
		for(int i = 0; i<arr_a.length;i++) {
			stack.push_a(arr_a[i]);
		}
		
		for(int i = 0; i<arr_b.length;i++) {
			stack.push_b(arr_b[i]);
		}
		
		// setup user interface
		Scanner scan = new Scanner(System.in);
		int input = 0; // used for UI
		int x;	   // used to push
		
		while(input!=9) {
			System.out.println("\nWhat operation would you like to do with the stacks?\n0: Push onto Stack A\n1: Push onto Stack B\n2: Pop off Stack A\n3: Pop off Stack B");
			System.out.println("4: Get top value off Stack A\n5: Get top value off Stack B\n6: Check if Stack A is empty\n7: Check if Stack B is empty\n8: Check if stacks are full\n9: Quit");
			input = scan.nextInt();
			switch(input) {
			case 0:
				System.out.print("Input a number: ");
				x = scan.nextInt();
				stack.push_a(x);
				break;
			case 1:
				System.out.print("Input a number: ");
				x = scan.nextInt();
				stack.push_b(x);
				break;
			case 2:
				stack.pop_a();
				break;
			case 3:
				stack.pop_b();
				break;
			case 4:
				System.out.println(stack.get_top_a());
				break;
			case 5:
				System.out.println(stack.get_top_b());
				break;
			case 6:
				System.out.println(stack.is_empty_a());
				break;
			case 7:
				System.out.println(stack.is_empty_b());
				break;
			case 8:
				System.out.println(stack.is_full());
				break;
			case 9:
				System.out.println("Shutting down...");
				break;
			default:
				System.out.println("Invalid input received.");
			}
		}
	}

}
