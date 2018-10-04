public class Q_1_3_37 {
    public static class Queue {
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

        Queue() {
            this.head = null;
            this.tail = null;
        }

        Node getHead() {
            return head;
        }

        void push(int value) {
            Node oldNode = this.tail;
            this.tail = new Node(value);

            if (this.head == null) {
                this.head = this.tail;
            } else {
                oldNode.next = this.tail;
            }

        }

        int size() {
            int size = 0;
            Node currentNode = this.head;

            while(currentNode != null) {
                size++;
                currentNode = currentNode.next;
            }

            return size;
        }

        void delete(int k) {
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

        return josephus.getHead().value;
    }

    public static void main(String[] args) {
        System.out.println(Josephus(7,2));
    }
}
