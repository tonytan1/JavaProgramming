/**
 * Created by tonytan on 6/6/15.
 *
 * use override toString method to display its properties.
 */
public class car2 {
    private String make;
    private int year;
    private String color;

    public car2(String make, int year, String color){
        this.make = make;
        this.year = year;
        this.color = color;
    }

    @Override
    public String toString(){

        return "make = "+make+ ", year = "+year+", color = "+color;
    }

    public static void main(String[] args){
        car2 car = new car2("Honda", 1998, "silver");
        System.out.println(car);
    }
}
