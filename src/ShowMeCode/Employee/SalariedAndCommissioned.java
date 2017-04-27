package ShowMeCode.Employee;

/**
 * Created by tonytan on 7/6/15.
 *
 * this class represents salaried and commissioned employee.
 */
public class SalariedAndCommissioned
        extends Salaried implements Commission {
    private double sales;

    public SalariedAndCommissioned(String name, double salary){
        super(name, salary);
    }

    public void addSales(double Sales){// The interface requires this method definition.
        this.sales += sales;
    }

    // postcondition: this resets sales to zero.


    @Override
    public double getPay() {// rewrite the parent class.
        double pay =
                super.getPay() + COMMISSION_RATE*sales;// interface supply the constant value.
        return pay;
    }
}
