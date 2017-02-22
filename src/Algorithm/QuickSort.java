package Algorithm;

/**
 * Created by tonytan on 9/1/2017.
 *
 * QUCIK SORT
 */
public class QuickSort {

    public static int[] qsort(int[] array, int low, int high){
        if (low < high){
            int mid = patrition(array, low, high);

            qsort(array, low, mid-1);
            qsort(array, mid+1, high);
        }

        return array;
    }

    private static int patrition(int[] array, int low, int high){
        int pivot = array[low];
        while (low < high){
            while(low<high && array[high]>=pivot) {
                --high;
            }
            array[low]=array[high];

            while(low<high && array[low]<pivot){
                ++low;
            }
            array[high]=array[low];
        }

        array[low]=pivot;
        return low;
    }


    public static  void main(String[] args){
        int[] arr = {9,4,3,5,6,2,1,8,7};
        qsort(arr, 0, arr.length-1);

        for (int i: arr) {
            System.out.println(i);
        }
    }

}
