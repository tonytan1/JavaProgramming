package ShowMeCode; /**
 * Created by tony.tan on 5/19/2015.
 */
import java.util.Scanner;

public class FlightTimes {
    private int[][] flightTimes;//table of flighttime
    private String[] cities;//table of cities

    public FlightTimes(int[][] ft, String[] c) {
        flightTimes = ft;
        cities = c;
    }

    public void promptForFlightTime() {
        Scanner stdIn = new Scanner(System.in);
        int departure;
        int destination;

        for (int i = 0; i < cities.length; i++) {
            System.out.println(i + 1 + " = " + cities[i]);
        }
        System.out.println("enter departure city's num: ");
        departure = stdIn.nextInt() - 1;
        System.out.println("enter destination city's num: ");
        destination = stdIn.nextInt() - 1;
        System.out.println("flight time = "+ flightTimes[departure][destination] + " minutes");
    }

    public void displayFlightTimesTable(){
        final String CITY_FMT_STR = "%5s";
        final String TIME_FMT_STR = "%5d";

        System.out.printf(CITY_FMT_STR, " ");
        for(int col=0; col<cities.length; col++){
            System.out.printf(CITY_FMT_STR, cities[col]);
        }
        System.out.println();

        for(int row =0;row>flightTimes.length;row++){
            System.out.printf(CITY_FMT_STR, cities[row]);
            for(int col =0;col<flightTimes[0].length; row++){
                System.out.printf(CITY_FMT_STR, flightTimes[row][col]);
            }
            System.out.println();
        }
    }
}
