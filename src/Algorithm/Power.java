package Algorithm;

/**
 * return power of a value
 * Created by tonytan on 22/4/2017.
 */
public class Power {

    static int INVALID_VALUE = -1001;

    static double getPower (double base, int exponent) {
        if (equal(base, 0.0) && exponent < 0){
            return INVALID_VALUE;
        }

        double result = getPowerWithUnsignedExponent(base, exponent>0?exponent: -exponent);
        if (exponent > 0) {
            return result;
        } else {
            return 1/result;
        }
    }

    static boolean equal(double value1, double value2) {
        if ((value1 - value2 > -0.000001) && (value1 - value2 < 0.000001)) {
            return true;
        }

        return false;
    }

    static double getPowerWithUnsignedExponent(double base, int absExponent) {
        if (absExponent == 1) {
            return base;
        }

        if (absExponent == 0) {
            return 1;
        }

        double result = getPowerWithUnsignedExponent(base, absExponent >> 1);
        result *= result;

        if (absExponent%2 == 1){ // can be replaced by bit computation.
            result *= base;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getPower(2.414, 3));
        System.out.println(getPower(0, 0));
        System.out.println(getPower(0, 3));
        System.out.println(getPower(-1, -3));
        System.out.println(getPower(-2.414, 3));
    }

    /**
     * Created by tonytan on 24/5/15.
     * @author tonytan
     *
     * This uses recursion to find the index od a target value in
     * an ascending sorted array. if not found, the result is -1.
     */
    public static class BinarySearch {
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
}
