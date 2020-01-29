package fornow.linkedlist;

//Given a linked list, swap every two adjacent nodes and return its head.
//You may not modify the values in the list's nodes, only nodes itself may be changed.
//Example:
//Given 1->2->3->4, you should return the list as 2->1->4->3.

import java.util.Random;

import static java.util.Objects.nonNull;

public class SwapPairs {

    static class Node<T> {
        T item;
        Node<T> next;
        Node(T item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        Node<Integer> tail = root;
        Random rand = new Random();
        for(int i=0; i<=10; i++) {
            tail.next = new Node<>(rand.nextInt(20) + 1);
            tail = tail.next;
        }

        printList(root);
        System.out.println();
        printList(swapPairs(root));
    }

    public static <T> Node<T> swapPairs(Node<T> curr) {
        if (curr == null || curr.next == null) return curr;
        Node<T> tmp = curr;
        Node<T> nxt = curr.next;
        curr = nxt;
        tmp.next = nxt.next;
        curr.next = tmp;
        tmp.next = swapPairs(tmp.next);
        return curr;
    }

    private static <T> void printList(Node<T> root)   {
        while(nonNull(root))   {
            System.out.print(root.item + "==>");
            root = root.next;
        }
    }
}
