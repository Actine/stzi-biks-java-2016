package ua.edu.uzhnu.biks.training.task5.familytree;

import com.sun.istack.internal.NotNull;

/**
 * Created by Actine on 16.03.2017.
 */
public class Male extends Person {

    // Створюється об'єкт анонімного класу, який extends Male
    public static final Male DEFAULT = new Male() {
        @Override
        public Male getFather() {
            return Male.DEFAULT;
        }

        @Override
        public Female getMother() {
            return Female.DEFAULT;
        }
    };

    public Male(String name, @NotNull Male father, @NotNull Female mother) {
        super(name, father, mother);
    }

    private Male() {
        super("Невідомий");
    }
}
