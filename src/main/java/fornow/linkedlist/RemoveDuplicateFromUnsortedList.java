package fornow.linkedlist;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static java.util.Objects.nonNull;

public class RemoveDuplicateFromUnsortedList {
    static class Node<T> {
        T item;
        Node<T> next;
        Node(T item)    {
            this.item = item;
        }
    }

    public static void main(String[] args)  {
        Node<Integer> root = new Node<>(1);
        Node<Integer> tail = root;
        Random rand = new Random();
        for(int i=0; i<10; i++) {
            tail.next = new Node<>(rand.nextInt(20) + 1);
            tail = tail.next;
        }

        printList(root);
        System.out.println();
        System.out.println("After removing duplicates");
        printList(removeDuplicates(root));
    }

    private static <T> void printList(Node<T> root) {
        while (nonNull(root)) {
            System.out.print(root.item.toString() + "==>");
            root = root.next;
        }
    }

    private static <T> Node<T> removeDuplicates(Node<T> root) {
        Node<T> curr = root;
        Node<T> prev = null;
        Set<T> itemSet = new HashSet<>();
        while (nonNull(curr)) {
            if (itemSet.contains(curr.item)) {
                prev.next = curr.next;
            }
            else {
                itemSet.add(curr.item);
                prev = curr;
            }
            curr = curr.next;
        }
        return root;
    }
}
