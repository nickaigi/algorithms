public class SortExample {
    // Template for sort classes
    public static void sort(Comparable[] a) {
        // See the algorithms in this src folder
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        // simple swap operation
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        // print the array, on a single line.
        for (Comparable comparable : a) StdOut.print(comparable + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        // test whether the array entries are in order
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // read strings from standard input, sort them and print
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
