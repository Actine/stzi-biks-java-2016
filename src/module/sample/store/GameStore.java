package module.sample.store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Actine on 15.12.2016.
 */
public class GameStore {

    private GameTitle[] gameTitles;
    private List<Purchase> purchases;

    public static GameStore getStore() {
        GameTitle[] games = new GameTitle[]{
                new GameTitle("Grand Theft Auto [GTA]", 4900),
                new GameTitle("Need for Speed [NFS]", 2900),
                new GameTitle("Counter Strike [CS]", 999)
        };
        return new GameStore(games);
    }

    private GameStore(GameTitle[] gameTitles) {
        this.gameTitles = gameTitles;
        this.purchases = new ArrayList<>();
    }

    public GameTitle findByName(String name) {
        for (GameTitle gameTitle : gameTitles) {
            if (gameTitle.getName().contains(name)) {
                return gameTitle;
            }
        }
        return null;
    }

    public Purchase buyGame(User user, GameTitle title) {
        if (user.getOwnedGames().contains(title)) {
            return null;
        }
        if (!user.charge(title.getPrice())) {
            return null;
        }

        user.getOwnedGames().add(title);
        Purchase p = new Purchase(user, title);
        purchases.add(p);
        return p;
    }

}
