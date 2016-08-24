package ch02;

/**
 * Created by almer on 22/08/16.
 */
public class Chapter02_03 {

    void deleteMiddleNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Node a = new Node(1); // A
        Node b = new Node(2); // B
        Node c = new Node(3); // C
        Node d = new Node(4); // D
        Node e = new Node(5); // E
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Chapter02_03 ch = new Chapter02_03();
        ch.deleteMiddleNode(d);
        Node.printNode(a);
    }
}
