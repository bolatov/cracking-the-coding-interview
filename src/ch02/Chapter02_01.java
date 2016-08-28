package ch02;

/**
 * Created by almer on 18/08/16.
 */
public class Chapter02_01 {

    static Node removeDuplicates(Node head) {
        if (head == null) {
            return head;
        }

        while (head.next != null && head.data == head.next.data) {
            head.next = head.next.next;
        }
        head.next = removeDuplicates(head.next);
        return head;
    }

    public static void main(String[] args) {
        Node head = Node.toLinkedList(new int[]{1, 1});
        head = removeDuplicates(head);
        Node.printNode(head);
    }
}
