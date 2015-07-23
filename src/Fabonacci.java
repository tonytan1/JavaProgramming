/**
 * Created by tonytan on 24/5/15.
 *
 * Fabonnacci sequence can be implemented by lambda and reduce method in Python.
 *
 * fib=lambda n:reduce(lambda x,y:(x[0]+x[1],x[0]),[(1,1)]*(n-2))[0]
 *
 */
public class Fabonacci {
    public static long fib(int n) {
            return n < 2 ? n : fib(n-1) + fib(n-2);
    }

    public static void main(String[] args){
        for(int i=0;i<30;i++){
            System.out.print(fib(i)+" , ");
        }

        System.out.print("...");
    }

}
