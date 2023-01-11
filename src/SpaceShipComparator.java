import java.util.Comparator;

public class SpaceShipComparator implements Comparator<Spaceship> {

    @Override
    public int compare(Spaceship o1, Spaceship o2) {
        int compareFirePower = Integer.compare(o2.getFirePower(), o1.getFirePower());
        if (compareFirePower == 0){
            int compareByYears = Integer.compare(o2.getCommissionYear(), o1.getCommissionYear());
            if (compareByYears == 0){
                return o1.getName().compareTo(o2.getName());
            }
            return compareByYears;
        }
        return compareFirePower;
    }
}
