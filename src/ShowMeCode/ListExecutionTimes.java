package ShowMeCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony.tan on 5/20/2015.
 */

import java.util.*;

public class ListExecutionTimes {
    public static void main(String[] args){
        String operationType = "Average get and set time";
        int length = 1000;
        int[] indicesA = getIndices(length);// random sequence
        int[] indicesB = getIndices(length);//random sequence

        ArrayList<Double> list = new ArrayList<Double>();

        Double element;
        long time0, time1;

        for(int i=0; i<length; i++){
            list.add(new Double(i));
        }

        time0 = System.nanoTime();
        for(int i=0; i<length; i++){
            element = list.remove(indicesA[i]);
            list.add(indicesB[i], element);
        }
        time1 = System.nanoTime();
        System.out.println(list.getClass());
        System.out.printf("for length = %d, %s = %, d ns\n", length, operationType, (time1-time0)/length);
    }

    private static int[] getIndices(int length){
        Random random = new Random();
        ArrayList<Integer> integers = new ArrayList<Integer>();
        int[] indices = new int[length];
        for(int i=0; i<length; i++){
            integers.add(random.nextInt(i+1), new Integer(i));
        }
        for(int i=0; i<length; i++){
            indices[i] = integers.get(i);
        }
        return indices;
    }

}
