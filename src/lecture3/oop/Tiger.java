package lecture3.oop;

/**
 * Created by Actine on 24.11.2016.
 */
public class Tiger extends Felidae {

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

}
