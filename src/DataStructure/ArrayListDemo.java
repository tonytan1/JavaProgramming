package DataStructure;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by tony.tan on 8/18/2015.
 */
public class ArrayListDemo {
    public static void main(String[] args){

        ArrayList<String> al = new ArrayList<>();
        al.add("apple");
        al.add("mango");
        al.add("grapes");
        al.add("oranges");

        System.out.println("Contents are: " + al);

        al.remove(2);

        System.out.println("After removing contents are " + al);
        System.out.println("size of array list: "+al.size());

        Iterator<String> itr = al.iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
