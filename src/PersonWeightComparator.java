import java.util.Comparator;

public class PersonWeightComparator implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return Double.compare(firstPerson.getWeight(), secondPerson.getWeight());
    }
}
