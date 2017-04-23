package Algorithm;

/**
 * Use recursive to solve the problem, save the middle value before caculation.
 * Created by tonytan on 22/4/2017.
 */
public class Fibonacci {
    static long getFibonacci(int i) {
        int[] ints = {0,1};
        if (i < 2) {
            return ints[i];
        }

        long fibonacciMinOne = 1;
        long fibonacciMinTwo = 0;
        long fibonacci = 0;
        for (int j = 2; j <= i; ++j) {//ATTENTION: <= , ++j
            fibonacci = fibonacciMinOne + fibonacciMinTwo;

            fibonacciMinTwo = fibonacciMinOne;
            fibonacciMinOne = fibonacci;
        }

        return fibonacci;
    }

    public static void main(String[] args) {
        System.out.println(getFibonacci(0));
        System.out.println(getFibonacci(1));
        System.out.println(getFibonacci(2));
        System.out.println(getFibonacci(3));
        System.out.println(getFibonacci(4));
        System.out.println(getFibonacci(5));
        System.out.println(getFibonacci(6));
        System.out.println(getFibonacci(7));
        System.out.println(getFibonacci(8));
    }
}
