import java.util.*;

public class CollectionTest {
    private static final String[] colors = {
            "MAGENTA", "RED", "WHITE", "BLUE", "CYAN"
    };

    private static final String[] removeColors = {
            "RED", "WHITE", "BLUE"
    };

    private CollectionTest() {
        List<String> list = new ArrayList<>();
        List<String> removeList = new ArrayList<>();

        // add elements in colors array to list
        for (String color : colors)
            list.add(color);

        /* add elements in removeColors to removeList
         * concise version of L17-L18
         */
        Collections.addAll(removeList, removeColors);

        System.out.println("ArrayList: ");
        // output list contents
        for (String s : list) System.out.printf("%s ", s);

        // remove colors contained in removeList
        removeColors(list, removeList);

        System.out.println("\n\nArrayList after calling removeColors: ");
        for (String color : list)
            System.out.printf("%s ", color);
    }

    private void removeColors(Collection<String> collection1, Collection<String> collection2) {
        // get iterator
        Iterator<String> iterator = collection1.iterator();

        // loop while collection has items
        while (iterator.hasNext())
            if (collection2.contains(iterator.next()))
                iterator.remove(); // remove current color
    }

    private void removeColorsBetter(Collection<String> collection1, Collection<String> collection2) {
        // remove current color
        collection1.removeIf(collection2::contains);
    }

    public static void main(String[] args) {
        new CollectionTest();
    }
}
