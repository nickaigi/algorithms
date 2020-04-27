import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTest {

    public static void main(String[] args) {
        String[] colors =
                {"black", "yellow", "green", "blue", "violet", "silver"};

        List<String> list1 = new LinkedList<>();

        list1.addAll(Arrays.asList(colors));

        String[] colors2 =
                {"gold", "white", "brown", "blue", "gray", "silver"};

        List<String> list2 = new LinkedList<>();
        for (String color : colors2)
            list2.add(color);


        list1.addAll(list2); //concatenate lists
        list2 = null;        //release resources
        printList(list1);    // print list elements

        convertToUppercaseStrings(list1);
        printList(list1);

        System.out.printf("%nDeleting elements 4 to 6...");
        removeItems(list1, 4, 7);
        printList(list1);
        printReversedList(list1);
    }

    public static void printList(List<String> list) {
        System.out.printf("%nlist:%n");
        for (String color : list)
            System.out.printf("%s ", color);
        System.out.println();
    }

    private static void convertToUppercaseStrings(List<String> list) {
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String color = iterator.next();    // get item
            iterator.set(color.toUpperCase()); // convert to uppercase
        }
    }

    private static void removeItems(List<String> list, int start, int end) {
        list.subList(start, end).clear(); // remove items
    }

    private static void printReversedList(List<String> list) {
        ListIterator<String> iterator = list.listIterator(list.size());
        System.out.printf("%nReversed List:%n");

        while (iterator.hasPrevious())
            System.out.printf("%s ", iterator.previous());
    }
}
