package ShowMeCode; /**
 * Created by tony.tan on 5/21/2015.
 *
 * This illustrates the creation and use of an ordinary FIFO Queue.
 */

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class ChipotlesQueue {
    public static void main(String[] args){
        String serverdPerson;
        Queue<String> chipotlesQueue = new ArrayDeque<String>();

        chipotlesQueue.add("Alexa");
        chipotlesQueue.add("baccat");
        chipotlesQueue.add("carrol");
        chipotlesQueue.add("duff");

        double time0, time1, time2, time3;
        time0 = System.nanoTime();

        Iterator iter= chipotlesQueue.iterator();
        while (iter.hasNext()){
            System.out.println("what is your order, " + (String)iter.next() +"?");
        }
        time1 = System.nanoTime();
        System.out.println("the consuming time is " + (time1-time0));

        time2 = System.nanoTime();
        while (!chipotlesQueue.isEmpty()){
            serverdPerson = chipotlesQueue.remove();
            System.out.println("what is your order, " + serverdPerson +"?");
        }
        time3 = System.nanoTime();
        System.out.println("the consuming time is " + (time3-time2));
    }
}
