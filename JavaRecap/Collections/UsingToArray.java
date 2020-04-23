import java.util.Arrays;
import java.util.LinkedList;

public class UsingToArray {
    public UsingToArray() {
        String[] colors = {"black", "blue", "yellow"};

        LinkedList<String> links = new LinkedList<>(Arrays.asList(colors));

        links.addLast("red");    // add as last item
        links.add("pink");       // add to the end
        links.add(3, "green");   // add at 3rd index
        links.addFirst("cyan");  // add as first item

        // get LinkedList elements as an array
        colors = links.toArray(new String[0]);
        System.out.println("colors: ");
        for (String color : colors)
            System.out.println(color);
    }

    public static void main(String[] args) {
        new UsingToArray();
    }
}
