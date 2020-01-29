package fornow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTLevelOrderTraversal {
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int _val) {
            this.val = _val;
        }
    }

    public static void main(String[] args) {
        levelOrder(null).forEach(each -> each.forEach(System.out::println));
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if (root!= null) q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> eachLevel = new ArrayList<>();
            for (int i=0; i<size; i++) {
                Node curr = q.remove();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                eachLevel.add(curr.val);
            }
            if (!eachLevel.isEmpty()) res.add(eachLevel);
        }
        return res;
    }
}
