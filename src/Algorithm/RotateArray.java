package Algorithm;

/**
 * RotateArray means  [0, 1, 2, 3, 4, 5] that be made like [2, 3, 4, 5, 0, 1].
 * above case can be solved by binary search.
 * Attention: [0, 1, 1, 1, 1] to [1, 1, 1, 0, 1] is a specail case that only could be solved by inorder search.
 * Created by tonytan on 22/4/2017.
 */
public class RotateArray {

    static int getMin(int[] numbers, int length) {
        if (numbers == null || length < 0) {
//            throw new Exception();
            System.out.println("error input");
        }

        int index1 = 0;
        int index2 = length-1;
        int midIndex = index1;

        while (numbers[index1] > numbers[index2]) {

            if (index2 - index1 == 1) {// in case of just two number
                midIndex = index2;
                break;
            }

            midIndex = (index1 + index2) / 2;

            if (numbers[index1] == numbers[index2] &&
                    numbers[midIndex] == numbers [index2]){ // specail case
                return getMinInOder(numbers, index1, index2);
            }
            if (numbers[midIndex] >= numbers[index1]) { // binary search
                index1 = midIndex;
            } else if (numbers[midIndex] <= numbers[index2]) {
                index2 = midIndex;
            }
        }

        return numbers[midIndex];
    }

    static int getMinInOder(int[] numbers, int index1, int index2) {
        int result = numbers[index1];

        for (int i = index1+1; i <= index2; ++i) {
            if (result > numbers[i]){
                result = numbers[i];
            }
        }

        return result;
    }

    public static void main(String[] args ){
        int[] numbers = {2, 3, 4, 5, 0, 1};

        int[] special = {1,1,1,2,3,1,1,1,1};

        System.out.println(getMin(numbers, numbers.length));
        System.out.println(getMin(special, numbers.length));


    }

}
