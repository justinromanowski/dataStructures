// Name: Justin Romanowski
// Class: CS 3305/W01
// Term: Fall 2023
// Instructor: Sharon Perry
// Assignment: 05-Part-1-Queues

package Assignment_5;

import java.util.Scanner;

public class Part1 {
	
	// class for queue item containing priority & task
	static class QueueItem{
		private
			int priority;
			String task;
		public
			QueueItem(int P, String T){
			priority = P;
			task = T;
			}
		
			// getters for priority & task
			int priority() {
				return priority;
			}
			
			String task() {
				return task;
			}
	}
	
	static class Queue{
		private
			QueueItem[] queue = new QueueItem[10];
			int count = 0;
		public
			
			void prioritySort() {
				for(int i = count; i>0; i--) {
					// if priority is more urgent than task infront, then swap the two
					if (queue[i].priority() < queue[i-1].priority()) {
						QueueItem temp = queue[i];
						queue[i] = queue[i-1];
						queue[i-1] = temp;
					} 
				}
			}
		
			void addTask(int P, String T) {
				// if priority isnt positive then dont add the task
				if(P<=0) {
					System.out.println("ERROR: Priority must be a poitive integer");
					return;
				}
				QueueItem new_task = new QueueItem(P,T);
				// 3 cases: if queue empty, if queue full, if queue not empty and not full
				if (count==0) {
					// if queue is empty
					queue[0] = new_task;
					count++;
					System.out.println("Task added!");

				} else if (count==10) {
					// if queue is full
					System.out.println("ERROR: Queue is full");
				} else {
					// not empty & not full
					queue[count] = new_task;
					// re-sort based on priority
					prioritySort();
					count++;
					System.out.println("Task added!");
				}
			}
			
			String completeTask() {
				String T;
				// pop element @ index 0 & shift every element up by 1
				if(count>0) {
					//queue is not empty
					T = queue[0].task;
					// shift all tasks up 1 position in queue
					for(int i = 0; i<count;i++) {
						queue[i] = queue[i+1];
					}
					queue[count-1] = null;
					count--;
				} else {
					// queue empty
					System.out.println("ERROR: Queue is empty");
					T = "none";
				}
				return T; // return the task
			}
			
			void printQueue() {
				// prints the queue neatly
				System.out.println("\t\tPriority\tTask");
				for (int i = 0; i<count; i++) {
					System.out.println("Element " + i + ":\t" + queue[i].priority + "\t\t" + queue[i].task);
				}
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue chores = new Queue();
		Scanner scan = new Scanner(System.in);
		int input = 0;
		int priority;
		String task;
		
		while(true) {
			System.out.println("Input the number for the function you would like to perform:");
			System.out.println("1. Add a chore\n2. Completed a chore\n3. View Chore List");
			input = scan.nextInt();
			
			switch(input) {
			case 1:
				System.out.println("Enter the priority then the task (Ex: '1 Mop the floor'):");
				priority = scan.nextInt();
				task = scan.nextLine();
								
				chores.addTask(priority, task);
				
				break;
				
			case 2:
				task = chores.completeTask();
				System.out.println("Task completed: " + task);
				
				break;
			
			case 3:
				chores.printQueue();
			}
		}
		
	}

}
