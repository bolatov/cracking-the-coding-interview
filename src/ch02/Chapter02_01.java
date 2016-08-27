package ch02;

/**
 * Created by almer on 18/08/16.
 */
public class Chapter02_01 {

    void removeDups(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node cur = head;
        while (cur != null) {
            Node nxt = cur.next;
            while (nxt != null) {
                if (cur.data == nxt.data) {
                    if (nxt.next == null) {
                        nxt = null;
                        break;
                    } else {
                        nxt.data = nxt.next.data;
                        nxt.next = nxt.next.next;
                    }
                } else {
                    nxt = nxt.next;
                }
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Node head = Node.toLinkedList(new int[]{1, 1});
        Chapter02_01 ch = new Chapter02_01();
        ch.removeDups(head);
        Node.printNode(head);
    }
}
