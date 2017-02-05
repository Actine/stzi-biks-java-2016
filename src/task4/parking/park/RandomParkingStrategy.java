package task4.parking.park;

import java.util.Random;

/**
 * <p></p>
 *
 * @author Paul Danyliuk
 * @version $Id$
 */
public class RandomParkingStrategy implements ParkingStrategy {

    private Random random;

    public RandomParkingStrategy() {
        random = new Random();
    }

    @Override
    public int findSpot(Parking parking, Car car) {
        int limit = parking.getLength();
        while (limit-- > 0) {
            boolean ok = true;
            int spot = random.nextInt(parking.getLength() - car.getLength() + 1);
            for (int i = 0; i < car.getLength(); i++) {
                if (parking.isTaken(spot + i)) {
                    ok = false;
                }
            }
            if (ok) {
                return spot;
            }
        }
        return -1;
    }

    @Override
    public boolean switchNeedsEmptyLot() {
        return false;
    }
}
