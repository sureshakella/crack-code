package tree;

import java.util.Random;

//Basic flow for AVL Insert - Happens inside recursion
//Find out where to insert (based on BST property) and insert new node.
//  While inserting determine it's height. Typically -1 as it's new node
//Then go back to it's root
//  Find the balance of it's root (left tree - right tree)
//      3 possibilities
//      0 - Awesome. The inserted node made it balanced. Set it's height. You are good
//      >1 - Left subtree is skewed
//            Check if it's Left-Left skewed Or Left-Right skewed (comparing height of `left.left` and `left.right` tree)
//              If Left-Left skewed; then you will perform right rotation of the `root`
//              If Left-Right skewed; then you will perform left rotation `root.left` followed by right rotation `root`
//      <-1 - Right subtree is skewed
//            Check if it's Right-Left skewed Or Right-Right skewed (comparing height of `right.left` and `right.right` tree)
//              If Right-Right skewed; then you will perform a left rotation of the `root`
public class AVLTreeInsert {
    static class Node {
        int val;
        Node left;
        Node right;
        int height;
        Node (int _val) { this.val = _val; }
    }

    public static void main(String[] args) {
        Node root = null;
        Node head = null;
        Random rand = new Random();
        for(int i=0; i<10; i++) {
            root = insert(root, rand.nextInt(50));
            if (i == 0) head = root;
        }
        printAVLTreeInOrder(root);
    }

    private static void printAVLTreeInOrder(Node root) {
        if(root == null) return;
        System.out.print(root.val + "==>");
        printAVLTreeInOrder(root.left);
        printAVLTreeInOrder(root.right);
    }

    private static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            root.left = null;
            root.right = null;
            root.height = setHeight(root);
            return  root;
        }

        if (val <= root.val) {
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }

        int balance = height(root.left) - height(root.right);
        if(balance > 1) {
            if( height(root.left.left) >= height(root.left.right))  //Left-Left case
                root = rightRotation(root);
            else {                                                  //Left-Right case

                root.left = leftRotation(root.left);
                root = rightRotation(root);
            }
        }
        else if (balance < -1) {
            if( height(root.right.right) >= height(root.right.left))    //Right-Left case
                root = leftRotation(root);
            else {                                                      //Right-Right case
                root.right = rightRotation(root.right);
                root = leftRotation(root);
            }
        }
        else {
            root.height = setHeight(root);
        }

        return root;
    }

    private static int height(Node node) {
        return node!=null ? node.height : -1;
    }

    private static int setHeight(Node node) {
        return node != null ? 1 + Math.max(height(node.left), height(node.right)) : -1;
    }
    private static Node rightRotation(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;
    }

    private static Node leftRotation(Node root) { //Meaning you would add node on left or right node becomes root
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;
    }
}
//
//    static Node insert(Node root,int val) {
//        if(root == null) {
//            root = new Node();
//            root.val = val;
//            root.ht = setHeight(root);
//            return root;
//        }
//        if(val <= root.val) {
//            root.left = insert(root.left, val);
//        }
//        else if (val > root.val) {
//            root.right = insert(root.right, val);
//        }
//        int balance = height(root.left) - height(root.right);
//
//        if(balance > 1) {
//            if(height(root.left.left) >= height(root.left.right)) {
//                root = rightRotation(root);
//            }
//            else {
//                root.left = leftRotation(root.left);
//                root = rightRotation(root);
//            }
//        }
//        else if(balance < -1) {
//            if(height(root.right.right) >= height(root.right.left)) {
//                root = leftRotation(root);
//            }
//            else {
//                root.right = rightRotation(root.right);
//                root = leftRotation(root);
//            }
//        }
//        else {
//            root.ht = setHeight(root);
//        }
//        return root;
//    }
//
//    private static Node rightRotation(Node root) {
//        Node newRoot = root.left;
//        root.left = newRoot.right;
//        newRoot.right = root;
//        root.ht = setHeight(root);
//        newRoot.ht = setHeight(newRoot);
//        return newRoot;
//    }
//
//    private static Node leftRotation(Node root) {
//        Node newRoot = root.right;
//        root.right = newRoot.left;
//        newRoot.left = root;
//        root.ht = setHeight(root);
//        newRoot.ht = setHeight(newRoot);
//        return newRoot;
//    }
//
//    private static int height(Node root) {
//        if(root == null)
//            return -1;
//        else
//            return root.ht;
//    }
//
//    private static int setHeight(Node root) {
//        if(root == null) {
//            return -1;
//        }
//        else {
//            return 1 + Math.max(height(root.left), height(root.right));
//        }
//    }