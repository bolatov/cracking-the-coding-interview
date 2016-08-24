package ch02;

/**
 * Created by almer on 23/08/16.
 */
public class Chapter02_06 {

    Node reverse(Node node) {
        Node head = null;
        while (node != null) {
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    boolean isPalindrome(Node head) {
        Node rev = reverse(head);
        for (; head != null && rev != null; head = head.next, rev = rev.next) {
            if (head.data != rev.data) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node node = Node.toLinkedList(new int[]{1, 2, 2, 2, 2});
        Chapter02_06 ch = new Chapter02_06();
        System.out.println(ch.isPalindrome(node));
    }
}
