package OODesign;

import java.util.ArrayList;

/**
 * Created by tonytan on 8/1/2017.
 *
 * Three level: fresher, technical lead, PM.
 * A group could have some fresher but only one TL or PM.
 * when call comes, fresher must be fisrt, if could not handle, then TL, then PM.
 * Design the classes and data structures for this problem.
 * Implement a method getCallHandler().
 */
public class CallHandler {
    public enum Level{
        fresher(1), techlead(2), PM(3);

        int level;

        private Level(int l){
            this.level = l;
        }
    }

    class Employee{
        Level level;
        boolean isfree;

        public Employee(){}

        public Employee(Level level){
            this.level = level;
            this.isfree = true;
        }
    }

    public class Fresher extends Employee{
        public Fresher(){
            super(Level.fresher);
        }
    }

    public class TechLead extends Employee{
        public TechLead(){
            super(Level.techlead);
        }
    }

    public class PM extends Employee{
        public PM(){
            super(Level.PM);
        }
    }

    public static ArrayList<Employee> employees = new ArrayList<>();

    private class Call{

    }
    public boolean dispatchCall(Call call){
        for (Employee e: employees) {
            if (e.level == Level.fresher && e.isfree == true){
                e.isfree = false;
                return true;
            }
        }

        return  false;
    }

    public boolean getCallHandler(){
        return true;
    }
}
