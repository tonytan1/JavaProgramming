package Concurrency;

/**
 * Created by tony.tan on 6/18/2015.
 */
public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is prime\n", number);
            }

            if (isInterrupted()) {
                System.out.printf("The prime generator has been interrupted.");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number){
        if(number<=2){
            return true;
        }
        //for(long i=2; i< number;i++){
        if(number%2 ==0) return false;
        for(long i=3; i*i <= number; i+=2){
            if ((number%i)==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Thread task=new PrimeGenerator();//start a object of PrimeGenerator class.
        task.start();

        try {
            Thread.sleep(10);//wait for 5 seconds
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        task.interrupt();
    }
}
