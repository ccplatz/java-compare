import java.util.Comparator;

public class PersonBmiComparator implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return Double.compare(firstPerson.getBmi(), secondPerson.getBmi());
    }
}
