package ch02;

/**
 * Created by almer on 22/08/16.
 */
public class Chapter02_04 {

    Node find(Node node, int val) {
        if (node == null) {
            return null;
        }
        while (node != null) {
            if (node.data < val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    void partition(Node node, int val) {
        if (node == null) {
            return;
        }

        // TODO: 24/08/16 Implement with two pointers

        while (node != null) {
            if (node.data < val) {
                node = node.next;
            } else {
                Node less = find(node, val);
                if (less == null) {
                    break;
                }
                int t = node.data;
                node.data = less.data;
                less.data = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 5, 10, 2, 1};

        Node head = Node.toLinkedList(arr);

        Chapter02_04 ch = new Chapter02_04();
        ch.partition(head, 5);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
