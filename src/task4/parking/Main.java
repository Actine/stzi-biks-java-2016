package task4.parking;

import task4.parking.park.Car;
import task4.parking.park.Parking;
import task4.parking.park.RandomParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p></p>
 *
 * @author Paul Danyliuk
 * @version $Id$
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        List<Car> cars = new ArrayList<>(50);
        for (int i = 0; i < 10; i++) {
            cars.add(Car.makeRandomCar());
        }

        Parking parking = new Parking(100, new RandomParkingStrategy());
        cars.forEach(parking::park);
        System.out.println(parking);

        while (true) {
            if (cars.isEmpty() || random.nextBoolean()) {
                Car c = Car.makeRandomCar();
                cars.add(c);
                parking.park(c);
            } else {
                Car c = cars.get(random.nextInt(cars.size()));
                cars.remove(c);
                parking.unpark(c);
            }

            System.out.println(parking);
            Thread.sleep(200);
        }
    }

}
