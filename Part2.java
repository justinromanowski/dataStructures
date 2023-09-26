// Name: Justin Romanowski
// Class: CS 3305/W01
// Term: Fall 2023
// Instructor: Sharon Perry
// Assignment: 3 – Part 2 Capitals Game

package Assignment3;
import java.util.Random;
import java.util.Scanner;


public class Part2 {
	
	static void randomResponse() {
		Random random = new Random();
		int rand = random.nextInt(7);
		switch (rand) {
		case 0:
			System.out.println("You're pretty smart!");
			break;
		case 1:
			System.out.println("You're doing good!");
			break;
		case 2:
			System.out.println("Geography genius over here!");
			break;
		case 3:
			System.out.println("Nice one!");
			break;
		case 4:
			System.out.println("Keep it up!");
			break;
		case 5:
			System.out.println("Awesome!");
			break;
		case 6:
			System.out.println("Good work!");
			break;
		}
	}
	
	static int questionPrompt(Scanner sc, String[][] capitals,int correctAns) {
		// get random number 0-49
		Random random = new Random();
		int rand = random.nextInt(50);
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("What is the capital of " + capitals[rand][0] + "? \t\t\t\tSCORE: " + correctAns);
		String input = sc.nextLine();
		input = input.toLowerCase();
		
		// check input if correct
		if (input.equals(capitals[rand][1].toLowerCase())) {
			correctAns++;
			System.out.print("You got it correct! ");
			randomResponse();
		} else {System.out.println("Incorrect! The capital of " + capitals[rand][0] + " is " + capitals[rand][1] + ".");}
		
		return correctAns;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] capitals = {       {"Alabama", "Montgomery"},
								      {"Alaska", "Juneau"},
								      {"Arizona", "Phoenix"},
								      {"Arkansas", "Little Rock"},
								      {"California", "Sacramento"},
								      {"Colorado", "Denver"},
								      {"Connecticut", "Hartford"},
								      {"Delaware", "Dover"},
								      {"Florida", "Tallahassee"},
								      {"Georgia", "Atlanta"},
								      {"Hawaii", "Honolulu"},
								      {"Idaho", "Boise"},
								      {"Illinois", "Springfield"},
								      {"Maryland", "Annapolis"},
								      {"Minnesota", "Saint Paul"},
								      {"Iowa", "Des Moines"},
								      {"Maine", "Augusta"},
								      {"Kentucky", "Frankfort"},
								      {"Indiana", "Indianapolis"},
								      {"Kansas", "Topeka"},
								      {"Louisiana", "Baton Rouge"},
								      {"Oregon", "Salem"},
								      {"Oklahoma", "Oklahoma City"},
								      {"Ohio", "Columbus"},
								      {"North Carolina", "Raleigh"},
								      {"North Dakota", "Bismark"},
								      {"New York", "Albany"},
								      {"New Mexico", "Santa Fe"},
								      {"New Jersey", "Trenton"},
								      {"New Hampshire", "Concord"},
								      {"Nevada", "Carson City"},
								      {"Nebraska", "Lincoln"},
								      {"Montana", "Helena"},
								      {"Missouri", "Jefferson City"},
								      {"Mississippi", "Jackson"},
								      {"Massachusettes", "Boston"},
								      {"Michigan", "Lansing"},
								      {"Pennslyvania", "Harrisburg"},
								      {"Rhode Island", "Providence"},
								      {"South Carolina", "Columbia"},
								      {"South Dakota", "Pierre"},
								      {"Tennessee", "Nashville"},
								      {"Texas", "Austin"},
								      {"Utah", "Salt Lake City"},
								      {"Vermont", "Montpelier"},
								      {"Virginia", "Richmond"},
								      {"Washington", "Olympia"},
								      {"West Virginia", "Charleston"},
								      {"Wisconsin", "Madison"},
								      {"Wyoming", "Cheyenne"}};
		Scanner scan = new Scanner(System.in);
		int correctAns = 0;			// # of correct answers
		
		// start game
		System.out.println("Welcome to the Capital Guessing Game by Justin!\n\tGuess as many capitals as you can.");
		System.out.println("\t-Make sure you do not enter any additional spaces or charachters.");
		while(true) {
			correctAns = questionPrompt(scan,capitals,correctAns);
		}
		
		
	}

}
