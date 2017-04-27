package Algorithm;

/**
 *
 * Created by tonytan on 23/4/2017.
 */
public class MirrorTree {

    static void mirrorTree(TreeNode tree) {
        if (tree == null){
            return;
        }

        if (tree.getLeftNode() == null && tree.getRightNode() == null){
            return;
        }

        TreeNode tmp = tree.getRightNode();
        tree.rightNode = tree.getLeftNode();
        tree.leftNode = tmp;

        if (tree.getLeftNode() != null) {
            mirrorTree(tree.getLeftNode());
        }
        if (tree.getRightNode() != null) {
            mirrorTree(tree.getRightNode());
        }

    }
}
