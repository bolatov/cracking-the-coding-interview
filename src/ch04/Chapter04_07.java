package ch04;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by almer on 27/08/16.
 */
public class Chapter04_07 {

    static List<Node> buildOrder(Set<Node> projects, List<Pair<Node, Node>> dependencies) {
        Graph graph = new Graph();
        for (Pair<Node, Node> pair : dependencies) {
            pair.getValue().children.add(pair.getKey());
        }

        projects.forEach(node -> graph.nodes.add(node));
        return topologicalSort(graph);
    }

    /**
     * Topological sort
     *
     * @param graph
     * @return
     */
    static List<Node> topologicalSort(Graph graph) {
       if (isCyclic(graph)) {
           throw new IllegalArgumentException("Build order cannot be done. Graph contains is not acyclic");
       }
        Set<Node> visited = new HashSet<>();
        Stack<Node> sorted = new Stack<>();
        for (Node node : graph.nodes) {
            dfs(node, visited, sorted);
        }
        List<Node> ordered = new ArrayList<>();
        sorted.forEach(ordered::add);
        return ordered;
    }

    /**
     * Bellman-Ford algorithm to check for cycles in graph
     * @param graph
     * @return True if graph contains a cycle, False otherwise.
     */
    static boolean isCyclic(Graph graph) {
//        TODO: Implement
        return false;
    }

    static void dfs(Node node, Set<Node> visited, Stack<Node> sorted) {
        if (!visited.contains(node)) {
            visited.add(node);
            for (Node child : node.children) {
                dfs(child, visited, sorted);
            }
            sorted.add(node);
        }
    }

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Set<Node> projects =
                Stream
                        .of(a, b, c, d, e, f)
                        .collect(Collectors.toSet());
        new Pair<>(a, d);
        List<Pair<Node, Node>> dependencies =
                Stream
                    .of(new Pair<>(a, d),
                            new Pair<>(f, b),
                            new Pair<>(b, d),
                            new Pair<>(f, a),
                            new Pair<>(d, c))
                    .collect(Collectors.toList());
        for (Node node : buildOrder(projects, dependencies)) {
            System.out.println(node.name);
        }
    }
}
