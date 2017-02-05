package task4.parking.park;

/**
 * <p></p>
 *
 * @author Paul Danyliuk
 * @version $Id$
 */
public class Parking {

    // Tracks which car occupies each meter
    private Car[] spaces;
    private ParkingStrategy currentStrategy;

    public Parking(int length, ParkingStrategy strategy) {
        spaces = new Car[length];
        currentStrategy = strategy;
    }

    public boolean park(Car car) {
        int spot = currentStrategy.findSpot(this, car);
        if (spot == -1) {
            return false;
        }

        for (int i = 0; i < car.getLength(); i++) {
            if (spaces[spot + i] != null) {
                throw new RuntimeException("Strategy found unsuitable spot!");
            }
            spaces[spot + i] = car;
        }

        return true;
    }

    public int unpark(Car car) {
        int index = -1;
        for (int i = 0, l = spaces.length; i < l; i++) {
            if (spaces[i] == car) {
                spaces[i] = null;
                // No need to look past this continuous spot
                if (index == -1) {
                    index = i;
                    l = i + car.getLength();
                }
            }
        }
        return index;
    }

    public int getLength() {
        return spaces.length;
    }

    public boolean isTaken(int position) {
        return spaces[position] != null;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(spaces.length);
        Car prevCell = null;
        for (Car car : spaces) {
            if (prevCell != null && car != prevCell) {
                // Close previous car
                b.setCharAt(b.length() - 1, ']');
            }
            if (car != null) {
                b.append(car == prevCell ? '_' : '[');
            } else {
                b.append('.');
            }
            prevCell = car;
        }

        if (prevCell != null) {
            // Close last car
            b.setCharAt(b.length() - 1, ']');
        }
        return b.toString();
    }
}
