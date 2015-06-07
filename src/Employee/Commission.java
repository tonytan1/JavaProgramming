package Employee;

/**
 * Created by tonytan on 7/6/15.
 *
 * specifies a common attribute and
 * a common behavior of commissioned employee.
 */
interface Commission {
    double COMMISSION_RATE  = 0.10;

    void addSales(double sales);
}
