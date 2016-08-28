package ch04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by almer on 27/08/16.
 */
public class Chapter04_03 {

    private static class QueueElement {
        BTNode node;

        int level;

        QueueElement(BTNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static List<List<BTNode>> listOfDepths(BTNode root) {
        List<List<BTNode>> nodesAtLevels = new ArrayList<>();

        if (root == null) {
            return nodesAtLevels;
        }

        Queue<QueueElement> queue = new LinkedList<>();
        queue.add(new QueueElement(root, 1));
        while (!queue.isEmpty()) {
            QueueElement element = queue.poll();
            BTNode node = element.node;
            if (nodesAtLevels.size() < element.level) {
                nodesAtLevels.add(new ArrayList<>());
            }
            nodesAtLevels.get(element.level).add(node);
            if (node.left != null) {
                queue.add(new QueueElement(node.left, element.level + 1));
            }
            if (node.right != null) {
                queue.add(new QueueElement(node.right, element.level + 1));
            }
        }

        return nodesAtLevels;
    }
}
