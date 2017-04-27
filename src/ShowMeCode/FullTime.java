package ShowMeCode;

/**
 * Created by tony.tan on 6/4/2015.
 *
 * This class describes a full time employee.
 */
public class FullTime extends Employee {
    private double salary = 0.0;

    public FullTime()
    {}

    public FullTime(String name, int id, double salary){
        super(name, id);
        this.salary = salary;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf(
                "salary: $%,.0f\n", salary);
    }
}
