package lecture3.oop;

/**
 * Тигр є підтипом котячих і наслідує всі властивості котячих, включаючи те, що вони видають звук.
 * Крім цього, у тигра можна вичислити об'єм (інтерфейс реалізований тут, а не у Felidae, просто для демонстрації,
 * що так можна. Зрештою, може, об'єм є не у всіх котячих?)
 */
public class Tiger extends Felidae implements HasVolume {

    private boolean hasStripes;

    public Tiger(int age, double weight, boolean hasStripes) {
        super(age, weight);
        this.hasStripes = hasStripes;
    }

    public Tiger(int age, double weight) {
        this(age, weight, true);
    }

    @Override
    public String getSound() {
        return "Rrr-r-r-r";
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "age=" + age + ", " +
                "weight=" + weight + ", " +
                "hasStripes=" + hasStripes +
                '}';
    }

    @Override
    public int getVolume() {
        return (int) (100 * 20 * weight * Math.PI);
    }

}
