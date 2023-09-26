// Name: Justin Romanowski
// Class: CS 3305/W01
// Term: Fall 2023
// Instructor: Sharon Perry
// Assignment: 05-Part-2-Shoppers

package Assignment_5;

import java.util.Random;

public class Part2 {
	
	// wait function to let time pass
	static void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	static class CheckoutLine {
		 private
		 	// list of names for customer
		 	String customer_names[] = new String[] {"Bob","John","Bill","Jose","Flo","Ramone","Luigi","Mario","Marcus","Denise",
		 			"Carol","Shelly","Amanda","Frank","Jessica","Taylor","Julia","Jane","Ahmed","Maria","Andrew","Adam","Claire",
		 			"Emma","Noah","Isaiah","Ezekiel","Joan","Sophia","Ashley","David","Deion","Jamal","Linda","Susan","Donald",
		 			"Thomas","Sarah","Elijah","Charles","Emily","Paul","Avery","Kevin","Lauren","Olivia","Justin","Isabel","Bob",
		 			"Jim","Juan","Anna","Liam","Edgar","Pedro","Daniela","Gabe","Paula","Jalen","Serena","Amar","Reese","Leo","Chris",
		 			"Denise","Mia","Jorge","Luis","Carlos","Aaditya","Sachin","Nushi","Ali","Li","Francis","Enrique","Omar","Camila",
		 			"Zoe","Susan","Ava","Evelyn","Valeria","Leah","Mariam","Hannah","Riley","James","Alice","Eve","Lily"};
			// rows = lines; columns = customer positions in line 
			String checkout_line[][] = new String[5][10];
			int counts[] = new int[]{0,0,0,0,0}; // counts size of line (correlates to index)
			Random rand = new Random();
		public
			CheckoutLine() {
				// add initial 5 customers
				this.addCustomer();
				this.addCustomer();
				this.addCustomer();
				this.addCustomer();
				this.addCustomer();
			}
		
			int shortestLine() {
				// min = line w/ shortest length
				int min_loc = 0;
				int min_val = 1000000;
				for(int i = 0; i<5; i++) {
					if(min_val>counts[i]) {
						min_loc = i;
						min_val = counts[i];
					}
				}
				// if all lines are full then return -1 and refuse to add more customers
				if(min_val>=10) {
					return -1;
				}
				return min_loc;
			}
			
			void addCustomer() {
				// things we need to do:
				// - find shortest line
				// - get customer's name from list
				// - add customer's name to the back of shortest line
				// - note: next available index held in counts array
				int line = shortestLine();
				// if all lines are full then refuse to add more customers
				if(line==-1) {
					return;
				}
				
				// get customer name
				int name_number = rand.nextInt(customer_names.length);
				String cust_name = customer_names[name_number];
				
				System.out.println(cust_name + " has entered Line " + line);
				
				// add customer to line
				checkout_line[line][counts[line]] = cust_name;
				counts[line]++;
			}
			
			void checkout() {
				// iterate through lines
				for(int i = 0; i<5; i++) {
					int checkout = rand.nextInt(3); // 33% chance of customer checkout
					
					if(checkout==0 && counts[i]>0) {
						System.out.println(checkout_line[i][0] + " has checked out from Line " + i);
						
						int j = 0;	// iterator over array
						String null_check = "eee";	// holds i+1 (if string is null no need to continue replacing names)
						
						while(null_check!=null && j<9) {
							// if next is not null AND not at last element
							checkout_line[i][j] = checkout_line[i][j+1]; // move up previous customer by 1 index
							null_check = checkout_line[i][j+1];
							j++;
						}
						checkout_line[i][9] = null;
						counts[i]--;
					}
				}
			}
			
			void printLines(int runtime) {
				System.out.println("\nLine Status @ time = " + runtime + "\nLINE 0\t\tLINE 1\t\tLINE 2\t\tLINE 3\t\tLINE 4");
				for(int i = 0; i<10; i++) {
					System.out.println(checkout_line[0][i]+"\t\t"+checkout_line[1][i]+"\t\t"+checkout_line[2][i]+"\t\t"+checkout_line[3][i]+"\t\t"+checkout_line[4][i]);
				}
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*	EDITING PARAMETERS:
		 *	If you wish to edit parameters, go to the following:
		 *	Duration of program: while loop argument @ line 134
		 *	Frequency of customers added per second: rand.nextInt function @ line 144
		 *	Frequency of  a customer checking out: rand.nextInt function @ line 89
		 */
		
		
		// create vars
		CheckoutLine store = new CheckoutLine();
		Random rand = new Random();
		int runtime = 0;
		
		//start simulation
		System.out.println("Starting simulation");
		while(runtime<=30) {
			System.out.println("------------------------------------------------------------");
			System.out.println("Time = " + runtime + " seconds");
			
			// handle checkouts
			System.out.println("\nCustomers who have checked out:");
			store.checkout();
			
			// add between 0 and 4 customers to the lines each second
			System.out.println("\nAdditions to the lines:");
			int new_customers = rand.nextInt(4);
			for(int i = 0; i<new_customers; i++) {
				store.addCustomer();
			}
			
			System.out.println("\nCustomers who have checked out:");
			
			// print line status
			store.printLines(runtime);
			
			// wait 1s before simulating next part
			wait(1000);
			runtime++;
		}
		System.out.println("------------------------------------------------------------");
		System.out.println("Simulation complete");
		
	}

}
