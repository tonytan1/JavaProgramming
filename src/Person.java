/**
 * Created by tony.tan on 6/4/2015.
 *
 * Base class for inheritance hierarchy.
 */
public class Person {
    private String name = "";

    public Person()
    {}

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
