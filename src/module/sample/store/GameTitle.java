package module.sample.store;

/**
 * Created by Actine on 15.12.2016.
 */
public class GameTitle {

    private String name;
    private int price;

    protected GameTitle(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "GameTitle{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
