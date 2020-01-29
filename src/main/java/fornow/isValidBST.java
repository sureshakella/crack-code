package fornow;

import java.util.Stack;

//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//        Assume a BST is defined as follows:
//
//        The left subtree of a node contains only nodes with keys less than the node's key.
//        The right subtree of a node contains only nodes with keys greater than the node's key.
//        Both the left and right subtrees must also be binary search trees.
//        Example 1:
//
//        Input:
//        2
//        / \
//        1   3
//        Output: true
//        Example 2:
//
//        5
//        / \
//        1   4
//        / \
//        3   6
//        Output: false
//        Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
//        is 5 but its right child's value is 4.
public class isValidBST {

    static class Node {
        int val;
        Node left;
        Node right;
        Node(int _val) { this.val = _val; }
    }

    public static void main(String[] args) {
        System.out.println(isValidBST(null));   //TODO: Populate actuall tree and pass it's root
    }

    public static boolean isValidBST(Node root) {
        Stack<Node> stack = new Stack<>();
        double value = - Double.MAX_VALUE;
        while(!stack.isEmpty() || root != null) {
            if(root!= null)  {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                if (value >= root.val) return false;
                value = root.val;
                root = root.right;
            }
        }
        return true;
    }
}