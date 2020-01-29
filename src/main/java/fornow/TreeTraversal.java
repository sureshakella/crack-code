package fornow;


import java.util.*;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class TreeTraversal {

    static class Node<T> {
        T item;
        Node<T> left;
        Node<T> right;
        Node(T item)    {
            this.item = item;
            left = right = null;
        }
    }

    public static void main(String[] args)  {
        Node<Integer> root = new Node<Integer>(0);
        Node<Integer> end = root;
        boolean flip = true;
        for(int i=0; i<10; i=i+2) {
            end.left = new Node<>(i +1);
            end.right = new Node<>(i + 2);
            end = flip ? end.left : end.right;
            flip = !flip;
        }
        System.out.println("End :" + end.item + "Start :" + root.item);
        printBFS(root);
        System.out.println();
        System.out.println("max Depth :" + recursiveMaxDepth(root));
        printDFSPreOrder(root);
        printDFSInOrder(root);
        printDFSPostOrder(root);
    }

    private static void printBFS(Node<Integer> root)  {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.print("BFS -- ");
        while (!queue.isEmpty())   {
            Node<Integer> current = queue.remove();
            System.out.print("Node:" + current.item);
            if(nonNull(current.left))  {
//                System.out.print("Left:" + current.left.item + " ==>");
                queue.add(current.left);
            }
            if(nonNull(current.right)) {
//                System.out.print("Right:" + current.right.item + " ==>");
                queue.add(current.right);
            }
            if(!queue.isEmpty()) System.out.print(" ==>");
        }
    }

    private static void printDFSPreOrder(Node<Integer> root)    {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        System.out.println();
        System.out.print("DFSPreOrder -- ");
        while (!stack.isEmpty())    {
            Node<Integer> current = stack.pop();
            System.out.print("Node:" + current.item);
            if(nonNull(current.right))   {
                stack.push(current.right);
            }
            if(nonNull(current.left))   {
                stack.push(current.left);
            }
            if(!stack.isEmpty()) System.out.print(" ==>");
        }
    }

    private static void printDFSInOrder(Node<Integer> root) {
        Stack<Node> stack = new Stack<>();
        Node<Integer> current = root;
        System.out.println();
        System.out.print("DFSInOrder -- ");
        while(!stack.isEmpty() || current != null) {
            if(current!= null)  {
                stack.push(current);
                current = current.left;
            }
            else {
                Node<Integer> processNode = stack.pop();
                System.out.print("Node:" + processNode.item + " ==>");
                current = processNode.right;
            }
        }
    }

    private static void recursivePreorder(Node<Integer> root) {
        if (root == null) return ;
        System.out.print("Node:" + root.item + " ==>");
        recursivePreorder(root.left);
        recursivePreorder(root.right);
    }
    private static void recursiveInOrder(Node<Integer> root) {
        if (root == null) return;
        recursiveInOrder(root.left);
        System.out.print("Node:" + root.item + " ==>");
        recursiveInOrder(root.right);
    }

    private static void printDFSPostOrder(Node<Integer> root)   {
        Stack<Node> stack = new Stack<>();
        System.out.println();
        System.out.print("DFSPostOrder -- ");
        stack.push(root);
        while(!stack.isEmpty()) {
            Node<Integer> processNode = stack.peek();
            if(isNull(processNode.right) && isNull(processNode.left)) {
                System.out.print("Node:" + processNode.item);
                stack.pop();
                if(!stack.isEmpty()) System.out.print(" ==>");
            }
            else {
                if(nonNull(processNode.right))  {
                    stack.push(processNode.right);
                    processNode.right = null;
                }
                if(nonNull(processNode.left))   {
                    stack.push(processNode.left);
                    processNode.left = null;
                }
            }
        }
    }

    public static <T> int recursiveMaxDepth(Node<T> root) {
        if (root == null) return 0;
        return 1 + Math.max(recursiveMaxDepth(root.left), recursiveMaxDepth(root.right));
    }
}
