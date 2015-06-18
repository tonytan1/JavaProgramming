package Concurrency;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

/**
 * Created by tony.tan on 6/18/2015.
 */
public class CleanerTask extends Thread {
    private Deque<Event> deque;
    public CleanerTask(Deque<Event> deque){
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true){
            Date date = new Date();
            clean(date);
        }
    }

    public void clean(Date date){
        long difference;
        boolean delete;

        if(deque.size() == 0){
            return;
        }
        delete = false;
        do {
            Event e = deque.getLast();
            difference = date.getTime() - e.getDate().getTime();

            if (difference > 10000){
                System.out.printf("Cleaner: %s\n", e.getEvent());
                deque.removeLast();
                delete = true;
            }
        }while (difference > 10000);
        if (delete){
            System.out.printf("Cleaner: Size of the queue: %d\n",
                    deque.size());
        }
    }

    public static void main(String[] args){
        Deque<Event> deque = new ArrayDeque<>();
        WriteTask writer = new WriteTask(deque);

        for (int i=0; i<3; i++){
            Thread thread = new Thread(writer);
            thread.start();
        }

        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}
