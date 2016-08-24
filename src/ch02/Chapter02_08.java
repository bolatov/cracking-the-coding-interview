package ch02;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by almer on 23/08/16.
 */
public class Chapter02_08 {

    boolean hasLoop(Node head) {
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    Node detectLoop(Node head) {
        if (!hasLoop(head)) {
            return null;
        }

        Node slow = head, fast = head.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        e.next = c;
        Chapter02_08 ch = new Chapter02_08();
        Node loopStart = ch.detectLoop(a);
        System.out.println(loopStart == null ? "NO LOOP" : loopStart.data);
    }
}
