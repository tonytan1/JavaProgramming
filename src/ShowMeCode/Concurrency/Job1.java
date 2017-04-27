package ShowMeCode.Concurrency;

/**
 * Created by tonytan on 24/6/15.
 */
public class Job1 implements Runnable{
    private PrintQueue1 printQueue1;

    public Job1(PrintQueue1 printQueue1){
        this.printQueue1 = printQueue1;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n",
                Thread.currentThread().getName());
        printQueue1.printJob(new Object());
        System.out.printf("%s: The document has been printed\n",
                Thread.currentThread().getName());
    }

    public static void main(String[] args){
        PrintQueue1 printQueue = new PrintQueue1();

        Thread thread[] = new Thread[10];
        for (int i=0; i<10; i++){
            thread[i] = new Thread(new Job1(printQueue), "Thread"+i);
        }
        for (int i=0; i<10; i++){
            thread[i].start();
        }
    }
}
