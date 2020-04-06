/*
 * Comparator interface: how to use with the sorting algos we've been using.
 * Use Object instead of Comparable.
 *  */

import java.util.Comparator;

public class ComparatorExample {

    public static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0 && less(comparator, a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
    }

    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
