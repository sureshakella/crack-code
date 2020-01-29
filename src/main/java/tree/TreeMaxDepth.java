package tree;

import java.util.Random;

public class TreeMaxDepth {
    static class Node<T> {
        T item;
        Node<T> left;
        Node<T> right;
        Node(T item) {  this.item = item; }
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        Node<Integer> tail = root;
        Random rand = new Random();
        boolean flip = true;
        for(int i=1; i<10; i=i+2) {
            tail.left = new Node<>(i + 1);
            tail.right = new Node<>(i + 2);
            tail = flip ? tail.left : tail.right;
            flip = !flip;
        }

        System.out.println(recursiveMaxDepth(0, root));
        System.out.println(recursiveSimplified(root));
    }

    public static <T> int recursiveSimplified(Node<T> root) {
        if (root == null) {
            return 0;
        }
        int a = recursiveSimplified(root.left);
        int b = recursiveSimplified(root.right);

        return 1 + Math.max(a, b);
    }

    public static <T> int recursiveMaxDepth(int depth, Node<T> root) {
        int max = 0;
        if (root == null) return depth ;
        else if (root.left == null & root.right == null) return depth + 1;
        if (root.left != null) {
            int tmp = recursiveMaxDepth(depth + 1, root.left);
            if (max < tmp) max = tmp;
        }
        if (root.right != null) {
            int tmp = recursiveMaxDepth(depth + 1, root.right);
            if (max < tmp) max = tmp;
        }
        return max;
    }
}
