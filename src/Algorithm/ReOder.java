package Algorithm;

/**
 * Reoder the array in certain condition.
 * 考察重点在于将逻辑框架抽象出来，判断标准作为参数（一个函数指针）， 用一个单独的函数来判断数字是不是符合标准
 * Created by tonytan on 22/4/2017.
 */
public class ReOder {
    void reorderOddEven(int[] array, int length) {
        if (array == null || length < 0) {
            System.out.println("input error");
            return;
        }

        int preIndex = 0;
        int postIndex = length -1;

        while(preIndex < postIndex) {
            while (array[preIndex]%2 != 0 && preIndex < postIndex){
                preIndex++;
            }

            while (array[postIndex]%2 == 0 && preIndex < postIndex){
                postIndex--;
            }

            if (preIndex < postIndex) {
                int tmp = array[preIndex];
                array[preIndex] = array[postIndex];
                array[postIndex] = tmp;
            }
        }
    }

    /**
     * RECONSTRUCTION: MAKE CRETERIA AS A BOOLEAN FUCNTION
     */

    void reOder(int[] array, int length) {
        if (array == null || length < 0) {
            System.out.println("input error");
            return;
        }

        int preIndex = 0;
        int postIndex = length - 1;

        while (preIndex < postIndex) {
            while (fulfilled(preIndex) && preIndex < postIndex) {
                preIndex++;
            }

            while (fulfilled(postIndex) && preIndex < postIndex) {
                postIndex--;
            }

            if (preIndex < postIndex) {
                int tmp = array[preIndex];
                array[preIndex] = array[postIndex];
                array[postIndex] = tmp;
            }
        }
    }

    boolean fulfilled(int i) {
        return (i & 1) == 0;
    }
}
