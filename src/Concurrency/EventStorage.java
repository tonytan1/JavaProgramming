package Concurrency;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import java.util.Queue;

/**
 * Created by tonytan on 23/6/15.
 */
public class EventStorage {
    private int maxSize;
    private List<Date> storage;

    public EventStorage(){
        maxSize=10;
        storage = new LinkedList<>();
    }

    public synchronized void set(){
        while (storage.size() == maxSize){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        ((LinkedList<Date>)storage).offer(new Date());
        System.out.printf("Set: %d\n", storage.size());
        notifyAll();// wake up all the threads that are sleeping in the wait() method.
    }

    public synchronized void get(){
        while (storage.size() == 0){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d: %s\n", storage.size(),
                ((LinkedList<?>)storage).poll());
        notifyAll();
    }
}
