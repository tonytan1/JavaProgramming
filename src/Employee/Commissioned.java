package Employee;

/**
 * Created by tonytan on 7/6/15.
 *
 * represent employees on straight commission.
 */
public class Commissioned extends Employee implements Commission{
    private double sales = 0.0;

    public Commissioned(String name){
        super(name);
        this.sales = sales;
    }

    public void addSales(double sales){
        this.sales += sales;// this interface requires this method defination.
    }

    //postcondition: this resets sales to zero.


    @Override
    public double getPay() {
        double pay = COMMISSION_RATE*sales;
        sales = 0.0;
        return pay;
    }
}
