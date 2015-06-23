package Concurrency;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tonytan on 17/6/15.
 *
 * demo of getting and setting thread information.
 */
public class Calculator1 implements Runnable{
    private int number;
    public Calculator1(int number){
        this.number = number;
    }

    @Override
    public void run(){
        for(int i=1; i<10; i++){
            System.out.printf("%s: %d * %d = %d\n",
                    Thread.currentThread().getName(), number, i, number*i);
        }
    }




}
