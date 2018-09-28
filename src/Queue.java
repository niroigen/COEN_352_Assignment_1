public class Queue {
	// A queue will be FIFO based
	// 1,2,3,4
	// Popping them will be 1,2,3,4
	
	public class Node {
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public Node head;
	public Node tail;
	
	public Queue() {
		this.head = null;
		this.tail = null;
	}
		
	public void pop() {
		if (this.tail != null) {
			this.head = this.head.next;
		}
	}
	
	public void push(int value) {
		Node oldNode = this.tail;
		this.tail = new Node(value);
		
		if (this.head == null) {
			this.head = this.tail;
		} else {
			oldNode.next = this.tail;
		}
		
	}
	
	public void print() {
		Node currentNode = this.head;
		
		while(currentNode != null) {
			System.out.print(currentNode.value + "\t");
			currentNode = currentNode.next;
		}
		
		System.out.println();
	}
	
	public int size() {
		int size = 0;
		Node currentNode = this.head;
		
		while(currentNode != null) {
			size++;
			currentNode = currentNode.next;
		}
		
		return size;
	}
	
	public void removeNumber(int value) {
		Node currentNode = this.head;
		Node previousNode = this.head;
		
		while(currentNode != null) {
			if (this.head.value == value) {
				this.head = this.head.next;
			}
			
			if (currentNode.value == value) {
				previousNode.next = currentNode.next != null ? currentNode.next : null;
			}
			
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
	}
	
	public void delete(int k) {
		Node currentNode = this.head;
		int counter = 0;
		int stopNumber = k - 1;
		
		while(currentNode != null) {
			if (counter == stopNumber) {
				currentNode.next = currentNode.next.next;
				break;
			}
			
			counter++;
			currentNode = currentNode.next;
		}
		
		System.out.println();
	}
	
//	public static int Josephus(int N, int M) {
//		
//	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();

		queue.push(2);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.push(10);

		queue.print();

		queue.delete(4);
		
		queue.print();
		
//		System.out.println(Josephus(8,2));
	}
}
