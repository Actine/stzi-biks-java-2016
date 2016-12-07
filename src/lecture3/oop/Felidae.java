package lecture3.oop;

/**
 * Created by Actine on 24.11.2016.
 */
public abstract class Felidae {

    protected int age;
    protected double weight;

    public Felidae(int age, double weight) {
        this.age = age;
        this.weight = weight;
    }

    public abstract String getSound();

    public void eat(double weight) {
        this.weight += weight;
    }

    @Override
    public String toString() {
        return "Felidae{" +
                "age=" + age +
                ", weight=" + weight +
                '}';
    }
}
