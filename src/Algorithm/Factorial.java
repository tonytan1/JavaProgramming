package Algorithm;

import java.util.Scanner;

/**
 * Created by tonytan on 23/5/15.
 */
public class Factorial {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int num;

        System.out.print("PLS enter a non-negative num:");
        num = stdIn.nextInt();

        System.out.println(factorial(num));
    }

    public static int factorial(int n){
        int nF;

        if(n == 0 || n==1){
            nF=1;
        }
        else {
            nF = n*factorial(n-1);
        }
        return nF;
    }
/**
 * this part is a recursive loop that has no stopping condition.
 * run with Exception in thread "main" java.lang.StackOverflowError.
 */
    //public static int factorial1(int n){
    //    return n*factorial1(n-1);
    //}
}
