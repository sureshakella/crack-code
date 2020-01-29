package fornow.linkedlist;

import javax.swing.*;
import java.util.Objects;

import static java.util.Objects.nonNull;

public class SingleLinkedListMiddleElement {

    static class Node<T> {
        T item;
        Node<T> next;

        Node(T item){
            this.item = item;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        Node<Integer> tail = root;
        for(int i=1; i<=9; i++) {
            tail.next = new Node<>(i + 1);
            tail = tail.next;
        }
        System.out.println("root: " + root.item + " tail: " + tail.item);
        printList(root);
        fetchMiddleElem(root);
    }

    private static void fetchMiddleElem(Node<Integer> root)   {
        Node<Integer> fast = root;
        Node<Integer> slow = root;
        while(nonNull(fast.next) && nonNull(fast.next.next))   {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println("Middle: " + slow.item);
    }

    private static void printList(Node<Integer> root)   {
        while(nonNull(root))   {
            System.out.print(root.item + "==>");
            root = root.next;
        }
    }
}
