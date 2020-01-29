package fornow.dcp;

import java.util.Random;

import static java.util.Objects.nonNull;

public class P26_RemoveKthNodeFromLL {
    static class Node<T> {
        T item;
        Node<T> next;
        Node(T _item) {
            this.item = _item;
        }
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        Node<Integer> tail = node;
        for(int i=2;i<1001;i++) {
            Node<Integer> curr = new Node<>(i);
            tail.next = curr;
            tail = tail.next;
        }
        printLL(node);
        Random rand = new Random();
        int k = rand.nextInt(1000)+1;
        System.out.println();
        System.out.println("Remove Kth element at :" + k);
        removeKthNode(k, node);
        printLL(node);
    }

    private static <T> Node<T> removeKthNode(int K, Node<T> root) {
        Node<T> curr = root;
        Node<T> slowNode = curr;
        int i=0;
        while (nonNull(curr)) {
            if (i++ > K) {
               slowNode = slowNode.next;
            }
            curr = curr.next;
        }
        if(nonNull(slowNode.next) && nonNull(slowNode.next.next)) {
            slowNode.next = (slowNode.next.next);
        }
        return root;
    }

    private static void printLL(Node root) {
        while (nonNull(root)) {
            System.out.print(root.item + (nonNull(root.next)? "=>" : ""));
            root = root.next;
        }
    }
}
