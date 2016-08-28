package ch04;

/**
 * Created by almer on 27/08/16.
 */
public class Chapter04_05 {

    static boolean isValidBST(BTNode root) {
        if (root == null) {
            return true;
        }

        // Left child data has to be less than current node's data
        if (root.left != null && root.left.data > root.data) {
            return false;
        }

        // Right child data has to be greater than current node's data
        if (root.right != null && root.right.data < root.data) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
}
