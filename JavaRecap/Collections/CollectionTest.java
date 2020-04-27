import java.util.*;

public class CollectionTest {

    public static void main(String[] args) {
        String[] colors = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN"};
        List<String> list = new ArrayList<>();

        // old way of adding to list
        for (String color : colors)
            list.add(color);

        String[] removeColors = {"RED", "WHITE", "BLUE"};
        List<String> removeList = new ArrayList<>();

        // concise version of adding to list
        Collections.addAll(removeList, removeColors);

        System.out.println("ArrayList: ");
        // output list contents
        for (String s : list) System.out.printf("%s ", s);

        // remove colors contained in removeList
        removeColorsBetter(list, removeList);

        System.out.println("\n\nArrayList after calling removeColors: ");
        for (String color : list)
            System.out.printf("%s ", color);
    }

    private static void removeColors(Collection<String> collection1, Collection<String> collection2) {
        // get iterator
        Iterator<String> iterator = collection1.iterator();

        // loop while collection has items
        while (iterator.hasNext())
            if (collection2.contains(iterator.next()))
                iterator.remove(); // remove current color
    }

    private static void removeColorsBetter(Collection<String> collection1, Collection<String> collection2) {
        // remove current color
        collection1.removeIf(collection2::contains);
    }
}
