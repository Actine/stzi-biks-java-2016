package ua.edu.uzhnu.biks.training.task5.familytree;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Actine on 16.03.2017.
 */
public abstract class Person {

    private String name;
    Male father;
    Female mother;
    protected List<Person> children = new ArrayList<>();

    public Person(String name, @NotNull Male father, @NotNull Female mother) {
        if (mother == null || father == null) {
            throw new IllegalArgumentException("Expecting non-null mother and father");
        }

        this.name = name;
        this.father = father;
        this.mother = mother;

        father.children.add(this);
        mother.children.add(this);
    }

    protected Person(String name) {
        this.name = name;
    }

    public Male getFather() {
        return father;
    }

    public Female getMother() {
        return mother;
    }

    public String getName() {
        return name;
    }

    public List<Person> getChildren() {
        return new ArrayList<>(children);
    }
}
