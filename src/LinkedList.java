public class LinkedList {
	
	public class Node {
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	Node head;
	
	public LinkedList() {
		head = null;
	}
}
