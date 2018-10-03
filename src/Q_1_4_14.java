import java.util.ArrayList;
import java.util.Arrays;

public class Q_1_4_14 {
    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(1,4,5,8,24,9,2,6,3));
        fourSumProblem(values,20);
    }

    private static void fourSumProblem(ArrayList<Integer> arrayList, int sum) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = i + 1; j < arrayList.size() - 1; j++) {
                for(int k = j + 1; k < arrayList.size() - 1; k++) {
                    for (int l = k + 1; l < arrayList.size(); l++) {
                        if (arrayList.get(i) + arrayList.get(j) + arrayList.get(k) + arrayList.get(l) == sum) {
                            System.out.println("Found values " + arrayList.get(i) + " " + arrayList.get(j) + " " + arrayList.get(k) + " " + arrayList.get(l));
                            return;
                        }
                    }
                }
            }
        }
    }
}
