/**
 * Created by tony.tan on 6/3/2015.
 * @author tony.tan
 *
 * This class prints the distance between two cities.
 */
public class CityTravel {
    public static void main(String[] args){
        final double KM_TO_MILES = 0.62137;
        City origin = City.PARKVILLE;
        City destination = City.KINGSTON;
        double distance = origin.getDistance(destination);

        System.out.printf("%s to %s: %.1f km, or %.1f miles",
                origin, destination, distance, distance*KM_TO_MILES);
    }

}
