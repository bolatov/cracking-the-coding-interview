package ch04;

/**
 * Created by almer on 27/08/16.
 */
public class Chapter04_04 {

    static int depth(BTNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    static boolean isBalanced(BTNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }
}
