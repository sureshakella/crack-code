package fornow;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

//Given an n-ary tree, return the preorder traversal of its nodes' values.
//For example, given a 3-ary tree:
//Return its preorder traversal as: [1,3,5,6,2,4].

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

class NaryTreeInorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public static void main(String[] args) {
        System.out.println(preorder(null));
    }
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> preorder(Node root) {
        return iterativePreorder(root);
    }

    public static List<Integer> iterativePreorder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty() && root != null) {
            Node curr = stack.pop();
            res.add(curr.val);
            ListIterator itr = curr.children.listIterator(curr.children.size());
            while(itr.hasPrevious()) {
                stack.push((Node)itr.previous());
            }
        }
        return res;
    }

    public static List<Integer> recursivePreorder(Node root) {
        if(root == null) return res;
        res.add(root.val);
        for(Node each : root.children) {
            recursivePreorder(each);
        }
        return res;
    }
}