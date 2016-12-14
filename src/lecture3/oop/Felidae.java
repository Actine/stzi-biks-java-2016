package lecture3.oop;

/**
 * Абстрактний суперклас «котячі». Об'єднує всі властивості котячих, проте об'єкт самого класу «котячі» створити
 * не можна - а тільки його конкретних підкласів. Імплементує інтерфейс MakesSound, але абстрактним методом: це означає,
 * що всі підтипи Felidae теж будуть об'єктами типу MakesSound і реалізуватимуть метод, заданий цим інтерфейсом.
 */
public abstract class Felidae implements MakesSound {

    private int age;
    private double weight;

    public Felidae(int age, double weight) {
        this.age = age;
        this.weight = weight;
    }

    protected int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
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
