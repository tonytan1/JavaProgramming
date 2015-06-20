package Concurrency;

/**
 * Created by tonytan on 19/6/15.
 *
 * Processing uncontrolled exceptions in a thread.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler{
    public void uncaughtException(Thread t, Throwable e){
        System.out.printf("An exception has been captured\n");
        System.out.printf("Thread: %s\n", t.getId());
        System.out.printf("Exception: %s: %s\n",
                e.getClass().getName(), e.getMessage());
        System.out.printf("Stack trace: \n");
        e.printStackTrace();
        System.out.printf("Thread status: %s\n", t.getState());
    }
}
