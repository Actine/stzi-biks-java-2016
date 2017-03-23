package ua.edu.uzhnu.biks.training.lecture5.generics;

/**
 * Created by Actine on 16.03.2017.
 */
public class Box<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
