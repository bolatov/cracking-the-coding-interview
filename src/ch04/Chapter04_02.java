package ch04;

/**
 * Created by almer on 27/08/16.
 */
public class Chapter04_02 {

    /**
     * Creates a binary search tree with minimal height.
     * @param array - a sorted (increasing order) array with unique integer elements.
     * @return root node of a binary search tree.
     */
    public static BTNode minimalTree(int[] array) {
        if (array == null || array.length < 1) {
            throw new IllegalArgumentException("Array argument cannot be null");
        }
        return _minimalTree(array, 0, array.length - 1);
    }

    private static BTNode _minimalTree(int[] array, int lo, int hi) {
        if (lo > hi) {
            return null;
        } else if (lo == hi) {
            return new BTNode(array[lo]);
        }
        int mid = lo + (hi - lo) / 2;
        BTNode root = new BTNode(array[mid]);
        root.left = _minimalTree(array, lo, mid - 1);
        root.right = _minimalTree(array, mid + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        test(1);
        test(10);
        test(13);
        test(20);
    }

    static void test(final int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        BTNode BTNode = minimalTree(array);
        BTNode.inOrder(BTNode);
    }
}
