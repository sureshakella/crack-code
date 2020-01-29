package tree;

import java.util.LinkedList;
import java.util.Queue;

import static java.util.Objects.nonNull;

public class BFSRecursiveTraversal extends BFSTraversal {
    Queue queue = new LinkedList();

    @Override
    public void traverse(Node root) {
        if (nonNull(root)) {
            queue.add(root);
            System.out.println(root.getData());
            while (!queue.isEmpty())    {

            }
        }
    }
}
