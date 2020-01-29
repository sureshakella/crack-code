package fornow;

import java.util.*;

//Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
//
//        Example:
//
//        Input: 3
//        Output:
//        [
//        [1,null,3,2],
//        [3,2,null,1],
//        [3,1,null,null,2],
//        [2,1,3],
//        [1,null,2,null,3]
//        ]
//        Explanation:
//        The above output corresponds to the 5 unique BST's shown below:
//
//        1         3     3      2      1
//        \       /     /      / \      \
//        3     2     1      1   3      2
//        /     /       \                 \
//        2     1         2                 3
public class GenerateUniqueBSTs {
    static class Node<T> {
        T item;
        Node<T> left;
        Node<T> right;
        Node(T _val) { this.item = _val; }

        @Override
        public String toString() {  //PreOrder traversal
            Node<T> curr = this;
            Stack<Node> s = new Stack<>();
            s.add(curr);
            List<T> list = new ArrayList<>();
            while (!s.isEmpty()) {
                curr = s.pop();
                list.add(curr.item);
                if (curr.right != null) s.push(curr.right);
                if (curr.left != null) s.push(curr.left);
            }
            return Arrays.toString(list.toArray());
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateUniqBST(1, 3).toArray()));
    }

    public static <T> List<Node<T>> generateUniqBST(int start, int end) {
        List<Node<T>> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for(int i=start; i<=end; i++) {
            List<Node<T>> leftSubTree = generateUniqBST(start, i-1);
            List<Node<T>> rightSubTree = generateUniqBST(i+1, end);
            for(Node<T> left: leftSubTree) {
                for (Node<T> right: rightSubTree) {
                    Node<Integer> root = new Node<>(i);
                    root.left = (Node<Integer>) left;
                    root.right = (Node<Integer>) right;
                    result.add((Node<T>) root);
                }
            }
        }
        return result;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//class Solution {
//    public List<TreeNode> generateTrees(int n) {
//        return n>=1 ? genereateUniqBST(1,n) : Collections.EMPTY_LIST;
//    }
//
//    public List<TreeNode> genereateUniqBST(int start, int end) {
//        List<TreeNode> res = new LinkedList<>();
//        if (start > end) {
//            res.add(null);
//            return res;
//        }
//
//        for (int i=start; i<=end; i++) {
//            List<TreeNode> leftSubTrees = genereateUniqBST(start, i-1);
//            List<TreeNode> rightSubTrees = genereateUniqBST(i+1, end);
//
//            for(TreeNode left: leftSubTrees) {
//                for (TreeNode right: rightSubTrees) {
//                    TreeNode root = new TreeNode(i);
//                    root.left = left;
//                    root.right = right;
//                    res.add(root);
//                }
//            }
//        }
//        return res;
//    }
//}