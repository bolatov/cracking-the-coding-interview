package ch04;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by almer on 27/08/16.
 */
public class Chapter04_01 {

    boolean routeBetweenNodes(Graph g, Node a, Node b) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        for (Node node : g.nodes) {
            visited.clear();
            queue.clear();

            queue.add(node);
            visited.add(node);
            while (!queue.isEmpty()) {
                Node n = queue.poll();
                for (Node child : n.children) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        queue.add(child);
                    }
                }
            }

            if (visited.contains(a) && visited.contains(b)) {
                return true;
            }
        }
        return false;
    }
}
