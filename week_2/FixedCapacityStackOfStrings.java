public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        // loitering: holding a reference to an object when it is no longer needed.
        return s[--N];
    }

    public String pop2() {
        /* avoids loitering.
         * Garbage Collector can reclaim memory only if no outstanding references
         */
        String item = s[--N];
        s[N] = null;
        return item;
    }
}
