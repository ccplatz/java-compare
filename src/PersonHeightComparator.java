import java.util.Comparator;

public class PersonHeightComparator implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return Double.compare(firstPerson.getHeight(), secondPerson.getHeight());
    }
}
