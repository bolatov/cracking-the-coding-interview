package ch04;

/**
 * Binary Tree Node
 *
 * Created by almer on 27/08/16.
 */
public class BTNode {

    public int data;

    BTNode left;

    BTNode right;

    BTNode(int data) {
        this.data = data;
    }

    static void inOrder(BTNode root) {
        System.out.print("[ ");
        _inOrder(root);
        System.out.println("]");
    }

    static void _inOrder(BTNode root) {
        if (root == null) {
            return;
        }
        _inOrder(root.left);
        System.out.print(root.data + " ");
        _inOrder(root.right);
    }

//    boolean isLeaf() {
//        return left == null && right == null;
//    }
}
