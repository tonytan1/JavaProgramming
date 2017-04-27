package ShowMeCode;

/**
 * Created by tony.tan on 6/3/2015.
 *@author tony.tan
 *
 *This enumerated type provides location properties of cities.
 */
public enum  City {
    PARKVILLE(39.2, -94.7),
    HAVANA(23.1, -82.4),
    KINGSTON (18.0, -76.8),
    NASSAU (25.1, -77.3),
    SAINT_TOMAS (18.3, -64.9);

    public final double latitude;
    public final double longitude;

    private City(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // This method returns the distance in km between two cities.

    public double getDistance(City destination){
        final double R = 6371;

        double lat1, lon1;
        double lat2, lon2;
        double a;

        lat1 = Math.toRadians(this.latitude);
        lon1 = Math.toRadians(this.longitude);
        lat2 = Math.toRadians(destination.latitude);
        lon2 = Math.toRadians(destination.longitude);

        a = Math.pow(Math.sin((lat2 - lat1)/2), 2)+
                Math.pow(Math.sin((lon2 - lon1)/2),2)*
                        Math.cos(lat1)*Math.cos(lat2);

        return (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)))*R;
    }
}
