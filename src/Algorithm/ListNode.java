package Algorithm;

/**
 * Created by tonytan on 23/4/2017.
 */
public class ListNode {
    int value;
    ListNode next;

    ListNode(int value){
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }


}
