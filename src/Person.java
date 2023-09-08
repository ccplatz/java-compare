import java.util.*;

public class Person {
    String name, firstName;
    double height, weight;

    ArrayList<String> firstNames = new ArrayList<>(Arrays.asList("Abraham", "Berta", "Carsten", "Detlef", "Edeltraud", "Ferdinand"));
    ArrayList<String> names = new ArrayList<>(Arrays.asList("Asbach", "Braun", "Conrad", "Dreher", "Engel", "Fischer"));

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

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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
}
