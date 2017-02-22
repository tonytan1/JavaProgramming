package Algorithm;

/**
 * Created by tonytan on 12/1/2017.
 */
public class MergeSort {

    static int[] sort2 = {1,2,4,5};
    static int[] sort1 = {3,6,9};

    static int[] mergesort(int[] sort1,int[] sort2){
        int i = sort1.length-1;
        int j = sort2.length-1;
        int k = i+j+1;
        int[] merge = new int[k+1];
        while (i>=0 && j>=0){
            if (sort2[j] > sort1[i]){
                merge[k] = sort2[j];
                k = k-1;
                j = j-1;
            }else {
                merge[k] = sort1[i];
                k = k-1;
                i = i-1;
            }
        }

        while (i>=0){
            merge[k--]=sort1[i--];
        }

        while (j>=0){
            merge[k--]=sort2[j--];
        }

        return merge;
    }

    public static void main(String[] args ){
        int[] merge = mergesort(sort1,sort2);
        for (int i: merge)
        System.out.print(i);
    }

}
