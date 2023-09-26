// Name: Justin Romanowski
// Class: CS 3305/W01
// Term: Fall 2023
// Instructor: Sharon Perry
// Assignment: 3 – Part 1 Linked List

package Assignment3;
import java.util.ArrayList;

public class Part1 {
	
	static class LinkedList<E> {
		int size = 0;	// size of linked list
		
		// Creating class for Nodes
			static class Node<E> {
				E x;
				Node<E> next;
				Node(E x){
					this.x = x;
				}
			}
		
		Node<E> root;		// to track first node
		Node<E> tail;		// to track last node
		Node<E> current;	// to iterate thru linked list
		
		LinkedList(E x){		// user has to provide us a root node to begin
			this.root = new Node<>(x);
			tail = root;
			size++;
		}
		
		// Recursive function for printing nodes
		void printNode(Node<E> node,int x, int max) {
			// check if x >= max to print
			if(x<max) {
				x++;
				System.out.print(node.x + "\t\t");
				System.out.println(node.next);
				printNode(node.next,x, max);
			}
		}
		
		void printLinkedList() {
			int x = 0;
			System.out.println("Element:\tNext:");
			printNode(root,x,size);
		}
		
		void addTail(E x) {
			size++;
			tail.next = new Node<>(x);	// create a new node at "next"
			tail = tail.next;			// new tail is now the node stored in previous tail's next
			
			//check to see if next has been established after root node
			if(root.next == null) {
				root.next = tail;
			}
		}
		
		void removeTail() {
			if(size>1) {
				size--;
				// set next and tail to null since they will go unused
				tail.next = null;
				tail.x = null;
				
				// traverse to the tail to set the new tail node
				current = root;
				for(int i = 0; i<(size-1); i++) {
					current = current.next;
				}
				tail = current;
			}
		}

		void printRange(int x, int y) {
			System.out.println("Range of Nodes:");

			
			// x and y need to be moved to scale w/ initial index = 0 instead of 1
			x--;
			y--;
			
			// make sure x and y <= size of linked list
			if(x>size) {
				x = size;
			}
			if(y>size) {
				y = size;
			}
			
			//traverse linked list to x, then print w/ max limiting\
			current = root;
			for(int i = 0; i<x; i++) {
				current = current.next;
			}
			printNode(current,x,y);
		}
		
		// helper function for removeRepetitions
		Node<E> removeIndex(Node<E> prev, int listPos) {
			prev.next = prev.next.next; // skip over the 'current' node
			
			if(prev.next==null) {	// adjust tail if tail is removed
				tail = prev;
			}
			return prev;
		}
		
		void removeRepetitions() {
			System.out.println("Repetitions Removed:");
			
			// need dynamic array/vector
			ArrayList<E> elements = new ArrayList<>();
			// use a nested for loop to iterate through the linked list & check in elements
			current = root;
			Node<E> prev = root;	// keep prev so we can fix previous node's next
			int listPos = 0;
			for(int i = 0; i<(size); i++) {	
				boolean repetitionFlag = false;
				listPos++;

				for(int j = 0; j<elements.size();j++) {
					// if repetition then remove element, else add its value to array list
					if(current.x == elements.get(j)) {
						repetitionFlag = true;
						current = removeIndex(prev,listPos);
						size--;
					} 
				}
				// if no repeat found then add it to array list
				if(repetitionFlag==false) {
					elements.add(current.x);
				}
				prev = current;
				current = current.next;
			}
		}
		
	}
			
	public static void main(String[] args) {
		int[] numbers = {1, 1, 2, 3, 3, 4, 4, 5, 6, 7};
		int root = numbers[0];
		LinkedList<Integer> linked_list = new LinkedList<>(root);
		
		for(int i = 1; i<numbers.length; i++) {		// add numbers to linked list
			linked_list.addTail(numbers[i]);		// verify linked list is correct
		}
		linked_list.printLinkedList();
		
		System.out.println("-----------------------------------------------------------");
		
		linked_list.printRange(2, 5);
		
		System.out.println("-----------------------------------------------------------");
		
		linked_list.removeRepetitions();
		linked_list.printLinkedList();

	}

}
