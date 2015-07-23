/**
 * Created by tony.tan on 6/4/2015.
 *
 * This describes a full-time employee.
 */
public class FullTimeDriver {
    public static void main(String[] args){
        FullTime fullTimer = new FullTime("tony",111111, 1000000);

        fullTimer.display();
        System.out.println(fullTimer.getName());

        int x = Integer.parseInt("2345");
    }
}
