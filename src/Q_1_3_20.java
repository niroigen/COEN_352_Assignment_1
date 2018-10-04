public class Q_1_3_20 {
    /*
 * 1.3.20 Write a method delete() that takes an int argument k and deletes the kth element
    in a linked list, if it exists
 */
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
