import java.util.ArrayList;
import java.util.Arrays;

public class BitonicSearch {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0,1,4,6,7,5,3,2));
        System.out.println(search(numbers,6));
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
