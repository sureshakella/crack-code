package fornow.linkedlist;

import static java.util.Objects.nonNull;

public class CheckIfLinkedListIsCyclic {

    static class Node<T> {
        T item;
        Node<T> next;
        Node(T item) {
            this.item = item;
        }
    }
    public static void main(String[] args)  {
        Node<Integer> root = new Node<Integer>(1);
        Node<Integer> tail = root;
        Node<Integer> temp = null;
        for(int i=1; i<10;i++) {
            tail.next = new Node<Integer>(i+1);
            if (i == 8) {
                temp = tail.next;
            }
            tail = tail.next;
        }
        tail.next = temp;

        if(checkIfLinkedListIsCyclic(root)) {
            System.out.println("Linkedlist is Cyclic");
        } else {
            System.out.println("Linkedlist is acyclic");
        }
    }

    static boolean checkIfLinkedListIsCyclic(Node<Integer> node)  {
        Node<Integer> fast = node;
        Node<Integer> slow = node;
        while (nonNull(fast) && nonNull(fast.next)) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
