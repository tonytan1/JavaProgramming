package Algorithm;

/**
 *
 * Created by tonytan on 23/4/2017.
 */
public class FindSubTree {

    static boolean hasSubTree (TreeNode source, TreeNode target) {

        boolean result = false;
        if (source != null && target != null) {
            if (source.getValue() == target.getValue()){
                result = isSubTree(source, target);//isSubTree
            }
            if (!result) {
                result = hasSubTree(source.getLeftNode(), target);
            }

            if (!result) {
                result = hasSubTree(source.getRightNode(), target);
            }
        }

        return result;
    }

    static boolean isSubTree(TreeNode source, TreeNode target) {
        if (target == null){ // 终止条件是target tree 已经比较完毕,
            return true;
        }

        if (source == null){
            return false;
        }

        boolean right = false;
        boolean left = false;
        if (source.getValue() == target.getValue()){
            System.out.println("compare subtree:" + source.getValue());
            right = isSubTree(source.getRightNode(), target.getRightNode());
            left = isSubTree(source.getLeftNode(), target.getLeftNode());
        }

        return left && right;
    }

    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);
        tree.setLeftNode(new TreeNode(2));
        tree.setRightNode(new TreeNode(3));
        tree.getLeftNode().setRightNode(new TreeNode(4));
        tree.getLeftNode().setLeftNode(new TreeNode(5));

        TreeNode target = new TreeNode(2);
        target.setLeftNode(new TreeNode(5));
        target.setRightNode(new TreeNode(4));

        System.out.println(hasSubTree(tree, target));
    }
}
