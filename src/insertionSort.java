/**
 * Created by tonytan on 25/5/15.
 */
public class insertionSort {
    public static void insertionSort(int[] list){
        int itemToInsert;
        int j;

        for (int i=1; i<list.length; i++){
            itemToInsert = list[i];
            for(j=i; j>0 && itemToInsert<list[j-1];j--){
                list[j] = list[j-1];
            }
            list[j] = itemToInsert;
        }
    }
}
