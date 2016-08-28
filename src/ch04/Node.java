package ch04;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by almer on 27/08/16.
 */
public class Node {

    public String name;

    public Set<Node> children;

    public Node(String name) {
        this.name = name;
        this.children = new HashSet<>();
    }

}
