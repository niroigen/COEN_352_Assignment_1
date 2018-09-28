public class LinkedList {
	
	public class Node {
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	Node head;
	
	public LinkedList() {
		head = null;
	}
	
	public void push(int value) {
		if (this.head == null) {
			head = new Node(value);
		} else {
			Node newNode = new Node(value);
			newNode.next = this.head;
			this.head = newNode;
		}
	}
	
	public void pop() {
		if (this.head != null) {
			this.head = this.head.next;
		}
	}
	
	/*
	 * 1.3.20 Write a method delete() that takes an int argument k and deletes the kth element
		in a linked list, if it exists
	 */
	public void delete(int k) {
		Node currentNode = this.head;
		int counter = 0;
		
		while (currentNode.next != null) {
			if (counter + 1 == k) {
				currentNode.next = currentNode.next.next;
				break;
			}
			
			counter++;
			currentNode = currentNode.next;
		}
	}
	
	public void prettyprint() {
		Node currentNode = this.head;
		
		while(currentNode != null) {
			System.out.print(currentNode.value + "\t");
			currentNode = currentNode.next;
		}
		
		System.out.println("\n");
	}
	
	/*
	1.3.27 Write a method max() that takes a reference to the first node in a linked list as
	argument and returns the value of the maximum key in the list. Assume that all keys are
	positive integers, and return 0 if the list is empty*/
	public static int max(Node node) {
		if (node == null) {
			return 0;
		} else {
			int currentMax = node.value;
			
			while(node != null) {
				currentMax = currentMax < node.value ? node.value : currentMax;
				node = node.next;
			}
			
			return currentMax;
		}
	}
	
	/*1.3.28 Develop a recursive solution to the previous question.*/
	// Example 1,2,3,4
	// Recursion is when you would call the same method
	// So definitely the parameter would be node.next
	// 
	public static int recursiveMax(Node node, int currentMax) {
		if (node == null) {
			return currentMax;
		} else {
			currentMax = node.value > currentMax ? node.value : currentMax;
			return recursiveMax(node.next, currentMax);
		}
	}
	
	/*
	1.3.37 Josephus problem. In the Josephus problem from antiquity, N people are in dire
	straits and agree to the following strategy to reduce the population. They arrange themselves
	in a circle (at positions numbered from 0 to N–1) and proceed around the circle,
	eliminating every Mth person until only one person is left. Legend has it that Josephus
	figured out where to sit to avoid being eliminated. Write a Queue client Josephus that
	takes N and M from the command line and prints out the order in which people are
	eliminated (and thus would show Josephus where to sit in the circle).
	% java Josephus 7 2
	1 3 5 0 4 2 6
	 */	
	
	public static void main(String[] args) {		
		LinkedList mylist= new LinkedList();
		mylist.push(3);
		mylist.push(7); 	
		mylist.push(100); 
		mylist.push(0); 
		mylist.push(5000);
		mylist.push(25);
		mylist.prettyprint();
		mylist.delete(1);
		mylist.prettyprint();
		
		System.out.println(recursiveMax(mylist.head, 0));
	}
}
