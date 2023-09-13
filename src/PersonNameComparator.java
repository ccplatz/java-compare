import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        if (firstPerson.getName().compareTo(secondPerson.getName()) == 0) {
            return firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
        }
        return firstPerson.getName().compareTo(secondPerson.getName());
    }
}
