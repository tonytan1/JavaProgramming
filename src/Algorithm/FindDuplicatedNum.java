package Algorithm;

/**
 * Created by tonytan on 10/1/2017.
 * Given an unsorted array(MAX =< length), find the duplicated num in it.
 */
public class FindDuplicatedNum {

    int[] array = {1,0,3,4,5,2,3};

    public int findDupNum(int[] arr){
        for (int i: arr) {
            if (i<0 || i >= arr.length){
                return -1;
            }
        }

        for (int i=0; i<arr.length-1; i++){
            while(arr[i]!=i){
                if (arr[arr[i]] == arr[i]){
                    return arr[i];
                }else {
                    swap(arr, i, arr[i]);
                }
            }
        }

        return -1;
    }

    private void swap(int[] data, int x, int y){
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }
}
