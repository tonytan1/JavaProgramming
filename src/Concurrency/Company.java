package Concurrency;

/**
 * Created by tony.tan on 6/22/2015.
 */
public class Company implements Runnable {
    private Account account;

    public Company(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            account.addAccount(1000);
        }
    }

    public static void main(String[] args){
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        System.out.printf("Account : Initial Balance: %f\n", account.getBalance());

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Balance : %f\n", account.getBalance());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
