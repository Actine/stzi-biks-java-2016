package lecture3.oop;

/**
 * Created by Actine on 24.11.2016.
 */
public class Cat extends Felidae {

    private String breed;

    public Cat(int age, double weight, String breed) {
        super(age, weight);
        this.breed = breed;
    }

    public Cat(int age, double weight) {
        // Дворовий кіт
        this(age, weight, "Stray");
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String getSound() {
        return "Pur-r-r-r";
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age + ", " +
                "weight=" + weight + ", " +
                "breed='" + breed + '\'' +
                '}';
    }

}
