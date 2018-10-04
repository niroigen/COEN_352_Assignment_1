public class Q_1_3_37 {
    private static int Josephus(int N, int M) {
        Queue josephus = new Queue();

        for (int i = 0; i < N; i++)
            josephus.push(i);

        int indexToDelete = M - 1;
        while(josephus.size() != 1) {
            josephus.delete(indexToDelete);
            if (indexToDelete > josephus.size()) {
                indexToDelete--;
            }

            indexToDelete = (indexToDelete + M - 1) % josephus.size();
        }

        return josephus.getHead().value;
    }

    public static void main(String[] args) {
        System.out.println(Josephus(7,2));
    }
}
