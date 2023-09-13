import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(new Person());
        }

        System.out.println("----------- Unsorted -----------");
        persons.forEach(System.out::println);
        System.out.println("----------- Sorted -----------");
        Collections.sort(persons);
        persons.forEach(System.out::println);
    }
}