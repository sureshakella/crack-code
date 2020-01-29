package tree;

import com.sun.istack.internal.Nullable;

import java.util.Arrays;
import java.util.List;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> right;
    private Node<T> left;

    Node(T input)   {
        this(input, null, null);
    }

    Node(T input, @Nullable Node left, @Nullable Node right)    {
        this.data = input;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> node)   {
        this.left = node;
    }

    public void setRight(Node<T> node)  {
        this.right = node;
    }

    @Override
    public String toString() {
        return getData().toString();
    }

    public List<Node> getChildren() {
        return Arrays.asList(getLeft(), getRight());
    }
}
