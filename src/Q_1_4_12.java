import java.util.ArrayList;
import java.util.Scanner;

public class Q_1_4_12 {
    private static void printCommonNumber(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        boolean readAllValues = false;

        int currentIndex = 0;
        int currentMax = array1.get(currentIndex);

        StringBuilder output = new StringBuilder("[");

        while(!readAllValues) {
            int currentElementOfArray1 = array1.get(currentIndex);
            int currentElementOfArray2 = array2.get(currentIndex);

            if (currentElementOfArray1 == currentElementOfArray2) {
                output.append(array1.get(currentIndex)).append(",");
            } else if (currentMax == currentElementOfArray1) {
                output.append(currentElementOfArray1).append(",");
            } else if (currentMax == currentElementOfArray2) {
                output.append(currentElementOfArray2).append(",");
            } else {
                currentMax = currentElementOfArray1 > currentElementOfArray2 ? currentElementOfArray1 :currentElementOfArray2;
            }

            if (currentIndex == array1.size() - 1) {
                readAllValues = true;
            }

            currentIndex++;
        }

        output.deleteCharAt(output.lastIndexOf(","));
        output.append("]");

        System.out.print(output);
    }

    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();

        System.out.println("Enter input for array 1");

        Scanner sc = new Scanner(System.in);

        String input1 = sc.nextLine();

        String[] elements = input1.split(", ");

        for (String element:
                elements) {
            array1.add(Integer.parseInt(element));
        }

        System.out.println("Enter input for array 2");

        String input2 = sc.nextLine();

        elements = input2.split(", ");

        for (String element:
                elements) {
            array2.add(Integer.parseInt(element));
        }

        printCommonNumber(array1, array2);
    }
}
