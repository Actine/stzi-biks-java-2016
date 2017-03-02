package ua.edu.uzhnu.biks.training.module.sample.store;

/**
 * Created by Actine on 15.12.2016.
 */
public class Purchase {

    private User buyer;
    private GameTitle boughtGame;

    Purchase(User buyer, GameTitle boughtGame) {
        this.buyer = buyer;
        this.boughtGame = boughtGame;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "buyer=" + buyer +
                ", boughtGame=" + boughtGame +
                '}';
    }
}
