package fornow;

import java.util.*;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class DistanceBetweenBSTNodes {
    static class Node<T extends Comparable<T>>{
        T item;
        Node<T> left;
        Node<T> right;
        Node(T item)    {
            this.item = item;
            left = right = null;
        }

        public void addNode(T item) {
            if(item.compareTo(this.item) < 0) {
                if (nonNull(this.left)) {
                    this.left.addNode(item);
                } else {
                    this.left = new Node<>(item);
                }
            }
            if(item.compareTo(this.item) >= 0) {
                if (nonNull(this.right)) {
                    this.right.addNode(item);
                } else {
                    this.right = new Node<>(item);
                }
            }
        }
    }

    public static void main(String[] args)  {
        Node root = createSequentialBST();
        printInOrder(root);
        printBFS(root);

        int NODE_1 = 13;
        int NODE_2 = 12;
        Node ancestor = getCommonParent(root, NODE_1, NODE_2);
        System.out.println();
        if(nonNull(ancestor)) {
            System.out.println("Common Parent is : " + ancestor.item);
            int dist = getDistanceFromCommonParent(ancestor, NODE_1, 0) +
                    getDistanceFromCommonParent(ancestor, NODE_2, 0);
            if (dist > 0) {
                System.out.print("Distance between Node " + NODE_1 + " and Node " + NODE_2 + " is: " + dist);
            }
            else {
                int donotExist = (ancestor.item.compareTo(NODE_1) == 0) ? NODE_2 :
                        (ancestor.item.compareTo(NODE_2) == 0) ? NODE_1 : -99;
                System.out.println("Dude!! Item " + donotExist + " doesn't exit in Tree");
            }
        }
        else System.out.println("Apparently no common parent between nodes. Are you sure the items exist in Tree?");
    }

    private static Node createSequentialBST()   {
        Node root = new Node<>(5);
        Node tail = root;
        for(int i=0; i < 10; i=i+1)   {
            if (i==4) continue;
            tail.addNode(i +1);
        }
        return root;
    }

    private static Node createRandomBinarySearchTree()   {
        int MAX_BOUND = 25;
        Random rand =new Random();
        Set<Integer> allVal = new HashSet<>();
        int rootVal = rand.nextInt(MAX_BOUND) + 1;
        allVal.add(rootVal);
        Node root = new Node<>(rootVal);
        Node tail = root;
        int eachVal = rootVal;
        for(int i=0; i < 10; i=i+1)   {
            while (allVal.contains(eachVal)) {eachVal = rand.nextInt(MAX_BOUND) + 1;}
            tail.addNode(eachVal);
            allVal.add(eachVal);
        }
        return root;
    }

    private static void printBFS(Node root)    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.println();
        System.out.print("BFS Traversal -- ");
        while(!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print("Node:" + current.item);
            if(nonNull(current.left))   {
                queue.add(current.left);
            }
            if(nonNull(current.right))  {
                queue.add(current.right);
            }
            if(!queue.isEmpty()) System.out.print(" ==> ");
        }
    }

    private static void printInOrder(Node root)    {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        System.out.print("DFS InOrder Traversal -- ");
        while(!stack.isEmpty() || nonNull(current))   {
            if(nonNull(current))    {
                stack.push(current);
                current = current.left;
            }
            else {
                Node<Integer> processNode = stack.pop();
                System.out.print("Node:" + processNode.item + " ==> ");
                current = processNode.right;
            }
        }
    }

    private static Node getCommonParent(Node root, Integer item1, Integer item2) {
        if(isNull(root))    {
            return null;
        }
        else if (root.item == item1 || root.item == item2)  {
            return root;
        }
        Node left = getCommonParent(root.left, item1, item2);
        Node right = getCommonParent(root.right, item1, item2);
        if (nonNull(left) && nonNull(right))   {
            return root;
        }
        if(isNull(left)) return right;
        else return left;
    }

    private static int getDistanceFromCommonParent(Node ancestor, Integer item, int distance) {
        if (isNull(ancestor)) {
            return -1;
        } else if (ancestor.item == item)  {
            return distance;
        }
        else if ((nonNull(ancestor.left) && ancestor.left.item == item) ||
                (nonNull(ancestor.right) && ancestor.right.item == item))   {
            distance = distance + 1;
            return distance;
        }
        else {
            distance += 1;
            if (ancestor.item.compareTo(item) >= 0)
                return getDistanceFromCommonParent(ancestor.left, item, distance);
            else
                return getDistanceFromCommonParent(ancestor.right, item, distance);
        }
    }
}
