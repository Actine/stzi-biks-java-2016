package ua.edu.uzhnu.biks.training.task4.parking.park;

import java.util.Random;

/**
 * <p></p>
 *
 * @author Paul Danyliuk
 * @version $Id$
 */
public class Car {

    private static Random random = new Random();

    private int length;

    public static Car makeRandomCar() {
        return new Car(random.nextInt(4) + 2);
    }

    public Car(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
