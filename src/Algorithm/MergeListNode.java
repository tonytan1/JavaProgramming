package Algorithm;

import java.util.List;

/**
 * merge two listnode
 * Created by tonytan on 23/4/2017.
 */
public class MergeListNode {

    static ListNode mergeListNode(ListNode listNode1, ListNode listNode2){
        if (listNode1 == null) {
            return listNode2;
        }

        if (listNode2 == null) {
            return listNode1;
        }
        ListNode mergedListNode = null;

        if (listNode1.getValue() <= listNode2.getValue()){
            mergedListNode = listNode1;
            mergedListNode.next = mergeListNode(listNode1.getNext(), listNode2);
        }else {
            mergedListNode = listNode2;
            mergedListNode.next = mergeListNode(listNode1, listNode2.getNext());
        }
        return mergedListNode;
    }
}
