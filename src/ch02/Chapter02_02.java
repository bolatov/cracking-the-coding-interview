package ch02;

/**
 * Created by almer on 22/08/16.
 */
public class Chapter02_02 {

    // Returns length of a linked list
    int len(Node head) {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }

    Node kthToLast(Node head, int k) {

        if (len(head) < k || k < 0) {
            throw new IllegalArgumentException("Argument k is invalid");
        }

        Node slow = head, fast = head;

        // Move fast pointer forward for k positions
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // Move both pointers till fast pointer reaches the end
        // of the linked list
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
