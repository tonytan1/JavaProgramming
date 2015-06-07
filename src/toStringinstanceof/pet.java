package toStringinstanceof;
/**
 * Created by tonytan on 7/6/15.
 *
 * This illustrates use of the instanceOf operator.
 *
 */

import java.util.Scanner;

public class pet {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        Object obj;

        System.out.print("witch type of pet do you prefer?\n"+
                "Enter d for dogs or c for cats");
        if(stdIn.next().equals("d")){
            obj = new Dog();
        }
        else {
            obj = new Cat();
        }
        if(obj instanceof Dog){
            //this condition will be true if the object referred to is an instance
            //of the Dog class or a class descended from the Dog class.
            System.out.println("wag tail");
        }
    }
}
