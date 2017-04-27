package ShowMeCode.Employee;

/**
 * Created by tonytan on 7/6/15.
 */
public class Salaried extends Employee{
    private double salary;

    public Salaried(String name, double salary){
        super(name);
        this.salary = salary;
    }

    @Override
    public double getPay() {
        return this.salary;
    }
}
