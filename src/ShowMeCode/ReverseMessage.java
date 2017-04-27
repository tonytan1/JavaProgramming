package ShowMeCode;

import java.util.Scanner;

/**
 * Created by tonytan on 23/5/15.
 */
public class ReverseMessage {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        String msg;

        System.out.println("pls enter ur word:");
        msg = stdIn.nextLine();
        reverseMessage(msg);
    }

    public static void reverseMessage(String msg){
        if(!msg.isEmpty()){
            for(int index=msg.length()-1;index>=0;index--){
                System.out.print(msg.charAt(index));
            }
        }
    }
}
