public class GenericFixedCapacityStack<Item> {
    private Item[] s;
    private int N = 0;

    public GenericFixedCapacityStack(int capacity) {
        /*
         * The next line should be like:
         *
         * s = new Item[capacity];
         *
         * but java does not allow the creation of generic arrays.
         */
        s = (Item[]) new Object[capacity];

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        s[N++] = item;
    }

    public Item pop() {
        return s[--N];
    }
}
