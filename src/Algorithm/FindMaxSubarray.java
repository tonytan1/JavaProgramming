package Algorithm;

/**
 * Created by tonytan on 11/1/2017.
 * Given int array, find the sub array with max sum.
 */
public class FindMaxSubarray {

    static int[] array = {-1,-2,3,-4,-5,7,8};
    static int[] negarr = {-10,-2,-3,-4,-5,7,-8};

    static int curSum = 0;
    static int max =  Integer.MIN_VALUE;
    static int findMaxSub(int[] data){
        for (int i=0; i<data.length; i++){
            if (curSum <=0){
                curSum = data[i];
            }else {
                curSum += data[i];
            }

            if (max < curSum) {
                max = curSum;
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.print(findMaxSub(negarr));
    }
}
