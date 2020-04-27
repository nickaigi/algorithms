import java.util.ArrayList;
import java.util.List;

public class Sort3 {
    public static void main(String[] args) {
        List<Time2> list = new ArrayList<>();

        list.add(new Time2(6, 24, 34));
        list.add(new Time2(18, 14, 58));
        list.add(new Time2(6, 05, 34));
        list.add(new Time2(12, 14, 58));
        list.add(new Time2(5, 24, 22));

        System.out.printf("Unsorted array elements:%n%s%n", list);

        list.sort(new TimeComparator());

        System.out.printf("Sorted list elements:%n%s%n", list);

    }
}
