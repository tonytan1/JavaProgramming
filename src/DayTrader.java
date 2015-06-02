/**
 * Created by tony.tan on 6/2/2015.
 *
 * This simulates stock market day trading.
 */
public class DayTrader {
    public static void main(String[] args){
        double balance = 1000;
        double moneyInvested;
        double moneyReturned;
        int win=0;
        int fail=0;
        int day;
        for(int simulation=0; simulation<100;simulation++ ){
            for(day=1; day<=90; day++){
                if(balance<100|| balance > 2000)continue;{
                    int result = (balance>1000?win++:fail++);
                }
                moneyInvested = 500;
                balance -= moneyInvested;
                moneyReturned = moneyInvested*(Math.random()*2.0);
                balance+=moneyReturned;
                System.out.print("\nINVESTMENT:"+(int)moneyInvested+"\tRETURNED: "+(int)moneyReturned+"\tBALANCE: "+(int)balance);
            }
        }
        System.out.println("\nWIN: "+win+"\tFAIL:"+fail);
    }
}
