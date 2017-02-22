package Algorithm;

/**
 * Created by tonytan on 21/10/2016.
 */
public class BinarySearch {

    int size = 7;
    int[] data = {1,2,3,4,5,6,7};

    public int search(int source){
        int low = 0;
        int high = size-1;

        while(high >= low){
            int mid = (low+high)>>1;

            if (data[mid]> source){
                high = mid-1;
            }else if (data[mid] < source){
                low = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        BinarySearch binary = new BinarySearch();
        System.out.println(binary.search(3));
    }
}
