package Employee;

/**
 * Created by tonytan on 7/6/15.
 *
 * implememts an employee paid by the hour.
 */
public class Hourly extends Employee{
    private double hourlyRate;
    private double hours = 0.0;

    public Hourly(String name, double rate){
        super(name);
        hourlyRate = rate;
    }

    @Override
    public double getPay() {
        double pay = hourlyRate*hours;
        hours = 0.0;
        return pay;
    }
}
