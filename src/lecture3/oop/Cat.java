package lecture3.oop;

/**
 * Кіт є підтипом котячих і наслідує всі властивості котячих, включаючи те, що вони видають звук.
 * Крім цього, у кота можна вичислити об'єм (інтерфейс реалізований тут, а не у Felidae, просто для демонстрації,
 * що так можна.  Зрештою, може, об'єм є не у всіх котячих?)
 */
public class Cat extends Felidae implements HasVolume {

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

    public String getSound(boolean loud) {
        if (loud) {
            return "MRRRRREOW";
        } else {
            return getSound();
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age + ", " +
                "weight=" + weight + ", " +
                "breed='" + breed + '\'' +
                '}';
    }

    @Override
    public int getVolume() {
        return (int) (30 * 20 * 10 * weight * Math.PI);
    }

}
