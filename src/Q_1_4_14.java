import java.util.ArrayList;
import java.util.Scanner;

public class Q_1_4_14 {
    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();

        System.out.println("Enter input for array");

        Scanner sc = new Scanner(System.in);

        String input1 = sc.nextLine();

        System.out.println("Enter input for sum");

        int sum = sc.nextInt();

        String[] elements = input1.split(", ");

        for (String element:
                elements) {
            values.add(Integer.parseInt(element));
        }

        fourSumProblem(values,sum);
    }

    private static void fourSumProblem(ArrayList<Integer> arrayList, int sum) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = i + 1; j < arrayList.size() - 1; j++) {
                for(int k = j + 1; k < arrayList.size() - 1; k++) {
                    for (int l = k + 1; l < arrayList.size(); l++) {
                        if (arrayList.get(i) + arrayList.get(j) + arrayList.get(k) + arrayList.get(l) == sum) {
                            System.out.println("[" + arrayList.get(i) + ", " + arrayList.get(j) + ", " + arrayList.get(k) + ", " + arrayList.get(l) + "], true");
                            return;
                        }
                    }
                }
            }
        }

        System.out.println("No numbers in the list add up to " + sum + ", false");
    }
}
