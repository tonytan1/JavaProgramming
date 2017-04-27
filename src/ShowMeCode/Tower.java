package ShowMeCode;

/**
 * Created by tonytan on 25/5/15.
 * @author tonytan
 *
 * This uses a recursive algorithm for towers of hanoi problem.
 * 解法的基本思想是递归。假设有A、B、C三个塔，A塔有N块盘，目标是把这些盘全部移到C塔。
 * 那么先把A塔顶部的N-1块盘移动到B塔，再把A塔剩下的大盘移到C，最后把B塔的N-1块盘移到C.
 * 每次移动多于一块盘时，则再次使用上述算法来移动。
 */
public class Tower {
    public static void main(String[] args){
        move(4,'A','C','B');
    }

    //move n disks from the source s to destination d using temporary t.
    private static void move(int n, char s, char d, char t){
        //System.out.printf("call n=%d, s=%s, d=%s, t=%s\n", n, s, d, t);

        if(n == 1){
            System.out.printf("move %d from %s to %s\n", n, s, d);
        }
        else {
            move(n-1,s, t, d);
            System.out.printf("move %d from %s to %s\n",n, s, d);
            move(n-1, t, d, s);
        }
        System.out.println("return n=" + n);
    }
}
