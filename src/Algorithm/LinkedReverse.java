package Algorithm;

/**
 * Created by tonytan on 18/12/2016.
 */
public class LinkedReverse {

    private class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node reverse(Node node){
        Node p1, p2 = null;
        p1 = node;

        while(node.next != null){
            p2 = node.next;
            node.next = p2.next;
            p2.next = p1;
            p1 = p2;
        }
        return p2;
    }

    // remove duplicated node without buffer(double pointer)
    public static void removeDuplicatedNode(Node node){
        Node head = node;
        Node runner = node.next;

        while (runner != null){
            if (runner.value == head.value){
                head.next = runner.next;
            }else {
                head = runner;
            }
            runner = runner.next;
        }
    }

    public static void main(String[] args){
        LinkedReverse lr = new LinkedReverse();
        Node head, tail;
        head = tail = lr.new Node(0);
        for (int i = 1; i < 10; i++) {
            Node p = lr.new Node(i<5?1:2);
            head.next = p;
            head = p;
        }
        head = tail;
        System.out.print(head.value+"www");
        head = reverse(head);
        removeDuplicatedNode(head);
        while(head.next!=null){
            System.out.print(head.value);
            head = head.next;
        }
    }
}
