import java.util.ArrayList;
import java.util.Arrays;

public class PrintSorted {
    private static void printSortedNumbers(ArrayList<Integer> array1, ArrayList<Integer> array2) {

        boolean isArray1Empty = false;
        while(!array1.isEmpty() && !array2.isEmpty()) {
            if (array1.get(0) < array2.get(0)) {
                System.out.print(array1.get(0) + "\t");
                array1.remove(0);
            } else {
                System.out.print(array2.get(0) + "\t");
                array2.remove(0);
            }

            isArray1Empty = array1.isEmpty();
        }

        ArrayList<Integer> nonEmptyArrayList = isArray1Empty ? array2 : array1;

        if (isArray1Empty) {
            for (Integer number :
                    nonEmptyArrayList) {
                System.out.print(number + "\t");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1,2,5,7,9,10,37));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(3,11,46,49,56,100,155));

        printSortedNumbers(array1, array2);
    }
}
