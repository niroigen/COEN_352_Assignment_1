public class Queue {
	// A queue will be FIFO based
	// 1,2,3,4
	// Popping them will be 1,2,3,4
	
	public class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
		}
	}
	
	private Node head;
	private Node tail;
	
	private Queue() {
		this.head = null;
		this.tail = null;
	}

	public void pop() {
		if (this.tail != null) {
			this.head = this.head.next;
		}
	}

	private void push(int value) {
		Node oldNode = this.tail;
		this.tail = new Node(value);
		
		if (this.head == null) {
			this.head = this.tail;
		} else {
			oldNode.next = this.tail;
		}
		
	}
	
	private void print() {
		Node currentNode = this.head;
		
		while(currentNode != null) {
			System.out.print(currentNode.value + "\t");
			currentNode = currentNode.next;
		}
		
		System.out.println();
	}
	
	private int size() {
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
				previousNode.next = currentNode.next;
			}
			
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
	}
	
	private void delete(int k) {
		if (k == 0) {
			this.head = this.head.next;
			return;
		}

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

	private static int Josephus(int N, int M) {
		Queue josephus = new Queue();

		for (int i = 0; i < N; i++)
			josephus.push(i);

		int indexToDelete = M - 1;
		while(josephus.size() != 1) {
			josephus.delete(indexToDelete);
			if (indexToDelete > josephus.size()) {
				indexToDelete--;
			}

			indexToDelete = (indexToDelete + M - 1) % josephus.size();
		}

		return josephus.head.value;
	}
	
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
		
		System.out.println(Josephus(5,2));
	}
}
