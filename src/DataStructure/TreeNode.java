package DataStructure;

import DataStructure.SelfSimilarityTree.Tree;

import java.util.*;

/**
 * Created by tonytan on 7/1/2017.
 */
public class TreeNode {
    TreeNode leftNode, rightNode;
    int data;
    Boolean isVisited=false;

    public TreeNode(){

    }

    public TreeNode(int value){
        this.data = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right){
        this.data = value;
        this.leftNode = left;
        this.rightNode = right;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public Boolean getVisited() {
        return isVisited;
    }

    public void setVisited(Boolean visited) {
        isVisited = visited;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    //tree is a restricted form of graph. graph have cycles. Both bfs and dfs are available to graph and tree.
    public void dfsTraversal(TreeNode node){
        if (node == null) return;

        node.setVisited(true);

        if (node.getLeftNode() != null){
            this.dfsTraversal(node.getLeftNode());
        }
        if (node.getRightNode() != null){
            this.dfsTraversal(node.getRightNode());
        }
    }

    public void bfsTraversal(TreeNode node){
        if (node == null) return;
        ArrayDeque<TreeNode> current = new ArrayDeque<>();
        current.add(node);
        while (current.isEmpty() == false){
            TreeNode thisnode = current.getLast();
            thisnode.setVisited(true);
            if (thisnode.getLeftNode() != null){
                current.add(thisnode.getLeftNode());
            }
            if (thisnode.getRightNode() != null){
                current.add(thisnode.getRightNode());
            }
        }
    }


    // arr is a sorted array, the method will create a balanced tree  with minimal height.
    public TreeNode addToTree(int arr[], int start, int end){
        if (end<start) return null;

        int mid = (start+end)/2;
        TreeNode node = new TreeNode(mid);
        node.leftNode = addToTree(arr, start, mid-1);
        node.rightNode = addToTree(arr, mid+1, end);

        return node;
    }


    //given a huge tree and small tree, design a program to show if the small tree is the subtree of huge one
    public boolean subtree(TreeNode huge, TreeNode small){
        if (huge == null) return false;

        if (huge.data != small.data) return false;
        else if (huge.data == small.data) {
            if (matchTree(huge, small)) return true;
        }
        return subtree(huge.leftNode, small) || subtree(huge.rightNode, small);
    }

    private boolean matchTree(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null) return true;

        if (node1 == null || node2 == null) return false;

        if (node1.data != node2.data) return false;

        return matchTree(node1.getLeftNode(), node2.getLeftNode())
                &&matchTree(node1.getRightNode(), node2.getRightNode());

    }


    public static void findExpectedSumPath(TreeNode node, int currentSum, int expecSum, ArrayList<TreeNode> pathnodes){
        if (node != null){
            currentSum = currentSum + node.data;
            pathnodes.add(node);

            if (currentSum == expecSum){
                // print all path nodes
                printNodes(pathnodes);
            }else if(currentSum < expecSum){
                findExpectedSumPath(node.getLeftNode(), currentSum, expecSum, pathnodes);
                findExpectedSumPath(node.getRightNode(), currentSum, expecSum, pathnodes);
            }

            pathnodes.remove(pathnodes.size()-1);

        }
    }

    private static void printNodes(List<TreeNode> nodes){
        if (!nodes.isEmpty()){
            for (TreeNode node: nodes) {
                System.out.print(node.data + " - ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(0, new TreeNode(1, new TreeNode(), new TreeNode()), new TreeNode(2, new TreeNode(), new TreeNode()));
        node.getLeftNode().getLeftNode().setData(5);
        node.getLeftNode().getRightNode().setData(6);
        node.getRightNode().getLeftNode().setData(3);
        node.getRightNode().getRightNode().setData(4);

        findExpectedSumPath(node, 0, 6, new ArrayList<TreeNode>());
    }
}
