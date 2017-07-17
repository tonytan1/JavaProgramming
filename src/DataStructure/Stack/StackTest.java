package DataStructure.Stack;

/**
 *  test for stack
 *  Created by tonytan on 20/5/2017.
 */
public class StackTest {
    public static void main(String[] args){
        StackDemo stack = new StackDemo();
        System.out.println("is empty ?"+stack.isEmpty());
        for (int i = 0; i < 12; i++) {
            stack.push(i);
        }
        System.out.println("is empty ?"+stack.isEmpty());
        System.out.println(" first element of stack: "+stack.peek());
        System.out.println(" first element of stack: "+stack.peek());
        for (int i = 0; i < 12; i++) {
            System.out.println(" element of stack: "+stack.pop());
        }
        System.out.println("is empty ?"+stack.isEmpty());
    }
}
