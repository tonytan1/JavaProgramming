package Concurrency;

/**
 * Created by tony.tan on 6/22/2015.
 */
public class Account {
    private double balance;

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public synchronized void addAccount(double amount){
        double tmp = balance;
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        tmp+=amount;
        balance=tmp;
    }

    public synchronized void subtractAmount(double amount){
        double tmp=balance;
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        tmp-=amount;
        balance=tmp;
    }
}
