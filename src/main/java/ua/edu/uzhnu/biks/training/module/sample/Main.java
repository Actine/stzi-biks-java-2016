package ua.edu.uzhnu.biks.training.module.sample;

import ua.edu.uzhnu.biks.training.module.sample.store.GameStore;
import ua.edu.uzhnu.biks.training.module.sample.store.GameTitle;
import ua.edu.uzhnu.biks.training.module.sample.store.Purchase;
import ua.edu.uzhnu.biks.training.module.sample.store.User;

/**
 * Created by Actine on 15.12.2016.
 */
public class Main {

    public static void main(String[] args) {
        GameStore store = GameStore.getStore();
        GameTitle title = store.findByName("GTA");
        System.out.println(title);

        User currentUser = User.getCurrentUser();
        System.out.println(currentUser);

        Purchase purchase = store.buyGame(currentUser, title);
        System.out.println(purchase);
        System.out.println(currentUser);
    }

}
