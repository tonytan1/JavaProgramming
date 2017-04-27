package ShowMeCode.Concurrency;

/**
 * Created by tonytan on 19/6/15.
 *
 *
 */
public class Task implements Runnable {
    @Override
    public void run() {
        int numero = Integer.parseInt("9o99");
    }

    public static void main(String[] args){
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
