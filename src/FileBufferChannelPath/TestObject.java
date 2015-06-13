package FileBufferChannelPath;

/**
 * Created by tonytan on 12/6/15.
 *
 * A typical heterogeneous object.
 */

import java.io.Serializable;

public class TestObject implements Serializable {
    private int id;
    private String text;
    public double number;//variable

    public TestObject(int id, String text, double number){
        this.id = id;
        this.text = text;
        this.number = number;
    }//end constructor

    public void display(){
        System.out.print(this.id + "\t");
        System.out.print(this.text + "\t");
        System.out.println(this.number);
    }
}
