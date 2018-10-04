import java.util.Scanner;

public class Q_1_3_27 {
    public static class LinkedList {
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

        void push(int value) {
            if (this.head == null) {
                head = new Node(value);
            } else {
                Node newNode = new Node(value);
                newNode.next = this.head;
                this.head = newNode;
            }
        }

        int max(LinkedList.Node node) {
            LinkedList.Node currentNode = node;

            int max = currentNode.value;

            while(currentNode.next != null) {
                max = currentNode.value > max ? currentNode.value : max;
                currentNode = currentNode.next;
            }

            return max;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("Enter input");

        Scanner sc = new Scanner(System.in);

        String input1 = sc.nextLine();

        String[] elements = input1.split(", ");

        for (String element:
                elements) {
            list.push(Integer.parseInt(element));
        }

        System.out.println("Max value is " + list.max(list.head));
    }
}
