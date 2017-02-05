package task4.parking.park;

/**
 * <p></p>
 *
 * @author Paul Danyliuk
 * @version $Id$
 */
public interface ParkingStrategy {

    int findSpot(Parking parking, Car car);
    boolean switchNeedsEmptyLot();

}
