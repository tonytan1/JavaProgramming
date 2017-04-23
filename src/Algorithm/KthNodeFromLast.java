package Algorithm;

/**
 * Note Points:
 * 1. ListNode cannot be traversed.
 * 2. Defensive programming.
 * Created by tonytan on 22/4/2017.
 */
public class KthNodeFromLast {

    static ListNode getKthNodeFromLast(ListNode node, int k){
        if (node == null) {
            System.out.print("error node");
            return null;
        }

        int nodeLength = 0;
        ListNode initNode = node;
        while (node.getNext() != null) {
            nodeLength++;
            node = node.getNext();
        }

        if (k > nodeLength || k < 1) {
            System.out.print("error k value");
            return null;
        }

        int kthNodeIndex = nodeLength - k + 1;
        int nodeIndex = 0;
        ListNode result = null;
        while (initNode != null){
            if (nodeIndex == kthNodeIndex){
                result = initNode;
            }
            ++nodeIndex;
//            System.out.println(initNode.getValue()); // for test
            initNode = initNode.getNext();
        }
        return result;
    }

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.setNext(new ListNode(2));
        node.getNext().setNext(new ListNode(3));;
        node.getNext().getNext().setNext(new ListNode(4));
        node.getNext().getNext().getNext().setNext(new ListNode(6));
        node.getNext().getNext().getNext().getNext().setNext(new ListNode(7));

        ListNode result = getKthNodeFromLast(node, 3);
        System.out.println(result.value);


    }

}
