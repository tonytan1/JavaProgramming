package Employee;

/**
 * Created by tonytan on 7/6/15.
 *
 * generic description for employee by abstract class
 */
public abstract class Employee {// Illegal to use private or final with abstract.
    private String name;
    public abstract double getPay();// reduce dummy writing below bcz overriding.

    public Employee(String name){
        this.name = name;
    }

    public void printPay(int date){
        System.out.println(date);
        System.out.println(getPay());
    }
    //public double getPay(){
    //    System.out.println("error! in dummy data");
    //    return 0.0;
    //}
}
