public class Q_1_3_27 {
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

    private int max(LinkedList.Node node) {
        LinkedList.Node currentNode = node;

        int max = currentNode.value;

        while(currentNode.next != null) {
            max = currentNode.value > max ? currentNode.value : max;
            currentNode = currentNode.next;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
