package Algorithm;

/**
 *
 * Created by tonytan on 23/4/2017.
 */
public class ReverseListNode {

    static ListNode reverseListNode(ListNode node){
        if (node == null){
            System.out.println("null node");
            return null;
        }
        if (node.getNext() == null) {
            return node;
        }

        ListNode current = node;
        ListNode reverseHead =  null;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.getNext();

            if (next == null) {
                reverseHead = current;
            }

            current.next = previous;
            previous = current;
            current = next;
        }
        System.out.println(reverseHead.getValue());
        return reverseHead;
    }
}
