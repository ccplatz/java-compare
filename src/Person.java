import java.util.*;

public class Person implements Comparable<Person> {
    private final String name;
    private final String firstName;
    private final double height;
    private final double weight;

    private static final ArrayList<String> firstNames = new ArrayList<>(Arrays.asList("Abraham", "Berta", "Carsten", "Detlef", "Edeltraud", "Ferdinand"));
    private static final ArrayList<String> names = new ArrayList<>(Arrays.asList("Asbach", "Braun", "Conrad", "Dreher", "Engel", "Fischer"));

    // use lambda expression
    static Comparator<Person> heightComparator = (firstPerson, secondPerson) -> Double.compare(firstPerson.getHeight(), secondPerson.getHeight());

    // use comparing method
    static Comparator<Person> weightComparator = Comparator.comparingDouble(Person::getWeight);

    // use anonymous class
    static Comparator<Person> bmiComparator = new Comparator<Person>() {
        @Override
        public int compare(Person firstPerson, Person secondPerson) {
            return Double.compare(firstPerson.getBmi(), secondPerson.getBmi());
        }
    };

    static Comparator<Person> nameComparator = new Comparator<Person>() {
        @Override
        public int compare(Person firstPerson, Person secondPerson) {
            if (firstPerson.getName().compareTo(secondPerson.getName()) == 0) {
                return firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
            }
            return firstPerson.getName().compareTo(secondPerson.getName());
        }
    };

    public Person() {
        Collections.shuffle(names);
        this.name = names.get(0);
        Random random = new Random();
        char middleInitial = (char) (random.nextInt(26) + 'a');
        Collections.shuffle(firstNames);
        this.firstName = firstNames.get(0) + " " + Character.toUpperCase(middleInitial) + ".";
        HashMap<String, Double> weightAndHeight = getHeightAndWeight();
        this.height = weightAndHeight.get("height");
        this.weight = weightAndHeight.get("weight");
    }

    public static Comparator<Person> getComparatorByType(String compare) {
        HashMap<String, Comparator<Person>> comparatorsToSortBy = new HashMap<>();
            comparatorsToSortBy.put("height", Person.heightComparator);
            comparatorsToSortBy.put("weight", Person.weightComparator);
            comparatorsToSortBy.put("bmi", Person.bmiComparator);
            comparatorsToSortBy.put("name", Person.nameComparator);

            return comparatorsToSortBy.get(compare);
    }

    private static HashMap<String, Double> getHeightAndWeight() {
        HashMap<String, Double> weightAndHeight = new HashMap<>();

        Random random = new Random();
        double bmi = (double) random.nextInt(1600, 4600) / 100;
        double height = (double) random.nextInt(140, 206) / 100;
        double weight = round(bmi * Math.pow(height, 2));

        weightAndHeight.put("height", height);
        weightAndHeight.put("weight", weight);

        return weightAndHeight;
    }

    private static double round(double d) {
        return Math.round(d * 100.0) / 100.0;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getBmi() {
        return round(weight / Math.pow(height, 2));
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name: '" + getName() + '\'' +
                ", Vorname: '" + getFirstName() + '\'' +
                ", Größe: " + getHeight() + " m" +
                ", Gewicht: " + getWeight() + " kg" +
                ", BMI: " + getBmi() +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return Double.compare(this.getHeight(), o.getHeight());
    }
}
