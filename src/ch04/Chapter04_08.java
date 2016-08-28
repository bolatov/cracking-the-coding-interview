package ch04;

/**
 * Created by almer on 28/08/16.
 */
public class Chapter04_08 {

    /**
     * Finds first (nearest) common ancestor of node a and node b.
     * The following implementation assumes that both nodes a and b exist
     * in the tree.
     * @param a
     * @param b
     * @return
     */
    static BTNode firstCommonAncestor(BTNode root, BTNode a, BTNode b) {
        if (root == null) {
            return null;
        }

        if (root == a || root == b) {
            return root;
        }

        BTNode leftLCA = firstCommonAncestor(root.left, a, b);
        BTNode rightLCA = firstCommonAncestor(root.right, a, b);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        //      1
        //    /   \
        //   2     3
        //  /\     /\
        // 4  5   6  7
        BTNode one = new BTNode(1);
        BTNode two = new BTNode(2);
        BTNode three = new BTNode(3);
        BTNode four = new BTNode(4);
        BTNode five = new BTNode(5);
        BTNode six = new BTNode(6);
        BTNode seven = new BTNode(7);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        System.out.println(firstCommonAncestor(one, four, five) == two);
        System.out.println(firstCommonAncestor(one, four, six) == one);
        System.out.println(firstCommonAncestor(one, three, four) == one);
        System.out.println(firstCommonAncestor(one, two, four) == two);
    }
}
