
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.*;
import static java.util.concurrent.TimeUnit.*;

/**
 * Created by tonytan on 30/6/15.
 */
class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static ArrayList<DelayedTask> sequence =
            new ArrayList<DelayedTask>();
    public DelayedTask(int delayInMilliseconds){
        delta = delayInMilliseconds;
        trigger = System.nanoTime() +
                NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }

    public long getDelay(TimeUnit unit){
        return  unit.convert(
                trigger - System.nanoTime(), NANOSECONDS);
    }

    public int compareTo(Delayed arg){
        DelayedTask task = (DelayedTask) arg;
        if (trigger<task.trigger) return -1;
        if (trigger>task.trigger) return 1;
        return 0;
    }

    public void run(){
        System.out.printf(this + " ");
    }

    public String toString(){
        return String.format("[%1$-4d]",delta)+"Task " + id;
    }

    public String summary(){
        return "(" + id+";"+delta+")";
    }

    public static class EndSentinel extends DelayedTask{
        private ExecutorService exec;
        public EndSentinel(int delay, ExecutorService e){
            super(delay);
            exec=e;
        }
        public void run(){
            for (DelayedTask pt : sequence){
                System.out.println(pt.summary() + " ");
            }
            System.out.println();
            System.out.printf(this + " Calling shutdownNow() ");
            exec.shutdownNow();
        }
    }
}

class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;
    public DelayedTaskConsumer(DelayQueue<DelayedTask> q){
        this.q = q;
    }
    public void run(){
        try {
            while (!Thread.interrupted()){
                q.take().run();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Finished DelayedTaskConsumer");
    }
}

public class DelayQueueDemo{
    public static void main(String[] args){
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue =
                new DelayQueue<DelayedTask>();
        //fill with tasks that have random delays
        for (int i=0; i<20; i++)
            queue.put(new DelayedTask(rand.nextInt(5000)));
        //set the stopping point
        queue.add(new DelayedTask.EndSentinel(5000, exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}