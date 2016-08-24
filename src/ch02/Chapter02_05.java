package ch02;

/**
 * Created by almer on 22/08/16.
 */
public class Chapter02_05 {

    Node sumLists(Node a, Node b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Any of the arguments cannot be null");
        }
        int q = 0;
        Node sum = null, cur = null;
        while (a != null && b != null) {
            int i = q + (a.data + b.data);
            Node n = new Node(i % 10);
            q = i / 10;
            if (sum == null) {
                sum = n;
                cur = n;
            } else {
                cur.next = n;
                cur = cur.next;
            }
            a = a.next;
            b = b.next;
        }
        while (a != null) {
            int i = q + a.data;
            Node n = new Node(i % 10);
            q = i / 10;
            cur.next = n;
            cur = cur.next;
            a = a.next;
        }
        while (b != null) {
            int i = q + b.data;
            Node n = new Node(i % 10);
            q = i / 10;
            cur.next = n;
            cur = cur.next;
            b = b.next;
        }
        if (q > 0) {
            cur.next = new Node(q);
        }
        return sum;
    }

    public static void main(String[] args) {
        Chapter02_05 ch = new Chapter02_05();
        Node a = Node.toLinkedList(new int[]{9, 7, 8});
        Node b = Node.toLinkedList(new int[]{6, 8, 5});
        Node sum = ch.sumLists(a, b);
        Node.printNode(sum);
    }
}
