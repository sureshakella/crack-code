package fornow;

import java.util.*;

//Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//        For example, given a 3-ary tree
//        We should return its level order traversal:
//
//        [
//        [1],
//        [3,2,4],
//        [5,6]
//        ]
//
//
//        Note:
//
//        The depth of the tree is at most 1000.
//        The total number of nodes is at most 5000.

class NaryTreeLevelOrderTraversal {
    static class Node {
        int val;
        List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        levelOrder(null);
    }

    private static List<List<Integer>> levelOrder(Node root) {
        return iterativeLevelOrder(root);
    }

    private static List<List<Integer>> iterativeLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root!= null) {
            q.add(root);
            res.add(Collections.singletonList(root.val));
        }
        while (!q.isEmpty()) {
            int qsize = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<qsize; i++) {
                Node curr = q.remove();
                for(Node each : curr.children) {
                    q.add(each);
                    level.add(each.val);
                }
            }
            if (!level.isEmpty()) res.add(level);
        }
        return res;
    }
}
