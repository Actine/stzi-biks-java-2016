package ua.edu.uzhnu.biks.training.lecture3.oop;

/**
 * Комп'ютер, у контексті нашої моделі, це просто дещо, що видає звук «біп».
 * Інші його властивості нас не цікавлять.
 */
public class Computer implements MakesSound {
    @Override
    public String getSound() {
        return "Beep";
    }
}
