import java.util.ArrayList;
import java.util.Scanner;

public class Q_1_4_20 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter input for array");

        Scanner sc = new Scanner(System.in);

        String input1 = sc.nextLine();

        System.out.println("Enter input for number to search");

        int number = sc.nextInt();

        String[] elements = input1.split(", ");

        for (String element:
                elements) {
            numbers.add(Integer.parseInt(element));
        }

        System.out.println("Element at index " + search(numbers,number));
    }

    private static int search(ArrayList<Integer> arrayList, int number) {
        int leftEndIndex, leftSideIndex;
        leftEndIndex = leftSideIndex = arrayList.size() / 2;
        int rightStartIndex, rightSideIndex;
        rightStartIndex = rightSideIndex = arrayList.size() / 2;
        int rightEndIndex = arrayList.size() - 1;

        while(true) {
            boolean leftMoveLeft = number <= arrayList.get(leftSideIndex);
            boolean rightMoveRight = number <= arrayList.get(rightSideIndex);

            leftEndIndex = leftMoveLeft ? leftSideIndex : leftEndIndex;
            rightEndIndex = rightMoveRight ? arrayList.size() - 1 : rightEndIndex;

            leftSideIndex = leftMoveLeft ? leftSideIndex / 2 : (leftSideIndex + leftEndIndex) / 2;
            rightSideIndex = rightMoveRight ? (rightSideIndex + rightEndIndex) / 2 : (rightStartIndex + rightSideIndex) / 2;

            if (arrayList.get(leftSideIndex) == number) {
                return leftSideIndex;
            } else if (arrayList.get(rightSideIndex) == number) {
                return rightSideIndex;
            }
        }
    }
}
