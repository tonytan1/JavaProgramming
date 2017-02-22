package DataStructure;

import java.util.ArrayDeque;

/**
 * Created by tonytan on 21/10/2016.
 */
public class BinaryTree {

    class TreeNode<T> {
        private T data;
        private TreeNode<T> leftNode;
        private TreeNode<T> rightNode;

        public TreeNode(T data, TreeNode<T> leftNode, TreeNode<T> rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public TreeNode<T> getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode<T> leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode<T> getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode<T> rightNode) {
            this.rightNode = rightNode;
        }
    }

    public void printNode(TreeNode<String> node) {
        System.out.print(node.getData() + "  ");
    }

    //  Tree iteration include DFS and BFS. DFS include pre-order, in-order and post-order.
    //  These are all can be implemented by recursive method.

    /*DFS: pre-order, root first then the children*/
    public void preOderIterator(TreeNode<String> tree){
        this.printNode(tree);//先
        if (tree.getLeftNode()!=null){
            this.preOderIterator(tree.getLeftNode());
        }
        if (tree.getRightNode()!=null){
            this.preOderIterator(tree.getRightNode());
        }
    }

    /*DFS: in-order, left first then the root, last right*/
    public void inOderIterator(TreeNode<String> tree){
        if (tree.getLeftNode()!=null){
            this.inOderIterator(tree.getLeftNode());
        }
        this.printNode(tree);//中
        if (tree.getRightNode()!=null){
            this.inOderIterator(tree.getRightNode());
        }
    }

    /*DFS: post-order, children fist and then root*/
    public void postOderIterator(TreeNode<String> tree){
        if (tree.getLeftNode()!=null){
            this.postOderIterator(tree.getLeftNode());
        }
        if (tree.getRightNode()!=null){
            this.postOderIterator(tree.getRightNode());
        }
        this.printNode(tree);//后
    }

    /*BFS: Breadth-first-search*/
    public void bfsIterator(TreeNode<String> tree){
        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.add(tree);
        while(queue.isEmpty() == false){
            this.printNode(tree);
            if (tree.getLeftNode()!=null){
                queue.add(tree.getLeftNode());
            }
            if (tree.getRightNode()!=null){
                queue.add(tree.getRightNode());
            }
        }
    }
}
