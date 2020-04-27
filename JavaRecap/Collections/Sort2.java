/* This example introduces the 'Comparator' interface which is used
 * for sorting a Collection's elements in a different order
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort2 {
    public static void main(String[] args) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        List<String> list = Arrays.asList(suits);
        System.out.printf("Unsorted array elements: %s%n", list);

        // sort in descending order using a comparator
        // old way
        // Collections.sort(list, Collections.reverseOrder());
        list.sort(Collections.reverseOrder());

        System.out.printf("Sorted list elements: %s%n", list);
    }
}
