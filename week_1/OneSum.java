public class OneSum {
    private int count(int[] a) {
        int N = a.length;
        int count = 0;
        for (int value : a)
            if (value == 0)
                count++;
        return count;
    }

    public static void main(String[] args) {
    }
}
