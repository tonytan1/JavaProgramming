import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by tony.tan on 6/4/2015.
 *
 * This class describes an employee.
 */
public class Employee extends Person {
    private int id =0;

    public Employee()
    {}

    public Employee(String name, int id){
        super(name);
        this.id = id;
    }

    public void display(){
        System.out.println("Name: "+ getName());
        System.out.println("ID: "+ id);
    }

}
