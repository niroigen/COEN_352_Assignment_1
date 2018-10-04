public class Q_1_3_20 {

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

    public void delete(LinkedList list, int k) {
        LinkedList.Node currentNode = list.head;
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

    public static void main(String[] args) {

    }
}
