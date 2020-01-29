package fornow.linkedlist;

import java.util.Random;

import static java.util.Objects.nonNull;

public class GetNthNodeFromLast {
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
        for(int i=0; i<10; i++) {
            tail.next = new Node<>(rand.nextInt(20) + 1);
            tail = tail.next;
        }

        printList(root);
        System.out.println();
        System.out.println(getNthNodeFromLast(root, 1).item);
        System.out.println(getNthNodeFromLast(root, 2).item);
        System.out.println(getNthNodeFromLast(root, 3).item);
    }

    private static <T> Node<T> getNthNodeFromLast(Node<T> root, int position) {
        Node<T> fast = root;
        Node<T> slow = root;
        int cnt = 1;
        while (nonNull(fast )) {
            fast = fast.next;
            if(cnt > position) {
                slow = slow.next;
            }
            cnt++;
        }
        return slow;
    }

    private static void printList(Node<Integer> root)   {
        while(nonNull(root))   {
            System.out.print(root.item + "==>");
            root = root.next;
        }
    }
}
