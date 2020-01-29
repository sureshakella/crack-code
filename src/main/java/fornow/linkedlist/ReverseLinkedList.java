package fornow.linkedlist;

import static java.util.Objects.nonNull;

public class ReverseLinkedList {

    static class Node<T> {
        T item;
        Node<T> next;

        Node(T item)    {
            this.item = item;
        }
    }

    public static void main(String[] args)  {
        Node<Integer> root = new Node<>(0);
        Node<Integer> tail = root;
        for(int i=1; i<11; i++) {
            tail.next = new Node<>(i);
            tail = tail.next;
        }
        printList(root);
        System.out.println();
//        printList(reverseLinkedList(root));
        printList(recursive(null, root));
    }

    private static <T> Node<T> reverseLinkedList(Node<T> root)    {
        Node<T> curr = root;
        Node<T> prev = null;
        Node<T> next;
        while (nonNull(curr)) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static <T> Node<T> recursive(Node<T> prev, Node<T> curr) {
        if (curr == null) return prev;
        Node<T> tmp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = recursive(prev, tmp);
        return curr;
    }

    private static void printList(Node<Integer> root)   {
        while(nonNull(root))   {
            System.out.print(root.item + "==>");
            root = root.next;
        }
    }
}
