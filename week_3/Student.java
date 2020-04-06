import java.util.Comparator;

/*
 * Implementing Comparator Interface
 * - we define a nested class that implements the 'Comparator' interface
 *   then we implement the compare() method
 */
public class Student {
    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_SECTION = new BySection();
    private final String name;
    private final int section;

    public Student(String name, int section) {
        this.name = name;
        this.section = section;
    }


    private static class ByName implements Comparator<Student> {
        @Override
        public int compare(Student v, Student w) {
            return v.name.compareTo(w.name);
        }
    }

    private static class BySection implements Comparator<Student> {
        @Override
        public int compare(Student v, Student w) {
            return v.section - w.section;
        }
    }
}
