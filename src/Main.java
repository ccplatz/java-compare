import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(new Person());
        }

        /* Sorting by comparable
        System.out.println("----------- Unsorted -----------");
        persons.forEach(System.out::println);
        System.out.println("----------- Sorted by height -----------");
        Collections.sort(persons);
        persons.forEach(System.out::println);
        System.out.println("----------- Sorted by weight -----------");
        Comparator<Person> personWeightComparator = new PersonWeightComparator();
        persons.sort(personWeightComparator);
        persons.forEach(System.out::println);
        */

        System.out.println("----------- Unsorted -----------");

        HashMap<Integer, String> attributesToSortBy = new HashMap<>();
        attributesToSortBy.put(1, "height");
        attributesToSortBy.put(2, "weight");
        attributesToSortBy.put(3, "BMI");
        attributesToSortBy.put(4, "name");

        HashMap<Integer, Comparator<Person>> comparatorsToSortBy = new HashMap<>();
        comparatorsToSortBy.put(1, new PersonHeightComparator());
        comparatorsToSortBy.put(2, new PersonWeightComparator());
        comparatorsToSortBy.put(3, new PersonBmiComparator());
        comparatorsToSortBy.put(4, new PersonNameComparator());

        HashMap<Integer, String> directionsToSortBy = new HashMap<>();
        directionsToSortBy.put(1, "ascending");
        directionsToSortBy.put(2, "descending");

        Scanner scanner = new Scanner(System.in);

        persons.forEach(System.out::println);
        System.out.println();

        System.out.println("How do you want to sort the Persons?");
        System.out.print("1 height \n2 weight \n3 BMI \n4 name (Lastname, firstname)");
        System.out.println();
        int keyOfAttributeToSortBy = Integer.parseInt(scanner.nextLine());

        String howToSort = "How do you want to sort the Persons by " + attributesToSortBy.get(keyOfAttributeToSortBy);
        System.out.println(howToSort);
        System.out.print("1 ascending \n2 descending");
        System.out.println();
        int keyOfDirectionToSortBy = Integer.parseInt(scanner.nextLine());

        String sortingConfirmation = "So, you want the person to be sorted by " +
                attributesToSortBy.get(keyOfAttributeToSortBy) +
                " " + directionsToSortBy.get(keyOfDirectionToSortBy) + "!";
        System.out.println(sortingConfirmation);
        System.out.println("Here you go ...");

        persons.sort(
                keyOfDirectionToSortBy == 2 ?
                        comparatorsToSortBy.get(keyOfAttributeToSortBy).reversed() :
                        comparatorsToSortBy.get(keyOfAttributeToSortBy)
        );
        persons.forEach(System.out::println);
    }
}