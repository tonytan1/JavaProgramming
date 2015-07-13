package FileBufferChannelPath;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 * Created by tonytan on 13/7/15.
 */
public class DataFileTest {
    public static void main(String[] args){
        Employees[] staff = new Employees[3];

        staff[0] = new Employees("Carl Tester", 75000,
                1987, 12, 15);
        staff[1] = new Employees("Harry Hacker", 50000,
                1989, 10, 1);
        staff[2] = new Employees("Tony Cracker", 95000,
                1990, 10, 13);

        try {
            //save all Employees records to the file Employees.
            PrintWriter out = new PrintWriter(new
                    FileWriter("Employees.dat"));
            writeData(staff, out);
            out.close();

            //print the newly read Employees records
            for (int i=0; i<staff.length; i++){
                System.out.println(staff[i]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Write all Employeess in an array to a print writer
     * 
     * @param e an array of Employees
     * @param out a print writer
     */
    static void writeData(Employees[] e, PrintWriter out) throws IOException{
        //Write number of Employees
        out.println(e.length);
        for (int i=0; i<e.length; i++){
            e[i].writeData(out);
        }
    }

    /**
     * Reads an array of Employeess from a buffered reader
     * @param in the buffered reader
     * @return the array of Employees
     */
    static Employees[] readData(BufferedReader in) throws IOException{
        //retrieve the array size
        int n = Integer.parseInt(in.readLine());

        Employees[] e = new Employees[n];
        for (int i=0; i<n; i++){
            e[i] = new Employees();
            e[i].readData(in);
        }
        return e;
    }
}

class Employees{
    private String name;
    private double salary;
    private Date hireDay;

    public Employees(){}

    public Employees(String n, double s, int year,
                     int month, int day){
        name = n;
        salary = s;
        GregorianCalendar calendar =
                new GregorianCalendar(year, month-1, day);
        hireDay = calendar.getTime();
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public Date getHireDay(){
        return hireDay;
    }

    public void raiseSalay(double byPercent){
        double raise = salary*byPercent/100;
        salary += raise;
    }

    public String toString(){
        return getClass().getName()
                +"[name="+name
                +",salary="+salary
                +",HireDay="+hireDay
                +"]";
    }

    /**
     * Writes employee data to a print writer
     *
     * @param out the print writer
     */
    public void writeData(PrintWriter out) throws IOException{
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(hireDay);
        out.println(name + "|"
        + salary + "|"
        + calendar.get(calendar.YEAR)
        + (calendar.get(calendar.MONTH)+1)
        + calendar.get(calendar.DAY_OF_MONTH));
    }

    /**
     * Reads employees data from a buffered reader
     *
     * @param in the buffered reader
     */
    public void readData(BufferedReader in) throws IOException{
        String s = in.readLine();
        StringTokenizer t = new StringTokenizer(s, "|");
        name = t.nextToken();
        salary = Double.parseDouble(t.nextToken());
        int y = Integer.parseInt(t.nextToken());
        int m = Integer.parseInt(t.nextToken());
        int d = Integer.parseInt(t.nextToken());
        GregorianCalendar calendar =
                new GregorianCalendar(y, m-1, d);
        //GregorianCalendar uses 0 = January
        hireDay = calendar.getTime();
    }
}
