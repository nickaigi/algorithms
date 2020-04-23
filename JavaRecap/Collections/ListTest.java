import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
    private static final String colors[] = {
            "black", "yellow", "green", "blue", "violet", "silver"
    };
    private static final String colors2[] = {
            "gold", "white", "brown", "blue", "gray", "silver"
    };

    public ListTest() {
        List<String> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();

        //add elements to list1
        Collections.addAll(list1, colors);
        Collections.addAll(list2, colors2);

        //concatenate lists
        list1.addAll(list2);
        list2 = null; // release resources
        printList(list1);

        convertToUppercaseStrings(list1);
        printList(list1);

        System.out.print("\nDeleting elements 4 to 6...");
        removeItems(list1, 4, 7);

        printList(list1);
        printReversedList(list1);
    }

    public void printList(List<String> list) {
        System.out.println("\nlist: ");
        for (String color : list)
            System.out.printf("%s ", color);
        System.out.println();
    }

    private void convertToUppercaseStrings(List<String> list) {
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String color = iterator.next();    // get item
            iterator.set(color.toUpperCase()); // convert to uppercase
        }
    }

    private void removeItems(List<String> list, int start, int end) {
        list.subList(start, end).clear(); // remove items
    }

    private void printReversedList(List<String> list) {
        ListIterator<String> iterator = list.listIterator();
        System.out.println("\nReversed List:");

        while (iterator.hasPrevious())
            System.out.printf("%s ", iterator.previous());
    }

    public static void main(String[] args) {
        new ListTest();
    }
}
