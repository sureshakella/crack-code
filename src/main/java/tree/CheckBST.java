package tree;

import static java.util.Objects.isNull;

public class CheckBST {

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int _val) { this.data = _val; }
    }
    public static void main(String[] args) {
        Node root = null;       //Insert into BST
        System.out.println("Tree is BST : " + checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean checkBST(Node current, int min, int max) {
        if (isNull(current)) return true;
        if(current.data <= min && current.data >= max) return false;
        return checkBST(current.left, min, current.data) && checkBST(current.right, current.data, max);
    }
}