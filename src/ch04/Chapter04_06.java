package ch04;

/**
 * Created by almer on 27/08/16.
 */
public class Chapter04_06 {

    static class BTNodeWithParent extends BTNode {

        BTNodeWithParent parent;

        BTNodeWithParent(int data) {
            super(data);
        }
    }

    static BTNode successor(BTNodeWithParent node) {
        if (node.right != null) {
            return node.right;
        }

        while (node.parent != null) {
            if (node == node.parent.left) {
                return node.parent;
            }
            node = node.parent;
        }
        return null;
    }

    public static void main(String[] args) {
        //     8
        //    /  \
        //   4    10
        //  / \     \
        // 2   6     20

        BTNodeWithParent eight = new BTNodeWithParent(8);
        BTNodeWithParent four = new BTNodeWithParent(4);
        BTNodeWithParent ten = new BTNodeWithParent(10);
        BTNodeWithParent two = new BTNodeWithParent(2);
        BTNodeWithParent six = new BTNodeWithParent(6);
        BTNodeWithParent twenty = new BTNodeWithParent(20);

        eight.left = four;
        eight.right = ten;

        four.left = two;
        four.right = six;
        four.parent = eight;

        ten.right = twenty;
        ten.parent = eight;

        two.parent = four;
        six.parent = four;

        twenty.parent = ten;

        System.out.println(successor(two) == four);
        System.out.println(successor(four) == six);
        System.out.println(successor(six) == eight);
        System.out.println(successor(eight) == ten);
        System.out.println(successor(ten) == twenty);
        System.out.println(successor(twenty) == null);
    }
}
