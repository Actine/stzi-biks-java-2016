package ua.edu.uzhnu.biks.training.task4.parking.park;

/**
 * <p></p>
 *
 * @author Paul Danyliuk
 * @version $Id$
 */
public class EagerParkingStrategy implements ParkingStrategy {

    @Override
    public int findSpot(Parking parking, Car car) {
        int checks = parking.getLength() - car.getLength() + 1;
        int vacantInRow = 0;
        for (int i = 0; i < checks; i++) {
            if (parking.isTaken(i)) {
                vacantInRow = 0;
            } else {
                vacantInRow++;
            }
            if (vacantInRow == car.getLength()) {
                return i + 1 - vacantInRow;
            }
        }
        return -1;
    }

    @Override
    public boolean switchNeedsEmptyLot() {
        return false;
    }
}
