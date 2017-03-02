package ua.edu.uzhnu.biks.training.module.sample.store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Actine on 15.12.2016.
 */
public class User {

    private int id;
    private List<GameTitle> ownedGames;
    private int funds;

    public static User getCurrentUser() {
        return new User(1, 6900);
    }

    protected User(int id, int funds) {
        this.id = id;
        this.funds = funds;
        this.ownedGames = new ArrayList<>();
    }

    List<GameTitle> getOwnedGames() {
        return ownedGames;
    }

    boolean charge(int amount) {
        if (this.funds >= amount) {
            this.funds -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", ownedGames=" + ownedGames +
                ", funds=" + funds +
                '}';
    }
}
