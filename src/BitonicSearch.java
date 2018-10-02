import java.util.ArrayList;
import java.util.Arrays;

public class BitonicSearch {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0,1,4,6,7,5,3,2));
        search(numbers,1);
    }

    public static void search(ArrayList<Integer> arrayList, int number) {
        int currentIndex = arrayList.size() / 2;
        while(true) {
            if (arrayList.get(currentIndex) == number) {
                System.out.println("Index value: " + currentIndex + " found number " + number);
                break;
            }

            currentIndex = arrayList.get(currentIndex) > number ? (arrayList.size() + currentIndex) / 2 : currentIndex / 2;
        }
    }
}
