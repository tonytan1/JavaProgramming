package ShowMeCode.Concurrency.CustomerProducer;

import java.util.Arrays;

/**
 * Created by tonytan on 11/12/2016.
 */
public class P {
    //remove duplicates in sorted array
    public static int[] removeDuplicatedInt(int[] A){
        if (A.length<2) return A;

        int i=1;
        int j=0;

        while(i<A.length){
            if (A[i] == A[j]){
                i++;
            }else{
                j++;
                A[j] = A[i];
                i++;
            }
        }
        System.out.println(j);
        int[] B = Arrays.copyOf(A, j+1);
        return B;
    }

    //remove duplicates for char array
    public static char[] removeDuplicatedChar(char[] A){
        if (A.length<2) return A;

        boolean[] exist = new boolean[256];
        int j=0;
        for (int i=0;i<A.length;i++) {
            if (exist[A[i]] == true){
                A[i]=0;
            }else {
                exist[A[i]] = true;
            }
        }
        return  A;
    }

    public static void main(String[] args){
//        int[] A = {1,2,2,3,3,3};
//        int[] B = removeDuplicatedInt(A);
//        for (int i:B) {
//            System.out.print(i);
//        }

        char[] A = {'a', 'a', 'b', 'b','c'};
        System.out.print(removeDuplicatedChar(A));
        for (char a:removeDuplicatedChar(A)){
            System.out.println(a);
        }
        System.out.print(A.length);

    }
}
