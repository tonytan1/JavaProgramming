package Bear; /**
 * Created by tony.tan on 5/20/2015.
 *
 * this class implements a store that sells toy bears
 */

import java.util.Scanner;
import java.util.ArrayList;

public class BearStore {
    ArrayList<Bear> bears = new ArrayList<>();

    public void addStdBears(int num){
        for(int i=0; i<num; i++){
            bears.add(new Bear("aaaa","bbbb"));
        }
    }

    public void addUserSpecifiedBear(int num){
        for(int i=0;i<num;i++){
            bears.add(getUserSpecifiedBear());
        }
    }

    private Bear getUserSpecifiedBear(){
        Scanner stdIn = new Scanner(System.in);
        String maker, type;

        System.out.println("PLS enter bear's maker: ");
        maker = stdIn.nextLine();

        System.out.println("PLS enter bear's type:");
        type = stdIn.nextLine();

        return new Bear(maker,type);
    }

    public void displayInventory(){
        for(Bear b:bears){
            b.display();
        }
    }

    public static void main(String[] args){
        BearStore store = new BearStore();
        store.addStdBears(3);
        store.addUserSpecifiedBear(2);
        store.displayInventory();
    }
}
