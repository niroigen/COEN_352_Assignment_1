import java.util.Scanner;

public class Q_1_3_20 {

    public static class LinkedList {

        class Node {
            int value;
            Node next;

            public Node(int value) {
                this.value = value;
                this.next = null;
            }
        }

        Node head;

        LinkedList() {
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

        void delete(int k) {
            LinkedList.Node currentNode = this.head;
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

        void prettyprint() {
            Node currentNode = this.head;

            while(currentNode != null) {
                System.out.print(currentNode.value + "\t");
                currentNode = currentNode.next;
            }

            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("Enter input");

        Scanner sc = new Scanner(System.in);

        String input1 = sc.nextLine();

        System.out.println("Enter the index you would like to delete from");

        int input2 = sc.nextInt();

        String[] elements = input1.split(", ");

        for (String element:
             elements) {
            list.push(Integer.parseInt(element));
        }

        list.delete(input2);

        list.prettyprint();
    }
}
