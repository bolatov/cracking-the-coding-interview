package ch02;

/**
 * Created by almer on 18/08/16.
 */
public class Node {
    Node next;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    Node deleteNode(Node head, int d) {
        Node n = head;

        if (n.data == d) {
            return head.next; // moved head
        }

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head; // head didn't change
            }
        }
        return head;
    }

    static Node toLinkedList(int[] arr) {
        if (arr == null || arr.length <= 0) {
            throw new IllegalArgumentException("Array argument has to be non-empty");
        }
        Node head = null, prev = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            Node node = new Node(arr[i]);
            node.next = prev;
            prev = node;
            head = node;
        }
        return head;
    }

    static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
