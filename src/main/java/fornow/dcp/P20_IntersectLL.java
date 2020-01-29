package fornow.dcp;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.nonNull;

//
//Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
//
//        For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
//
//        In this example, assume nodes with the same value are the exact same node objects.
//
//        Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

//Just a note that because the intersecting node is common for both lists,
// all subsequent nodes are same for both lists. Using this property, we can achieve constant space.
public class P20_IntersectLL {
    static class Node<T> {
        T item;
        Node<T> next;
        Node(T item)    {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node(1);
        Node<Integer> tail = node;
        for(int i=2; i<5; i++) {
            Node curr = new Node(i);
            tail.next = curr;
            tail = tail.next;
        }
        Node<Integer> node2 = new Node(8);
        Node<Integer> tail2 = node2;
        for(int i=2; i<5; i++) {
            Node curr = new Node(i*3);
            tail2.next = curr;
            tail2 = tail2.next;
        }
        System.out.print("Print list 1 : ");
        printList(node);
        System.out.println();
        System.out.print("Print list 2 : ");
        printList(node2);
        System.out.println();
        Node<Integer> link = intersectingNode(node, node2);
        System.out.println("Intersecting Node is : " + (nonNull(link) ? link.item : "No link node"));
    }

    private static void printList(Node<Integer> root)   {
        while(nonNull(root))   {
            System.out.print(root.item + (nonNull(root.next) ? "==>" : ""));
            root = root.next;
        }
    }

    //This works but has o(m+n) time complexity for m and n size lists and O(max(m,n)) space
    private static Node intersectingNode(Node<Integer> list1, Node<Integer> list2) {
        Set<Integer> exists = new HashSet<>();
        while(nonNull(list1)) {
            exists.add(list1.item);
            list1 = list1.next;
        }
//        exists.forEach(System.out::println);
        while(nonNull(list2)) {
            if (exists.contains(list2.item)) {
                return list2;
            }
            list2 = list2.next;
        }
        return null;
    }

}
