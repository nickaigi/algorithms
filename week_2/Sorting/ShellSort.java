public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;

        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;  // 1, 4, 13, 40, 121, 364,.... 3x+1 increment sequence

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = 1; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[j];
        a[i] = a[j];
        a[j] = swap;
    }
}
