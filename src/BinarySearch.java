/**
 * Created by tonytan on 24/5/15.
 * @author tonytan
 *
 * This uses recursion to find the index od a target value in
 * an ascending sorted array. if not found, the result is -1.
 */
public class BinarySearch {
    public static int binarySearch(int[] arr, int first, int last, int targert){
        int mid;
        int index=0;

        System.out.printf("first=%d\tlast=%d\n",first,last);
        if(first == last){
            if(arr[first]==targert){
                index = first;
                System.out.println("found");
            }
            else {
                index = -1;
                System.out.println("not found");
            }
        }
        else {
            mid = (first+last)/2;
            if(targert > arr[mid]){
                first = mid+1;
            }
            else {
                last = mid;
            }
            index = binarySearch(arr, first, last,targert);
        }
        return index;
    }
}
