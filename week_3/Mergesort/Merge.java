public class Merge {

    // Top-down mergesort

    private static Comparable[] aux;   // auxiliary array for merges

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];   // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        // Sort a[lo..hi];
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);       // Sort left half
        sort(a, mid + 1, hi);     // Sort right half
        merge(a, lo, mid, hi);  // Merge results
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // Merge a[lo..mid] with a[mid+1..hi]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)  // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Character[] a = {'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        StdOut.println("Sorting:");
        for (char c : a)
            StdOut.print(c);

        Merge.sort(a);

        StdOut.println("\n\nAfter Sorting:");
        for (char c : a)
            StdOut.print(c);
    }
}
