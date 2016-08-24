package ch02;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by almer on 23/08/16.
 */
public class Chapter02_07 {

    Node hasIntersection(Node m, Node n) {
        if (m == null || n == null) {
            throw new IllegalArgumentException("Argument node cannot be null");
        }

        Set<Node> set = new HashSet<>();
        while (m != null) {
            set.add(m);
            m = m.next;
        }
        while (n != null) {
            if (set.contains(n)) {
                return n;
            }
            n = n.next;
        }
        return null;
    }
}
