package ua.edu.uzhnu.biks.training.task5.familytree;

import com.sun.istack.internal.NotNull;

/**
 * Created by Actine on 16.03.2017.
 */
public class Female extends Person {

    public static final Female DEFAULT = new Female() {
        @Override
        public Male getFather() {
            return Male.DEFAULT;
        }

        @Override
        public Female getMother() {
            return Female.DEFAULT;
        }
    };

    public Female(String name, @NotNull Male father, @NotNull Female mother) {
        super(name, father, mother);
    }

    private Female() {
        super("Невідома");
    }

}
