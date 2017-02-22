package DataStructure;

import java.util.Hashtable;
import java.util.Set;

/**
 * Created by tonytan on 8/1/2017.
 */
public class FindXthLargest {
    long[] hugeArr = {1,2,3};

    public static Set<Long> arrayToUnique(long[] arr){
        Hashtable<Long,Integer> counter = new Hashtable<>();

        for (int i=0; i<arr.length; i++){
            if (!counter.containsKey(arr[i])){
                counter.put(arr[i], 1);
            }else {
                int last = counter.get(arr[i]);
                counter.put(arr[i], last+1);
            }
        }
        return counter.keySet();
    }

    static  class minHeap{
        int size;
        long[] heap;

        public minHeap(int size){
            this.size = size;
            heap = new long[size];
        }

        private int parent(int pos) {
            return pos / 2;
        }

        private void swap(int i1, int i2){
            long tmp = heap[i1];
            heap[i1] = heap[i2];
            heap[i2] = tmp;
        }

        void insert(Long number){
            size++;
            heap[size] = number;
            int current = size;
            while (heap[current] < heap[parent(current)]){
                swap(current, parent(current));
                current = parent(current);
            }
        }
    }

    public static void main(String[] args){
        // find the 11st largest number
        long[] arr = new long[100000];
        Set<Long> set = arrayToUnique(arr);
        minHeap heap = new minHeap(11);
        for (Long number: set) {
            heap.insert(number);
        }
    }
}
