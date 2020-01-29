package tree;

public interface TreeTraversal<T extends Comparable<T>> {
    void traverse(Node<T> root);
}
