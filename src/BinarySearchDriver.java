/**
 * Created by tonytan on 24/5/15.
 */
public class BinarySearchDriver {
    public static void main(String[] args){
        int[] array = {-7,3,5,8,12,16,23,33,55};

        System.out.println(BinarySearch.binarySearch(array,0,array.length-1,23));
    }


}
