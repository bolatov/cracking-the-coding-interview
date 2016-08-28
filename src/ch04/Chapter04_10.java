package ch04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by almer on 28/08/16.
 */
public class Chapter04_10 {

    static boolean checkSubtree(BTNode t1, BTNode t2) {
        // Traverse T1 with BFS. If a descendant node of T1 is equal to T2,
        // then check T1's subtree.

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(t1);
        while (!queue.isEmpty()) {
            BTNode node = queue.poll();
            if (node.data == t2.data && _check(node, t2)) {
                return true;
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return false;
    }

    static boolean _check(BTNode n, BTNode m) {
        if (n == m) { // both are null or both are the same object
            return true;
        } else if (n == null || m == null) {
            return false;
        }

        return n.data == m.data && _check(n.left, m.left) && _check(n.right, m.right);
    }
}
