import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student that) {
        /* returns:
         *      +ve integer if this.age > that.age
         *      -ve integer if this.age < that.age
         *      0 if this.age == that.age
         */
        return Integer.compare(this.age, that.age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nick", 20));
        students.add(new Student("Son", 25));
        students.add(new Student("Kaigi", 30));
        for (Student s : students)
            System.out.println(s);
    }
}
