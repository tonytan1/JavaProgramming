package Concurrency;

/**
 * Created by tony.tan on 6/17/2015.
 *
 *
 */
public class Calculator implements Runnable{
    private int number;
    public Calculator(int number){
        this.number = number;
    }

    @Override
    public void run() {
        for(int i=1; i<10; i++){
            System.out.printf("%s: %d*%d = %d\n", Thread.currentThread().getName(),
                    number, i, i*number);
        }
    }

    public static void main(String[] args ){
        for(int j=0; j<10; j++){
            Calculator calculator = new Calculator(j);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
